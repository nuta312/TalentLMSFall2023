package db.utils;

import db.beans.ActorBean;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {

        DBConnection.open("dvdrental");

        ActorBean actorTimur = ActorBean.builder().first_name("Timur").last_name("Fall2023").build();
        String actorTable = "actor";
        String whereProperties = "first_name = '" + actorTimur.getFirst_name() + "' AND last_name = '" + actorTimur.getLast_name() + "';";
        //                 first_name + 'Timur' AND last_name = 'Fall2023';
        System.out.println(DBActions.createAndGetNewData(actorTimur, actorTable, whereProperties, ActorBean.class, actorTimur.getFirst_name(), actorTimur.getLast_name()));
        //ActorBean.getAllActors().forEach(System.out::println);
    }
    // Object... insertParams -> 5, 10 -> [10] length = 10
    //                0         1
    // Object[] = {"Timur", "Fall2023"}
}
