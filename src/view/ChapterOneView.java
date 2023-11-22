package view;

import controller.ChapterOneController;
import controller.DialogController;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;

public class ChapterOneView extends JPanel {

    private ChapterOneController chapterOneController;
    private static ChapterOneView instance;

    public ChapterOneView() {
        chapterOneController = new ChapterOneController(this);
        instance = this;
        setLayout(new BorderLayout());
        String texto = "<html>Não sei quanto tempo o oxigênio vai durar e nem como vou sobreviver,<br>" +
                "mas preciso recuperar o ATLAS, antes que seja tarde demais.<br>" +
                "<br>Capítulo 1 - Viagem só de ida.</html>";
        add(new DialogView(texto), BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {

    }

    public void instantiateControllerComponents() {

    }

    public static ChapterOneView getInstance() {
        return instance;
    }
}
