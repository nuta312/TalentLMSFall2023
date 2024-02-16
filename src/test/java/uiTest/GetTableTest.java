package uiTest;

import entity.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

import static entity.Users.getUsersFromTable;

public class GetTableTest extends BaseTest{
    @Test
    void getTableTest(){
        driver.findElement(By.xpath("(//div[@class='tl-bold-link'])[1]/child::*")).click();
        List<Users> users = getUsersFromTable(driver);
        users.forEach(System.out::println);
    }
}
