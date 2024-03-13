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
public class CategoryBean {
    private int category_id;
    private String name;
    private String last_update;

    public static List<CategoryBean> getAllCategory() throws SQLException {
        String query = "SELECT * FROM category";
        try (ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet,CategoryBean.class);
        }
    }

    public static CategoryBean getByCategory(String column,String value) throws SQLException{
        String query = "SELECT * FROM category WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query,value);
        if(!rs.next()) return null;
        return new BeanProcessor().toBean(rs,CategoryBean.class);
}
}