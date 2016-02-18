package aoo.finance.test;

import aoo.finance.employee.Employee;
import aoo.finance.employee.HourlyEmployee;

/**
 * Created by Juju on 20/01/2016.
 */
public class EmployeeTest extends TesterBase {
    
    //@Test
    //public void testEmployee() throws Exception {
    public static void main(String[] args) {
        Employee mike = new HourlyEmployee("Mike", 268)
                .setWage(15.20)
                .setHoursWorked(40)
                .setHireDate("20100524");
        
        System.out.println(mike);
        System.out.println("Earnings: " + mike.getEarnings());
    }
    
}
