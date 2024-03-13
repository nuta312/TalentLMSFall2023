package ui.pages.categories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;
import java.util.List;

import static ui.helper.FakeDataHelper.faker;

public class CategoriesPage extends BasePage {

    @FindBy(xpath = "(//div[@class='tl-bold-link'])[3]")
    public WebElement categoriesButton;
    @FindBy(xpath = "(//a[@class='btn btn-primary'])[3]")
    public WebElement addCategoryButton;
    @FindBy(xpath = "//input[@name='name']" )
    public WebElement nameInput;
    @FindBy(xpath = "//div[@class='controls']//div[@class='select2-container tl-select2']")
    public WebElement parentCategoryClick;
    @FindBy(xpath = "//ul[@class='select2-results']")
    public WebElement parentCategory;
    @FindBy(xpath = "//a[@id='show-price']")
    public WebElement priceButton;
    @FindBy(xpath = "//input[@name='price']")
    public WebElement priceInput;
    @FindBy(xpath = "//input[@name='submit_category']")
    public WebElement addCategoryButtonAfterCreateCategory;
    @FindBy(xpath = "//a[@class='brand']")
    public WebElement returnToMainPage;

    public CategoriesPage addCategoriesPage() {
        webElementHelper.click(categoriesButton)
                .click(addCategoryButton)
                .sendKeys(nameInput,faker.commerce().department())
                .click(parentCategoryClick);
        List<WebElement> liElements = parentCategory.findElements(By.tagName("li"));
        if(!liElements.isEmpty()){
            int ramdonInt = random.nextInt(liElements.size());
            WebElement randomLi = liElements.get(ramdonInt);
            randomLi.click();
        }
        webElementHelper
                .click(priceButton)
                .sendKeys(priceInput,faker.commerce().price())
                .click(addCategoryButtonAfterCreateCategory);
        return this;
    }

    public CategoriesPage categoryButtonClick() {
        webElementHelper.click(categoriesButton);
        return this;
    }
}
