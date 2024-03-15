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
public class Film_CategoryBean {

    private int film_id;
    private int category_id;
    private String last_update;

    public static List<Film_CategoryBean> getAllFilmCategory() throws SQLException {
        String query = "SELECT * FROM film_category";
        try (ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,Film_CategoryBean.class);
        }
    }

    public static Film_CategoryBean getByFilmCategory(String column,String value) throws SQLException {
        String query = "SELECT * FROM film_category WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs,Film_CategoryBean.class);
}

}
