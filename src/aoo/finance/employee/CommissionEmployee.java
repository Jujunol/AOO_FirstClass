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
public class CommissionEmployee extends Employee {
    
    private double commissionRate, grossSales;

    public CommissionEmployee(String name, int id) {
        super(name, id);
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public CommissionEmployee setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
        return this;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public CommissionEmployee setGrossSales(double grossSales) {
        this.grossSales = grossSales;
        return this;
    }

    @Override
    public double getEarnings() {
        return commissionRate * grossSales;
    }
    
    @Override
    public String toString() {
        return new StringBuilder(super.toString())
                .append("\nCommission Rate: \t").append(commissionRate)
                .append("\nGross Sales: \t").append(grossSales)
                .toString();
    }
    
}
