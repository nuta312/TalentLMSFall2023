package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverManager {
    public static WebDriver driver;

    public static WebDriver initChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver.quit();
    }

    public static void openTheSite(String URL) {
        driver.get(URL);
    }
}
