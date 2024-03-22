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
@EqualsAndHashCode
@ToString
public class StoreBean {

    private int store_id;
    private int manager_staff_id;
    private int address_id;
    private String last_update;

    public static List<StoreBean> getAllStore() throws SQLException{
        String query = "select * from store";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, StoreBean.class);
        }
    }

    public static StoreBean getBy(String column, String value) throws SQLException{
        String query = "select * from store where" + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, StoreBean.class);
    }
}
