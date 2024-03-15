package db.util;

import db.beans.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {

        DBConnection.open("dvdrental");

    /*    ActorBean actor = ActorBean.builder().first_name("Nurzat").last_name("QA").build();
        CityBean city = CityBean.builder().city("OSH").country_id(2).build();

        String nameTable = "actor";
        String sqlQuery = "first_name = '" + actor.getFirst_name() + "' AND last_name = '" + actor.getLast_name() + "';";
        System.out.println(DBActions.createNewData(actor, nameTable, sqlQuery, ActorBean.class, actor.getFirst_name(), actor.getLast_name()));
*/

        String nameTable = "address";
        String sqlQuery = "address = '1331 Usak Boulevard'";

        DBActions.deleteDataTable(ActorBean.class, nameTable, sqlQuery);
   /*     nameTable = "city";
        sqlQuery = "city = '" + city.getCity() + "' AND country_id = '" + city.getCountry_id() + "';";
        System.out.println(DBActions.createNewData(city, nameTable, sqlQuery, CityBean.class, city.getCity(), city.getCountry_id()));


     */

        /*List<ActorBean> listActor = DBActions.getAllDataTable(ActorBean.class, "actor");
        List<CityBean> listCity = DBActions.getAllDataTable(CityBean.class, "city");*/

        /*System.out.println("Actor Table: ");
        for(ActorBean actors : listActor){
            System.out.println(actors);
        }*/

        /*System.out.println("City Table: ");
        for(CityBean cities : listCity){
            System.out.println(cities);
        }*/



        DBConnection.close();
  }
}