package aoo.net;

import aoo.finance.employee.CommissionEmployee;
import aoo.finance.employee.Employee;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by 200240927 on 4/6/2016.
 */
public class Database implements AutoCloseable {

    private final Connection connection;

    public Database() {
        // TODO create config for encapsulate data
        Properties config = new Properties();
        config.put("user", "gc200240927");
        config.put("password", "cm?4iJMi");

        try {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://sql.computerstudi.es:3306/gc200240927", config);
        } catch(Exception ex) {
            throw new RuntimeException("Unable to establish connection to db", ex);
        }
    }

    public Employee[] getEmployeeList() throws SQLException {
        String query = "select * from EMP_PROJ_EMPLOYEE";

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
        ResultSetMetaData metaData = results.getMetaData();

        ArrayList<Employee> employees = new ArrayList<>();

        while(results.next()) {
            employees.add(new CommissionEmployee(results.getInt("emp_id"))
                    .setName(results.getString("name"))
                    .setDepartment(results.getString("department"))
                    .setHireDate(new SimpleDateFormat("yyyy-MM-dd").format(results.getDate("hireDate")))
            );
            results.close();
        }

        return employees.toArray(new Employee[employees.size()]);
    }

    @Override
    public void close() throws Exception {
        if(connection != null) connection.close();
    }
}
