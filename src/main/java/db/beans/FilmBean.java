package db.beans;
import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class FilmBean {
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int language_id;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private double replacement_cost;
    private MPAA_Rating rating;
    private String last_update;
    private String special_features;
    private String fulltext;

    public enum MPAA_Rating {
        G,
        PG,
        PG_13,
        R,
        NC_17
    }

    public static List<FilmBean> getAllFilmCategories()throws SQLException {
        String query="SELECT * FROM film";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, FilmBean.class);
        }
    }

    public static FilmBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM film WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, FilmBean.class);
        }
    }

     public static String getAllColumns(FilmBean filmBean){
        StringBuilder columns=new StringBuilder();
        Field[] fields=filmBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-3;i++){
            columns.append(fields[i].getName()).append(", ");
        }
        if(columns.length()>0){
            columns.setLength(columns.length()-2);
        }
        return columns.toString();
    }

    public static String getValuesPlaceholders(FilmBean filmBean){
        StringBuilder placeholder=new StringBuilder();
        Field[] fields=filmBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-3;i++){
            placeholder.append("?, ");
        }
        if(placeholder.length()>0){
            placeholder.setLength(placeholder.length()-2);
        }
        return placeholder.toString();
    }

    public static FilmBean createNewFilm(FilmBean filmBean) throws SQLException {
        String columns=getAllColumns(filmBean);
        String placeholders=getValuesPlaceholders(filmBean);
        String insertQuery="INSERT INTO film (" +columns+ ") VALUES (" +placeholders+ ")";
        String retrieveQuery="SELECT * FROM film WHERE title = ? " +
                "AND description = ? " +
                "AND release_year = ? " +
                "AND language_id = ? " +
                "AND rental_duration = ? AND rental_rate = ? " +
                "AND length = ? AND replacement_cost = ? AND rating = ?";
        return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery, FilmBean.class, filmBean.getTitle(),
                filmBean.getDescription(),
                filmBean.getRelease_year(),filmBean.getLanguage_id(),
                filmBean.getRental_duration(),
                filmBean.getRental_rate(),
                filmBean.getLength(),
                filmBean.getReplacement_cost(),filmBean.getRating());
    }
}



