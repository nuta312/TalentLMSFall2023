package uiTest.categoryTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import uiTest.BaseTest;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotSame;

public class CategoryTest extends BaseTest {

    @Test
    void addNewCategory() {
        categoriesPage.addCategoriesPage();
        String textAfterAddNewCategory = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
        assertEquals("Success! New category created.", textAfterAddNewCategory);
    }

    @Test
    void updateCategory() {
        categoriesPage.categoryButtonClick();
        editTheCategories.changeCategories();
        String textAfterUpdateCategory = driver.findElement(By.xpath("//div[@class='toast-message']")).getText();
        assertEquals("Category updated successfully", textAfterUpdateCategory);
    }

    @Test
    void removeTheCategory() {
        List<WebElement> listOfCategories = driver.findElements(By.xpath("//table[@id='tl-categories-grid']/tbody"));
        for (WebElement row : listOfCategories) {
            System.out.println(row.getText());
        }
        categoriesPage.categoryButtonClick();
        deleteCategory.removeCategory();
        List<WebElement> listOfCategoriesAfterDelete = driver.findElements(By.xpath("//table[@id='tl-categories-grid']/tbody"));
        for (WebElement row : listOfCategoriesAfterDelete) {
            System.out.println(row.getText());
        }
        assertNotSame(listOfCategories, listOfCategoriesAfterDelete);
    }

    @Test
    void saveAsCSVFileOfCategory() {
        categoriesPage.categoryButtonClick();
        downloadCategoriesInfo.clickToInstall();
    }

    @Test
    void catalogClickButton() {
        categoriesPage.categoryButtonClick();
        viewCourseCatalog.viewCourseCatalogBtn();
    }
}
