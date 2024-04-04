package apiTest;

import api.controllers.UserController;
import api.entities.User;
import api.utils.EntityManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class UserTest extends BaseApiTest {
    UserController userController;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        userController = application.getUserController();
    }

    @Test
    public void userDelete() {
        User[] users = userController.getUsers();
        userController.deleteUser(users[2].getId());
    }

    @Test
    public void createUser() {
        User user = EntityManager.generateUser();
        userController.createUser(user);
    }
}

