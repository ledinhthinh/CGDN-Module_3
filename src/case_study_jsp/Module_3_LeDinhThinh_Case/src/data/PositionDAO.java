package data;

import model.CustomerType;
import model.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "05122002";
    private static final String SELECT_POSITION = "SELECT * FROM position";
    private static final String GET_POSITION_BY_ID = "SELECT * FROM position where position_id = ?;";

    public PositionDAO() {
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
    public Position selectPositionNote(int id) {
        Position position = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_POSITION_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("position_name");
                position = new Position(id, name);
            }
            connection.close();
        } catch ( SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
    public  List<Position> selectAllPosition() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Position> position = new ArrayList<>();
        // Step 1: Establishing a Connection
        // Step 2:Create a statement using connection object
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION)) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                position.add(new Position(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
}
