package view;

import java.awt.*;
import javax.swing.*;
import controller.SecondAcessController;

public class SecondAcessView extends JPanel {

	private SecondAcessController secondAcessController;
	private JLabel tip, lbl[];
	private JTextField userIDTF, acessWorkTF;
	private JButton[] button;
	private Image background;
	private static JDialog jdSecondAcessView;

	public SecondAcessView() {
		secondAcessController = new SecondAcessController(this);

		jdSecondAcessView = new JDialog();
		jdSecondAcessView.setSize(450, 510);

		setLayout(null);
		setSize(450, 510);
		background = new ImageIcon("MenuComponents/loginView.png").getImage();

		lbl = new JLabel[3];

		lbl[0] = new JLabel("Usuário (ID)");
		lbl[0].setBounds((jdSecondAcessView.getWidth() - 210) / 2, 195, 100, 35);

		lbl[1] = new JLabel("Palavra");
		lbl[1].setBounds((jdSecondAcessView.getWidth() - 210) / 2, 255, 100, 35);

		for (int i = 0; i < lbl.length - 1; i++) {
			lbl[i].setFont(new Font("", Font.BOLD, 12));
			lbl[i].setForeground(Color.WHITE);
			add(lbl[i]);
		}

		String frase = "<html><br>- Utilize o seu id para encontrar uma dica da palavra cadastrada.<br></html>";
		lbl[2] = new JLabel(frase);
		lbl[2].setBounds(75, 1, 300, 35);
		lbl[2].setFont(new Font("", Font.BOLD, 10));
		lbl[2].setForeground(Color.RED);
		add(lbl[2]);

		button[0].setBounds(1, 1, 70, 35);
		button[1].setBounds((jdSecondAcessView.getWidth() - 120) / 2, 375, 120, 30);
		button[2].setBounds((jdSecondAcessView.getWidth() - 95) / 2, 420, 95, 30);

		for (int i = 0; i < button.length; i++) {
			button[i].setFont(new Font("", Font.BOLD, 12));
			button[i].setFocusPainted(false);
			button[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
			button[i].setBackground(new Color(200, 50, 220));
			add(button[i]);
		}

		tip.setFont(new Font("Arial", Font.BOLD, 35));
		tip.setForeground(Color.WHITE);
		tip.setHorizontalAlignment(SwingConstants.CENTER);
		tip.setBounds((jdSecondAcessView.getWidth() - 500) / 2, 10, 500, 300);
		add(tip);

		userIDTF.setBounds((jdSecondAcessView.getWidth() - 210) / 2, 225, 210, 35);
		add(userIDTF);

		acessWorkTF.setBounds((jdSecondAcessView.getWidth() - 210) / 2, 285, 210, 35);
		add(acessWorkTF);

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
		jdSecondAcessView.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 3));
		jdSecondAcessView.setUndecorated(true);
		jdSecondAcessView.setResizable(false);
		jdSecondAcessView.setLocationRelativeTo(null);
		jdSecondAcessView.setModal(true);
		jdSecondAcessView.add(this);
		jdSecondAcessView.revalidate();
		jdSecondAcessView.repaint();
		jdSecondAcessView.setVisible(false);
	}

	public static JDialog getJDialog() {
		return jdSecondAcessView;
	}

	public void instantiateControllerComponents() {

		tip = new JLabel();

		button = new JButton[3];

		button[0] = new JButton("Voltar");
		button[1] = new JButton("Buscar dica");
		button[2] = new JButton("Entrar");

		userIDTF = new JTextField();
		acessWorkTF = new JTextField();
	}

	public String getUserIFTF() {

		return userIDTF.getText();
	}

	public String getAcessWorkTF() {

		return acessWorkTF.getText();
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

	public void setTipLabel(String tip) {

		this.tip.setText(this.tip.getText() + tip);
	}

	public void clearComponents() {

		tip.setText("");
		userIDTF.setText("");
		acessWorkTF.setText("");
	}
}