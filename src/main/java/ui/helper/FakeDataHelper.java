package ui.helper;

import ui.entity.User;
import com.github.javafaker.Faker;

public class FakeDataHelper {

    public static Faker faker = new Faker();

    public static User createNewUserWithFakerData() {
        User user = new User();
        user.setFirstname(faker.name().firstName());
        user.setLastname(faker.name().lastName());
        user.setEmailAddress(faker.internet().emailAddress());
        user.setUsername(faker.name().username());
        return user;
    }
}
