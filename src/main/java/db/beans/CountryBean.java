package db.beans;
import db.util.DBConnection;
import lombok.*;
import org.apache.commons.dbutils.BeanProcessor;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Builder
public class CountryBean {
    private int country_id;
    private String country;
    private String last_update;

    public static List<CountryBean>getAllCountries() throws SQLException {
        String query="SELECT * FROM country";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs,CountryBean.class);
        }
    }

    public static CountryBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM country WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, CountryBean.class);
        }
    }

    public static String getAllColumns(CountryBean countryBean){
        StringBuilder columns=new StringBuilder();
        Field[] fields=countryBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-1;i++){
            columns.append(fields[i].getName()).append(", ");
        }
        if(columns.length()>0){
            columns.setLength(columns.length()-2);
        }
        return columns.toString();
    }

    public static String getValuesPlaceholders(CountryBean countryBean){
        StringBuilder placeholder=new StringBuilder();
        Field[] fields=countryBean.getClass().getDeclaredFields();
        for(int i=1;i< fields.length-1;i++){
            placeholder.append("?, ");
        }
        if(placeholder.length()>0){
            placeholder.setLength(placeholder.length()-2);
        }
        return placeholder.toString();
    }

    public static CountryBean createNewCountry(CountryBean countryBean) throws SQLException {
        String columns=getAllColumns(countryBean);
        String placeholders=getValuesPlaceholders(countryBean);
        String insertQuery="INSERT INTO country (" +columns+ ") VALUES (" +placeholders+ ")";
        String retrieveQuery="SELECT * FROM country WHERE country=" +countryBean.getCountry();
        return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery,CountryBean.class,countryBean.getCountry());
    }
}