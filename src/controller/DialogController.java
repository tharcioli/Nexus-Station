package controller;

import main.MainFrame;
import view.ChapterOneView;
import view.DialogView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogController implements ActionListener {

    private DialogView dialogView;
    private static boolean running;
    private int currentIndex = 6;

    public DialogController(DialogView dialogView) {
        this.dialogView = dialogView;
        ChapterOneController.pauseGameLoop();
        dialogView.setText(dialogView.getText());
        dialogView.instantiateControllerComponents();
        dialogView.getCloseButton().addActionListener(this);
        running = true;
    }

    public void startTextAnimation() {
        Timer timer = new Timer(32, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex <= dialogView.getText().length()) {
                    dialogView.getPhrase().setText(dialogView.getText().substring(0, currentIndex));
                    currentIndex++;
                } else {
                    ((Timer) e.getSource()).stop();
                    dialogView.getCloseButton().setVisible(true);
                }
            }
        });

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dialogView.getCloseButton()) {
            TapSong.getSong();
            ChapterOneController.resumeGameLoop();
            ChapterOneView.getInstance().remove(dialogView);
            MainFrame.getInstance().revalidate();
            MainFrame.getInstance().repaint();
            running = false;
        }
    }

    public static boolean getRunning() {
        return running;
    }
}
