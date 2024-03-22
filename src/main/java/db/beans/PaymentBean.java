package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.beans.beancontext.BeanContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public static List<PaymentBean> getAllPayment() throws SQLException{
        String query = "select * from payment";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,PaymentBean.class);
        }
    }

    public static PaymentBean getBy(String column, String value) throws SQLException{
        String query = "select * from payment where" + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet,PaymentBean.class);
    }
}
