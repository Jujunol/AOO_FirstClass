package aoo;

import aoo.gui.MyWindow;

import java.awt.*;

public class Main {

    public static final String TITLE = "Le nom du programme ici";
    public static final int WIDTH = 600, HEIGHT = 500;
    
    public static void main(String[] args) {
        new MyWindow(TITLE, WIDTH, HEIGHT)
                .centerOnScreen()
                .showWindow();
    }
    
}
