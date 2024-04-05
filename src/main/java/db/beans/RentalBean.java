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
public class RentalBean {

    private int rental_id;
    private String rental_date;
    private int inventory_id;
    private int customer_id;
    private String return_date;
    private int staff_id;
    private String last_update;

    public static List<RentalBean> getAllRentals() throws SQLException {
        String query = "SELECT * FROM rental";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, RentalBean.class);
        }
    }

    public static RentalBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM rental WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, RentalBean.class);
        }
    }
}
