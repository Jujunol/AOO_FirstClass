package aoo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Juju on 3/23/2016.
 */
public class FooterPanel extends JPanel implements ActionListener {

    FooterPanel() {
        JButton exitButton = new JButton("Safe Exit");

        exitButton.addActionListener(this);
        add(exitButton, BorderLayout.CENTER);

        setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.lightGray));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MyWindow window = (MyWindow) SwingUtilities.getWindowAncestor(this);
        window.closeWindow();
    }

}
