package view;

import java.awt.*;
import javax.swing.*;

import controller.UserPanelController;

public class UserPanelView extends JPanel {

	private JButton edit, cancel, confirm, exit, delete;
	private JTextField userIDTF, emailTF, acessWorkTF, tipTF;
	private JPasswordField passwordPF;
	private UserPanelController userPanelController;
	private Image background;

	public UserPanelView() {
		userPanelController = new UserPanelController(this);

		setBackground(null);
		setOpaque(false);

		setPreferredSize(new Dimension(380, 700));
		background = new ImageIcon("MenuComponents/userPanelBackground.png").getImage();

		setBackground(Color.BLACK);
		setLayout(null);
		setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 3, true));

		setLayout(null);
		setBounds(5, 45, 370, 720);

		JLabel title = new JLabel("Painel do Usuário");
		title.setBounds(100, 40, 200, 50);
		title.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		title.setForeground(Color.WHITE);
		add(title);

		JLabel[] lbl = new JLabel[3];

		lbl[0] = new JLabel("ID: ");
		lbl[0].setBounds(115, 135, 100, 35);
		add(lbl[0]);

		userIDTF.setBounds(135, 135, 110, 30);
		userIDTF.setHorizontalAlignment(SwingConstants.CENTER);
		userIDTF.setBackground(null);
		userIDTF.setForeground(Color.WHITE);
		userIDTF.setEditable(false);
		add(userIDTF);

		lbl[1] = new JLabel("Email & Senha");
		lbl[1].setBounds(90, 200, 110, 35);
		add(lbl[1]);

		emailTF.setBounds(90, 230, 200, 35);
		emailTF.setEditable(false);
		add(emailTF);

		passwordPF.setBounds(90, 280, 200, 35);
		passwordPF.setEditable(false);
		add(passwordPF);

		lbl[2] = new JLabel("Palavra & Dica de Acesso");
		lbl[2].setBounds(90, 350, 200, 35);
		add(lbl[2]);

		for (int i = 0; i < lbl.length; i++) {
			lbl[i].setForeground(Color.WHITE);
		}

		acessWorkTF.setBounds(90, 380, 200, 35);
		acessWorkTF.setEditable(false);
		add(acessWorkTF);

		tipTF.setBounds(90, 430, 200, 35);
		tipTF.setEditable(false);
		add(tipTF);

		edit.setBounds(115, 490, 150, 35);
		edit.setForeground(Color.WHITE);
		edit.setBackground(new Color(200, 50, 220));
		add(edit);

		cancel.setBounds(90, 490, 90, 35);
		cancel.setForeground(Color.WHITE);
		cancel.setBackground(new Color(200, 50, 220));

		confirm.setBounds(200, 490, 90, 35);
		confirm.setForeground(Color.WHITE);
		confirm.setBackground(new Color(200, 50, 220));

		exit.setBounds(115, 580, 150, 35);
		exit.setForeground(Color.WHITE);
		exit.setBackground(new Color(200, 50, 220));
		add(exit);

		delete.setBounds(115, 630, 150, 35);
		delete.setForeground(Color.WHITE);
		delete.setBackground(new Color(242, 41, 41));
		add(delete);
	}

	public void instantiateControllerComponents() {

		userIDTF = new JTextField();
		emailTF = new JTextField();
		acessWorkTF = new JTextField();
		tipTF = new JTextField();
		passwordPF = new JPasswordField();

		edit = new JButton("Editar");

		cancel = new JButton("Cancelar");
		confirm = new JButton("Salvar");
		exit = new JButton("Sair da Conta");
		delete = new JButton("Deletar Conta");
	}

	public JTextField getUserIDTF() {

		return userIDTF;
	}

	public JTextField getEmailTF() {

		return emailTF;
	}

	public JTextField getAcessWorkTF() {

		return acessWorkTF;
	}

	public JTextField getTipTF() {

		return tipTF;
	}

	public JPasswordField getPasswordPF() {

		return passwordPF;
	}

	public JButton getEditButton() {

		return edit;
	}

	public JButton getCancelButton() {

		return cancel;
	}

	public JButton getConfirmButton() {

		return confirm;
	}

	public JButton getExitButton() {

		return exit;
	}

	public JButton getDeleteButton() {

		return delete;
	}

	public void setTextFields(String userID, String email, String password, String acessWork, String tip) {

		userIDTF.setText(userID);
		emailTF.setText(email);
		acessWorkTF.setText(acessWork);
		tipTF.setText(tip);
		passwordPF.setText(password);
	}
}