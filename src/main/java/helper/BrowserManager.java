package helper;

import org.openqa.selenium.WebDriver;

public class BrowserManager {

        private WebDriver driver;

        public BrowserManager(WebDriver driver){
            this.driver=driver;
        }

        public void openByNavigate(final String URL){
            driver.navigate().to(URL);
        }
        public void openByGet(final String URL){
            driver.get(URL);
        }
        public void goBack(final String URL){
            driver.navigate().back();
        }
        public void goForward(final String URL){
            driver.navigate().forward();
        }
        public void refreshThePage(final String URL){
            driver.navigate().refresh();
        }
        // добавить методы Frame,Window
    }


