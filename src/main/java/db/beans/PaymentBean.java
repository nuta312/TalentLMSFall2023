package db.beans;

import db.utils.DBConnection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.dbutils.BeanProcessor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class PaymentBean {

    private int payment_id;
    private int customer_id;
    private int staff_id;
    private int rental_id;
    private double amount;
    private String payment_date;

    public static List<PaymentBean> getAllPayments() throws SQLException {
        String query = "SELECT * FROM payment";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, PaymentBean.class);
        }
    }

    public static PaymentBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM payment WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, PaymentBean.class);
        }
    }
}
