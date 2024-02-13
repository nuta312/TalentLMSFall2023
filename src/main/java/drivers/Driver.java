package drivers;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {
    private Driver() {
        //Singleton
    }
    private static WebDriver driver; //объявляем driver для управления браузером

    /**
     * создаем кастомный метод getDriver для переключения между браузерами указанными в app.properties
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigReader.getValue("browser").toLowerCase()) {
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFirefoxDriver();
                    break;
                //TODO add macOS
                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        } return driver;
    }
    public static void closeDriver(){ //нужен по умолчанию
        try {
            if (driver!=null){
                driver.close();
                driver.quit();
                driver=null;
            }
        }catch (Exception e){
            System.out.println("Error while closing driver");
        }
    }
}
