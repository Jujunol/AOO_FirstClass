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
    
    private double wage;
    
    public HourlyEmployee(String name, int id, double wage) {
        this(name, id, "", "", wage);
    }
    
    public HourlyEmployee(String name, int id, String department, String position, double wage) {
        super(name, id, department, position);
        this.wage = wage;
    }

    public HourlyEmployee setWage(double wage) {
        this.wage = wage;
        return this;
    }

    public double getWage() {
        return wage;
    }
    
}
