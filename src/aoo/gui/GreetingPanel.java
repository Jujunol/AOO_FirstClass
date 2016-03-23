package aoo.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Juju on 3/23/2016.
 */
public class GreetingPanel extends JPanel {

    public GreetingPanel() {
        JLabel label = new JLabel("Le nom du programme ici");

        label.setFont(new Font(Font.SERIF, Font.BOLD, 24));
        add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(getWidth(), 50));
        setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.lightGray));
    }

}
