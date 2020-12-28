package data;

import model.Division;
import model.EducationDegree;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "05122002";
    private static final String SELECT_EDUCATION_DEGREE = "SELECT * FROM education_degree";
    private static final String GET_EDUCATION_DEGREE_BY_ID = "SELECT * FROM education_degree where education_degree_id = ?;";

    public  EducationDegreeDAO() {
    }
    protected  Connection getConnection() {
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
    public EducationDegree selectEducationDegreeNote(int id) {
        EducationDegree educationDegree = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_EDUCATION_DEGREE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("education_degree_name");
                educationDegree = new EducationDegree(id, name);
            }
            connection.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return educationDegree;
    }
    public  List<EducationDegree> selectAllEducationDegree() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<EducationDegree> educationDegree = new ArrayList<>();
        // Step 1: Establishing a Connection
        // Step 2:Create a statement using connection object
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("education_degree_id");
                String name = rs.getString("education_degree_name");
                educationDegree.add(new EducationDegree(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegree;
    }
}
