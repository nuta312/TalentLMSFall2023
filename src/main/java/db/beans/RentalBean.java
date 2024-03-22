package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class RentalBean {

    private int rental_id;
    private String rental_date;
    private int inventory_id;
    private int customer_id;
    private String return_date;
    private int staff_id;
    private String last_update;

    public static List<RentalBean> getAllRental() throws SQLException {
        String query = "select * from rental";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, RentalBean.class);
        }
    }

    public static RentalBean getBy(String column, String value) throws SQLException {
        String query = "select * from rental where" + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, RentalBean.class);
    }
}