package data;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "05122002";
    private static DivisionDAO divisionDAO = new DivisionDAO();
    private static EducationDegreeDAO educationDegreeDAO = new EducationDegreeDAO();
    private static PositionDAO positionDAO = new PositionDAO();

    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO employee" + "(employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) values"
            + "(?,?,?,?,?,?,?,?,?,?,?);";

    private static final String SELECT_EMPLOYEE_BY_ID = "select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id from employee where employee_id=?";
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name= ?,employee_birthday= ?,employee_id_card= ?,employee_salary= ?,employee_phone= ?,employee_email= ?,employee_address= ?,position_id= ?,education_degree_id= ?,division_id = ? where employee_id = ?;";

    public EmployeeDAO() {
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

    public static void insertEmployee(Employee employee) throws SQLException{
        System.out.println(INSERT_EMPLOYEE_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);) {
            preparedStatement.setString(1, employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getBirthday());
            preparedStatement.setString(4, employee.getId_card());
            preparedStatement.setString(5, employee.getSalary());
            preparedStatement.setString(6, employee.getPhone());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getAddress());
            preparedStatement.setInt(9, employee.getPosition().getPosition_id());
            preparedStatement.setInt(10, employee.getEducation_degree().getEducation_degree_id());
            preparedStatement.setInt(11, employee.getDivision().getDivision_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Employee selectEmployee(String employee_id) throws SQLException{
        Employee employee = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setString(1, employee_id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                String employee_salary = rs.getString("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                Position position = positionDAO.selectPositionNote(rs.getInt("position_id"));
                EducationDegree educationDegree = educationDegreeDAO.selectEducationDegreeNote(rs.getInt("education_degree_id"));
                Division division = divisionDAO.selectDivisionNote(rs.getInt("division_id"));
                employee = new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary,
                        employee_phone, employee_email, employee_address, position,educationDegree,division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }



    public static List<Employee> selectAllEmployees()throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String employee_name = rs.getString("employee_name");
                String employee_birthday = rs.getString("employee_birthday");
                String employee_id_card = rs.getString("employee_id_card");
                String employee_salary = rs.getString("employee_salary");
                String employee_phone = rs.getString("employee_phone");
                String employee_email = rs.getString("employee_email");
                String employee_address = rs.getString("employee_address");
                Position position = positionDAO.selectPositionNote(rs.getInt("position_id"));
                EducationDegree educationDegree = educationDegreeDAO.selectEducationDegreeNote(rs.getInt("education_degree_id"));
                Division division = divisionDAO.selectDivisionNote(rs.getInt("division_id"));
                employees.add(new Employee(employee_id, employee_name, employee_birthday, employee_id_card, employee_salary,
                        employee_phone, employee_email, employee_address, position,educationDegree,division));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }


    public boolean deleteEmployee(String employee_id)throws SQLException{
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setString(1, employee_id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }


    public static boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getId_card());
            preparedStatement.setString(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPosition().getPosition_id());
            preparedStatement.setInt(9, employee.getEducation_degree().getEducation_degree_id());
            preparedStatement.setInt(10, employee.getDivision().getDivision_id());
            preparedStatement.setString(11, employee.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    private static void printSQLException(SQLException ex) {
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
