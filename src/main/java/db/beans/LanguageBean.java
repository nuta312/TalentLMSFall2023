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
@NoArgsConstructor
@AllArgsConstructor
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
public class LanguageBean {

    private int language_id;
    private String name;
    private String last_update;

<<<<<<< HEAD
    public static List<LanguageBean> getAllLanguage() throws SQLException {
        String query = "select * from language";
        try(ResultSet resultSet = DBConnection.query(query)){
=======
    public static List<LanguageBean> getAllLanguages() throws SQLException {
        String query = "SELECT * FROM language";
        try (ResultSet resultSet = DBConnection.query(query)) {
>>>>>>> master
            return new BeanProcessor().toBeanList(resultSet, LanguageBean.class);
        }
    }

<<<<<<< HEAD
    public static LanguageBean getBy(String column, String value) throws SQLException{
        String query = "select * from language where" + column +  "= ?;";
        ResultSet resultSet = DBConnection.query(query,value);
        if(!resultSet.next()) return null;
        return new BeanProcessor().toBean(resultSet, LanguageBean.class);
=======
    public static LanguageBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM language WHERE " + column + " = ?;";
        ResultSet resultSet = DBConnection.query(query, value);
        if (!resultSet.next()) {
            return null;
        } else {
            return new BeanProcessor().toBean(resultSet, LanguageBean.class);
        }
>>>>>>> master
    }
}
