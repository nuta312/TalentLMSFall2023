package db.beans;

import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@EqualsAndHashCode
@ToString


public class StoreBean {
    private int store_id;
    private int manager_staff_id;
    private int address_id;
    private String last_update;

    public static List<StoreBean> getAllStore() throws SQLException {
        String query = "SELECT * FROM store";
        try (ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,StoreBean.class);
        }
    }

    public static StoreBean getBy(String column,String value) throws SQLException {
        String query = "SELECT * FROM store WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, StoreBean.class);
    }


}
