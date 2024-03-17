package db.beans;
import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
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

    public static List<StaffBean> getAllStaff()throws SQLException {
        String query="SELECT * FROM staff";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, StaffBean.class);
        }
    }

    public static StaffBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM staff WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, StaffBean.class);
        }
    }

    public static String getAllColumns(StaffBean staffBean){
        StringBuilder columns=new StringBuilder();
        Field[] fields=staffBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-2;i++){
            columns.append(fields[i].getName()).append(", ");
        }
        if(columns.length()>0){
            columns.setLength(columns.length()-2);
        }
        return columns.toString();
    }


    public static String getValuesPlaceholders(StaffBean staffBean){
        StringBuilder placeholder=new StringBuilder();
        Field[] fields=staffBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-2;i++){
            placeholder.append("?, ");
        }
        if(placeholder.length()>0){
            placeholder.setLength(placeholder.length()-2);
        }
        return placeholder.toString();
    }

    public static StaffBean createNewStaff(StaffBean staffBean) throws SQLException {
        String columns=getAllColumns(staffBean);
        String placeholders=getValuesPlaceholders(staffBean);
        String insertQuery="INSERT INTO staff (" +columns+ ") VALUES (" +placeholders+ ")";
        String retrieveQuery="SELECT * FROM staff WHERE first_name = ? " +
                "AND last_name = ? " +
                "AND address_id = ? " +
                "AND email = ? " +
                "AND store_id = ? AND active = ? " +
                "AND username = ? AND password = ?";
        return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery, StaffBean.class, staffBean.getFirst_name(),
                staffBean.getLast_name(),
                staffBean.getAddress_id(),staffBean.getEmail(),
                staffBean.getStore_id(),
                staffBean.isActive(),
                staffBean.getUsername(),
                staffBean.getPassword());
    }
}
