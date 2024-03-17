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
public class CityBean {
    private int city_id;
    private String city;
    private int country_id;
    private String last_update;

    public static List<CityBean> getAllCities() throws SQLException {
        String query = "SELECT * FROM city";
        try (ResultSet rs = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(rs, CityBean.class);
        }
    }

    public static CityBean getBy(String column, String value) throws SQLException {
        String query2 = "SELECT * FROM city WHERE " + column + " =?;";
        try (ResultSet resultSet = DBConnection.query(query2, value)) {
            if (!resultSet.next()) return null;
            return new BeanProcessor().toBean(resultSet, CityBean.class);
        }
    }

    public static CityBean createNewCity(CityBean cityBean) throws SQLException {
        String insertQuery = "INSERT INTO city (city, country_id) VALUES (?, ?)";
        String retrieveQuery = "SELECT * FROM city WHERE city = ? AND country_id = ?";
    return DBConnection.insertAndRetrieveBean(insertQuery, retrieveQuery,
                CityBean.class,  cityBean.getCity(), cityBean.getCountry_id());
    }
}


