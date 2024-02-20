package uiTest;

import entity.Users;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.List;

import static entity.Users.getUsersFromTable;
import static org.testng.Assert.assertEquals;

public class GetTableTest extends BaseTest{
    @Test
    void getTableTest(){
        driver.findElement(By.xpath("(//div[@class='d-col tl-onboarding-end-item-cont'])[4]/child::*")).click();
        driver.findElement(By.xpath("(//div[@class='tl-bold-link'])[1]/child::*")).click();
        List<Users> users = getUsersFromTable(driver);
        users.forEach(System.out::println);
    }
}
