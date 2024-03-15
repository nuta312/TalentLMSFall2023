package db.beans;

import db.utils.DBConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.dbutils.BeanProcessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class ActorBean {

    private int actor_id;
    private String first_name;
    private String last_name;
    private String last_update;

    /**
     * Gets list of all actors from the database.
     * try (with params) is a 'Try-With-Resources' or 'try-finally' block.
     * @return: List of all actors
     * @throws SQLException: if a database access error occurs
     */
    public static List<ActorBean> getAllActors() throws SQLException {
        String query = "SELECT * FROM actor";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, ActorBean.class);
        }
    }

    /**
     * Gets the result of parametrized query
     * @param column: instance variable
     * @param value: target
     * @return
     * @throws SQLException
     */
    public static ActorBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM actor WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, ActorBean.class);
        }
    }
}
