package controller;

import main.MainFrame;
import model.SquaresVO;
import view.LoginView;
import view.MenuView;
import view.NewsView;
import view.UserPanelView;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MenuController implements ActionListener, Runnable, LoginChangeListener {

    private MenuView menuView;
    private static final int TARGET_TPS = 60;
    private static final long OPTIMAL_TIME = 1000000000 / TARGET_TPS;
    private static int tps;
    private static int fps;
    private List<SquaresVO> squaresVOList;
    private static Clip menuMusic;
    private static boolean isRunning;
    private UserPanelView userPanelView;
    private boolean isOpenned;

    public MenuController(MenuView menuView) {
        this.menuView = menuView;

        isOpenned = false;

        LoginFile.setLogin(LoginFile.readLoginFromFile());

        menuView.instantiateControllerComponents();
        squaresVOList = new ArrayList<>();

        menuView.getUserPanelButton().addActionListener(this);
        menuView.getNewsButton().addActionListener(this);
        menuView.getStartSessionButton().addActionListener(this);
        menuView.getExitButton().addActionListener(this);
        menuView.getMinimizeButton().addActionListener(this);

        LoginFile.addLoginChangeListener(this);

        userPanelView = new UserPanelView();
        userPanelView.setBounds(0, 0, 380, 720);

        getSquaresState();
        menuView.getGraphics();

        Thread gameLoopMenu = new Thread(this);
        gameLoopMenu.start();

        if (gameLoopMenu.isAlive()) { isRunning = true; }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuView.getExitButton()) {
            TapSong.getSong();
            System.exit(0);
        }

        if (e.getSource() == menuView.getMinimizeButton()) {
            TapSong.getSong();
            MainFrame.getInstance().setState(JFrame.ICONIFIED);
        }

        if (e.getSource() == menuView.getUserPanelButton()) {
            TapSong.getSong();

            if (!isOpenned) {
                menuView.add(userPanelView);
                isOpenned = true;
            } else {
                menuView.remove(userPanelView);
                isOpenned = false;
            }
        }

        if (e.getSource() == menuView.getNewsButton()) {
            TapSong.getSong();

            NewsView newsView = new NewsView();
            newsView.setVisible(true);
        }

        if (e.getSource() == menuView.getStartSessionButton()) {
            TapSong.getSong();
            new LoginView();
        }
    }

    public List<SquaresVO> getSquaresVOList() {
        return squaresVOList;
    }

    public void getSquaresState() {
        int minSeparation = 20;
        Random random = new Random();

        for (int i = 0; i < 15; i++) {
            int x, y;
            boolean tooClose;

            do {
                tooClose = false;
                x = random.nextInt(MainFrame.getW() - 10);
                y = random.nextInt(MainFrame.getH() - 10);

                for (SquaresVO q : squaresVOList) {
                    if (Math.abs(q.x - x) < minSeparation && Math.abs(q.y - y) < minSeparation) {
                        tooClose = true;
                        break;
                    }
                }

            } while (tooClose);

            int quicknessX = 0;
            int quicknessY = random.nextInt(5) + 1;
            squaresVOList.add(new SquaresVO(x, y, 10, 10, quicknessX, quicknessY, Color.WHITE));
        }
    }


    private void update() {
        for (SquaresVO q : squaresVOList) {

            q.y += q.quicknessY;

            if (q.y > MainFrame.getH()) {

                q.y = -q.height;
                q.x = (int) (Math.random() * MainFrame.getW());
                q.quicknessY = (int) (Math.random() * 6) + 1;
            }
        }
    }

    @Override
    public void run() {
        startMenuMusic();

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int ticks = 0;
        int frames = 0;

        while (isRunning) {
            long now = System.nanoTime();
            lastTime = now;

            update();
            menuView.repaint();

            ticks++;
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                tps = ticks;
                fps = frames;
                ticks = 0;
                frames = 0;

                System.out.println("TPS: " + tps + ", FPS: " + fps);
            }

            try {
                Thread.sleep((lastTime - System.nanoTime() + OPTIMAL_TIME) / 1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startMenuMusic() {

        try {

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("MenuSongs/menuSong.wav"));
            menuMusic = AudioSystem.getClip();
            menuMusic.open(audioStream);
            menuMusic.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception ex) {

            System.out.println("Erro ao acessar a música" + ex.getMessage());
        }

        menuMusic.start();
    }

    public void onLoginStateChanged(boolean loggedIn) {
        if (loggedIn) {
            menuView.getStartSessionButton().setVisible(false);
            menuView.getNewsButton().setBounds((MainFrame.getW() - 150) / 2, 0, 150, 35);
            menuView.add(menuView.getMenuOptionsView());
            menuView.add(menuView.getUserPanelButton());
        } else {
            menuView.getStartSessionButton().setVisible(true);
            menuView.getNewsButton().setBounds(0, 0, 150, 35);
            menuView.remove(menuView.getMenuOptionsView());
            menuView.remove(menuView.getUserPanelButton());
        }
    }

    public static void stopGameLoop() {
        isRunning = false;
        SwingUtilities.invokeLater(() -> menuMusic.stop());
    }

    public static void startGameLoop() {
        isRunning = true;
        startMenuMusic();
    }
}