package entity;

import lombok.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class Users {
    private String userName;
    private String email;
    private String userType;
    /**
     * this method allows to take all data from the table and save it to ArrayList
     */
    public static ArrayList<Users> getUsersFromTable(WebDriver driver){
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr[@role='row']"));
        ArrayList<Users> users = new ArrayList<>();
        for (WebElement row:rows){
            List<WebElement> cells = row.findElements(By.cssSelector(".tl-align-left"));
            String userName = cells.get(0).getText();
            String email = cells.get(1).getText();
            String userType = cells.get(2).getText();
            if (userName.isEmpty()||email.isEmpty()||userType.isEmpty()){
                continue;
            }
            users.add(new Users(userName, email, userType));
        }
        return users;
    }
}
