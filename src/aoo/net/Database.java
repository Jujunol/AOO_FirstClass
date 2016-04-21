package aoo.net;

import aoo.Main;
import aoo.config.DatabaseConfig;
import aoo.finance.Product;
import aoo.finance.employee.CommissionEmployee;
import aoo.finance.employee.Employee;
import aoo.finance.employee.SalaryEmployee;

import java.sql.*;
import java.util.ArrayList;

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

    private ResultSet selectQuery(String query) throws SQLException {
        return connection.createStatement().executeQuery(query);
    }

    public Employee[] getCommissionEmployees() throws SQLException {
        String query = "select * from EMP_PROJ_COMMISSION_EMPLOYEE " +
                "left join EMP_PROJ_EMPLOYEE using (emp_id);";

        ResultSet results = selectQuery(query);

        ArrayList<Employee> employees = new ArrayList<>();

        while(results.next()) {
            employees.add(new CommissionEmployee(results.getString("name"), results.getInt("emp_id"))
                    .setGrossSales(results.getDouble("gross_sales"))
                    .setCommissionRate(results.getDouble("commission_rate"))
                    .setDepartment(results.getString("department"))
                    .setHireDate(results.getDate("hireDate"))
            );
            results.close();
        }

        return employees.toArray(new Employee[employees.size()]);
    }

    public SalaryEmployee[] getSalaryEmployees() throws SQLException {
        String query = "select * from EMP_PROJ_SALARY_EMPLOYEE " +
                "left join EMP_PROJ_EMPLOYEE using (emp_no);";

        ResultSet results = selectQuery(query);

        ArrayList<Employee> employees = new ArrayList<>();

        while(results.next()) {
            employees.add(new SalaryEmployee(results.getString("name"), results.getInt("emp_id"))
                    .setSalary(results.getDouble("salary"))
                    .setDepartment(results.getString("department"))
                    .setHireDate(results.getDate("hireDate"))
            );
            results.close();
        }

        return (SalaryEmployee[])(employees.toArray(new Employee[employees.size()]));
    }

    public Product[] getProducts() throws SQLException {
        String query = "select * from EMP_PROJ_PRODUCT " +
                "left join EMP_PROJ_MANUFACTURER using (manufacturer_id)";

        ResultSet results = selectQuery(query);

        ArrayList<Product> products = new ArrayList<>();

        while(results.next()) {
            products.add(new Product(results.getInt("product_id"), results.getString("name"))
                    .setCategory(results.getString("category"))
                    .setDescription(results.getString("description"))
                    .setPartNum(results.getString("part_num"))
                    .setCost(results.getDouble("cost"))
                    .setPrice(results.getDouble("price"))
            );
            results.close();
        }

        return products.toArray(new Product[products.size()]);
    }

    public boolean registerCommisionEmployee(CommissionEmployee employee) {
        if(!registerEmployee(employee)) return false;

        try {
            String query = "insert into EMP_PROJ_COMMISSION_EMPLOYEE (emp_id, commission_rate, gross_sales) " +
                    "values (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getUpdatedID());
            statement.setDouble(2, employee.getCommissionRate());
            statement.setDouble(3, employee.getGrossSales());

            statement.execute();
        } catch (SQLException ex) {
            Main.getLogger().logEvent("Unable to register CommissionEmployee");
            return false;
        }
        return true;
    }

    public boolean registerSalaryEmployee(SalaryEmployee employee) {
        if(!registerEmployee(employee)) return false;

        try {
            String query = "insert into EMP_PROJ_SALARY_EMPLOYEE (emp_id, salary) " +
                    "values (?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getUpdatedID());
            statement.setDouble(2, employee.getSalary());

            statement.execute();
        } catch (SQLException ex) {
            Main.getLogger().logEvent("Unable to register SalaryEmployee");
            return false;
        }
        return true;
    }

    private boolean registerEmployee(Employee employee) {
        try {
            String query = "insert into EMP_PROJ_EMPLOYEE (name, department, position, hireDate) " +
                    "values (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getDepartment());
            statement.setString(3, employee.getPosition());
            statement.setDate(4, new Date(employee.getHireDate().getTime()));

            statement.execute();

            // get employee's ID
            ResultSet results = statement.getGeneratedKeys();
            if(results.next()) {
                employee.setUpdatedID(results.getInt("emp_id"));
            }
        } catch (SQLException ex) {
            Main.getLogger().logEvent("Unable to register new employee into database", ex);
            return false;
        }
        return true;
    }

    public boolean registerProduct(Product product) {
        try {
            String query = "insert into EMP_PROJ_PRODUCT (name, category, description, part_num, cost, price) " +
                    "values (?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getCategory());
            statement.setString(3, product.getDescription());
            statement.setString(4, product.getPartNum());
            statement.setDouble(5, product.getCost());
            statement.setDouble(6, product.getPrice());

            // Get updated ID
            ResultSet results = statement.getGeneratedKeys();
            if(results.next()) {
                product.setUpdatedID(results.getInt(1));
            }
        } catch (SQLException ex) {
            Main.getLogger().logEvent("Unable to register Product", ex);
            return false;
        }
        return true;
    }

    @Override
    public void close() throws Exception {
        if(connection != null) connection.close();
        System.out.println("Connection closed");
    }
}
