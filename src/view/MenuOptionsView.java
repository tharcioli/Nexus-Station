package view;

import controller.MenuOptionsController;
import javax.swing.*;
import java.awt.*;

public class MenuOptionsView extends JPanel {

    private JButton resumeButton;
    private JButton newGameButton;
    private JButton settingsButton;
    private MenuOptionsController menuOptionsController;
    public MenuOptionsView() {
        menuOptionsController = new MenuOptionsController(this);
        setLayout(null);

        JLabel[] label = new JLabel[3];

        label[0] = new JLabel("Continuar");
        label[0].setBounds((getWidth() + 125) * 2, 172, 150, 35);
        label[0].setHorizontalAlignment(SwingConstants.CENTER);
        label[0].setForeground(Color.CYAN);
        label[0].setFont(new Font("Monospaced", Font.BOLD, 16));
        add(label[0]);

        resumeButton.setBounds((getWidth() + 125) * 2, 25, 150, 150);
        resumeButton.setFocusPainted(false);
        resumeButton.setContentAreaFilled(false);
        resumeButton.setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 2, true));
        add(resumeButton);

        label[1] = new JLabel("Novo Jogo");
        label[1].setBounds((getWidth() + 10) * 2, 156, 120, 35);
        label[1].setHorizontalAlignment(SwingConstants.CENTER);
        label[1].setForeground(Color.CYAN);
        label[1].setFont(new Font("Monospaced", Font.BOLD, 15));
        add(label[1]);

        newGameButton.setBounds((getWidth() + 10) * 2, 40, 120, 120);
        newGameButton.setFocusPainted(false);
        newGameButton.setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 2, true));
        newGameButton.setContentAreaFilled(false);
        add(newGameButton);

        label[2] = new JLabel("Ajustes");
        label[2].setBounds((getWidth() + 255) * 2, 156, 120, 35);
        label[2].setHorizontalAlignment(SwingConstants.CENTER);
        label[2].setForeground(Color.CYAN);
        label[2].setFont(new Font("Monospaced", Font.BOLD, 15));
        add(label[2]);

        settingsButton.setBounds((getWidth() + 255) * 2, 40, 120, 120);
        settingsButton.setFocusPainted(false);
        settingsButton.setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 2, true));
        settingsButton.setContentAreaFilled(false);
        add(settingsButton);

        setOpaque(false);
        setBackground(null);
    }

    public void instantiateControllerComponents() {
        resumeButton = new JButton(new ImageIcon("MenuComponents/resumeIcon.png"));
        newGameButton = new JButton(new ImageIcon("MenuComponents/newGameIcon.png"));
        settingsButton = new JButton(new ImageIcon("MenuComponents/settingsIcon.png"));
    }

    public JButton getResumeButton() {
        return resumeButton;
    }

    public JButton getSettingsButton() {
        return settingsButton;
    }

    public JButton getNewGameButton() {
        return newGameButton;
    }
}
