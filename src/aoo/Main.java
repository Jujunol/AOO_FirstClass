package aoo;

import aoo.gui.MyWindow;

public class Main {
    
    public static void main(String[] args) {
        new MyWindow("Le nom du programme ici", 400, 600)
                .centerOnScreen()
                .showWindow();
    }
    
}
