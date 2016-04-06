package aoo.gui.partials;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 200240927 on 4/6/2016.
 */
public class SearchTab extends JPanel {

    public SearchTab() {
        JTextField searchField = new JTextField();
//        JTextArea displayField = new JTextArea();

        add(searchField, BorderLayout.NORTH);
//        add(displayField, BorderLayout.SOUTH);
    }

}
