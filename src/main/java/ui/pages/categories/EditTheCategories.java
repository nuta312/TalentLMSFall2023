package ui.pages.categories;

import ui.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static ui.helper.FakeDataHelper.faker;

public class EditTheCategories extends BasePage {

    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]")
    public WebElement navigateMouse;
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]/div/div/i[1]")
    public WebElement editButton;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement nameInputChange;
    @FindBy(xpath = "//a[@id='show-price']")
    public WebElement priceButton;
    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceInputChange;
    @FindBy(xpath = "//input[@value='Update category']")
    public WebElement updateCategoryButton;

    public EditTheCategories changeCategories() {
        webElementHelper.actions.moveToElement(navigateMouse).build().perform();
        webElementHelper.click(editButton)
                .sendKeys(nameInputChange, faker.commerce().department())
                .click(priceButton)
                .sendKeys(priceInputChange, faker.number().digit())
                .click(updateCategoryButton);
        return this;
    }
}