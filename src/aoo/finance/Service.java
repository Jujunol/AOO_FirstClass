package aoo.finance;

public class Service {
    
    private static int employeeId = 10000;

    public static int getEmployeeId() {
        return employeeId++;
    }

}
