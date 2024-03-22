package db.beans;

import db.utill.DBConnection;
import io.cucumber.java.eo.Se;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@ToString
public class CountryBean {

    private int country_id;
    private String country;
    private String last_update;

    public static List<CountryBean> getAllCountry() throws SQLException{
        String query = "select * from country";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, CountryBean.class);
        }
    }

    public static CountryBean getBy(String column, String value) throws SQLException{
        String query = "select * from country where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, CountryBean.class);
    }
}