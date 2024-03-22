package db.beans;

import db.utill.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class LanguageBean {

    private int language_id;
    private String name;
    private String last_update;

    public static List<LanguageBean> getAllLanguage() throws SQLException {
        String query = "select * from language";
        try(ResultSet resultSet = DBConnection.query(query)){
            return new BeanProcessor().toBeanList(resultSet, LanguageBean.class);
        }
    }

    public static LanguageBean getBy(String column, String value) throws SQLException{
        String query = "select * from language where" + column +  "= ?;";
        ResultSet resultSet = DBConnection.query(query,value);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, LanguageBean.class);
    }
}
