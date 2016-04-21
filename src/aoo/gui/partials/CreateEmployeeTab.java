package aoo.gui.partials;

import aoo.Main;
import aoo.finance.employee.CommissionEmployee;
import aoo.tester.EmployeeTester;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Juju on 4/20/2016.
 */
public class CreateEmployeeTab extends JPanel implements ActionListener {

    private CommissionEmployee employee;
    private JTextField nameField, departmentField, positionField, commissionField, grossSalesField;
    private JTextField yearField, monthField, dayField;
    private JButton submit;

    public CreateEmployeeTab() {
        JLabel nameLabel = new JLabel("Name: ");
        JLabel departmentLabel = new JLabel("Department: ");
        JLabel positionLabel = new JLabel("Position: ");
        JLabel commissionLabel = new JLabel("Commission Rate: ");
        JLabel grossSalesLabel = new JLabel("Gross Sales: ");
        JLabel hireDateLabel = new JLabel("Hire Date: ");

        nameField = new JTextField(50);
        departmentField = new JTextField(50);
        positionField = new JTextField(25);
        commissionField = new JTextField(5);
        grossSalesField = new JTextField(5);
        submit = new JButton("Save Employee");

        setLayout(new GridLayout(7, 2));
        submit.addActionListener(this);

        add(nameLabel);
        add(nameField);
        add(departmentLabel);
        add(departmentField);
        add(positionLabel);
        add(positionField);
        add(commissionLabel);
        add(commissionField);
        add(grossSalesLabel);
        add(grossSalesField);
        add(hireDateLabel);
        add(createHireDatePanel());
        add(new Label("")); // blank label to shift over button
        add(submit);
    }

    public CreateEmployeeTab(CommissionEmployee employee) {
        this();
        fillFields(employee);
    }

    private void fillFields(CommissionEmployee employee) {
        this.employee = employee;

        nameField.setText(employee.getName());
        departmentField.setText(employee.getDepartment());
        positionField.setText(employee.getPosition());
        commissionField.setText("" + employee.getCommissionRate());
        grossSalesField.setText("" + employee.getGrossSales());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(employee.getHireDate());
        yearField.setText("" + calendar.get(Calendar.YEAR));
        monthField.setText("" + calendar.get(Calendar.MONTH));
        dayField.setText("" + calendar.get(Calendar.DAY_OF_MONTH));
    }

    private JPanel createHireDatePanel() {
        JPanel panel = new JPanel();

        yearField = new JTextField("yyyy", 4);
        monthField = new JTextField("mm", 2);
        dayField = new JTextField("dd", 2);

        panel.setLayout(new GridLayout(1, 3));
        panel.add(yearField);
        panel.add(monthField);
        panel.add(dayField);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        // Test data before sending employee
        EmployeeTester tester = new EmployeeTester();

        String name, department, position;
        int year, month, day;
        double commissionRate, grossSales;

        name = nameField.getText();
        if(!tester.testName(name)) {
            error("Invalid name");
            return;
        }

        department = departmentField.getText();
        if(!tester.testDepartment(department)) {
            error("Invalid department");
            return;
        }

        position = positionField.getText();
        if(!tester.testPosition(position)) {
            error("Invalid position");
            return;
        }

        if(!tester.testYear(yearField.getText())) {
            error("Invalid year");
            return;
        }
        year = Integer.parseInt(yearField.getText());

        if(!tester.testMonth(monthField.getText())) {
            error("Invalid month");
            return;
        }
        month = Integer.parseInt(monthField.getText());

        if(!tester.testDay(dayField.getText())) {
            error("Invalid day");
            return;
        }
        day = Integer.parseInt(dayField.getText());

        if(!tester.testCommissionRate(commissionField.getText())) {
            error("Invalid commission");
            return;
        }
        commissionRate = Double.parseDouble(commissionField.getText());

        if(!tester.testGrossSales(grossSalesField.getText())) {
            error("Invalid number for gross sales");
            return;
        }
        grossSales = Double.parseDouble(grossSalesField.getText());

        Date hireDate = new Date();
        try {
            hireDate = new SimpleDateFormat("yyyyMMdd").parse("" + year + month + day);
        } catch (Exception ex) {
            Main.getLogger().logEvent("Could not parse hire date of year:{" + year + "}, month:{" + month + "}, day: {"+ day + "}", ex);
        }

        // Check if we're updating or creating ( using employee passed )
        if(employee == null) {
            // all testing done - create employee object
            Main.getDatabase().registerCommisionEmployee(
                    (CommissionEmployee) new CommissionEmployee(-1)
                    .setCommissionRate(commissionRate)
                    .setGrossSales(grossSales)
                    .setName(name)
                    .setPosition(position)
                    .setDepartment(department)
                    .setHireDate(hireDate)
            );
        }
        else {
            // TODO update employee code here
            employee.setCommissionRate(commissionRate)
                    .setGrossSales(grossSales)
                    .setName(name)
                    .setPosition(position)
                    .setDepartment(department)
                    .setHireDate(hireDate);

        }

        JOptionPane.showMessageDialog(this, "Employee added successfully!");
    }

    private void error(String error) {
        JOptionPane.showMessageDialog(this, error, "Error!", JOptionPane.ERROR_MESSAGE);
    }
}
