package db.beans;

import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;


import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder

public class ActorBean {
    private int actor_id;
    private String first_name;
    private String last_name;
    private String last_update;

    public static List<ActorBean> getAllActors()throws SQLException {
        String query="SELECT * FROM actor";
        try (ResultSet resultSet= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,ActorBean.class);
        }
    }

    public  static ActorBean getBy (String column,String value)throws SQLException{
        String query = "SELECT * FROM actor WHERE " + column + " = ?;";
        ResultSet rs=DBConnection.query(query,value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs,ActorBean.class);
 }
    public static ActorBean createNewActor(ActorBean actorbean) throws SQLException {
        String columns = getAllColumns(actorbean); // это коллонок
        String values = getValuesPlaceholder(actorbean); // для значений
        String insertQuery = "INSERT INTO actor (" + columns + ") VALUES (" + values + ")";
      String retrieveQuery = "SELECT * FROM actor WHERE first_name = " + actorbean.getFirst_name() + " AND last_name = " + actorbean.getLast_name();
       // ResultSet resultSet = DBConnection.query(query,firstName,lastName);
       return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery,ActorBean.class,actorbean.getFirst_name(),actorbean.getLast_name());
    }
    private static String getAllColumns(ActorBean actorBean) {
        StringBuilder columns = new StringBuilder();
        Field[] fields = actorBean.getClass().getDeclaredFields();
        for(int i = 1; i < fields.length - 1; i++) {
            columns.append(fields[i].getName()).append(", ");
        }
        if (columns.length() > 0) {
            columns.setLength(columns.length() - 2);
        }
        return columns.toString();
    }
    private static String getValuesPlaceholder(ActorBean actorBean) {
        StringBuilder placeholders = new StringBuilder();
        Field[] fields = actorBean.getClass().getDeclaredFields();

        for (int i = 1; i < fields.length -1; i++) {
            placeholders.append("?, ");
        }
        if (placeholders.length() > 0) {
            placeholders.setLength(placeholders.length() - 2);
        }

        return placeholders.toString();
    }




}
