package view;

import java.awt.*;
import javax.swing.*;

import controller.LoginController;

public class LoginView extends JPanel {

	private JButton[] button;
	private JTextField userIDTF;
	private JPasswordField passwordPF;
	private CadastroView cadastroView;
	private SecondAcessView secondAcessView;
	private LoginController loginController;
	private static JDialog jd;
	private Image background;

	public LoginView() {
		loginController = new LoginController(this);

		setLayout(null);

		jd = new JDialog();
		jd.setSize(450, 510);

		background = new ImageIcon("MenuComponents/loginView.png").getImage();

		JLabel title = new JLabel("LOG.IN");
		title.setForeground(Color.WHITE);
		title.setBounds((jd.getWidth() - 200)/ 2, 95, 200, 50);
		title.setFont(new Font("Verdana", Font.BOLD, 35));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);

		JLabel[] lbl = new JLabel[2];

		lbl[0] = new JLabel("Usuário (ID)");
		lbl[0].setBounds((jd.getWidth() - 210) / 2, 195, 100, 35);

		lbl[1] = new JLabel("Senha");
		lbl[1].setBounds((jd.getWidth() - 210) / 2, 255, 100, 35);

		for (int i = 0; i < lbl.length; i++) {
			lbl[i].setFont(new Font("", Font.BOLD, 12));
			lbl[i].setForeground(Color.WHITE);
			add(lbl[i]);
		}

		userIDTF.setForeground(Color.BLACK);
		userIDTF.setBounds((jd.getWidth() - 210) / 2, 225, 210, 35);
		add(userIDTF);

		passwordPF.setForeground(Color.BLACK);
		passwordPF.setBounds((jd.getWidth() - 210) / 2, 285, 210, 35);
		add(passwordPF);

		button[0].setBounds(0, 0, 85, 35);
		button[1].setBounds((jd.getWidth() - 95) / 2, 410, 95, 30);
		button[2].setBounds((jd.getWidth() - 250) / 2, 365, 120, 30);
		button[3].setBounds(329, 0, 115, 25);
		button[4].setBounds((jd.getWidth() - -30) / 2, 365, 120, 30);

		for (int i = 0; i < button.length; i++) {
			button[i].setFont(new Font("", Font.BOLD, 12));
			button[i].setFocusPainted(false);
			button[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			button[i].setBackground(new Color(200, 50, 220));
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
		jd.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 3));
		jd.setUndecorated(true);
		jd.setResizable(false);
		jd.setLocationRelativeTo(null);
		jd.setModal(true);
		jd.add(this);
		jd.revalidate();
		jd.repaint();
		jd.setVisible(true);
	}

	public static JDialog getJDialog() {
		return jd;
	}

	public void instantiateControllerComponents() {
		userIDTF = new JTextField();
		passwordPF = new JPasswordField();
		cadastroView = new CadastroView();
		secondAcessView = new SecondAcessView();

		button = new JButton[5];
		button[0] = new JButton("Fechar");
		button[1] = new JButton("Entrar");
		button[2] = new JButton("Exibir Senha");
		button[3] = new JButton("Cadastre-se");
		button[4] = new JButton("Esqueceu senha");
	}

	public JButton getButton(int index) {
		return button[index];
	}

	public JPasswordField getJPasswordFieldPassword() {
		return passwordPF;
	}

	public void showCadastroView() {
		jd.setVisible(false);
		CadastroView.getJDialog().setVisible(true);
	}

	public CadastroView getCadastroView() {
		return cadastroView;
	}

	public void showSecondAcessView() {
		jd.setVisible(false);
		SecondAcessView.getJDialog().setVisible(true);
	}

	public String getUserIDTF() {
		return userIDTF.getText();
	}

	public char[] getPasswordPF() {
		return passwordPF.getPassword();
	}
}
