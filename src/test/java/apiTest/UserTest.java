package apiTest;

import api.controllers.UserController;
import api.entities.User;
import api.utils.EntityManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.controllers.UserController.By.ID;
import static org.testng.Assert.assertEquals;

public class UserTest extends BaseApiTest {
    UserController userController;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        userController = application.getUserController();
    }

    @Test
    public void userTest() {
        User[] users = userController.getUsers();
        assertEquals(users.length, 5);
        User userBy = userController.getUserBy(ID, "1");
        assertEquals(userBy.getFirstName(), "Aidin");
    }

    @Test
    public void createUser() {
        User user = EntityManager.generateUser();
        userController.createUser(user);
    }
}
