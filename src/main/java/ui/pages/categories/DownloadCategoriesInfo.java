package ui.pages.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class DownloadCategoriesInfo extends BasePage {

    @FindBy(xpath = "//i[@class='icon-download tl-icon19']")
    public WebElement downloadButton;

    public DownloadCategoriesInfo clickToInstall() {
        webElementHelper.click(downloadButton);
        return this;
    }
}
