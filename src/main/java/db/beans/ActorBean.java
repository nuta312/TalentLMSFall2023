package db.beans;

<<<<<<< HEAD
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
=======
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
>>>>>>> master
@Builder
@EqualsAndHashCode
@ToString
public class ActorBean {

    private int actor_id;
    private String first_name;
    private String last_name;
    private String last_update;

<<<<<<< HEAD
=======
    /**
     * Gets list of all actors from the database.
     * try (with params) is a 'Try-With-Resources' or 'try-finally' block.
     * @return: List of all actors
     * @throws SQLException: if a database access error occurs
     */
>>>>>>> master
    public static List<ActorBean> getAllActors() throws SQLException {
        String query = "SELECT * FROM actor";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, ActorBean.class);
        }
    }

<<<<<<< HEAD
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
=======
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
>>>>>>> master
