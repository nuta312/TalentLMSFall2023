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
@Builder
@EqualsAndHashCode
@ToString
public class PaymentBean {
    private int payment_id;
    private int customer_id;
    private int staff_id;
    private int rental_id;
    private float amount;
    private String payment_date;

    public static List<PaymentBean> getAllPayment() throws SQLException {
        String query = "SELECT * FROM payment";
        try (ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,PaymentBean.class);
        }
    }

    public static PaymentBean getByPayment(String column,String value) throws SQLException{
        String query = "SELECT * FROM payment WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs,PaymentBean.class);
  }

}
