package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.NewsView;

public class NewsController implements ActionListener, KeyListener {

	private final NewsView newsView;
	private int indiceSlideAtual;
	
	public NewsController(NewsView newsView) {

		newsView.instantiateControllerComponents();

		indiceSlideAtual = 0;

		if (indiceSlideAtual == 2)
			newsView.getNextButton().setVisible(false);
		else
			newsView.getNextButton().setVisible(true);

		if (indiceSlideAtual == 0)
			newsView.getPreviousButton().setVisible(false);
		else
			newsView.getPreviousButton().setVisible(true);

		newsView.getCloseButton().addActionListener(this);
		newsView.getPreviousButton().addActionListener(this);
		newsView.getNextButton().addActionListener(this);

		this.newsView = newsView;
		
		if(newsView.isVisible())
			newsView.transferFocus();
		
		else
			newsView.getParent().transferFocus();
		
		newsView.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == newsView.getCloseButton()) {

			TapSong.getSong();

			newsView.dispose();
		}

		if (e.getSource() == newsView.getPreviousButton()) {

			TapSong.getSong();

			if(indiceSlideAtual == 1)
				indiceSlideAtual = 0;

			if(indiceSlideAtual == 2)
				indiceSlideAtual = 1;
		}

		if (e.getSource() == newsView.getNextButton()) {

			TapSong.getSong();

			if(indiceSlideAtual == 1)
				indiceSlideAtual = 2;

			if(indiceSlideAtual == 0)
				indiceSlideAtual = 1;
		}

		newsView.setSlide(indiceSlideAtual);

		if (indiceSlideAtual == 2)
			newsView.getNextButton().setVisible(false);
		else
			newsView.getNextButton().setVisible(true);

		if (indiceSlideAtual == 0)
			newsView.getPreviousButton().setVisible(false);
		else
			newsView.getPreviousButton().setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}
}
