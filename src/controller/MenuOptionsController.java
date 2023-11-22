package controller;

import main.MainFrame;
import view.ChapterOneView;
import view.DialogView;
import view.MenuOptionsView;
import view.SettingsView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuOptionsController implements ActionListener {

    private MenuOptionsView menuOptionsView;
    private DialogView dialogView;
    private SettingsView settingsView;

    public MenuOptionsController(MenuOptionsView menuOptionsView) {
        this.menuOptionsView = menuOptionsView;

        menuOptionsView.instantiateControllerComponents();
        menuOptionsView.getResumeButton().addActionListener(this);
        menuOptionsView.getNewGameButton().addActionListener(this);
        menuOptionsView.getSettingsButton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuOptionsView.getResumeButton()) {
            TapSong.getSong();
            // verificar se o usuário já criou um novo jogo alguma vez.
            // se sim, continuar o jogo do exato ponto onde o usuário parou.
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar progresso. " +
                    "\nPor favor, inicie um novo jogo!");
        }

        if (e.getSource() == menuOptionsView.getNewGameButton()) {
            TapSong.getSong();
            // verificar se o usuário já possui algum progresso.
            // se sim, perguntar se ele deseja substituir o seu progresso atual por um novo.
            Object[] options = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null,
                    "Qualquer progresso feito anteriormente será perdido.\nDeseja continuar ?",
                    "Iniciar um Novo Jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            if (resposta == JOptionPane.YES_OPTION) {
                TapSong.getSong();
                MenuController.stopGameLoop();
                MainFrame.getInstance().remove(MainFrame.getMenuView());
                MainFrame.setMenuView(null);

                MainFrame.getInstance().add(new ChapterOneView());
                MainFrame.getInstance().revalidate();
                MainFrame.getInstance().repaint();
            } else {
                TapSong.getSong();
                return;
            }
        }

        if (e.getSource() == menuOptionsView.getSettingsButton()) {
            TapSong.getSong();

            JOptionPane.showMessageDialog(null, "Não é possível acessar seus ajustes no momento." +
                            "\n(botão desabilitado)", "Chegando em breve", JOptionPane.INFORMATION_MESSAGE);

            // aqui deve abrir as configurações do usuário.
            // deve possuir relação no banco "um usuário possui tais configurações".
        }
    }
}
