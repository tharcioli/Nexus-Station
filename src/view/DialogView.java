package view;

import javax.swing.*;
import controller.DialogController;
import main.MainFrame;

import java.awt.*;

public class DialogView extends JPanel {

    private DialogController dialogController;
    private JLabel phrase;
    private JButton closeButton;
    private String text;
    private static DialogView instance;

    public DialogView(String text) {
        dialogController = new DialogController(this);
        setLayout(null);
        instance = this;
        setBackground(Color.BLACK);
        phrase.setForeground(Color.WHITE);
        phrase.setHorizontalAlignment(SwingConstants.CENTER);
        phrase.setFont(new Font("Monospaced", Font.BOLD, 25));
        phrase.setBounds((MainFrame.getW() - 1850) / 2, (MainFrame.getH() - 1250) / 2, 1850, 1200);
        add(phrase);

        this.text = text;
        dialogController.startTextAnimation();

        closeButton.setBounds((MainFrame.getW() - 180) / 2, 550, 180, 50);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Monospaced", Font.PLAIN, 25));
        closeButton.setContentAreaFilled(false);
        closeButton.setHorizontalAlignment(SwingConstants.CENTER);
        closeButton.setFocusPainted(false);
        add(closeButton);
        closeButton.setVisible(false);
    }

    public void instantiateControllerComponents() {
        phrase = new JLabel();
        closeButton = new JButton("Continuar");
    }

    public static DialogView getInstance() {
        return instance;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JLabel getPhrase() {
        return phrase;
    }

    public JButton getCloseButton() {
        return closeButton;
    }
}
