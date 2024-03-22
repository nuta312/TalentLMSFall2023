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

<<<<<<< HEAD
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
>>>>>>> master
public class InventoryBean {

    private int inventory_id;
    private int film_id;
    private int store_id;
    private String last_update;

<<<<<<< HEAD
    public static List<InventoryBean> getAllInventory() throws SQLException{
        String query = "select * from inventory";
        try(ResultSet resultSet = DBConnection.query(query)){
=======
    public static List<InventoryBean> getAllInventories() throws SQLException {
        String query = "SELECT * FROM inventory";
        try (ResultSet resultSet = DBConnection.query(query)) {
>>>>>>> master
            return new BeanProcessor().toBeanList(resultSet, InventoryBean.class);
        }
    }

<<<<<<< HEAD
    public static InventoryBean getBy(String column, String value) throws SQLException{
        String query = "select * from inventory where " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query,value);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, InventoryBean.class);
    }
}
=======
    public static InventoryBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM inventory WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, InventoryBean.class);
        }
    }
}
>>>>>>> master
