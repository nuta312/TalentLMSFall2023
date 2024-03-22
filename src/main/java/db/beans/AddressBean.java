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

@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@EqualsAndHashCode
@ToString
@Builder
@Setter
@Getter
=======
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
>>>>>>> master
public class AddressBean {

    private int address_id;
    private String address;
    private String address2;
    private String district;
    private int city_id;
<<<<<<< HEAD
    private String postal_code;
    private String phone;
    private String last_update;

    public static List<AddressBean> getAllAddress() throws SQLException {
=======
    private int postal_code;
    private long phone;
    private String last_update;

    public static List<AddressBean> getAllAddresses() throws SQLException {
>>>>>>> master
        String query = "SELECT * FROM address";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, AddressBean.class);
        }
    }

    public static AddressBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM address WHERE " + column + " = ?;";
<<<<<<< HEAD
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, AddressBean.class);
    }
}
=======
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, AddressBean.class);
        }
    }
}
>>>>>>> master
