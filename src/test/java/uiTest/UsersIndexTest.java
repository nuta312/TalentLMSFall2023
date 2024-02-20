package uiTest;

import helper.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.UsersIndexPage;


public class UsersIndexTest extends BaseTest{
    UsersIndexPage usersIndexPage;
    BrowserManager browserManager;
    @Test
    void UsersIndexPageTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='d-row align-items-stretch']/div[4]/a")).click();
        WebElement webElement= driver.findElement(By.xpath("//div[@id='tl-admin-settings']/div[2]/a[2]"));
        webElement.click();
        UsersIndexPage usersIndexPage = new UsersIndexPage();
        usersIndexPage
                .fillSelectSignUp()
                .fillSelectDefaultUserType()
                .fillSelectDefaultGroup()
                .clickPasswordSetting()
                .fillCheckboxStrongPasswords()
                .fillCheckboxChangePassword()
                .fillInputDays()
                .fillCheckboxPasswordChange()
                .fillCheckboxLockAccount()
                .fillInputFailedAttempts()
                .fillInputFailedAttemptsPerMinutes()
                .clickTermOfService()
                .fillInputText()
                .fillVisibleUserFormat()
                .fillSelectUserName()
                .clickOnHidenSocialOptions()
                .fillCheckboxSocialMedia()
                .fillCheckboxCatalog()
                .fillCheckboxLknCertificate()
                .fillCheckboxCourseRating()
                .fillCancelBtn();



    }
}
