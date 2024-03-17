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
public class CustomerBean {
    private int customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private String email;
    private int address_id;
    private boolean activebool;
    private String create_date;
    private String last_update;
    private int active;

    public static List<CustomerBean>getAllCustomers()throws SQLException {
        String query="SELECT * FROM customer";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs,CustomerBean.class);
        }
    }

    public static CustomerBean getByCustomer(String column, String value) throws SQLException{
        String query2="SELECT * FROM customer WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, CustomerBean.class);
        }
    }

    public static String getAllColumns(CustomerBean customerBean){
            StringBuilder columns=new StringBuilder();
            Field[] fields=customerBean.getClass().getDeclaredFields();
            for(int i=1;i< fields.length-3;i++){
                columns.append(fields[i].getName()).append(", ");
            }
            if(columns.length()>0){
                columns.setLength(columns.length()-2);
            }
            return columns.toString();
        }

        public static String getValuesPlaceholders(CustomerBean customerBean){
            StringBuilder placeholder=new StringBuilder();
            Field[] fields=customerBean.getClass().getDeclaredFields();
            for(int i=1;i< fields.length-3;i++){
                placeholder.append("?, ");
            }
            if(placeholder.length()>0){
                placeholder.setLength(placeholder.length()-2);
            }
            return placeholder.toString();
        }

        public static CustomerBean createNewCustomer(CustomerBean customerBean) throws SQLException {
            String columns=getAllColumns(customerBean);
            String placeholders=getValuesPlaceholders(customerBean);
            String insertQuery="INSERT INTO customer (" +columns+ ") VALUES (" +placeholders+ ")";
            String retrieveQuery="SELECT * FROM customer WHERE store_id=" +customerBean.getStore_id()+ "AND first_name="
                    +customerBean.getFirst_name()+ "AND last_name=" +customerBean.getLast_name()+
                    "AND email=" +customerBean.getEmail()+
                    "AND address_id=" +customerBean.getAddress_id()+ "AND activebool=" +customerBean.isActivebool();
            return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery,CustomerBean.class,
                    customerBean.getStore_id(),
                    customerBean.getFirst_name(),
                    customerBean.getLast_name(),customerBean.getEmail(),
                    customerBean.getAddress_id(),
                    customerBean.isActivebool());
        }
    }

