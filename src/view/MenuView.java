package view;

import controller.LoginFile;
import controller.MenuController;
import main.MainFrame;
import model.SquaresVO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuView extends JPanel {

    private MenuController menuController;
    private JLabel title;
    private Image background;
    private JButton userPanelButton;
    private JButton newsButton;
    private JButton startSessionButton;
    private JButton exitButton, minimizeButton;
    private BufferedImage buffer;
    private MenuOptionsView menuOptionsView;

    public MenuView() {
        menuController = new MenuController(this);

        setLayout(null);
        setBackground(Color.BLACK);
        background = new ImageIcon("MenuComponents/background.png").getImage();

        menuController.getSquaresState();
        getGraphics();
        buffer = new BufferedImage(MainFrame.getW(), MainFrame.getH(), BufferedImage.TYPE_INT_ARGB);

        title.setBounds((MainFrame.getW() - 600) / 2, 300, 600, 70);
        add(title);

        userPanelButton.setBounds(2, 2, 60, 60);
        userPanelButton.setBackground(new Color(200, 50, 220));
        userPanelButton.setFocusPainted(false);
        userPanelButton.setBorderPainted(false);

        newsButton.setBounds(0, 0, 150, 35);
        newsButton.setBackground(new Color(200, 50, 220));
        newsButton.setForeground(Color.BLACK);
        newsButton.setFocusPainted(false);
        newsButton.setFont(new Font("Arial", Font.BOLD, 15));
        newsButton.setBorderPainted(false);
        add(newsButton);

        startSessionButton.setBounds((MainFrame.getW() - 250) / 2, 500, 250, 60);
        startSessionButton.setForeground(Color.BLACK);
        startSessionButton.setFocusPainted(false);
        startSessionButton.setBackground(Color.WHITE);
        startSessionButton.setFont(new Font("Arial", Font.BOLD, 20));
        add(startSessionButton);

        menuOptionsView = new MenuOptionsView();
        menuOptionsView.setBounds((MainFrame.getW() - 650) / 2, 400, 650, 200);

        boolean loggedIn = LoginFile.readLoginFromFile();

        if (loggedIn) {
            startSessionButton.setVisible(false);
            newsButton.setBounds((MainFrame.getW() - 150) / 2, 0, 150, 35);
            add(menuOptionsView);
            add(userPanelButton);
        } else {
            startSessionButton.setVisible(true);
            newsButton.setBounds(0, 0, 150, 35);
            remove(menuOptionsView);
            remove(userPanelButton);
        }

        exitButton.setBounds(MainFrame.getW() - 50, 0, 50, 35);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        exitButton.setBackground(new Color(200, 50, 220));
        exitButton.setForeground(Color.BLACK);
        exitButton.setToolTipText("Fechar");
        add(exitButton);

        minimizeButton.setBounds(MainFrame.getW() - 100, 0, 50, 35);
        minimizeButton.setBorderPainted(false);
        minimizeButton.setFocusPainted(false);
        minimizeButton.setBackground(new Color(200, 50, 220));
        minimizeButton.setForeground(Color.BLACK);
        minimizeButton.setFont(new Font("Arial", Font.BOLD, 20));
        minimizeButton.setToolTipText("Minimizar");
        add(minimizeButton);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(background, 0, 0, this);

        for (SquaresVO square : menuController.getSquaresVOList()) {
            g2d.setColor(square.color);
            g2d.fillRect(square.x, square.y, square.width, square.height);
        }

        g2d.drawImage(buffer, 0, 0, this);
    }

    public void instantiateControllerComponents() {
        title = new JLabel(new ImageIcon("MenuComponents/title.png"));
        userPanelButton = new JButton(new ImageIcon("MenuComponents/userPanelButton.png"));
        newsButton = new JButton("Novidades");
        startSessionButton = new JButton("Iniciar Sessão");
        exitButton = new JButton("✖");
        minimizeButton = new JButton("–");
    }

    public JButton getUserPanelButton() {
        return userPanelButton;
    }

    public JButton getNewsButton() {
        return newsButton;
    }

    public JButton getStartSessionButton() {
        return startSessionButton;
    }

    public JButton getExitButton() { return exitButton; }

    public JButton getMinimizeButton() { return minimizeButton; }

    public MenuOptionsView getMenuOptionsView() {
        return menuOptionsView;
    }
}
