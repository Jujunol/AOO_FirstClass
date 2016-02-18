/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aoo;

import aoo.finance.employee.Employee;
import aoo.finance.employee.HourlyEmployee;
import java.util.ArrayList;

/**
 *
 * @author 200240927
 */
public class Main {
    
    public static void main(String[] args) {
        //String firstName,String lastName,int age, 
        //String position, int year,int month, int da
        Employee myEmp = new HourlyEmployee("Joe", "Smith", 30, "Manager", 2016, 3, 20);

        /*String firstName,String lastName,int age, 
         String position, int year,int month, int day, 
         double commissionRate, double grossSales
         */
        Employee myCommEmp = new CommissionSalesEmployee("Jane", "Doe", 32, "Sales", 2016, 3, 18, 0.15, 0.00);

        //firstName,lastName,age,position,year,month,day, commissionRate, grossSales
        Employee mySalPlusCommEmp = new SalaryPlusCommissionEmployee("Steve", "Johnston", 32, "Sales Manager", 2016, 7, 12, 0.25, 10.00, 300.00);

        //generic collection that will store Employees
        ArrayList<Employee> myList = new ArrayList<>();

        myList.add(new CommissionSalesEmployee("Jane", "Doe",
                32, "Sales", 2016, 3, 18, 0.15, 0.00));

        myList.add(new Employee("Joe", "Smith", 30, "Manager",
                2016, 3, 20));

        System.out.println(myEmp.toString());
        System.out.println(myCommEmp.toString());
        System.out.println(mySalPlusCommEmp.toString());
        /*
         int counter = 1;
         for(Employee emp:myList)
         {
         if(emp.getClass().getSimpleName().equals("CommissionSalesEmployee"))
         {
         System.out.println("I am a more refined, better Employee :)");
         }
            
         if(emp.getClass().getSimpleName().equals("Employee"))
         {
         System.out.println("I am an Employee :)");
         }
        
         System.out.println(counter++);
         }*/
    }
    
}
