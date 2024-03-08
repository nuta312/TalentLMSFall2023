package uiTest.categoryTest;

import io.qameta.allure.testng.Tag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import uiTest.BaseTest;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

public class CategoryTest extends BaseTest {

    @Test(groups = {"TLMS", "Regression", "UI", "117"})
    @Tag("Regression")
    public void addNewCategory() {
        talentLmsInitPages.categoriesPage.addCategoriesPage();
        String textAfterAddNewCategory = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
        assertEquals("Success! New category created.", textAfterAddNewCategory);
    }

    @Test(groups = {"TLMS", "Regression", "UI", "118"})
    @Tag("Regression")
    public void updateCategory() {
        talentLmsInitPages.categoriesPage.categoryButtonClick();
        talentLmsInitPages.editTheCategories.changeCategories();
        String textAfterUpdateCategory = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
        assertEquals("Category updated successfully", textAfterUpdateCategory);
    }

    @Test(groups = {"TLMS", "Regression", "UI", "119"})
    @Tag("Regression")
    public void removeTheCategory() {
        List<WebElement> listOfCategories = driver.findElements(By.xpath("//table[@id='tl-categories-grid']/tbody"));
        for (WebElement row : listOfCategories) {
            System.out.println(row.getText());
        }
        talentLmsInitPages.categoriesPage.categoryButtonClick();
        talentLmsInitPages.deleteCategory.removeCategory();
        List<WebElement> listOfCategoriesAfterDelete = driver.findElements(By.xpath("//table[@id='tl-categories-grid']/tbody"));
        for (WebElement row : listOfCategoriesAfterDelete) {
            System.out.println(row.getText());
        }
        assertNotSame(listOfCategories, listOfCategoriesAfterDelete);
    }

    @Test(groups = {"TLMS", "Regression", "UI", "120"})
    @Tag("Regression")
    public void saveAsCSVFileOfCategory() {
        talentLmsInitPages.categoriesPage.categoryButtonClick();
        talentLmsInitPages.downloadCategoriesInfo.clickToInstall();
    }

    @Test(groups = {"TLMS", "Regression", "UI", "121"})
    @Tag("Regression")
    void catalogClickButton() {
        talentLmsInitPages.categoriesPage.categoryButtonClick();
        talentLmsInitPages.viewCourseCatalog.viewCourseCatalogBtn();
    }
}
