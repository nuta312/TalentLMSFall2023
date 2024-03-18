package db.utils;

import java.lang.reflect.Field;
import java.sql.SQLException;

public class DBActions {

    public static <T> T createAndGetNewData(T bean, String tableName, String whereProperties, Class<T> beanClass, Object... param) throws SQLException {
        String columns = getAllColumns(bean);
        String values = getValuesPlaceholder(bean);
        String insertQuery = "INSERT INTO " +  tableName + " (" + columns + ") VALUES (" + values + ")";
        String retrieveQuery = "SELECT * FROM " +  tableName + " WHERE " + whereProperties;
        return DBConnection.insertAndRetrieveBean(insertQuery, retrieveQuery, beanClass, param);
    }

    private static String getAllColumns(Object data) {
        StringBuilder columns = new StringBuilder();
        Field[] fields = data.getClass().getDeclaredFields();
        for(int i = 1; i < fields.length - 1; i++) {
            columns.append(fields[i].getName()).append(", ");
        }
        if (columns.length() > 0) {
            columns.setLength(columns.length() - 2);
        }
        return columns.toString();
    }

    private static String getValuesPlaceholder(Object data) {
        StringBuilder placeholders = new StringBuilder();
        Field[] fields = data.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length - 1; i++) {
            placeholders.append("?, ");
        }
        if (placeholders.length() > 0) {
            placeholders.setLength(placeholders.length() - 2);
        }
        return placeholders.toString();
    }
}
