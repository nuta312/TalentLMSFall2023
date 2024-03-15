package ui.pages.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class ReportsIconAndLinkPage extends BasePage {

    @FindBy(xpath = "//div/div/a[contains(text(),'Reports')]")
    public WebElement reportsLink;
    @FindBy(xpath = "//i[@class='icon-chart-pie tl-icon-stack-content']")
    public WebElement reportsIcon;
    @FindBy(xpath = "//span/a[contains(text(),'Home')]")
    public WebElement homeClick;

    public ReportsIconAndLinkPage clickReportsIcon() {
        webElementHelper.click(reportsIcon);
        return this;
    }

    public ReportsIconAndLinkPage clickReportsLink() {
        webElementHelper.click(reportsLink);
        return this;
    }

    public ReportsIconAndLinkPage clickLinkUnderReports(WebElement element) {
        webElementHelper.click(element);
        return this;
    }

    public ReportsIconAndLinkPage clickHomeLink() {
        webElementHelper.click(homeClick);
        return this;
    }

    public void clickToUser(WebElement element) {
        webElementHelper.click(element);
    }
}