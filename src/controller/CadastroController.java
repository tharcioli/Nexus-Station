package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.CadastroBO;
import view.CadastroView;
import view.LoginView;

public class CadastroController implements ActionListener {

	private CadastroView cadastroView;
	private CadastroBO cadastroBO;
	private boolean showingPassword;

	public CadastroController(CadastroView cadastroView) {

		cadastroBO = new CadastroBO();
		showingPassword = false;

		cadastroView.instantiateControllerComponents();
		cadastroView.getButton0().addActionListener(this);
		cadastroView.getButton1().addActionListener(this);
		cadastroView.getButton2().addActionListener(this);

		this.cadastroView = cadastroView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == cadastroView.getButton0()) {

			TapSong.getSong();
			CadastroView.getJDialog().dispose();
			LoginView.getJDialog().setVisible(true);
		}

		if (e.getSource() == cadastroView.getButton1()) {

			TapSong.getSong();

			String userID = cadastroView.getUserIDTF();
			String email = cadastroView.getEmailTF().toLowerCase();
			String password = new String(cadastroView.getPasswordPF());
			String surePassword = new String(cadastroView.getSurePasswordPF());
			String acessWork = cadastroView.getAcessWorkTF();
			String tip = cadastroView.getTipTF();

			String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
			int letterOrSymbolCount = password.replaceAll("[^a-zA-Z\\W_]", "").length();

			if (password.length() < 8 || letterOrSymbolCount < 2 || password.contains(" ") || password.length() > 45) {
				JOptionPane.showMessageDialog(null,
						"A senha deve conter pelo menos 8 caracteres, 2 letras ou símbolos e nada de espaços!\n(máx 45 caracteres)",
						"Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (!email.matches(emailPattern) || email.length() > 100) {
				JOptionPane.showMessageDialog(null, "O email(máx 100 caracteres) inserido não é válido.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (userID.isEmpty() || email.isEmpty() || password.isEmpty() || surePassword.isEmpty()
					|| acessWork.isEmpty() || tip.isEmpty())
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos!", "Erro",
						JOptionPane.ERROR_MESSAGE);

			else if (acessWork.contains(" ") || acessWork.length() > 45) {
				JOptionPane.showMessageDialog(null, "Palavra de acesso(máx 45 caracteres) não deve conter espaços.",
						"Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			else if (cadastroBO.verificarUserIDExistente(userID)) {
				JOptionPane.showMessageDialog(null,
						userID + " Já está em uso.\nPor gentileza, escolha outra ID ou faça login.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			else if (userID.length() > 45) {
				JOptionPane.showMessageDialog(null, "ID de usuário deve conter até 45 caracteres.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			else if (cadastroBO.verificarEmailExistente(email)) {
				JOptionPane.showMessageDialog(null, "Email já cadastrado em outro ID.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			else if (!password.equals(surePassword)) {
				JOptionPane.showMessageDialog(null, "Ops! Parece que você digitou senhas diferentes.", "Erro",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			else {

				if (cadastroBO.cadastrarUsuario(userID, email, password, acessWork, tip)) {
					JOptionPane.showMessageDialog(null,
							"Bem vindo " + userID + "! Faça login para continuar.",
							"Cadastro Concluído", JOptionPane.INFORMATION_MESSAGE);
					cadastroView.clearJTextFields();
					CadastroView.getJDialog().dispose();
				}

				else
					JOptionPane.showMessageDialog(null,
							"Ops! Parece que Ocorreu um erro inesperado ao tentar cadastrar " + userID
									+ ". Tente novamente mais tarde.",
							"Erro", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == cadastroView.getButton2()) {

			TapSong.getSong();

			if (showingPassword) {
				cadastroView.getJPasswordFieldSurePassword().setEchoChar('\u2022');
				cadastroView.getJPasswordFieldPassword().setEchoChar('\u2022');
				cadastroView.getButton2().setText("Exibir senhas");

			} else {
				cadastroView.getJPasswordFieldSurePassword().setEchoChar((char) 0);
				cadastroView.getJPasswordFieldPassword().setEchoChar((char) 0);
				cadastroView.getButton2().setText("Ocultar senhas");
			}

			showingPassword = !showingPassword;
		}
	}
}