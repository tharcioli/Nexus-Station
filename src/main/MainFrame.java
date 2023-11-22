package main;

import view.MenuView;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static int w;
    private static int h;
    private static MainFrame instance;
    public static MenuView menuView;

    public MainFrame() {
        instance = this;
        setTitle("NEXUS STATION");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        w = d.width;
        h = d.height;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(w, h);

        getContentPane().setBackground(Color.BLACK);
        menuView = new MenuView();
        add(menuView);

        setResizable(false);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
            new MainFrame();
    }

    public static int getW() {
        return w;
    }

    public static int getH() {
        return h;
    }

    public static MainFrame getInstance() { return instance; }

    public static MenuView getMenuView() { return menuView; }
    public static void setMenuView(MenuView mv) { menuView = mv; }
}
