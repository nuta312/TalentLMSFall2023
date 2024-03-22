package db.utils;

import org.postgresql.ds.PGSimpleDataSource;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static config.ConfigReader.getValue;

public class DBConnection {

    private static Connection connection;
    private static Statement statement;

    /**
     * Singleton
     */
    public DBConnection() {
    }

    /**
     * Gets base data source (all credentials) to connect to the database.
     * @param database: name of database
     * @return: base data source
     */
    private static PGSimpleDataSource getBaseDataSource(String database) {
        PGSimpleDataSource dataSource = new PGSimpleDataSource() {{
            setServerName(getValue("server"));
            setPortNumber(Integer.parseInt(getValue("port")));
            setUser(getValue("user"));
            setPassword(getValue("sql_password"));
            setDatabaseName(database);
        }};
        return dataSource;
    }

    /**
     * Connects to the database.
     * @param database: name of database
     */
    public static void open(String database) throws SQLException {
        if (connection == null) {
            connection = getBaseDataSource(database).getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }
    }

    /**
     * Creates and executes the given SQL query.
     * @param query: statement (no parameters)
     * @param params: optional parameters of query for different conditions
     * @return: a ResultSet object that contains the data produced by the query; never null
     */
    public static ResultSet query(String query, Object... params) throws SQLException {
        if (params.length == 0) {
            return statement.executeQuery(query);
        }
        else {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeQuery();
        }
    }

    /**
     * Disconnects from the database.
     */
    public static void close() {
        try {
            if (statement != null) {
                statement.close();
                statement = null;
            }
            if (connection != null) {
                connection.close();
                connection = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
