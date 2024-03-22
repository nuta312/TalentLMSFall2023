package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;
import org.openqa.selenium.support.FindBy;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class FilmBean {

    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int rental_duration;
    private double rental_rate;
    private int replacement_cost;
    private String rating;
    private String last_update;
    private String special_features;
    private String fulltext;

    public static List<FilmBean> getAllFilm() throws SQLException {
        String query = "select * from film";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, FilmBean.class);
        }
    }

    public static FilmBean getBy(String column, String value) throws SQLException{
        String query = "select * from film where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, FilmBean.class);
    }
}
