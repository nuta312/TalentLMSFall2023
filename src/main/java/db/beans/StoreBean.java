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
public class StoreBean {

    private int store_id;
    private int manager_staff_id;
    private int address_id;
    private String last_update;

    public static List<StoreBean> getAllStores() throws SQLException {
        String query = "SELECT * FROM store";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, StoreBean.class);
        }
    }

    public static StoreBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM store WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, StoreBean.class);
        }
    }
}
