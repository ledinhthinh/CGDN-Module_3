package data;

import model.Division;
import model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "05122002";
    private static final String SELECT_DIVISION = "SELECT * FROM division";
    private static final String GET_DIVISION_BY_ID = "SELECT * FROM division where division_id = ?;";

    public  DivisionDAO() {
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
    public Division selectDivisionNote(int id) {
        Division division = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_DIVISION_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("division_name");
                division = new Division(id, name);
            }
            connection.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return division;
    }
    public List<Division> selectAllDivision() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Division> division = new ArrayList<>();
        // Step 1: Establishing a Connection
        // Step 2:Create a statement using connection object
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("division_id");
                String name = rs.getString("division_name");
                division.add(new Division(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }
}
