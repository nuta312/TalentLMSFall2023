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
@EqualsAndHashCode
@ToString
public class Film_categoryBean {
        private int film_id;
        private int category_id;
        private String last_update;


        public static List<Film_categoryBean> getAllFilmCategories()throws SQLException {
        String query="SELECT * FROM film_category";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, Film_categoryBean.class);
        }
    }

        public static Film_categoryBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM film_category WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, Film_categoryBean.class);
        }
    }
    }

