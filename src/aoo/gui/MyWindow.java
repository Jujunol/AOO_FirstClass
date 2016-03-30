package aoo.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Juju on 3/23/2016.
 */
public class MyWindow extends JFrame {

    public MyWindow(String title, int width, int height) {
        super(title);

        add(new GreetingPanel(), BorderLayout.NORTH);
        add(new ContentPanel().setDimensions(width, height), BorderLayout.WEST);
        add(new FooterPanel(), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
    }

    public MyWindow centerOnScreen() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - getWidth()) / 2;
        int y = (screen.height - getHeight()) / 2;
        setBounds(x, y, getWidth(), getHeight());
        return this;
    }

    /**
     * This method is important to keep seperate from the constructor
     * as 'setVisible()' is responsible for the initialization of the JFrame
     * @return this
     */
    public MyWindow showWindow() {
//        pack();
        setVisible(true);
        return this;
    }

    /**
     * Clean up method
     */
    public void closeWindow() {
        dispose();
    }

}
