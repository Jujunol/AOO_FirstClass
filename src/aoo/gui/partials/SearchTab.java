package aoo.gui.partials;

import javax.swing.*;
import java.awt.*;

/**
 * Created by 200240927 on 4/6/2016.
 */
public class SearchTab extends JPanel {

    public SearchTab() {
        JTextField searchField = new JTextField(20);
        JTextArea displayField = new JTextArea(20, 40);

//        searchField.setPreferredSize(new Dimension(this.getWidth(), 20));
//        displayField.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 30));

        add(searchField, BorderLayout.NORTH);
        add(displayField, BorderLayout.CENTER);
    }

}
