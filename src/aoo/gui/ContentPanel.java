package aoo.gui;

import aoo.finance.Product;
import aoo.finance.employee.Employee;
import aoo.finance.employee.HourlyEmployee;
import aoo.finance.employee.SalaryCommissionEmployee;
import aoo.finance.employee.SalaryEmployee;
import aoo.gui.partials.EmployeeTab;
import aoo.gui.partials.ProductTab;
import aoo.gui.partials.SearchTab;
import aoo.gui.partials.TabMenu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Juju on 3/23/2016.
 */
public class ContentPanel extends JPanel {

    private JTabbedPane menu;

    ContentPanel() {
        add(createTabbedPane(), BorderLayout.WEST);

        setBorder(BorderFactory.createLineBorder(Color.red));
    }

    JTabbedPane createTabbedPane() {
        menu = new JTabbedPane();

        // TODO populate from database
        Employee mike = new SalaryEmployee("Mike", 268)
                .setSalary(15.20 * 40 * 52);

        Employee joseph = new SalaryCommissionEmployee("Joseph", 268)
                .setBaseSalary(4500)
                .setCommissionRate(24.50)
                .setGrossSales(5);

        Product water = new Product(100, "Water")
                .setCost(0.15)
                .setPrice(2.30)
                .setCategory("Liquid")
                .setDescription("A water bottle");

        Product kitty = new Product(101, "Kitty")
                .setCost(10)
                .setPrice(150)
                .setCategory("Animal")
                .setDescription("A kitty cat");

        menu.addTab("Employees", new EmployeeTab()
                .addItem(mike)
                .addItem(joseph)
        );

        menu.addTab("Products", new ProductTab()
                .addItem(water)
                .addItem(kitty)
        );

        menu.addTab("Search", new SearchTab());

        return menu;
    }

    ContentPanel setDimensions(int width, int height) {
        Dimension preferredSize = new Dimension(width, height);

        setPreferredSize(preferredSize);
        menu.setPreferredSize(preferredSize);

        return this;
    }

}
