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
@EqualsAndHashCode
@ToString
@Builder
public class LanguageBean {
    private int language_id;
    private String name;
    private String last_update;

    public static List<LanguageBean> getAllLanguages()throws SQLException {
        String query="SELECT * FROM language";
        try(ResultSet rs= DBConnection.query(query)){
            return new BeanProcessor().toBeanList(rs, LanguageBean.class);
        }
    }

    public static LanguageBean getBy(String column, String value)throws SQLException{
        String query2="SELECT * FROM language WHERE "+column+" =?;";
        try(ResultSet rs=DBConnection.query(query2,value)){
            if(!rs.next()) return null;
            return new BeanProcessor().toBean(rs, LanguageBean.class);
        }
    }

    public static String getAllColumns(LanguageBean languageBean){
        StringBuilder column=new StringBuilder();
        Field[] fields=languageBean.getClass().getDeclaredFields();
        for(int i=1; i<fields.length-1;i++){
            column.append(fields[i].getName()).append(", ");
        }
        if(column.length()>0){
            column.setLength(column.length()-2);
        }
        return column.toString();
    }

    public static String getValuePlaceholder(LanguageBean languageBean){
        StringBuilder placeholder=new StringBuilder();
        Field[] fields=languageBean.getClass().getDeclaredFields();
        for(int i=1;i<fields.length-1;i++){
            placeholder.append("?, ");
        }
        if(placeholder.length()>0){
            placeholder.setLength(placeholder.length()-2);
        }
        return placeholder.toString();
    }

    public static LanguageBean createNewLanguage(LanguageBean languageBean) throws SQLException {
        String columns=getAllColumns(languageBean);
        String values=getValuePlaceholder(languageBean);
        String insertQuery="INSERT INTO language (" +columns+ ") VALUES (" +values+ ")";
        String retrieveQuery="SELECT * FROM language WHERE name=" +languageBean.getName();
        return DBConnection.insertAndRetrieveBean(insertQuery,retrieveQuery,LanguageBean.class,languageBean.getName());
    }
}
