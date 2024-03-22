package db.beans;

<<<<<<< HEAD
import db.utill.DBConnection;
import io.cucumber.java.eo.Se;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
>>>>>>> master
@ToString
public class CountryBean {

    private int country_id;
    private String country;
    private String last_update;

<<<<<<< HEAD
    public static List<CountryBean> getAllCountry() throws SQLException{
        String query = "select * from country";
        try(ResultSet resultSet = DBConnection.query(query)){
=======
    public static List<CountryBean> getAllCountries() throws SQLException {
        String query = "SELECT * FROM country";
        try (ResultSet resultSet = DBConnection.query(query)) {
>>>>>>> master
            return new BeanProcessor().toBeanList(resultSet, CountryBean.class);
        }
    }

<<<<<<< HEAD
    public static CountryBean getBy(String column, String value) throws SQLException{
        String query = "select * from country where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, CountryBean.class);
    }
}
=======
    public static CountryBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM country WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, CountryBean.class);
        }
    }
}
>>>>>>> master
