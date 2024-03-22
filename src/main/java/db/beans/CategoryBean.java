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
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
=======
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
>>>>>>> master
@ToString
public class CategoryBean {

    private int category_id;
    private String name;
    private String last_update;

<<<<<<< HEAD
    public static List<CategoryBean> getAllCategory() throws SQLException{
        String query = "select * from category";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, CategoryBean.class);
        }
    }
    public static CategoryBean getBy(String column, String value) throws SQLException{
        String query = "select * from category where " + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs, CategoryBean.class);
=======
    public static List<CategoryBean> getAllCategories() throws SQLException {
        String query = "SELECT * FROM category";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, CategoryBean.class);
        }
    }

    public static CategoryBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM category WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, CategoryBean.class);
        }
>>>>>>> master
    }
}
