package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxWebDriver {
    public static WebDriver loadFirefoxDriver (){
        System.setProperty("webdriver.firefox.driver", "src/main/resources/drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        return driver;
    }


}
