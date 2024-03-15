package ui.pages.userTypes;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class AddUserTypePage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Add user type']")
    public WebElement addUserTypeInput;
    @FindBy(xpath = "//input [@id='user_type_name']")
    public WebElement nameInput;
    @FindBy(xpath = "//span[@class='select2-arrow']")
    public WebElement arrowClickInput;
    @FindBy(xpath = "//div[text()='Administrator']")
    public WebElement adminInput;
    @FindBy(xpath = "//div[text()='Instructor']")
    public WebElement instructorInput;
    @FindBy(xpath = "//div[text()='Learner']")
    public WebElement learnerInput;
    @FindBy(xpath = "//*[@id='tl-user-types-tree']/ul/li[1]/span/span[2]")
    public WebElement tickTheBoxForAdmin;
    @FindBy(xpath = "//*[@id='tl-user-types-tree']/ul/li[2]/span/span[2]")
    public WebElement tickTheBoxForInstr;
    @FindBy(xpath = "//*[@id='tl-user-types-tree']/ul/li[3]/span/span[2]")
    public WebElement tickTheBoxForLearn;
    @FindBy(xpath = "//*[@id='tl-user-types-tree']/ul/li[4]/span/span[2]")
    public WebElement tickTheBoxForGen;
    @FindBy(xpath = "//a[text()='Administrator']")
    public WebElement clickAdmin;
    @FindBy(xpath = "//a[text()='Instructor']")
    public WebElement clickInstructor;
    @FindBy(xpath = "//a[text()='Learner']")
    public WebElement clickLearner;
    @FindBy(xpath = "//a[text()='General']")
    public WebElement clickGeneral;
    @FindBy(xpath = "//input[@id='user-type-save-button']")
    public WebElement saveBtn;
    @FindBy(xpath = "//span[text()='A user type with this name already exists']")
    public WebElement alreadyExistUserTypeWithThisNameMess;
    @FindBy(xpath = "//span[text()='The assigned default role is not available for this user type']")
    public WebElement notAvailableUserTypeForTheAssignedDefaultRoleMess;
    @FindBy(xpath = "//span[@class='help-inline'][1]")
    public WebElement nameIsRequiredMess;
    @FindBy(xpath = "//span[text()='The assigned default role is not available for this user type']")
    public WebElement defaultRoleUnavailableForThisUserTypeMess;
    @FindBy(xpath = "//span[text()='You have not defined any permissions for this user type']")
    public WebElement notDefinedAnyPermissionsForThisUserTypeMess;
    @FindBy(xpath = "//span[@class='help-inline']")
    public WebElement orCancelToPress;
    @FindBy(xpath = "//i[@class='icon-info-circle tl-info-icon']")
    public WebElement exclamationPoint;

    public AddUserTypePage clickAddUserType() {
        webElementHelper.click(addUserTypeInput);
        return this;
    }

    public AddUserTypePage fillUpNameInput() {
        webElementHelper.sendKeys(nameInput, "Admin");
        return this;
    }

    public AddUserTypePage fillUpNameInput1() {
        webElementHelper.sendKeys(nameInput, "SuperAdmin");
        return this;
    }

    public AddUserTypePage fillUpLearnNameInput() {
        webElementHelper.sendKeys(nameInput, "Learner-Type");
        return this;
    }

    public AddUserTypePage fillUpInstructorNameInput() {
        webElementHelper.sendKeys(nameInput, "Instructor");
        return this;
    }

    public AddUserTypePage arrowClick() {
        webElementHelper.click(arrowClickInput);
        return this;
    }

    public AddUserTypePage adminClick() {
        webElementHelper.click(adminInput);
        return this;
    }

    public AddUserTypePage instructorClick() {
        webElementHelper.click(instructorInput);
        return this;
    }

    public AddUserTypePage learnerClick() {
        webElementHelper.click(learnerInput);
        return this;
    }

    public AddUserTypePage tickTheBoxForAdministrator() {
        webElementHelper.click(tickTheBoxForAdmin);
        return this;
    }

    public AddUserTypePage tickTheBoxForInstructor() {
        webElementHelper.click(tickTheBoxForInstr);
        return this;
    }

    public AddUserTypePage tickTheBoxForLearner() {
        webElementHelper.click(tickTheBoxForLearn);
        return this;
    }

    public AddUserTypePage tickTheBoxForGeneral() {
        webElementHelper.click(tickTheBoxForGen);
        return this;
    }

    public AddUserTypePage clickOnTheAdminButton() {
        webElementHelper.click(clickAdmin);
        return this;
    }

    public AddUserTypePage clickOnTheInstructorButton() {
        webElementHelper.click(clickInstructor);
        return this;
    }

    public AddUserTypePage clickOnTheLearnButton() {
        webElementHelper.click(clickLearner);
        return this;
    }

    public AddUserTypePage clickOnTheGeneralButton() {
        webElementHelper.click(clickGeneral);
        return this;
    }

    public AddUserTypePage saveButton() {
        webElementHelper.click(saveBtn);
        return this;
    }

    public AddUserTypePage orCancelButton() {
        webElementHelper.click(orCancelToPress);
        return this;
    }

    public AddUserTypePage exclamationPointClick() {
        webElementHelper.click(exclamationPoint);
        return this;
    }
}