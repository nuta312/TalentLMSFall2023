package ui.pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;
import java.util.List;

import static ui.driver.Driver.getDriver;
import static ui.helper.FakeDataHelper.faker;

public class CoursesPage extends BasePage {

    @FindBy(xpath = "//div[@id='tl-admin-courses']")
    public WebElement clickCourses;
    @FindBy(xpath = "//a[contains(text(),'Add course')]")
    public WebElement clickAddCourse;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputNameOfCourse;
    @FindBy(xpath = "//span[contains(text(), 'Select or create a category')]")
    public WebElement clickToSelectOrCreateACategory;
    @FindBy(xpath = "//div[@id='select2-drop']/ul")
    public WebElement chooseCategory;
    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement inputDescription;
    @FindBy(xpath = "//a[@id='show-coursecode']")
    public WebElement clickCourseCode;
    @FindBy(xpath = "//input[@name='course_code']")
    public WebElement inputCourseCode;
    @FindBy(xpath = "//a[@id='show-price']")
    public WebElement clickPrice;
    @FindBy(xpath = "//input[@name='price']")
    public WebElement inputPrice;
    @FindBy(xpath = "//a[@id='show-intro-video-url']")
    public WebElement clickVideo;
    @FindBy(xpath = "//input[@name='intro_video_url']")
    public WebElement inputVideoURL;
    @FindBy(xpath = "//a[@id='show-capacity']")
    public WebElement clickCapacity;
    @FindBy(xpath = "//input[@name='capacity']")
    public WebElement inputCapacity;
    @FindBy(xpath = "//i[@id='icon-time-options']")
    public WebElement clickTimeOptions;
    @FindBy(xpath = "//div[@id='controls-course-duration']//label[@for='start-date']")
    public WebElement clickStartDate;
    @FindBy(xpath = "(//table[@class=' table-condensed']//th[@class='switch'])[1]")//
    public WebElement switchToStartMonth;
    @FindBy(xpath = "(//div[@class='dtpicker-months']//td)[1]")
    public WebElement chooseStartMonth;
    @FindBy(xpath = "//label[@for='expiration-date']")
    public WebElement clickExpirationDate;
    @FindBy(xpath = "(//table[@class=' table-condensed']//th[@class='switch'])[2]")//
    public WebElement switchToExpirationMonth;
    @FindBy(xpath = "(//div[@class='dtpicker-months']//td)[2]")
    public WebElement chooseExpirationMonth;
    @FindBy(xpath = "(//div[@class='dtpicker-days'])[1]//tbody/tr")
    public WebElement chooseStartDay;
    @FindBy(xpath = "(//div[@class='dtpicker-days'])[2]//tbody/tr")
    public WebElement chooseExpirationDay;
    @FindBy(xpath = "(//div[@id='control-group-time-options']//a)[1]")
    public WebElement clickToAllWindow;
    @FindBy(xpath = "//i[@id='icon-certification']")
    public WebElement clickCertificate;
    @FindBy(xpath = "//div[@id='s2id_course-certification']")
    public WebElement chooseCertificate;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
    public WebElement classicChoose;
    @FindBy(xpath = "//i[@id='icon-level']")
    public WebElement clickLevel;
    @FindBy(xpath = "//div[@id='s2id_course-level']")
    public WebElement triangleOfLevel;
    @FindBy(xpath = "(//ul[@class='select2-results'])[7]")
    public WebElement listOfLevel;
    @FindBy(xpath = "//div[@aria-label='Close']")
    public WebElement closeBeta;
    @FindBy(xpath = "//input[@class='btn btn-primary' and @name='submit_course']")
    public WebElement clickToSave;
    @FindBy(xpath = "//div[@class='toast toast-info']//div[@class='toast-message']")
    public WebElement messageAfterCreateCourse;
    @FindBy(xpath = "//span[@class='tl-box-title-options']//a[2]")
    public WebElement backToCoursePage;
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-grid-checkbox-wrapper hidden-phone'])[1]")
    public WebElement navigateMouseToPage;

