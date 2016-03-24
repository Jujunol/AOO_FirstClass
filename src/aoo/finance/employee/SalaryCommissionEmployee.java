package aoo.finance.employee;

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
