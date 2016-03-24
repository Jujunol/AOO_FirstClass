package aoo.gui;

import aoo.finance.Accountable;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Juju on 3/23/2016.
 */
public class TabMenu extends JPanel {

    private ArrayList<Accountable> menuList;
    private DefaultListModel<String> menuListModel;

    TabMenu() {
        menuList = new ArrayList<>();
        menuListModel = new DefaultListModel<>();

        JList list = new JList(menuListModel);
        JScrollPane scrollPane = new JScrollPane(list);

        add(scrollPane);
    }

    TabMenu addItem(Accountable accountable) {
        menuList.add(accountable);
        menuListModel.addElement(accountable.getName());
        return this;
    }

}