    /**
     * delete xpath
     */
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]//i[3]")
    public WebElement hiddenDeleteButton;
    @FindBy(xpath = "//a[@id='tl-confirm-submit']")
    public WebElement deleteButton;

    /**
     * clonePage xpath
     */
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]//a/i")
    public WebElement hiddenCloneButton;
    @FindBy(xpath = "//a[@id='tl-clone-modal-confirm-submit']")
    public WebElement cloneButton;

    /**
     * edit xpath
     */
    @FindBy(xpath = "(//td[@class=' tl-align-center tl-table-operations-cell'])[1]//i[2]")
    public WebElement hiddenEditButton;
    @FindBy(xpath = "//div[@class='form-actions']//input")
    public WebElement updateCourseButton;
    @FindBy(xpath = "//div[@class='toast toast-success']//div[@class='toast-message']")
    public WebElement messageAfterEditCourse;
    public String courseTitle = faker.name().title();

    public CoursesPage addCourse() {
        webElementHelper
                .click(clickCourses)
                .click(clickAddCourse)
                .sendKeys(inputNameOfCourse, courseTitle)
                .click(clickToSelectOrCreateACategory);
        List<WebElement> liElements = chooseCategory.findElements(By.tagName("li"));
        if(!liElements.isEmpty()){
            int randomInt = random.nextInt(liElements.size());
            WebElement randomLi = liElements.get(randomInt);
            randomLi.click();
        }
        webElementHelper.sendKeys(inputDescription, faker.lorem().sentence())
                .click(clickCourseCode)
                .sendKeys(inputCourseCode, faker.number().digit())
                .click(clickPrice)
                .sendKeys(inputPrice, faker.number().digit())
                .click(clickVideo)
                .sendKeys(inputVideoURL, "https://www.youtube.com/watch?v=FctlT5sMnV0&ab_channel=Bairakgroup")
                .click(clickCapacity)
                .scrollDownPageAction(0,900)
                .sendKeys(inputCapacity, faker.number().digit())
                .click(clickTimeOptions)
                .scrollDownPageAction(0,700)
                .click(clickStartDate)
                .click(switchToStartMonth);
        List<WebElement> spanElementsOfStartMonth = chooseStartMonth.findElements(By.tagName("span"));
        if(!spanElementsOfStartMonth.isEmpty()){
            int randomInt = random.nextInt(spanElementsOfStartMonth.size());
            WebElement randomSpan = spanElementsOfStartMonth.get(randomInt);
            randomSpan.click();
        }
        List<WebElement> startDayElements = chooseStartDay.findElements(By.xpath("td"));
        if(!startDayElements.isEmpty()){
            int randomInt = random.nextInt(startDayElements.size());
            WebElement randomTd = startDayElements.get(randomInt);
            randomTd.click();
        }
        webElementHelper
                .click(clickExpirationDate)
                .click(switchToExpirationMonth);
        List<WebElement> spanElementsOfExpirationMonth = chooseExpirationMonth.findElements(By.tagName("span"));
        if(!spanElementsOfExpirationMonth.isEmpty()){
            int randomInt = random.nextInt(spanElementsOfExpirationMonth.size());
            WebElement randomSpan = spanElementsOfExpirationMonth.get(randomInt);
            randomSpan.click();
        }
        List<WebElement> dayElementsExpiration = chooseExpirationDay.findElements(By.xpath("td"));
        if(!dayElementsExpiration.isEmpty()){
            int randomInt = random.nextInt(dayElementsExpiration.size());
            WebElement randomTd = dayElementsExpiration.get(randomInt);
            randomTd.click();
        }
        webElementHelper
                .click(clickToAllWindow)
                .scrollDownPageAction(0,500)
                .click(clickCertificate)
                .click(chooseCertificate)
                .click(classicChoose)
                .click(clickLevel)
                .click(triangleOfLevel);
        List<WebElement> liElementss = listOfLevel.findElements(By.tagName("li"));
        if (!liElementss.isEmpty()) {
            int randomInt = random.nextInt(liElementss.size());
            WebElement randomLi = liElementss.get(randomInt);
            randomLi.click();
        }
        webElementHelper.click(closeBeta)
                .click(clickToSave);
        return this;
    }

    public CoursesPage clickToCoursePart(){
        webElementHelper.click(backToCoursePage);
        return this;
    }

    public void navigateMouse(){
        webElementHelper.actions = new Actions(getDriver());
        webElementHelper.actions.moveToElement(navigateMouseToPage).build().perform();
    }

    public CoursesPage removeCourse() {
        navigateMouse();
        webElementHelper.click(hiddenDeleteButton)
                .click(deleteButton);
        return this;
    }

    public CoursesPage cloneTheCourse() {
        navigateMouse();
        webElementHelper.click(hiddenCloneButton)
                .click(cloneButton);
        getDriver().navigate().refresh();
        return this;
    }

    public CoursesPage editCourse(){
        navigateMouse();
        webElementHelper.click(hiddenEditButton)
                .sendKeys(inputNameOfCourse,"Fall 2023 Course")
                .sendKeys(inputDescription, "The best team")
                .scrollDownPage()
                .click(updateCourseButton);
        return this;
    }
}