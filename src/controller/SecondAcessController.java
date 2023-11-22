package controller;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.LoginBO;
import model.SecondAcessBO;
import view.LoginView;
import view.SecondAcessView;

public class SecondAcessController implements ActionListener {

	private SecondAcessView secondAcessView;
	private SecondAcessBO secondAcessBO;
	private LoginBO loginBO;

	public SecondAcessController(SecondAcessView secondAcessView) {

		secondAcessBO = new SecondAcessBO();
		loginBO = new LoginBO();
		secondAcessView.instantiateControllerComponents();

		secondAcessView.getButton0().addActionListener(this);
		secondAcessView.getButton1().addActionListener(this);
		secondAcessView.getButton2().addActionListener(this);

		this.secondAcessView = secondAcessView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String userID = secondAcessView.getUserIFTF();
		String acessWork = secondAcessView.getAcessWorkTF();

		if (e.getSource() == secondAcessView.getButton0()) {

			TapSong.getSong();
			SecondAcessView.getJDialog().dispose();
			LoginView.getJDialog().setVisible(true);
			secondAcessView.clearComponents();
		}

		if (e.getSource() == secondAcessView.getButton1()) {

			TapSong.getSong();

			if (loginBO.verificarUserIDExistente(userID)) {

				if (!userID.isEmpty())
					secondAcessView.setTipLabel(secondAcessBO.buscarDica(userID));

				else
					JOptionPane.showMessageDialog(null, "Preencha o primeiro campo!", "Erro",
							JOptionPane.ERROR_MESSAGE);
			}

			else
				JOptionPane.showMessageDialog(null, "Usuário não cadastrado.", "Erro", JOptionPane.ERROR_MESSAGE);

		}

		if (e.getSource() == secondAcessView.getButton2()) {

			TapSong.getSong();

			int resultado = loginBO.realizarLoginSecundario(userID, acessWork);

			if (acessWork.isEmpty())
				JOptionPane.showMessageDialog(null, "Informe a palavra!", "Erro", JOptionPane.ERROR_MESSAGE);

			if (resultado == 0) {

				SecondAcessView.getJDialog().dispose();
				LoginView.getJDialog().dispose();
				LoginFile.setUserID(userID);
				LoginFile.setLogin(true);

				JOptionPane.showMessageDialog(null, "Bem vindo " + userID + ".", "Sessão iniciada",
						JOptionPane.INFORMATION_MESSAGE);

			} else if (resultado == 1) {

				JOptionPane.showMessageDialog(null, "Palavra Incorreta.", "Erro", JOptionPane.ERROR_MESSAGE);
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
	}
}
