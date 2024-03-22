package db.beans;

<<<<<<< HEAD
import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.beans.beancontext.BeanContext;
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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
>>>>>>> master
public class PaymentBean {

    private int payment_id;
    private int customer_id;
    private int staff_id;
    private int rental_id;
    private double amount;
    private String payment_date;

<<<<<<< HEAD
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
=======
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
>>>>>>> master
    }
}
