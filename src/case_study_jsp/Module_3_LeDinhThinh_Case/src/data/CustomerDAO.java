package data;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "05122002";

    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer" + "(customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id) values"
            + "(?,?,?,?,?,?,?,?);";

    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address,customer_type_id from customer where customer_id=?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_name = ?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?,customer_type_id=? where customer_id = ?;";

    public CustomerDAO() {
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void insertCustomer(Customer customer) throws SQLException{
        System.out.println(INSERT_CUSTOMERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL);) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getId_card());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customer.getCustomer_type_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer selectCustomer(int customer_id) throws SQLException{
        Customer customer = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, customer_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                String customer_type_id = rs.getString("customer_type_id");
                customer = new Customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card,
                        customer_phone, customer_email, customer_address, customer_type_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public static List<Customer> selectAllCustomers()throws SQLException {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customer_id = rs.getInt("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_birthday = rs.getString("customer_birthday");
                String customer_gender = rs.getString("customer_gender");
                String customer_id_card = rs.getString("customer_id_card");
                String customer_phone = rs.getString("customer_phone");
                String customer_email = rs.getString("customer_email");
                String customer_address = rs.getString("customer_address");
                String customer_type_id = rs.getString("customer_type_id");
                customers.add(new Customer(customer_id, customer_name, customer_birthday, customer_gender, customer_id_card,
                        customer_phone, customer_email, customer_address, customer_type_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    public boolean deleteCustomer(int customer_id)throws SQLException{
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, customer_id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }


    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getBirthday());
            preparedStatement.setString(3, customer.getGender());
            preparedStatement.setString(4, customer.getId_card());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setString(8, customer.getCustomer_type_id());
            preparedStatement.setInt(9, customer.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
