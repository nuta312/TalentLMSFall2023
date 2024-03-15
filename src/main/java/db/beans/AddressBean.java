package db.beans;

import db.utils.DBConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.dbutils.BeanProcessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class AddressBean {

    private int address_id;
    private String address;
    private String address2;
    private String district;
    private int city_id;
    private int postal_code;
    private long phone;
    private String last_update;

    public static List<AddressBean> getAllAddresses() throws SQLException {
        String query = "SELECT * FROM address";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, AddressBean.class);
        }
    }

    public static AddressBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM address WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, AddressBean.class);
        }
    }
}
