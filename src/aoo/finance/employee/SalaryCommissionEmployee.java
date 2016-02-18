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
public class SalaryCommissionEmployee extends CommissionEmployee {

    private double baseSalary;
    
    public SalaryCommissionEmployee(String name, int id) {
        super(name, id);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public SalaryCommissionEmployee setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
        return this;
    }

    @Override
    public double getEarnings() {
        return super.getEarnings() + baseSalary;
    }
    
}
