package db.beans;

<<<<<<< HEAD
import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;
import org.openqa.selenium.support.FindBy;

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
>>>>>>> master
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

<<<<<<< HEAD
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
>>>>>>> master
public class FilmBean {

    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int rental_duration;
    private double rental_rate;
<<<<<<< HEAD
    private int replacement_cost;
=======
    private int length;
    private double replacement_cost;
>>>>>>> master
    private String rating;
    private String last_update;
    private String special_features;
    private String fulltext;

<<<<<<< HEAD
    public static List<FilmBean> getAllFilm() throws SQLException {
        String query = "select * from film";
        try(ResultSet resultSet = DBConnection.query(query)){
=======
    public static List<FilmBean> getAllFilms() throws SQLException {
        String query = "SELECT * FROM film";
        try (ResultSet resultSet = DBConnection.query(query)) {
>>>>>>> master
            return new BeanProcessor().toBeanList(resultSet, FilmBean.class);
        }
    }

<<<<<<< HEAD
    public static FilmBean getBy(String column, String value) throws SQLException{
        String query = "select * from film where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, FilmBean.class);
=======
    public static FilmBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM film WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, FilmBean.class);
        }
>>>>>>> master
    }
}
