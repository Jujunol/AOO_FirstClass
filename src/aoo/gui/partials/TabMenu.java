package aoo.gui.partials;

import aoo.finance.Accountable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Created by Juju on 3/23/2016.
 */
public abstract class TabMenu extends JPanel {

    private ArrayList<Accountable> menuList;
    private JTable table;

    public TabMenu(String[] columns) {
        menuList = new ArrayList<>();

        DefaultTableModel model = new DefaultTableModel();
        table = new JTable(model);

        for (String column : columns) {
            model.addColumn(column);
        }

        add(new JScrollPane(table));
    }

    public TabMenu addItem(Accountable accountable) {
        menuList.add(accountable);
        ((DefaultTableModel) table.getModel()).addRow(accountable.getTabData());
        return this;
    }

}
