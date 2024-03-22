package db.beans;

<<<<<<< HEAD
import db.utill.DBConnection;
import io.cucumber.java.eo.Se;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
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
public class CustomerBean {

    private int customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private String email;
    private int address_id;
<<<<<<< HEAD
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
=======
    private boolean activebool;
    private java.sql.Date create_date;
    private String last_update;
    private int active;

    public static List<CustomerBean> getAllCustomers() throws SQLException {
        String query = "SELECT * FROM customer";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, CustomerBean.class);
        }
    }

    public static CustomerBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM customer WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, CustomerBean.class);
        }
    }
}
>>>>>>> master
