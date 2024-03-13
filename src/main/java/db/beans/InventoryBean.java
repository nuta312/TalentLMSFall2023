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


public class InventoryBean {
    private int inventory_id;
    private int film_id;
    private int store_id;
    private String last_update;

    public static List<InventoryBean> getAllInventory() throws SQLException {
        String query = "SELECT * FROM city";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, InventoryBean.class);
        }
    }

    public static InventoryBean getByInventory(String column, String value) throws SQLException {
        String query = "SELECT * FROM inventory WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, InventoryBean.class);
    }
}
