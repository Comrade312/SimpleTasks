package simpletasks.requestTask;

import java.sql.*;

public class DBWorker {

    private static final String URL = "jdbc:mysql://localhost/parsing_schema?useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false"
            + "&serverTimezone=UTC"
            + "&verifyServerCertificate=false"
            + "&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private Connection connection;

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(String username, String searchWord){

        if(connection == null) getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO parsing_schema.users (username, search_word) values (?, ?);");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, searchWord);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
