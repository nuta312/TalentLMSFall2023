package apiTest;

import api.asserts.ApiAssert;
import api.controllers.UserController;
import api.entities.User;
import api.utils.EntityManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest extends BaseApiTest {
    UserController userController;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        userController = application.getUserController();
    }

    @Test
    public void userDelete() {
        User[] users = userController.getUsers();
        userController.deleteUser(users[users.length - 1].getId());
        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(200);
    }

    @Test
    public void createUser() {
        User[] users = userController.getUsers();
        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(200);
        if (users.length == 5) {
            userController.deleteUser(users[users.length - 1].getId());
            ApiAssert.assertThat(userController.getResponse())
                    .isCorrectStatusCode(200);
        }
        User expectedUser = EntityManager.generateUser();
        User actualUser = userController.createUser(expectedUser);
        ApiAssert.assertThat(userController.getResponse())
                .isCorrectStatusCode(200)
                .assertUser(actualUser)
                .isEqualTo(expectedUser);
    }
}

