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
@EqualsAndHashCode
@ToString
public class StoreBean {
    private int store_id;
    private int manager_staff_id;
    private int address_id;
    private String last_update;

    public static List<StoreBean> getAllStores()throws SQLException {
        String query="SELECT * FROM store";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, StoreBean.class);
        }
    }

    public static StoreBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM store WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, StoreBean.class);
        }
    }
}
