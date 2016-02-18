/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoo.finance.employee;

/**
 *
 * @author 200240927
 */
public class HourlyEmployee extends Employee {
    
    private int hoursWorked;
    private double wage;

    public HourlyEmployee(String name, int id) {
        super(name, id);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public HourlyEmployee setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
        return this;
    }

    public HourlyEmployee setWage(double wage) {
        this.wage = wage;
        return this;
    }

    public double getWage() {
        return wage;
    }

    @Override
    public double getEarnings() {
        return wage * hoursWorked;
    }
    
}
