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
public class AddressBean {

    private int address_id;
    private String address;
    private String address2;
    private String district;
    private int city_id;
    private String postal_code;
    private String phone;
    private String last_update;


    public static List<AddressBean> getAllAddresses() throws SQLException {
        String query = "SELECT * FROM address";
        try (ResultSet resultSet = DBConnection.query(query)) {
            return new BeanProcessor().toBeanList(resultSet, AddressBean.class);
        }
    }

    public static AddressBean getBy(String column, String value) throws SQLException {
        String query = "SELECT * FROM address WHERE " + column + " =?;";
        ResultSet resultSet2 = DBConnection.query(query, value);
        if (!resultSet2.next())
            return null;
        return new BeanProcessor().toBean(resultSet2, AddressBean.class);

    }

    public static AddressBean createNewAddress(AddressBean addressBean) throws SQLException {
        String columns = getAllColumns(addressBean);
        String values = getValuesPlaceHolders(addressBean);
        String insertQuery = "INSERT INTO address (" + columns + ") VALUES (" + values + ")";
        String retrieveQuery = "SELECT * FROM address WHERE address=" + addressBean.getAddress() + " AND district=" + addressBean.getDistrict();
        return DBConnection.insertAndRetrieveBean(insertQuery, retrieveQuery, AddressBean.class, addressBean.getAddress(),
                addressBean.getAddress2(), addressBean.getDistrict(), addressBean.getCity_id(), addressBean.getPostal_code(),
                addressBean.getPhone());
    }

    public static String getAllColumns(AddressBean addressBean) {
        StringBuilder columns = new StringBuilder();
        Field[] fields = addressBean.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length - 1; i++) {
            columns.append(fields[i].getName()).append(", ");
        }
        if (columns.length() > 0) {
            columns.setLength(columns.length() - 2);
        }
        return columns.toString();
    }

    public static String getValuesPlaceHolders(AddressBean addressBean) {
        StringBuilder placeHolders = new StringBuilder();
        Field[] fields = addressBean.getClass().getDeclaredFields();
        for (int i = 1; i < fields.length - 1; i++) {
            placeHolders.append("?, ");
        }
        if (placeHolders.length() > 0) {
            placeHolders.setLength(placeHolders.length() - 2);
        }
        return placeHolders.toString();
    }

    public static void delete(int address_id) throws SQLException {
        String deleteQuery = "DELETE FROM address WHERE address_id = ?";
        String retrieveQuery = "SELECT * FROM address WHERE address_id= ?";
        DBConnection.deleteBean(deleteQuery, retrieveQuery, AddressBean.class, address_id);

    }
}