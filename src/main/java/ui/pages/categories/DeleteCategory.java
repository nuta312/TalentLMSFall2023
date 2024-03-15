package ui.pages.categories;

import ui.driver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class DeleteCategory extends BasePage {

    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]")
    public WebElement navigateMouse;
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]/div/div/i[2]")
    public WebElement deleteButton;
    @FindBy(xpath = "//a[@id='tl-confirm-submit']")
    public WebElement deleteButtonClick;

    public DeleteCategory removeCategory() {
        webElementHelper.actions = new Actions(Driver.getDriver());
        webElementHelper.actions.moveToElement(navigateMouse).build().perform();
        webElementHelper.click(deleteButton)
                .click(deleteButtonClick);
        return this;
    }
}
