package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CityBean {

    private int city_id;
    private String city;
    private int  country_id;
    private String last_update;

    public static List<CityBean> getAllCity() throws SQLException{
        String query = "select * from city";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, CityBean.class);
        }
    }

    public static CityBean getBy(String column, String value) throws SQLException{
        String query = "select * from city where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, CityBean.class);
    }
}