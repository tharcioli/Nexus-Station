package view;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import controller.NewsController;

public class NewsView extends JDialog {

	private JButton close, previous, next;
	private JLabel news;

	public NewsView() {

		NewsController newsCOntroller = new NewsController(this);
		
		setLayout(null);

		setSize(1000, 563);

		getRootPane().setBorder(BorderFactory.createLineBorder(new Color(200, 50, 220), 8));
		getContentPane().setBackground(Color.WHITE);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setModal(true);
		
		close.setBounds(0, 0, 75, 35);
		close.setFocusPainted(false);
		close.setBackground(new Color(200, 50, 220));
		close.setForeground(Color.BLACK);
		add(close);

		previous.setBounds(-2, 245, 60, 60);
		previous.setBackground(new Color(200, 50, 220));
		previous.setFont(new Font("Arial", Font.BOLD, 20));
		previous.setForeground(Color.BLACK);
		add(previous);

		next.setBounds(926, 245, 60, 60);
		next.setBackground(new Color(200, 50, 220));
		next.setForeground(Color.BLACK);
		next.setFont(new Font("Arial", Font.BOLD, 20));
		add(next);

		news.setBounds(0, 0, 1000, 563);
		news.setOpaque(false);

		add(news);
	}

	public void instantiateControllerComponents() {

		close = new JButton("Sair");
		previous = new JButton("<");
		next = new JButton(">");

		news = new JLabel(new ImageIcon("MenuComponents/slide(0).gif"));
	}

	public void setSlide(int i) {

		news.setIcon(new ImageIcon("MenuComponents/slide(" + i + ").gif"));
    }

	public JButton getCloseButton() {

		return close;
	}

	public JButton getPreviousButton() {

		return previous;
	}

	public JButton getNextButton() {

		return next;
	}
}
