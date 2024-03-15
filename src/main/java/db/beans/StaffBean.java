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
public class StaffBean {

    private int staff_id;
    private String first_name;
    private String last_name;
    private int address_id;
    private String email;
    private int store_id;
    private boolean active;
    private String username;
    private String password;
    private String last_update;
    private byte[] picture;

    public static List<StaffBean> getAllStaff() throws SQLException {
        String query = "SELECT * FROM staff";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, StaffBean.class);
        }
    }

    public static StaffBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM staff WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, StaffBean.class);
        }
    }
}
