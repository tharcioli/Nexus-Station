package controller;

import view.ChapterOneView;
import view.PauseView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ChapterOneController implements Runnable, KeyListener {

    private ChapterOneView chapterOneView;
    private static final int TARGET_TPS = 60;
    private static final long OPTIMAL_TIME = 1000000000 / TARGET_TPS;
    private static final Object lock = new Object();
    private static int tps;
    private static int fps;
    private static Thread gameloop;
    private static boolean isOppened;

    public ChapterOneController(ChapterOneView chapterOneView) {
        this.chapterOneView = chapterOneView;
        chapterOneView.instantiateControllerComponents();
        chapterOneView.addKeyListener(this);
        chapterOneView.setFocusable(true);
        chapterOneView.setFocusTraversalKeysEnabled(false);

        isOppened = true;
        tps = 0;
        fps = 0;

        gameloop = new Thread(this);
        gameloop.start();
    }

    private synchronized void update() {

    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int ticks = 0;
        int frames = 0;

        while (isOppened) {
            long now = System.nanoTime();
            lastTime = now;

            // Lógica do jogo

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

            synchronized (lock) {
                while (!isOppened) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public synchronized static void resumeGameLoop() {
        isOppened = true;
        synchronized (lock) {
            lock.notify();
        }
    }

    public synchronized static void pauseGameLoop() {
        isOppened = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!DialogController.getRunning()) {
                new PauseView();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
