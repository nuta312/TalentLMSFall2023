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
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
>>>>>>> master
@Builder
@EqualsAndHashCode
@ToString
public class StoreBean {

    private int store_id;
    private int manager_staff_id;
    private int address_id;
    private String last_update;

<<<<<<< HEAD
    public static List<StoreBean> getAllStore() throws SQLException{
        String query = "select * from store";
        try(ResultSet resultSet = DBConnection.query(query)){
=======
    public static List<StoreBean> getAllStores() throws SQLException {
        String query = "SELECT * FROM store";
        try (ResultSet resultSet = DBConnection.query(query)) {
>>>>>>> master
            return new BeanProcessor().toBeanList(resultSet, StoreBean.class);
        }
    }

<<<<<<< HEAD
    public static StoreBean getBy(String column, String value) throws SQLException{
        String query = "select * from store where" + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, StoreBean.class);
=======
    public static StoreBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM store WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, StoreBean.class);
        }
>>>>>>> master
    }
}
