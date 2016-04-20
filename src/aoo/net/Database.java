package aoo.net;

import aoo.config.DatabaseConfig;
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
    private final DatabaseConfig config;

    public Database() {
        config = new DatabaseConfig();

        try {
            connection = DriverManager.getConnection(config.getConnectionString(), config.getLoginProperties());
        } catch(Exception ex) {
            throw new RuntimeException("Unable to establish connection to db", ex);
        }
    }

    public Employee[] getEmployeeList() throws SQLException {
        String query = "select * from EMP_PROJ_EMPLOYEE";

        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery(query);
//        ResultSetMetaData metaData = results.getMetaData();

        ArrayList<Employee> employees = new ArrayList<>();

        while(results.next()) {
            employees.add(new CommissionEmployee(results.getInt("emp_id"))
                    .setName(results.getString("name"))
                    .setDepartment(results.getString("department"))
                    .setHireDate(results.getDate("hireDate"))
            );
            results.close();
        }

        return employees.toArray(new Employee[employees.size()]);
    }

    @Override
    public void close() throws Exception {
        if(connection != null) connection.close();
        System.out.println("Connection closed");
    }
}
