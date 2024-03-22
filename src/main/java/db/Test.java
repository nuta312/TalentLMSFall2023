package db;

import db.beans.*;
import db.utill.DBConnection;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {

        DBConnection.open("dvdrental");
        ActorBean.getAllActors().forEach(System.out::println);
       // ActorBean.createActor("Umut","Schwarz");
//        CityBean.getAllCity().forEach(System.out::println);
//        AddressBean.getAllAddress().forEach(System.out::println);
//        CategoryBean.getAllCategory().forEach(System.out::println);
//        CountryBean.getAllCountry().forEach(System.out::println);
//        CustomerBean.getAllCustomer().forEach(System.out::println);
//        FilmBean.getAllFilm().forEach(System.out::println);
//        Film_actorBean.getAllFilmActor().forEach(System.out::println);
//        Film_categoryBean.getAllFilmCategory().forEach(System.out::println);
//        InventoryBean.getAllInventory().forEach(System.out::println);
//        LanguageBean.getAllLanguage().forEach(System.out::println);
//        PaymentBean.getAllPayment().forEach(System.out::println);
//        RentalBean.getAllRental().forEach(System.out::println);
//        StaffBean.getAllStaff().forEach(System.out::println);
//        StoreBean.getAllStore().forEach(System.out::println);
    }
}