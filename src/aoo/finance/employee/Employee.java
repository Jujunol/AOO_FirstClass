package aoo.finance.employee;

public abstract class Employee {
    
    private String name, department, position;
    private int id;
    
    Employee() {
        this("", 0, "", "");
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
    
    public Employee setId(int id) {
        this.id = id;
        return this;
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
    
    @Override
    public String toString() {
        return String.format("Name: %s\nID: %d\nDepartment: %s\nPosition: %s\n", name, id, department, position);
    }
    
}
