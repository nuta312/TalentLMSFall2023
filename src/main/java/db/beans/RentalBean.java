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

    public static List<RentalBean> getAllRental()throws SQLException {
        String query="SELECT * FROM rental";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, RentalBean.class);
        }
    }

    public static RentalBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM rental WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, RentalBean.class);
        }
    }
}
