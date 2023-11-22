package view;

import java.awt.*;

import javax.swing.*;

import controller.CadastroController;

public class CadastroView extends JPanel {

	private JLabel[] lbl;
	private JButton[] button;
	private JTextField userIDTF, emailTF, acessWorkTF, tipTF;
	private JPasswordField passwordPF, surePasswordPF;
	private CadastroController cadastroController;
	private static JDialog jdCadastro;
	private Image background;

	public CadastroView() {

		cadastroController = new CadastroController(this);

		setLayout(null);
		background = new ImageIcon("MenuComponents/cadastroView.gif").getImage();

		jdCadastro = new JDialog();
		jdCadastro.setSize(830, 498);

		JLabel title = new JLabel("CADASTRO");
		title.setForeground(Color.WHITE);
		title.setBounds((jdCadastro.getWidth() - 220)/ 2, 48, 220, 50);
		title.setFont(new Font("Verdana", Font.BOLD, 35));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);

		lbl = new JLabel[6];

		lbl[0] = new JLabel("Usuário (ID)");
		lbl[0].setBounds(90, 120, 100, 35);
		lbl[1] = new JLabel("Email");
		lbl[1].setBounds(90, 190, 100, 35);
		lbl[2] = new JLabel("Senha");
		lbl[2].setBounds(90, 260, 100, 35);
		lbl[3] = new JLabel("Confirmar senha");
		lbl[3].setBounds(487, 120, 120, 35);
		lbl[4] = new JLabel("Palavra de Acesso");
		lbl[4].setBounds(487, 190, 200, 35);
		lbl[5] = new JLabel("Dica da Palavra de Acesso");
		lbl[5].setBounds(487, 260, 150, 35);

		for (int i = 0; i < lbl.length; i++) {
			lbl[i].setFont(new Font("", Font.BOLD, 12));
			lbl[i].setForeground(Color.WHITE);
			add(lbl[i]);
		}

		userIDTF.setBounds(90, 150, 250, 35);
		userIDTF.setBackground(Color.LIGHT_GRAY);
		add(userIDTF);

		emailTF.setBounds(90, 220, 250, 35);
		emailTF.setBackground(Color.LIGHT_GRAY);
		add(emailTF);

		passwordPF.setBounds(90, 290, 250, 35);
		passwordPF.setBackground(Color.LIGHT_GRAY);
		add(passwordPF);

		surePasswordPF.setBounds(487, 150, 250, 35);
		surePasswordPF.setBackground(Color.LIGHT_GRAY);
		add(surePasswordPF);

		acessWorkTF.setBounds(487, 220, 250, 35);
		acessWorkTF.setBackground(Color.LIGHT_GRAY);
		add(acessWorkTF);

		tipTF.setBounds(487, 290, 250, 35);
		tipTF.setBackground(Color.LIGHT_GRAY);
		add(tipTF);

		button[0].setBounds(1, 1, 70, 35);
		button[1].setBounds((jdCadastro.getWidth() - 120) / 2, 405, 120, 35);
		button[2].setBounds((jdCadastro.getWidth() - 120) / 2, 365, 120, 35);

		for (int i = 0; i < button.length; i++) {
			button[i].setFont(new Font("", Font.BOLD, 12));
			button[i].setFocusPainted(false);
			button[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			button[i].setBackground(new Color(200, 50, 220));
			button[i].setForeground(Color.BLACK);
			add(button[i]);
		}

		revalidate();
		repaint();

		createJDialog();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0, 0, this);
	}

	private void createJDialog() {
		jdCadastro.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 3));
		jdCadastro.setUndecorated(true);
		jdCadastro.setResizable(false);
		jdCadastro.setLocationRelativeTo(null);
		jdCadastro.setModal(true);
		jdCadastro.add(this);
		jdCadastro.revalidate();
		jdCadastro.repaint();
		jdCadastro.setVisible(false);
	}

	public static JDialog getJDialog() {
		return jdCadastro;
	}

	public void instantiateControllerComponents() {

		button = new JButton[3];

		button[0] = new JButton("Voltar");
		button[1] = new JButton("Cadastrar");
		button[2] = new JButton("Exibir senhas");
		
		userIDTF = new JTextField();
		emailTF = new JTextField();
		passwordPF = new JPasswordField();
		surePasswordPF = new JPasswordField();
		acessWorkTF = new JTextField();
		tipTF = new JTextField();
	}

	public JButton getButton0() {

		return button[0];
	}

	public JButton getButton1() {

		return button[1];
	}

	public JButton getButton2() {

		return button[2];
	}

	public void clearJTextFields() {
		
		userIDTF.setText("");
		emailTF.setText("");
		acessWorkTF.setText("");
		tipTF.setText("");
		passwordPF.setText("");
		surePasswordPF.setText("");
	}
	
	public JPasswordField getJPasswordFieldPassword() {

		return passwordPF;
	}

	public JPasswordField getJPasswordFieldSurePassword() {

		return surePasswordPF;
	}

	public String getUserIDTF() {

		return userIDTF.getText();
	}

	public char[] getPasswordPF() {

		return passwordPF.getPassword();
	}

	public char[] getSurePasswordPF() {

		return surePasswordPF.getPassword();
	}

	public String getEmailTF() {

		return emailTF.getText();
	}

	public String getAcessWorkTF() {

		return acessWorkTF.getText();
	}

	public String getTipTF() {

		return tipTF.getText();
	}
}
