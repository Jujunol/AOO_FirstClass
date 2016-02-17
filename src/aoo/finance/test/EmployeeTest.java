package aoo.finance.test;

import aoo.finance.employee.HourlyEmployee;

/**
 * Created by Juju on 20/01/2016.
 */
public class EmployeeTest extends TesterBase {
    
    //@Test
    //public void testEmployee() throws Exception {
    public static void main(String[] args) {
        HourlyEmployee mike = new HourlyEmployee("Mike", 268, 15.20);
        
        System.out.println(mike);
    }
    
}
