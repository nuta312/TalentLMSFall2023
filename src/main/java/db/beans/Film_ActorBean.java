package db.beans;

import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Film_ActorBean {

    private int actor_id;
    private int film_id;
    private String last_update;

    public static List<Film_ActorBean> getAllFilmActor() throws SQLException {
        String query = "SELECT * FROM film_actor";
        try (ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,Film_ActorBean.class);
        }
    }

    public static Film_ActorBean getByFilmActor(String column,String value) throws SQLException {
        String query = "SELECT * FROM film_actor WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs,Film_ActorBean.class);
}
}
