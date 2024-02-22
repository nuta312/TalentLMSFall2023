package uiTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddUserTypeTest extends BaseTest {

    @Test(description = "Add a user type.Type user role defaults with the assert")
    void addUserTypeTest()  {
        addUserTypePage.clickAddUserType()
                       .fillUpNameInput()
                       .arrowClick()
                       .adminClick()
                       .tickTheBoxForAdministrator()
                       .saveButton();
        String actualArrowClick1 = driver.findElement(By.xpath("//span[normalize-space()='Administrator']")).getText();
        assertEquals(actualArrowClick1, "Administrator");
        String actualArrowClick2 = driver.findElement(By.xpath("//span[normalize-space()='Instructor']")).getText();
        assertEquals(actualArrowClick2, "Instructor");
        String actualArrowClick3 = driver.findElement(By.xpath("//span[normalize-space()='Learner']")).getText();
        assertEquals(actualArrowClick3, "Learner");
    }

    @Test(description = "Add a user type with an existing name")
    void addUserTypeTest2()  {
        addUserTypePage.clickAddUserType()
                       .fillUpNameInput1()
                       .arrowClick()
                       .adminClick()
                       .tickTheBoxForAdministrator()
                       .saveButton();
        String actualAlreadyExistUserTypeWithThisNameMess = addUserTypePage.alreadyExistUserTypeWithThisNameMess.getText();
        assertEquals(actualAlreadyExistUserTypeWithThisNameMess, "A user type with this name already exists");
    }

    @Test(description = "Add the Instructor user type as the default user type - Administrator role, Instructor permissions")
    void addUserTypeTest3(){
        addUserTypePage.clickAddUserType()
                       .fillUpInstructorNameInput()
                       .arrowClick()
                       .adminClick()
                       .tickTheBoxForInstructor()
                       .saveButton();
        String actualNotAvailableUserTypeForTheAssignedDefaultRoleMess = addUserTypePage.notAvailableUserTypeForTheAssignedDefaultRoleMess.getText();
        assertEquals(actualNotAvailableUserTypeForTheAssignedDefaultRoleMess, "The assigned default role is not available for this user type");
    }

    @Test(description = "Without adding the default user type and role for the administrator user type")
    void addUserTypeTest4(){
        addUserTypePage .clickAddUserType();
        webElementHelper.scrollToElement(addUserTypePage.saveBtn);
        addUserTypePage .saveButton();
        String actualNameIsRequiredMess = addUserTypePage.nameIsRequiredMess.getText();
        assertEquals(actualNameIsRequiredMess, "'Name' is required");
        String actualDefaultRoleUnavailableForThisUserTypeMess = addUserTypePage.defaultRoleUnavailableForThisUserTypeMess.getText();
        assertEquals(actualDefaultRoleUnavailableForThisUserTypeMess, "The assigned default role is not available for this user type");
        String actualNotDefinedAnyPermissionsForThisUserTypeMess = addUserTypePage.notDefinedAnyPermissionsForThisUserTypeMess.getText();
        assertEquals(actualNotDefinedAnyPermissionsForThisUserTypeMess, "You have not defined any permissions for this user type");
    }

    @Test(description = "Add the Instructor user type and existing permissions to Instructor")
    void addUserTypeInstructorTest() {
        addUserTypePage.clickAddUserType()
                       .fillUpInstructorNameInput()
                       .arrowClick()
                       .instructorClick()
                       .tickTheBoxForInstructor()
                       .saveButton();
    }

    @Test(description = "Add the Learner user type and existing permissions to Learner,General")
    void addUserTypeLearnerGeneralTest() {
        addUserTypePage.clickAddUserType()
                       .fillUpLearnNameInput()
                       .arrowClick()
                       .learnerClick()
                       .tickTheBoxForLearner()
                       .tickTheBoxForGeneral();
        webElementHelper.scrollToElement(addUserTypePage.saveBtn);
        addUserTypePage.saveButton();
    }
}