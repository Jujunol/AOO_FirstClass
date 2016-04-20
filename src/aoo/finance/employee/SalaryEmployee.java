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
public class SalaryEmployee extends Employee {

    /*
    create table EMP_PROJ_SALARY_EMPLOYEE (
        emp_id int primary key,
        salary decimal(10, 2),

        foreign key (emp_id) REFERENCES EMP_PROJ_EMPLOYEE(emp_id)
    );
     */

    private double salary;

    public SalaryEmployee(String name, int id) {
        super(name, id);
    }

    public SalaryEmployee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    @Override
    public double getEarnings() {
        return salary;
    }
}
