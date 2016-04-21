package aoo.finance.employee;

import aoo.finance.Accountable;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee implements Accountable {

    /*
    create table EMP_PROJ_EMPLOYEE (
        emp_id int AUTO_INCREMENT PRIMARY key,
        name varchar(50) not null,
        department varchar(25) not null,
        position varchar(25) not null,
        hireDate date default CURRENT_DATE
    );
     */
    
    private final int id;
    private String name, department, position;
    private Date hireDate;

    private int updatedID;

    Employee(int id) {
        this("", id, "", "");
    }
    
    Employee(String name, int id) {
        this(name, id, "", "");
    }
    
    Employee(String name, int id, String department, String position) {
        this.name = name;
        this.id = id;
        this.department = department;
        this.position = position;
    }
    
    public abstract double getEarnings();

    @Override
    public String getName() {
        return name;
    }
    
    public Employee setName(String name) {
        this.name = name;
        return this;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public Employee setDepartment(String department) {
        this.department = department;
        return this;
    }
    
    public String getPosition() {
        return position;
    }
    
    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Employee setHireDate(Date hireDate) {
//        try {
//            this.hireDate = new SimpleDateFormat("yyyyMMdd").parse(hireDate);
//        } catch (Exception ex) {
//            throw new RuntimeException("Unexpected date format for HireDate: " + hireDate);
//        }
        this.hireDate = hireDate;
        return this;
    }

    public int getUpdatedID() {
        return updatedID;
    }

    public Employee setUpdatedID(int updatedID) {
        this.updatedID = updatedID;
        return this;
    }

    @Override
    public Object[] getTabData() {
        return new Object[]{
                id,
                name,
                department,
                position,
                hireDate
        };
    }
    
    @Override
    public String toString() {
        return new StringBuilder()
                .append("Class: \t").append(this.getClass().getSimpleName())
                .append("\nName: \t").append(name)
                .append("\nID: \t").append(id)
                .append("\nDepartment: \t").append(department)
                .append("\nPosition: \t").append(position)
                .append("\nHire Date: ").append(hireDate)
                .toString();
    }
    
}
