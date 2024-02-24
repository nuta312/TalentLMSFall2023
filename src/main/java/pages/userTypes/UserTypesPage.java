package pages.userTypes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserTypesPage extends BasePage {

    private int countRowsInTableUserTypes;

    @FindBy(xpath = "//input[@id='user_type_name']")
    public WebElement nameUserTypeField;
    @FindBy(xpath = "//div[@class='tl-header-tools']/a[@class='btn btn-primary']")
    public WebElement addUserTypeBtn;
    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement fieldSelectUserType;
    @FindBy(xpath = "//div[@class='select2-result-label']")
    public List<WebElement> listSelectUserTypes;
    @FindBy(xpath = "//span[@class='dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-exp-e dynatree-ico-ef']/span[@class='dynatree-checkbox']")
    public List<WebElement> listPermissionCheckbox;
    @FindBy(xpath = "//span[@class='dynatree-node dynatree-folder dynatree-expanded dynatree-has-children dynatree-lastsib dynatree-exp-el dynatree-ico-ef']/span[@class='dynatree-checkbox']")
    public WebElement permissionCheckboxGeneral;
    @FindBy(xpath = "//input[@id='user-type-save-button']")
    public WebElement saveBtn;
    @FindBy(xpath = "//input[@class='tl-grid-search-input']")
    public WebElement searchField;
    @FindBy(xpath = "//span[@id='user-type-name-help-block']/span[@class='help-inline']")
    public WebElement warningTextTypeNameRepeated;
    @FindBy(xpath = "//th[@class='tl-align-left sorting_asc']")
    public WebElement filterUserTypeNameInTableUserType;
    @FindBy(xpath = "//tr[@role='row']")
    public List<WebElement> rowsTableUserTypes;
    @FindBy(xpath = "//td[@class=' tl-align-left']")
    public List<WebElement> cellsNameTableUserTypes;
    @FindBy(xpath = "//i[@class='icon-remove icon-grid']")
    public List<WebElement> removeBtnUserTypesTable;
    @FindBy(xpath = "//div[@class='tl-table-operations-trigger touchable']")
    public List<WebElement> optionBtnUserTypesTable;

    public void addUserTypeBtnClick() {
        webElementHelper.click(addUserTypeBtn);
    }

    public void saveBtnClick() {
        webElementHelper.click(saveBtn);
    }

    public void searchFieldClear() {
        searchField.clear();
        searchField.sendKeys(Keys.ENTER);
    }

    public boolean checkUserInTable(WebDriver driver, String  userNameType) {
        for(String nameType : getRolesFromTable(driver)){
            if(nameType.toLowerCase().equals(userNameType.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    public void addNotUniqueUserType(String userTypeName, int  indexPermission) {
        addUserType(userTypeName, indexPermission);
        addUserType(userTypeName, indexPermission);
    }

    public void addUserType (String userTypeName, int  indexPermission) {
        addUserTypeBtnClick();
        fillUpNameUserType(userTypeName);
        choiceUserTypes(indexPermission);
        choosePermission(indexPermission);
        saveBtnClick();
    }

    public boolean checkFilterUserTypeNameInTableUserType(List<String> beforeSortUserTypesName, List<String> afterSortUserTypesName) {
        Collections.sort(beforeSortUserTypesName);
        countRowsInTableUserTypes = 0;
        for(int i = 0; i < beforeSortUserTypesName.size(); i++){
            if(beforeSortUserTypesName.get(i).equals(afterSortUserTypesName.get(i))){
                countRowsInTableUserTypes++;
            }
        }
        if(countRowsInTableUserTypes == afterSortUserTypesName.size()){
            return true;
        } else{
            return false;
        }
    }

    public int countingRowsInTable(List<String> listUserTypes, String searchWord) {
        countRowsInTableUserTypes = 0;
        for(int i = 0; i < listUserTypes.size(); i++){
            if(listUserTypes.get(i).toLowerCase().contains(searchWord.toLowerCase())){
                countRowsInTableUserTypes++;
            }
        }
        return countRowsInTableUserTypes;
    }

    public void fillUpNameUserType(String nameUserType) {
        webElementHelper.sendKeys(nameUserTypeField, nameUserType);
    }

    public void choiceUserTypes(int choice) {
        fieldSelectUserType.click();
        listSelectUserTypes.get(choice).click();
    }

    public void choosePermission(int choose){
        switch (choose){
            case 0:
                listPermissionCheckbox.get(0).click();
                permissionCheckboxGeneral.click();
                break;
            case 1:
                listPermissionCheckbox.get(1).click();
                permissionCheckboxGeneral.click();
                break;
            case 2:
                listPermissionCheckbox.get(2).click();
                permissionCheckboxGeneral.click();
                break;
        }
    }

    public ArrayList<String> getRolesFromTable(WebDriver driver){
        String nameType;
        ArrayList<String> roles = new ArrayList<>();
        countRowsInTableUserTypes = 0;
        for(WebElement row : rowsTableUserTypes){
            if(countRowsInTableUserTypes >= rowsTableUserTypes.size() - 1){
                break;
            }
            nameType = cellsNameTableUserTypes.get(countRowsInTableUserTypes).getText();
            countRowsInTableUserTypes++;
            roles.add(nameType);
        }
        return roles;
    }
}