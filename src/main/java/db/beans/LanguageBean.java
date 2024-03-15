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

public class LanguageBean {
    private int language_id;
    private String name;
    private String last_update;

    public static List<LanguageBean> getAllCity() throws SQLException {
        String query = "SELECT * FROM language";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, LanguageBean.class);
        }
    }

    public static LanguageBean getByLanguage(String column,String value) throws SQLException {
        String query = "SELECT * FROM language WHERE" + column + " = ?;";
        ResultSet rs = DBConnection.query(query, value);
        if (!rs.next()) return null;
        return new BeanProcessor().toBean(rs, LanguageBean.class);
    }
}


