package aoo.gui.partials;

import aoo.gui.ContentPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 200240927 on 4/6/2016.
 */
public class SearchTab extends JPanel {

    public SearchTab() {
//        JTextField searchField = new JTextField(20);
//        JTextArea displayField = new JTextArea(20, 40);

//        searchField.setPreferredSize(new Dimension(this.getWidth(), 20));
//        displayField.setPreferredSize(new Dimension(this.getWidth(), this.getHeight() - 30));

//        add(searchField);
//        add(displayField, BorderLayout.CENTER);

        add(new JLabel("No functionality provided for searching"));
        add(createButtonPanel());
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        JButton addEmployeeButton = new JButton("Add Employee");
        JButton addProductButton = new JButton("Add Product");
        JButton searchButton = new JButton("Search for Employee/Product");

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // .addTab("New Employee", new CreateEmployeeTab());
                getContentPanel().addTab("New Employee", new CreateEmployeeTab());
            }
        });

        panel.setLayout(new GridLayout(1, 3));
        panel.add(addEmployeeButton);
        panel.add(addProductButton);
        panel.add(searchButton);

        return panel;
    }

    private ContentPanel getContentPanel() {
        return (ContentPanel) SwingUtilities.getAncestorOfClass(ContentPanel.class, this);
    }

}
