package pages.reports;

import driver.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static pages.TalentLMS_PAGES.*;

public class UserReportsPage extends BasePage {
    public static String columnNameFromTheTable = "//tbody//tr//td[@class=' tl-align-left']";
    public static String columnUserTypeFromTheTable = "//tbody//tr//td[@class=' tl-align-left hidden-phone']";

    /**
     * This class reflects web elements of the "User reports" web page from https://www.talentlms.com and special methods created to work with this web page.
     */

    @FindBy(xpath = "//a[@title='Home']")
    public WebElement textHome;
    @FindBy(xpath = "//a[@title='Reports']")
    public WebElement textReports;
    @FindBy(xpath = "//th[@aria-label='User']")
    public WebElement tableSortingByUser;
    @FindBy(xpath = "//th[@aria-label='User type']")
    public WebElement tableSortingByUserType;
    @FindBy(xpath = "//a[@class='tl-grid-size-more'] ")
    public WebElement buttonToDisplayTheWholeTable;
    @FindBy(xpath = "//td[@class=' tl-align-center tl-table-operations-cell hidden-phone']")
    public WebElement optionsSignal;
    @FindBy(xpath = "//tbody//tr[@role='row']")
    public WebElement tableRows;
    @FindBy(xpath = "//input[@class='tl-grid-search-input']")
    public WebElement inputTextForSearch;
    @FindBy(xpath = "//tbody//td//a")
    public WebElement textNameFromTable;
    @FindBy(xpath = "//a[@id='tl-export-user']")
    public WebElement exportInExcelBtn;

    public UserReportsPage goToTheCustomReportsPage() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + USER_REPORTS);
        return this;
    }

    @Step("Click on 'Home' text")
    public UserReportsPage clickTextHome() {
        webElementHelper.click(textHome);
        return this;
    }

    @Step("Click on 'Reports' text")
    public UserReportsPage clickTextReports() {
        webElementHelper.click(textReports);
        return this;
    }

    @Step("Click on sort button for 'User' column")
    public UserReportsPage clickSortButtonForColumnName() {
        webElementHelper.click(tableSortingByUser);
        return this;
    }

    @Step("Click on button to display the whole table")
    public UserReportsPage clickButtonToDisplayTheWholeTable() {
        webElementHelper.click(buttonToDisplayTheWholeTable);
        return this;
    }

    @Step("Click on sort button for 'User Type' column")
    public UserReportsPage clickSortButtonForColumnUserType() {
        webElementHelper.click(tableSortingByUserType);
        return this;
    }

    @Step("Click on options signal")
    public UserReportsPage clickOptionsSignal() {
        webElementHelper.click(optionsSignal);
        return this;
    }

    @Step("Click on text name from table")
    public UserReportsPage clickTextNameFromTable() {
        webElementHelper.click(textNameFromTable);
        return this;
    }

    @Step("Click on export in Excel button")
    public UserReportsPage clickExportInExcelBtn() {
        webElementHelper.click(exportInExcelBtn);
        return this;
    }

    @Step("Send key random text {createRandomTextForSearch} in input search")
    public UserReportsPage sendKeyRandomTextInInputSearch(String createRandomTextForSearch) {
        webElementHelper.sendKeys(inputTextForSearch, createRandomTextForSearch);
        return this;
    }

    @Step("Get column data")
    public static List<String> getColumnNameData(WebElement tableRows, String columnFromTheTableXPath) {
        return saveColumnNameData(tableRows, columnFromTheTableXPath);
    }

    public static List<String> getColumnNameTypeData(WebElement tableRows, String columnFromTheTableXPath) {
        return saveColumnNameTypeData(tableRows, columnFromTheTableXPath);
    }

    @Step("Sort data")
    public static List<String> sortData(List<String> getColumnData) {
        Collections.sort(getColumnData);
        return getColumnData;
    }

    /**
     * Method saves data of a specific column in the sheet.
     *
     * @param tableRows          Web element representing rows in the table.
     * @param columnFromTheTable Web elements representing cells of columns in the table.
     * @return List<String> initialDataValues containing data from cells located in a single column.
     */

    @Step("Save column name data")
    public static List<String> saveColumnNameData(WebElement tableRows, String columnFromTheTable) {
        List<String> initialDataValues = new ArrayList<>();
        try {
            List<WebElement> initialData = tableRows.findElements(By.xpath(columnFromTheTable));
            initialDataValues = initialData.stream()
                    .map(WebElement::getText)
                    .filter(text -> !text.equals("d. digitalnomad"))
                    .map(text -> text.substring(3))
                    .collect(Collectors.toList());
        } catch (StaleElementReferenceException e) {
        }
        return initialDataValues;
    }

    @Step("Save column name type data")
    public static List<String> saveColumnNameTypeData(WebElement tableRows, String columnFromTheTable) {
        List<String> initialDataValues = new ArrayList<>();
        try {
            List<WebElement> initialData = tableRows.findElements(By.xpath(columnFromTheTable));
            initialData.stream()
                    .map(WebElement::getText)
                    .filter(text -> !text.equals("d. digitalnomad"))
                    .forEach(initialDataValues::add);
        } catch (StaleElementReferenceException e) {
        }
        return initialDataValues;
    }

    @Step("Sort user type data")
    public static List<String> sortUserTypeData(List<String> getColumnData) {
        List<String> customOrder = Arrays.asList("SuperAdmin", "Admin-Type", "Trainer-Type", "Learner-Type", "Instructor");
        List<String> list = new ArrayList<>();
        for (String getColumnDatum : getColumnData) {
            if (customOrder.contains(getColumnDatum)) {
                list.add(getColumnDatum);
            }
        }
        list.sort(Comparator.comparingInt(customOrder::indexOf));
        return list;
    }

    @Step("Select text from table for search")
    public static String selectTextFromTableForSearch(List<String> getColumnData) {
        Random random = new Random();
        return getColumnData.get(random.nextInt(getColumnData.size())).substring(3);
    }

    @Step("Check if text found in search results")
    public static boolean isTextFoundInSearchResults(String searchText) {
        List<WebElement> rows = Driver.getDriver().findElements(By.xpath(columnNameFromTheTable));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(columnNameFromTheTable));
            boolean isTextFound = false;
            for (WebElement cell : cells) {
                String userText = cell.getText().substring(3);
                if (userText.contains(searchText)) {
                    isTextFound = true;
                }
            }
            if (!isTextFound) {
                return false;
            }
        }
        return true;
    }

    @Step("Pause for {milliseconds} milliseconds")
    public UserReportsPage pause(int milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
