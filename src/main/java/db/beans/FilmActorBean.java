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
public class FilmActorBean {

    private int actor_id;
    private int film_id;
    private String last_update;

    public static List<FilmActorBean> getAllFilmActors() throws SQLException {
        String query = "SELECT * FROM film_actor";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, FilmActorBean.class);
        }
    }

    public static FilmActorBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM film_actor WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, FilmActorBean.class);
        }
    }
}
