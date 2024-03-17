package db.beans;
import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@ToString
@Builder
public class CategoryBean {
    private int category_id;
    private String name;
    private String last_update;

    public static List<CategoryBean>getAllCategories()throws SQLException {
        String query1="SELECT * FROM category";
        try(ResultSet rs= DBConnection.query(query1)){
            return new BeanProcessor().toBeanList(rs, CategoryBean.class);
        }
    }

    public static CategoryBean getByCategory(String column, String value) throws SQLException {
        String query2="SELECT * FROM category WHERE " +column+ " =?;";
            try (ResultSet resultSet =DBConnection.query(query2,value)) {
                if (!resultSet.next()) {
                    return null;
                }
                return new BeanProcessor().toBean(resultSet, CategoryBean.class);

    }
}

    public static CategoryBean createNewCategory(CategoryBean categoryBean) throws SQLException {
        String columns=getAllColumns(categoryBean);
        String values=getValuePlaceholders(categoryBean);
        String insertQuery="INSERT INTO category (" +columns+ ") VALUES (" +values+ ")";
        String retrieveQuery="SELECT * FROM category WHERE category=" +categoryBean.getName();
        return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery, CategoryBean.class,categoryBean.getName());
    }

    public static String getAllColumns(CategoryBean categoryBean){
        StringBuilder columns=new StringBuilder();
        Field[] fields=categoryBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-1;i++){
            columns.append(fields[i].getName()).append(", ");
        }
        if(columns.length()>0){
            columns.setLength(columns.length()-2);
        }
        return columns.toString();
    }

    public static String getValuePlaceholders(CategoryBean categoryBean){
        StringBuilder placeholder=new StringBuilder();
        Field[] fields=categoryBean.getClass().getDeclaredFields();
        for (int i=1;i<fields.length-1;i++){
            placeholder.append("?, ");
        }
        if(placeholder.length()>0){
            placeholder.setLength(placeholder.length()-2);
        }
        return placeholder.toString();
    }
}
