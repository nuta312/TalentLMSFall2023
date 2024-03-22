package db.beans;

<<<<<<< HEAD
import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

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
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
>>>>>>> master
@ToString
public class CityBean {

    private int city_id;
    private String city;
<<<<<<< HEAD
    private int  country_id;
    private String last_update;

    public static List<CityBean> getAllCity() throws SQLException{
        String query = "select * from city";
        try(ResultSet resultSet = DBConnection.query(query)){
=======
    private int country_id;
    private String last_update;

    public static List<CityBean> getAllCities() throws SQLException {
        String query = "SELECT * FROM city";
        try (ResultSet resultSet = DBConnection.query(query)) {
>>>>>>> master
            return new BeanProcessor().toBeanList(resultSet, CityBean.class);
        }
    }

<<<<<<< HEAD
    public static CityBean getBy(String column, String value) throws SQLException{
        String query = "select * from city where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, CityBean.class);
    }
}
=======
    public static CityBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM city WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, CityBean.class);
        }
    }
}
>>>>>>> master
