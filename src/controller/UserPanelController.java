package controller;

import model.UserPanelBO;
import view.LoginView;
import view.UserPanelView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanelController implements ActionListener, LoginChangeListener {

    private final UserPanelView userPanelView;
    private final UserPanelBO userPanelBO;
    private String userID, email, password, acessWork, tip;

    public UserPanelController(UserPanelView userPanelView) {

        userPanelView.instantiateControllerComponents();

        userPanelBO = new UserPanelBO();

        userPanelView.getEditButton().addActionListener(this);
        userPanelView.getCancelButton().addActionListener(this);
        userPanelView.getConfirmButton().addActionListener(this); // banco
        userPanelView.getExitButton().addActionListener(this);
        userPanelView.getDeleteButton().addActionListener(this);

        LoginFile.addLoginChangeListener(this);

        this.userPanelView = userPanelView;

        if (LoginFile.isLogin()) {

            userID = LoginFile.readUserIDFromFile();

            email = userPanelBO.getEmail(userID);
            password = userPanelBO.getPassword(userID);
            acessWork = userPanelBO.getAcessWork(userID);
            tip = userPanelBO.getTip(userID);

            userPanelView.setTextFields(userID, email, password, acessWork, tip);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == userPanelView.getExitButton()) {

            TapSong.getSong();

            Object[] options = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja sair ?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (resposta == JOptionPane.YES_OPTION) {
                TapSong.getSong();
                LoginFile.setLogin(false);
                userPanelView.getParent().remove(userPanelView);
                JOptionPane.showMessageDialog(null, "Sessão Encerrada", "Volte Logo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                TapSong.getSong();
                return;
            }
        }

        if (e.getSource() == userPanelView.getEditButton()) {

            TapSong.getSong();

            userPanelView.getPasswordPF().setEchoChar((char) 0);

            userPanelView.remove(userPanelView.getEditButton());
            userPanelView.add(userPanelView.getConfirmButton());
            userPanelView.add(userPanelView.getCancelButton());
            userPanelView.getDeleteButton().setEnabled(false);
            userPanelView.getExitButton().setEnabled(false);

            userPanelView.getUserIDTF().setEditable(true);
            userPanelView.getEmailTF().setEditable(true);
            userPanelView.getPasswordPF().setEditable(true);
            userPanelView.getAcessWorkTF().setEditable(true);
            userPanelView.getTipTF().setEditable(true);

        }

        if (e.getSource() == userPanelView.getConfirmButton()) {

            TapSong.getSong();

            String newUserID = userPanelView.getUserIDTF().getText();
            String newEmail = userPanelView.getEmailTF().getText().toLowerCase();
            String newPassword = new String(userPanelView.getPasswordPF().getPassword());
            String newAcessWork = userPanelView.getAcessWorkTF().getText();
            String newTip = userPanelView.getTipTF().getText();

            if (!userID.equals(newUserID)) {

                if (newUserID.length() > 45) {
                    JOptionPane.showMessageDialog(null, "ID de usuário deve conter até 45 caracteres.", "Erro", JOptionPane.ERROR_MESSAGE);

                    return;
                } else if (userPanelBO.canUpdateUserID(userID, newUserID)) {

                    userPanelBO.updateUserID(userID, newUserID);
                    userID = newUserID;
                    LoginFile.setUserID(userID);
                } else {

                    JOptionPane.showMessageDialog(null, "Este ID já está em uso.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }

            }

            if (!newEmail.toLowerCase().equals(email)) {

                String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
                if (!newEmail.matches(emailPattern) || newEmail.length() > 100) {

                    JOptionPane.showMessageDialog(null, "O email(máx 100 caracteres) inserido não é válido.", "Erro", JOptionPane.ERROR_MESSAGE);

                    return;
                } else if (userPanelBO.canUpdateEmail(userID, newEmail)) {

                    userPanelBO.updateEmail(userID, newEmail);
                    email = newEmail;
                } else {

                    JOptionPane.showMessageDialog(null, "Este email já está em uso.", "Erro", JOptionPane.ERROR_MESSAGE);

                    return;
                }
            }

            if (!password.equals(newPassword)) {

                int letterOrSymbolCount = password.replaceAll("[^a-zA-Z\\W_]", "").length();

                if (newPassword.length() < 8 || letterOrSymbolCount < 2 || newPassword.contains(" ") || newPassword.length() > 45) {

                    JOptionPane.showMessageDialog(null, "A nova senha deve conter pelo menos 8 caracteres, 2 letras ou símbolos e nada de espaços!\n(máx 45 caracteres)", "Erro", JOptionPane.ERROR_MESSAGE);

                    return;
                } else {

                    userPanelBO.updatePassword(userID, newPassword);
                    password = newPassword;
                }
            }

            if (!acessWork.equals(newAcessWork)) {

                if (newAcessWork.contains(" ") || newAcessWork.length() > 45) {

                    JOptionPane.showMessageDialog(null, "Nova palavra de acesso(máx 45 caracteres) não deve conter espaços.", "Erro", JOptionPane.ERROR_MESSAGE);

                    return;
                } else {

                    userPanelBO.updateAcessWork(userID, newAcessWork);
                    acessWork = newAcessWork;
                }
            }

            if (!tip.equals(newTip)) {

                userPanelBO.updateTip(userID, newTip);
                tip = newTip;
            }

            userPanelView.remove(userPanelView.getConfirmButton());
            userPanelView.remove(userPanelView.getCancelButton());
            userPanelView.add(userPanelView.getEditButton());

            userPanelView.getPasswordPF().setEchoChar('•');

            userPanelView.getUserIDTF().setEditable(false);
            userPanelView.getEmailTF().setEditable(false);
            userPanelView.getPasswordPF().setEditable(false);
            userPanelView.getAcessWorkTF().setEditable(false);
            userPanelView.getTipTF().setEditable(false);

            userPanelView.getDeleteButton().setEnabled(true);
            userPanelView.getExitButton().setEnabled(true);
        }

        if (e.getSource() == userPanelView.getCancelButton()) {

            TapSong.getSong();

            userPanelView.setTextFields(userID, email, password, acessWork, tip);

            userPanelView.remove(userPanelView.getConfirmButton());
            userPanelView.remove(userPanelView.getCancelButton());
            userPanelView.add(userPanelView.getEditButton());

            userPanelView.getPasswordPF().setEchoChar('•');

            userPanelView.getUserIDTF().setEditable(false);
            userPanelView.getEmailTF().setEditable(false);
            userPanelView.getPasswordPF().setEditable(false);
            userPanelView.getAcessWorkTF().setEditable(false);
            userPanelView.getTipTF().setEditable(false);

            userPanelView.getDeleteButton().setEnabled(true);
            userPanelView.getExitButton().setEnabled(true);
        }

        if (e.getSource() == userPanelView.getDeleteButton()) {

            TapSong.getSong();

            Object[] options = {"Sim", "Não"};
            int resposta = JOptionPane.showOptionDialog(null,
                    "Todos os seus dados serão perdidos." +
                            "\nNão será possível recuperá-los posteriormente." +
                            "\nDeseja prosseguir com a ação ?", "Deletar Conta",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (resposta == JOptionPane.YES_OPTION) {
                TapSong.getSong();
                userPanelBO.deleteUser(userID);
                LoginFile.setUserID("");
                LoginFile.setLogin(false);
                userPanelView.getParent().remove(userPanelView);
                JOptionPane.showMessageDialog(null, "Sua conta foi deletada!", "Foi bom enquanto durou", JOptionPane.INFORMATION_MESSAGE);
            } else {
                TapSong.getSong();
                return;
            }
        }
    }

    @Override
    public void onLoginStateChanged(boolean loggedIn) {

        if (loggedIn) {

            userID = LoginFile.readUserIDFromFile();

            email = userPanelBO.getEmail(userID);
            password = userPanelBO.getPassword(userID);
            acessWork = userPanelBO.getAcessWork(userID);
            tip = userPanelBO.getTip(userID);

            userPanelView.setTextFields(userID, email, password, acessWork, tip);
        }
    }
}