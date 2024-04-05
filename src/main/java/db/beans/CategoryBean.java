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
public class CategoryBean {

    private int category_id;
    private String name;
    private String last_update;

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
    }
}
