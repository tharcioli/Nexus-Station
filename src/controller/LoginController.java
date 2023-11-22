package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import model.LoginBO;
import view.CadastroView;
import view.LoginView;

public class LoginController implements ActionListener, KeyListener {

	private final LoginView loginView;
	private final LoginBO loginBO;
	private boolean showingPassword;

	public LoginController(LoginView loginView) {

		loginBO = new LoginBO();

		loginView.instantiateControllerComponents();

		loginView.getButton(0).addActionListener(this);
		loginView.getButton(1).addActionListener(this);
		loginView.getButton(2).addActionListener(this);
		loginView.getButton(3).addActionListener(this);
		loginView.getButton(4).addActionListener(this);

		this.loginView = loginView;
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginView.getButton(0)) {

			TapSong.getSong();

			CadastroView.getJDialog().dispose();
			LoginView.getJDialog().dispose();
		}

		if (e.getSource() == loginView.getButton(1)) {

			TapSong.getSong();

			String userID = loginView.getUserIDTF();
			String password = new String(loginView.getPasswordPF());

			int resultado = loginBO.realizarLogin(userID, password);

			if (userID.isEmpty() || password.isEmpty()) {

				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (resultado == 0) {

				CadastroView.getJDialog().dispose();
				LoginView.getJDialog().dispose();
				LoginFile.setUserID(userID);
				LoginFile.setLogin(true);

				JOptionPane.showMessageDialog(null, "Bem vindo " + userID + ".", "Sessão iniciada",
						JOptionPane.INFORMATION_MESSAGE);

			} else if (resultado == 1) {

				JOptionPane.showMessageDialog(null, "Senha incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
				LoginFile.setLogin(false);

			} else if (resultado == 2) {

				JOptionPane.showMessageDialog(null, "Usuário não cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);
				LoginFile.setLogin(false);

			} else {

				JOptionPane.showMessageDialog(null,
						"Ops! Parece que Ocorreu um erro inesperado ao iniciar a sessão com " + userID
								+ ". Tente novamente mais tarde.",
						"Erro", JOptionPane.ERROR_MESSAGE);

				LoginFile.setLogin(false);
			}
		}

		if (e.getSource() == loginView.getButton(2)) {

			TapSong.getSong();

			if (showingPassword) {

				loginView.getJPasswordFieldPassword().setEchoChar('•');
				loginView.getButton(2).setText("Exibir senha");

			} else {

				loginView.getJPasswordFieldPassword().setEchoChar((char) 0);
				loginView.getButton(2).setText("Ocultar Senha");
			}

			showingPassword = !showingPassword;
		}

		if (e.getSource() == loginView.getButton(3)) {

			TapSong.getSong();

			loginView.showCadastroView();
		}

		if (e.getSource() == loginView.getButton(4)) {

			TapSong.getSong();
			loginView.showSecondAcessView();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}
}
