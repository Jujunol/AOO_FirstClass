package aoo.finance.employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
    
    private final int id;
    private String name, department, position;
    private Date hireDate;
    
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
    
    // This should not be modified after initialization
//    Employee setId(int id) {
//        this.id = id;
//        return this;
//    }
    
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

    public Employee setHireDate(String hireDate) {
        try {
            this.hireDate = new SimpleDateFormat("yyyyMMdd").parse(hireDate);
        } catch (Exception ex) {
            throw new RuntimeException("Unexpected date format for HireDate: " + hireDate);
        }
        return this;
    }
    
    @Override
    public String toString() {
        //return String.format("Class: %s\nName: %s\nID: %d\nDepartment: %s\nPosition: %s\n", this.getClass().getSimpleName(), name, id, department, position);
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
