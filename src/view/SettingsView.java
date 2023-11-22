package view;

import controller.SettingsController;

import javax.swing.*;
import java.awt.*;

public class SettingsView extends JDialog {

    private JPanel savesPanel;
    private JButton savesPanelButton;
    private JPanel soundPanel;
    private JButton soundPanelButton;
    private JPanel creditPanel;
    private JButton creditPanelButton;
    private JPanel buttonsPanel;
    private JButton closeButton;
    private SettingsController settingsController;

    public SettingsView() {
        settingsController = new SettingsController(this);

        setLayout(null);
        setSize(800, 600);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);

        instantiateControllerComponents();
        createButtonsPanel();
        add(buttonsPanel);

        revalidate();
        repaint();

        setVisible(true);
    }

    public void instantiateControllerComponents() {
        savesPanel = new JPanel();
        savesPanelButton = new JButton("Sa");
        soundPanel = new JPanel();
        soundPanelButton = new JButton("So");
        creditPanel = new JPanel();
        creditPanelButton = new JButton("Cr");
        buttonsPanel = new JPanel();
        closeButton = new JButton("Fechar");
    }

    public void crateSavesPanel() {
        savesPanel.setBounds(80, 0, 720, 600);
        savesPanel.setBackground(Color.BLACK);
    }

    public void createSoundPanel() {
        soundPanel.setBounds(80, 0, 720, 600);
        savesPanel.setBackground(Color.BLACK);
    }

    public void createCreditPanel() {
        creditPanel.setBounds(80, 0, 720, 600);
        savesPanel.setBackground(Color.BLACK);
    }

    public void createButtonsPanel() {
        buttonsPanel.setLayout(null);
        buttonsPanel.setBounds(0, 0, 80, 600);

        closeButton.setBounds(0, 0, 80, 35);
        closeButton.setFont(new Font("", Font.BOLD, 12));
        closeButton.setFocusPainted(false);
        buttonsPanel.add(closeButton);

        savesPanelButton.setBounds(0, 150, 80, 80);
        savesPanelButton.setFocusPainted(false);
        buttonsPanel.add(savesPanelButton);

        soundPanelButton.setBounds(0, 230, 80, 80);
        soundPanelButton.setFocusPainted(false);
        buttonsPanel.add(soundPanelButton);

        creditPanelButton.setBounds(0, 310, 80, 80);
        creditPanelButton.setFocusPainted(false);
        buttonsPanel.add(creditPanelButton);
    }
}
