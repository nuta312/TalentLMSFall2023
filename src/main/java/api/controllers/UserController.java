package api.controllers;

import api.ApiRequest;
import api.entities.User;
import lombok.Getter;

import java.util.HashMap;

import static api.TalentLMSEndpoints.*;


public class UserController extends ApiRequest {
    public UserController(String url) {
        super(url);
    }

    public User[] getUsers() {
        return super.get(getEndpoint(API, V1, USERS)).as(User[].class);
    }

    public User getUserBy(By by, String value) {
        HashMap<String, String> parameters = new HashMap<>() {{
            put(by.getKey(), value);
        }};
        return super.get(getEndpoint(API, V1, USERS
                , formatParameter(parameters))).as(User.class);
    }

    public void createUser(User user) {
        super.post(getEndpoint(API, V1, USER_SIGNUP), user.toJson());
    }

    @Getter
    public enum By {
        ID("id"),
        USERNAME("username"),
        EMAIL("email");
        public final String key;

        By(String key) {
            this.key = key;
        }
    }
}
