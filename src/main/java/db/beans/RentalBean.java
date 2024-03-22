package db.beans;

<<<<<<< HEAD
import db.utill.DBConnection;
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
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
public class RentalBean {

    private int rental_id;
    private String rental_date;
    private int inventory_id;
    private int customer_id;
    private String return_date;
    private int staff_id;
    private String last_update;

<<<<<<< HEAD
    public static List<RentalBean> getAllRental() throws SQLException {
        String query = "select * from rental";
=======
    public static List<RentalBean> getAllRentals() throws SQLException {
        String query = "SELECT * FROM rental";
>>>>>>> master
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, RentalBean.class);
        }
    }

    public static RentalBean getBy(String column, String value) throws SQLException {
<<<<<<< HEAD
        String query = "select * from rental where" + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, RentalBean.class);
    }
}
=======
        String query = "SELECT * FROM rental WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, RentalBean.class);
        }
    }
}
>>>>>>> master
