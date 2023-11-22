package view;

import controller.PauseController;
import javax.swing.*;
import java.awt.*;

public class PauseView extends JDialog {

    private PauseController pauseController;
    private JButton[] button;

    public PauseView() {
        pauseController = new PauseController(this);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(350,250);
        setUndecorated(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);

        JLabel title = new JLabel("Jogo Pausado");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Monospaced", Font.BOLD, 25));
        title.setBounds((getWidth() - 200) / 2, 35, 200, 35);
        add(title);

        button[0].setBounds((getWidth() - 200) / 2, 120, 200, 35);
        button[0].setFont(new Font("Monospaced", Font.PLAIN, 20));
        button[0].setContentAreaFilled(false);
        button[0].setHorizontalAlignment(SwingConstants.CENTER);
        button[0].setFocusPainted(false);
        add(button[0]);

        button[1].setBounds((getWidth() - 200) / 2, 180, 200, 35);
        button[1].setFont(new Font("Monospaced", Font.PLAIN, 18));
        button[1].setContentAreaFilled(false);
        button[1].setHorizontalAlignment(SwingConstants.CENTER);
        button[1].setFocusPainted(false);
        add(button[1]);

        revalidate();
        repaint();
        setVisible(true);
    }

    public void instantiateControllerComponents() {
        button = new JButton[2];
        button[0] = new JButton("Continuar");
        button[1] = new JButton("Voltar ao Menu");
    }

    public JButton getButton(int index) {
        return button[index];
    }
}
