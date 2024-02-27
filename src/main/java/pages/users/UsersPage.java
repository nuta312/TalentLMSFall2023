package pages.users;

import entity.User;
import helper.FakeDataHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class UsersPage extends BasePage {

    User randomUser = FakeDataHelper.createNewUserWithFakerData();
    @FindBy(xpath = "//a[contains(text(), 'Home')]")
    public WebElement homeBtn;
    @FindBy(xpath = "(//div[@class='hidden-phone']/child::a)[1]")
    public WebElement homeAddUserBtn;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstnameInput;
    @FindBy(xpath = "//input[@name='surname']")
    public WebElement lastnameInput;
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//input[@name='login']")
    public WebElement usernameInput;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInput;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement bioInput;
    @FindBy(xpath = "(//span[@class='select2-arrow'])[1]")
    public WebElement userTypesSelectBtn;
    @FindBy(xpath = "(//span[@class='select2-chosen'])[2]")
    public WebElement timeZoneSelectBtn;
    @FindBy(xpath = "//span[contains(text(),'English')]")
    public WebElement languageSelectInput;
    @FindBy(xpath = "//input[@id='status']")
    public WebElement activeCheckbox;
    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement excludeFromEmailsCheckbox;
    @FindBy(xpath = "//input[@name='submit_personal_details']")
    public WebElement addUserSubmitBtn;
    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancelAddUserSubmitBtn;
    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement addUserSuccessMessage;
    @FindBy(xpath = "(//span[@class='help-inline'])[3]")
    public WebElement emailMessage;
    @FindBy(xpath = "(//span[@class='help-inline'])[4]")
    public WebElement userNameMessage;
    @FindBy(xpath = "(//span[@class='help-inline'])[1]")
    public WebElement nameIsRequiredMessage;
    @FindBy(xpath = "(//span[@class='help-inline'])[2]")
    public WebElement lastNameIsRequiredMessage;
    @FindBy(xpath = "(//span[@class='help-inline'])[3]")
    public WebElement emailAddressValidationMessage;
    @FindBy(xpath = "(//span[@class='help-inline'])[2]")
    public WebElement passwordValidationMessage;

    @FindBy(xpath = "//a[@id='tl-confirm-continue']")
    public WebElement confirmDeletePopUp;

    public UsersPage fillUpUserWithFakerData(){
        webElementHelper
                .sendKeys(firstnameInput, randomUser.getFirstname())
                .sendKeys(lastnameInput, randomUser.getLastname())
                .sendKeys(emailInput, randomUser.getEmailAddress())
                .sendKeys(usernameInput, randomUser.getUsername());
        passwordInput.sendKeys("TestTest123!");
        webElementHelper
                .sendKeys(bioInput, randomUser.getBio());
        return this;
    }

    public UsersPage selectUserType(){
        webElementHelper.click(userTypesSelectBtn);
        List<WebElement> userTypeDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = random.nextInt(userTypeDropDown.size());
        userTypeDropDown.get(randomIndex).click();
        return this;
    }

    public UsersPage selectTimeZone(){
        webElementHelper.click(timeZoneSelectBtn);
        List<WebElement> timeZoneDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = random.nextInt(timeZoneDropDown.size());
        timeZoneDropDown.get(randomIndex).click();
        return this;
    }

    public UsersPage selectLanguage(){
        webElementHelper.click(languageSelectInput);
        List<WebElement> languageDropDown = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy
                (By.xpath("//div[@id='select2-drop']/ul/li")));
        int randomIndex = random.nextInt(languageDropDown.size());
        webElementHelper.waitForButtonToBeClickAble(languageSelectInput);
        languageDropDown.get(randomIndex).click();
        return this;
    }

    public UsersPage clickOnExcludeFromEmailsCheckbox(){
        webElementHelper.scrollToElement(excludeFromEmailsCheckbox);
        webElementHelper.click(excludeFromEmailsCheckbox);
        return this;
    }

    public UsersPage clickOnAddUserSubmitBtn(){
        webElementHelper.scrollToElement(activeCheckbox)
                .click(activeCheckbox);
        webElementHelper.scrollToElement(addUserSubmitBtn);
        webElementHelper.click(addUserSubmitBtn);
        return this;
    }

    // get Users from Table
    public static ArrayList<User> getUsersFromTable(WebDriver driver){

        List<WebElement> usersRows = driver.findElements(By.xpath("//table[@id='tl-users-grid']"));
        ArrayList<User> usersList = new ArrayList<>();
        for (WebElement rows : usersRows){

            //for sorting
            WebElement registrationSortBtn = driver.findElement(By.xpath("//th[text()='Registration']"));
            registrationSortBtn.click();

            List<WebElement> row = rows.findElements(By.xpath("//tbody/tr[@role='row']"));
            String user = row.get(0).getText();
            String email = row.get(0).getText();
            String userType = row.get(0).getText();
            String registration = row.get(0).getText();
            System.out.println("Rows: " + rows.getText());

            usersList.add(new User(user, email, userType, registration, "bio"));
        }
        return usersList;
    }

    // for deleting new added user:
    public UsersPage deleteLastAddedUser() throws InterruptedException {
        // Get the last added user row
        WebElement lastAddedUser = driver.findElement(By.xpath("(//tr[@role='row'])[2]"));
        // Check the checkbox for the last added user
        WebElement lastAddedUserCheckbox = lastAddedUser.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        lastAddedUserCheckbox.click();

        // Open mass actions menu
        WebElement massActionsBtn = driver.findElement(By.xpath("//a[@class='btn dropdown-toggle']"));
        massActionsBtn.click();

        // Select the delete option from mass actions menu
        WebElement deleteBtn = driver.findElement(By.xpath("//a[@data-mode='delete']"));
        deleteBtn.click();

        // Confirm the deletion in the pop-up
        WebElement deletePopUp = driver.findElement(By.xpath("//a[@id='submit-mass-action']"));   // //div[@class='modal-footer']/a[1]
        webElementHelper.click(deletePopUp);
        Thread.sleep(5000);

//        Actions actions = new Actions(driver);
//        WebElement element = driver.findElement(By.id("//a[@id='submit-mass-action']"));
//        actions.moveToElement(element).click().perform();


        // Try to hide the modal backdrop (if it exists)
//        try {
//            WebElement modalBackdrop = driver.findElement(By.xpath("//div[@class='modal-backdrop fade in']"));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", modalBackdrop);
//        } catch (NoSuchElementException e) {
//            // Modal backdrop not found, continue
//        }

        return this;

    }
}
