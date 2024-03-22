package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Film_actorBean {

    private int actor_id;
    private int film_id;
    private String last_update;

    public static List<Film_actorBean> getAllFilmActor() throws SQLException{
        String query = "select * from film_actor";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, Film_actorBean.class);
        }
    }

    public static Film_actorBean getBy(String column, String value) throws SQLException{
        String query = "select * from film_actor where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, Film_actorBean.class);
    }
}
