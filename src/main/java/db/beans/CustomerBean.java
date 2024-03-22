package db.beans;

import db.utill.DBConnection;
import io.cucumber.java.eo.Se;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerBean {

    private int customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private String email;
    private int address_id;
    private String activebool;
    private String create_date;
    private String last_update;
    private int active;

    public static List<CustomerBean> getAllCustomer() throws SQLException{
        String query = "select * from customer";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,CustomerBean.class);
        }
    }

    public static CustomerBean getBy(String column, String value) throws SQLException{
        String query = "select * from customer where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, CustomerBean.class);
    }
}