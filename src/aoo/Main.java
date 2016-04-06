package aoo;

import aoo.finance.employee.Employee;
import aoo.gui.MyWindow;
import aoo.net.Database;

import java.awt.*;

public class Main {

    public static final String TITLE = "Le nom du programme ici";
    public static final int WIDTH = 600, HEIGHT = 500;
    
    public static void main(String[] args) {
        new MyWindow(TITLE, WIDTH, HEIGHT)
                .centerOnScreen()
                .showWindow();
    }

//    public static void main(String[] args) throws Exception {
//        Database database = new Database();
//        for (Employee employee : database.getEmployeeList()) {
//            System.out.println(employee);
//        }
//    }
    
}
