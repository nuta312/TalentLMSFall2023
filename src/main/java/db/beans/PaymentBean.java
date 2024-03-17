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
public class PaymentBean {
    private int payment_id;
    private int customer_id;
    private int staff_id;
    private int rental_id;
    private double amount;
    private String payment_date;

    public static List<PaymentBean> getAllPayments() throws SQLException {
        String query = "SELECT * FROM payment";
        try (ResultSet rs = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(rs, PaymentBean.class);
        }
    }

    public static PaymentBean getBy(String column, String value) throws SQLException {
        String query2 = "SELECT * FROM payment WHERE " + column + " =?;";
        try (ResultSet rs = DBConnection.query(query2, value)) {
            if (!rs.next()) return null;
            return new BeanProcessor().toBean(rs, PaymentBean.class);
        }
    }

}
