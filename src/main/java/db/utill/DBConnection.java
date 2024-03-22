package db.utill;

import org.apache.commons.dbutils.BeanProcessor;
import org.postgresql.ds.PGSimpleDataSource;
import ui.config.ConfigReader;

import java.sql.*;

import static ui.config.ConfigReader.getValue;

public class DBConnection {

    private static Connection connection;

    private static Statement statement;

    private DBConnection(){
    }

    public static void open(String db) throws SQLException{
        if(connection == null){
            connection = getBaseDataSource(db).getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }
    }

    public static ResultSet query(String query, Object ... params) throws SQLException{
        if(params.length == 0){
            return statement.executeQuery(query);
        }else{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            for(int i = 0; i < params.length; i ++){
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement.executeQuery();
        }
    }

    public static void close(){
        try{
            if(statement != null){
                statement.close();
                statement = null;
            }
            if(connection != null){
                connection.close();
                connection = null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static <T> T insertAndRetrieveBean(String insertQuery, String retrieveQuery,Class<T> beanClass, Object... insertParams) throws SQLException {
        // Выполнение вставки
        PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
        for (int i = 0; i < insertParams.length; i++) {
            insertStatement.setObject(i + 1, insertParams[i]); // индексация начинается в бд с 1, поэтому i + 1
        }
        insertStatement.executeUpdate();

        // Получение созданного объекта Java Bean
        PreparedStatement retrieveStatement = connection.prepareStatement(retrieveQuery);
        // Предположим, что retrieveQuery возвращает только одну запись и ваш Java Bean может быть создан с использованием BeanProcessor
        ResultSet resultSet = retrieveStatement.executeQuery();
        if (resultSet.next()) {
            return new BeanProcessor().toBean(resultSet, beanClass);
        } else {
            return null; // Возвращаем null, если запись не найдена
        }
    }

    public static <T> T deleteBean(String deleteQuery, String retrieveQuery,Class<T> beanClass, Object... insertParams) throws SQLException {
        PreparedStatement insertStatement = connection.prepareStatement(deleteQuery);
        for (int i = 0; i < insertParams.length; i++) {
            insertStatement.setObject(i + 1, insertParams[i]);
        }
        insertStatement.executeUpdate();
        PreparedStatement retrieveStatement = connection.prepareStatement(retrieveQuery);
        ResultSet resultSet = retrieveStatement.executeQuery();
        if (resultSet.next()) {
            return new BeanProcessor().toBean(resultSet, beanClass);
        } else {
            return null;
        }
    }


    private static PGSimpleDataSource getBaseDataSource(String database) throws SQLException{
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setServerName(getValue("server"));
        dataSource.setPortNumber(Integer.parseInt(ConfigReader.getValue("port")));
        dataSource.setUser(getValue("user"));
        dataSource.setPassword(getValue("sql_password"));
        dataSource.setDatabaseName(database);
        return dataSource;
    }
}