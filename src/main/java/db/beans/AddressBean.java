package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Setter
@Getter
public class AddressBean {

    private int address_id;
    private String address;
    private String address2;
    private String district;
    private int city_id;
    private String postal_code;
    private String phone;
    private String last_update;

    public static List<AddressBean> getAllAddress() throws SQLException {
        String query = "SELECT * FROM address";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, AddressBean.class);
        }
    }

    public static AddressBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM address WHERE " + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, AddressBean.class);
    }
}