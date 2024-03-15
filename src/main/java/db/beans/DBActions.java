package db.beans;

import db.util.DBConnection;
import org.apache.commons.dbutils.BeanProcessor;

import java.lang.reflect.Field;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DBActions {
    public static <T> T createNewData(T bean, String nameTable, String sqlQueryWhere, Class<T> beanClass, Object... param) throws SQLException {
        String columns = getAllColumns(bean);
        String values = getValuesPlaceholder(bean);
        String insertQuery = "INSERT INTO " +  nameTable + " (" + columns + ") VALUES (" + values + ")";
        String retrieveQuery = "SELECT * FROM " +  nameTable + " WHERE " + sqlQueryWhere;
        return (T) DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery,beanClass,param);
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

    public static <T> List<T> getAllDataTable(Class<T> beanClass, String nameTable) throws SQLException {
        String query="SELECT * FROM " + nameTable;
        try (ResultSet resultSet= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,beanClass);
        }
    }

    // No Tests

    public  static <T> T getBy (Class<T> beanClass, String nameTable, String column, String value)throws SQLException{
        String query = "SELECT * FROM " + nameTable + " WHERE " + column + " = ?;";
        ResultSet rs=DBConnection.query(query,value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs,beanClass);
    }

    public static <T> T updateBeanTable(Class<T> beanClass, String nameTable, int expectedIndex, Map<String, Object> updates) throws SQLException {
        if (updates == null || updates.isEmpty()) {
            throw new IllegalArgumentException("Updates map cannot be null or empty");
        }
        String updateQuery = "UPDATE employees SET " +
                updates.entrySet().stream()
                        .map(entry -> entry.getKey() + " = ?")
                        .collect(Collectors.joining(", ")) +
                " WHERE emp_no = ?";
        // Добавляем expectedIndex в конец списка параметров
        updates.put("emp_no", expectedIndex);
        return DBConnection.updateAndRetrieveBean(updateQuery, "SELECT * FROM " + nameTable + " WHERE emp_no = " + expectedIndex, beanClass, updates.values().toArray());
    }

    public static <T> T deleteDataTable(Class<T> beanClass, String nameTable, String sqlQueryWhere) throws SQLException {
        List<String> listForeignKeys = DBConnection.getForeignKeysTable(nameTable);
        System.out.println(listForeignKeys);
        String updateQuery = "";

        for(int i = 0; i < listForeignKeys.size(); i+=4){
            updateQuery = "UPDATE " + listForeignKeys.get(i + 3) +
                        " SET " + listForeignKeys.get(i + 2) + " = 1" +
                        " WHERE " + listForeignKeys.get(i + 2) + " IN (" +
                        " SELECT " + listForeignKeys.get(i) + " FROM " +
                        listForeignKeys.get(i + 1) + " WHERE " + sqlQueryWhere + ");";

            System.out.println(updateQuery);
            DBConnection.updateRowsQuery(updateQuery);
        }

        String deleteQuery = "DELETE FROM " +  nameTable + " WHERE " + sqlQueryWhere;
        String retrieveQuery = "SELECT * FROM " +  nameTable;
        return  DBConnection.deleteBean(deleteQuery,retrieveQuery,beanClass);
    }
}
