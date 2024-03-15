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
public class RentalBean {

    private int rental_id;
    private String rental_date;
    private int inventory_id;
    private int customer_id;
    private String return_date;
    private int staff_id;
    private String last_update;

    public static List<RentalBean> getAllRental() throws SQLException {
        String query = "SELECT * FROM rental";
        try (ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,RentalBean.class);
        }
    }

    public static RentalBean getByRental(String column,String value) throws SQLException{
        String query = "SELECT * FROM rental WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs,RentalBean.class);
  }
}
