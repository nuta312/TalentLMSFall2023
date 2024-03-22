package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.*;
import java.util.List;

import static ui.config.ConfigReader.getValue;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class ActorBean {

    private int actor_id;
    private String first_name;
    private String last_name;
    private String last_update;

    public static List<ActorBean> getAllActors() throws SQLException {
        String query = "SELECT * FROM actor";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, ActorBean.class);
        }
    }

    public static ActorBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM actor WHERE " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, ActorBean.class);
    }

        public static void createActor(String firstName, String lastName) throws SQLException {

        Connection con = DriverManager.getConnection(getValue("url"), getValue("user"), getValue("sql_password"));
        String query = "INSERT INTO actor (first_name, last_name) VALUES (?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        int affectedRows = preparedStatement.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating actor failed, no rows affected.");
        }
    }

    public static ActorBean deleteActor(int expectedIndex) throws SQLException {
        String deleteQuery = "DELETE FROM  actor WHERE  actor_id = " + expectedIndex;
        String retrieveQuery = "SELECT * FROM actor";
        return DBConnection.deleteBean(deleteQuery, retrieveQuery, ActorBean.class);
    }
}