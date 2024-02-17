package helper;

import Entity.User;
import com.github.javafaker.Faker;

public class FakeDataHelper {

    static Faker faker = new Faker();

    public static User createNewUserWithFakerData() {
        User user = new User();
        user.setFirstname(faker.name().firstName());
        user.setLastname(faker.name().lastName());
        user.setEmailAddress(faker.internet().emailAddress());
        user.setUsername(faker.name().username());
        user.setBio("Lorem Ipsum is simply dummy text of the printing and " +
                "typesetting industry. Lorem Ipsum has been the industry's standard dummy " +
                "text ever since the 1500s, when an unknown printer took a galley of type and " +
                "scrambled it to make a type specimen book. It has survived not only five centuries.");
        return user;
    }
}
