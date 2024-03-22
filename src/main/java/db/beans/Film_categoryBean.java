package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Film_categoryBean {

    private int film_id;
    private int category_id;
    private String last_update;

    public static List<Film_categoryBean> getAllFilmCategory() throws SQLException{
        String query = "select * from film_category";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, Film_categoryBean.class);
        }
    }

    public static Film_categoryBean getBy(String column, String value) throws SQLException{
        String query = "select * from film_category where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, Film_categoryBean.class);
    }
}