package ui.pages.accountAndSettings;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.pages.BasePage;
import java.util.LinkedList;
import java.util.List;

public class ThemesPage extends BasePage {

    @FindBy(id = "select-theme")
    public WebElement themesButton;
    @FindBy(id = "select-item")
    public WebElement selectItem;
    @FindBy (id = "set-active-theme")
    public WebElement activeThemeButton;
    @FindBy(id = "update-theme")
    public WebElement updateThemeButton;
    @FindBy(id="save-as-new-button")
    public WebElement saveAsNewButton;
    @FindBy(id="delete-button")
    public WebElement deleteButton;
    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement successMessage;
    @FindBy(xpath = "//option[@value='1']")
    public WebElement defaultTheme;
    @FindBy (xpath = "//option[@value='41']")
    public WebElement modernTheme;

    public ThemesPage selectThemeButton() {
        themesButton.sendKeys(Keys.ENTER);
        return this;
    }

    public ThemesPage selectRandomTheme() {
        selectThemeButton();
        select = new Select(themesButton);
        List<WebElement> themesList = select.getOptions();
        List <String> valueList = new LinkedList<>();
        for (WebElement e: themesList){
            valueList.add(e.getText());
        }
        int randomIndex = random.nextInt(valueList.size());
        themesList.get(randomIndex).click();
        return this;
    }

    public ThemesPage activeThemeButtonClick() {
        webElementHelper.click(activeThemeButton);
        return this;
    }

    public ThemesPage sendKeys(WebElement element, String txt) {
        element.sendKeys(txt);
        return this;
    }
}
