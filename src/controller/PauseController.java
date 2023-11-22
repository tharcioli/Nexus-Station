package controller;

import main.MainFrame;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseController implements ActionListener {

    private PauseView pauseView;

    public PauseController(PauseView pauseView) {
        this.pauseView = pauseView;
        pauseView.instantiateControllerComponents();

        for (int i = 0; i < 2; i++) {
            pauseView.getButton(i).addActionListener(this);
        }

        ChapterOneController.pauseGameLoop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pauseView.getButton(0)) {
            TapSong.getSong();
            pauseView.dispose();
            ChapterOneController.resumeGameLoop();
        }

        if (e.getSource() == pauseView.getButton(1)) {
            TapSong.getSong();
            pauseView.dispose();
            MainFrame.getInstance().remove(ChapterOneView.getInstance());
            MainFrame.setMenuView(new MenuView());
            MainFrame.getInstance().add(MainFrame.getMenuView());
            MainFrame.getInstance().revalidate();
            MainFrame.getInstance().repaint();
        }
    }
}
