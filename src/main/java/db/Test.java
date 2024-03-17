package db;
import db.util.DBConnection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        DBConnection.open("dvdrental");
        /* ActorBean donald = ActorBean.builder().first_name("Donald").last_name("Tramp").build();
           System.out.println(ActorBean.createNewActor(donald));
     AddressBean bishkek=AddressBean.builder().address("Bishkek").address2(" ")
                .district("Bokonbaeva")
                .city_id(312)
                .postal_code("720021")
                .phone("0707800700")
                .build();
        System.out.println(AddressBean.createNewAddress(bishkek));
        try {
            AddressBean.delete(609);
            System.out.println("deleted");
              DBConnection.close();

        } catch (SQLException e) {
            System.out.println("not deleted: "+e.getMessage());

        CategoryBean category=CategoryBean.builder().name("Food").build();
        System.out.println(CategoryBean.createNewCategory(category));

        CityBean bish=CityBean.builder().city("Bishkek").country_id(25).build();
        System.out.println(CityBean.createNewCity(bish));

       CustomerBean aizirek = CustomerBean.builder().store_id(1).first_name("Aizirek").last_name("N").email("demo@mail.ru")
                .address_id(611).activebool(true).build();
        System.out.println(CustomerBean.createNewCustomer(aizirek));

        FilmBean film=FilmBean.builder().title("Titanik").description("A sad story about love").release_year(2003)
                .language_id(1).rental_duration(7).rental_rate(4.99)
                .length(150).replacement_cost(25.99).rating(FilmBean.MPAA_Rating.valueOf("PG")).build();
        System.out.println(FilmBean.createNewFilm(film));

        StaffBean staff=StaffBean.builder().first_name("Aizirek").last_name("Tazhibaeva").address_id(611).email("aizirek@gmail.com")
                .store_id(1).active(true).username("aizu").password("ahsfdl5858ssmsnx").build();
        System.out.println(StaffBean.createNewStaff(staff));
        InventoryBean inv=InventoryBean.builder().film_id(745).store_id(2).build();
        System.out.println(InventoryBean.createNewInventory(inv));*/

    }
    }
