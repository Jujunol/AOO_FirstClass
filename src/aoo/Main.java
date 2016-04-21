package aoo;

import aoo.gui.MyWindow;
import aoo.logger.Logger;
import aoo.net.Database;

public class Main {

    public static final String TITLE = "Le nom du programme ici";
    public static final int WIDTH = 650, HEIGHT = 700;

    private static Database database;
    private static Logger logger;

    public static Database getDatabase() {
        return database;
    }

    public static Logger getLogger() {
        return logger;
    }
    
    public static void main(String[] args) {
        logger = new Logger();
        try {
            database = new Database();

            new MyWindow(TITLE, WIDTH, HEIGHT)
                    .centerOnScreen()
                    .showWindow();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                logger.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
