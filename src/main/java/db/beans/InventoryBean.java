package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class InventoryBean {

    private int inventory_id;
    private int film_id;
    private int store_id;
    private String last_update;

    public static List<InventoryBean> getAllInventory() throws SQLException{
        String query = "select * from inventory";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, InventoryBean.class);
        }
    }

    public static InventoryBean getBy(String column, String value) throws SQLException{
        String query = "select * from inventory where " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query,value);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, InventoryBean.class);
    }
}