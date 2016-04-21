package aoo.gui;

import aoo.Main;
import aoo.finance.Product;
import aoo.finance.employee.*;
import aoo.gui.partials.EmployeeTab;
import aoo.gui.partials.ProductTab;
import aoo.gui.partials.SearchTab;
import aoo.gui.partials.TabMenu;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Created by Juju on 3/23/2016.
 */
public class ContentPanel extends JPanel {

    private JTabbedPane menu;

    ContentPanel() {
        add(createTabbedPane(), BorderLayout.WEST);
    }

    JTabbedPane createTabbedPane() {
        menu = new JTabbedPane();

        EmployeeTab employeeTab = new EmployeeTab();
        ProductTab productTab = new ProductTab();
        try {
            for(Employee employee : Main.getDatabase().getCommissionEmployees()) {
                employeeTab.addItem(employee);
            }
            for(Product product : Main.getDatabase().getProducts()) {
                productTab.addItem(product);
            }
        } catch (SQLException ex) {
            Main.getLogger().logEvent("Unable to retrieve list of employees / products!", ex);
        }

        menu.addTab("Employees", employeeTab);
        menu.addTab("Products", productTab);
        menu.addTab("Search", new SearchTab());

        return menu;
    }

    public void addTab(String text, JPanel tab) {
        menu.add(text, tab);
    }

    public void closeTab(JPanel tab) {
        menu.remove(tab);
    }

    ContentPanel setDimensions(int width, int height) {
        Dimension preferredSize = new Dimension(width, height);

        setPreferredSize(preferredSize);
        menu.setPreferredSize(preferredSize);

        return this;
    }

}
