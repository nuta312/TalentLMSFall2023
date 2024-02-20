package pages.categories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class ViewCourseCatalog extends BasePage{

    @FindBy(xpath = "//div[@class='hidden-phone tl-header-tools pull-right']/a")
    public WebElement viewCourseCatalogButton;

    public ViewCourseCatalog viewCourseCatalogBtn(){
        webElementHelper.click(viewCourseCatalogButton);
        return this;
    }
}
