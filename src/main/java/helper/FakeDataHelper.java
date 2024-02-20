package helper;

import entity.User;
import com.github.javafaker.Faker;

public class FakeDataHelper {

    public static Faker faker = new Faker();

    public static User createNewUserWithFakerData(){
        User user = new User();
        user.setFirstname(faker.name().firstName());
        user.setLastname(faker.name().lastName());
        user.setEmailAddress(faker.internet().emailAddress());
        user.setUsername(faker.name().username());
        user.setBio("Tests won't fail if you don't write tests :)");
        return user;
    }
}
