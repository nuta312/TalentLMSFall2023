package db.util;

import db.beans.ActorBean;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {

//        System.out.println(ActorBean.getBy("first_name","Nick"));


        DBConnection.open("dvdrental");
//        System.out.println(ActorBean.getBy("last_name","Mary"));
        ActorBean nuri = ActorBean.builder().first_name("Nuriya").last_name("Meerimkulova").build();
        System.out.println(ActorBean.createNewActor(nuri));
        DBConnection.close();
  }


}
