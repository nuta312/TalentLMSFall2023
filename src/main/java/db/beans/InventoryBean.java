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
public class InventoryBean {
    private int inventory_id;
    private int film_id;
    private int store_id;
    private String last_update;

    public static List<InventoryBean> getAllInventories()throws SQLException {
        String query="SELECT * FROM inventory";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, InventoryBean.class);
        }
    }

    public static InventoryBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM inventory WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, InventoryBean.class);
        }
    }

    public static String getAllColumns(InventoryBean inventoryBean){
        StringBuilder columns=new StringBuilder();
        Field[] fields=inventoryBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-1;i++){
            columns.append(fields[i].getName()).append(", ");
        }
        if(columns.length()>0){
            columns.setLength(columns.length()-2);
        }
        return columns.toString();
    }

    public static String getValuesPlaceholders(InventoryBean inventoryBean){
        StringBuilder placeholder=new StringBuilder();
        Field[] fields=inventoryBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-1;i++){
            placeholder.append("?, ");
        }
        if(placeholder.length()>0){
            placeholder.setLength(placeholder.length()-2);
        }
        return placeholder.toString();
}

    public static InventoryBean createNewInventory(InventoryBean inventoryBean) throws SQLException {
        String columns=getAllColumns(inventoryBean);
        String placeholders=getValuesPlaceholders(inventoryBean);
        String insertQuery="INSERT INTO inventory (" +columns+ ") VALUES (" +placeholders+ ")";
        String retrieveQuery="SELECT * FROM inventory WHERE film_id=" +inventoryBean.getFilm_id()+ "AND store_id=" +inventoryBean.getStore_id();
        return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery,InventoryBean.class,inventoryBean.getFilm_id(), inventoryBean.getStore_id());
    }
}
