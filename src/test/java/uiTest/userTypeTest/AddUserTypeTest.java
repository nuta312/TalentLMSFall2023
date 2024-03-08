package uiTest.userTypeTest;

import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;

public class AddUserTypeTest extends BaseTest {

    @Test(description = "Add a user type.Type user role defaults with the assert", groups = {"TLMS", "Regression", "UI", "149"})
    @Tag("Regression")
    void addUserTypeTest() {
        talentLmsInitPages.addUserTypePage.clickAddUserType()
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

    @Test(description = "Add a user type with an existing name", groups = {"TLMS", "Regression", "UI", "150"})
    @Tag("Regression")
    void addUserTypeTest2() {
        talentLmsInitPages.addUserTypePage.clickAddUserType()
                       .fillUpNameInput1()
                       .arrowClick()
                       .adminClick()
                       .tickTheBoxForAdministrator()
                       .saveButton();
        String actualAlreadyExistUserTypeWithThisNameMess = talentLmsInitPages.addUserTypePage.alreadyExistUserTypeWithThisNameMess.getText();
        assertEquals(actualAlreadyExistUserTypeWithThisNameMess, "A user type with this name already exists");
    }

    @Test(description = "Add the Instructor user type as the default user type - Administrator role, Instructor permissions", groups = {"TLMS", "Regression", "UI", "151"})
    @Tag("Regression")
    void addUserTypeTest3() {
        talentLmsInitPages.addUserTypePage.clickAddUserType()
                       .fillUpInstructorNameInput()
                       .arrowClick()
                       .adminClick()
                       .tickTheBoxForInstructor()
                       .saveButton();
        String actualNotAvailableUserTypeForTheAssignedDefaultRoleMess = talentLmsInitPages.addUserTypePage.notAvailableUserTypeForTheAssignedDefaultRoleMess.getText();
        assertEquals(actualNotAvailableUserTypeForTheAssignedDefaultRoleMess, "The assigned default role is not available for this user type");
    }

    @Test(description = "Without adding the default user type and role for the administrator user type", groups = {"TLMS", "Regression", "UI", "152"})
    @Tag("Regression")
    void addUserTypeTest4() {
        talentLmsInitPages.addUserTypePage .clickAddUserType();
        webElementHelper.scrollToElement(talentLmsInitPages.addUserTypePage.saveBtn);
        talentLmsInitPages.addUserTypePage .saveButton();
        String actualNameIsRequiredMess = talentLmsInitPages.addUserTypePage.nameIsRequiredMess.getText();
        assertEquals(actualNameIsRequiredMess, "'Name' is required");
        String actualDefaultRoleUnavailableForThisUserTypeMess = talentLmsInitPages.addUserTypePage.defaultRoleUnavailableForThisUserTypeMess.getText();
        assertEquals(actualDefaultRoleUnavailableForThisUserTypeMess, "The assigned default role is not available for this user type");
        String actualNotDefinedAnyPermissionsForThisUserTypeMess = talentLmsInitPages.addUserTypePage.notDefinedAnyPermissionsForThisUserTypeMess.getText();
        assertEquals(actualNotDefinedAnyPermissionsForThisUserTypeMess, "You have not defined any permissions for this user type");
    }

    @Test(description = "Add the Instructor user type and existing permissions to Instructor", groups = {"TLMS", "Regression", "UI", "153"})
    @Tag("Regression")
    void addUserTypeInstructorTest() {
        talentLmsInitPages.addUserTypePage.clickAddUserType()
                       .fillUpInstructorNameInput()
                       .arrowClick()
                       .instructorClick()
                       .tickTheBoxForInstructor()
                       .saveButton();
    }

    @Test(description = "Add the Learner user type and existing permissions to Learner,General", groups = {"TLMS", "Regression", "UI", "154"})
    @Tag("Regression")
    void addUserTypeLearnerGeneralTest() {
        talentLmsInitPages.addUserTypePage.clickAddUserType()
                       .fillUpLearnNameInput()
                       .arrowClick()
                       .learnerClick()
                       .tickTheBoxForLearner()
                       .tickTheBoxForGeneral();
        webElementHelper.scrollToElement(talentLmsInitPages.addUserTypePage.saveBtn);
        talentLmsInitPages.addUserTypePage.saveButton();
    }
}