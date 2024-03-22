package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
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
    private String picture;

    public static List<StaffBean> getAllStaff() throws SQLException{
        String query = "select * from staff";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,StaffBean.class);
        }
    }

    public static StaffBean getBy(String column, String value) throws SQLException{
        String query = "select * from staff where" + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet,StaffBean.class);
    }
}
