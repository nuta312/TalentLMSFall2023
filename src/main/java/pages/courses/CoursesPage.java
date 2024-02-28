package pages.courses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import java.util.List;

import static helper.FakeDataHelper.faker;

public class CoursesPage extends BasePage {

    @FindBy(id = "tl-admin-courses")
    public WebElement clickCourses;
    @FindBy(xpath = "(//a[@class='btn btn-primary'])[3]")
    public WebElement clickAddCourse;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputNameOfCourse;
    @FindBy(xpath = "(//span[@class='select2-chosen'])[1]")
    public WebElement getCategory;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[1]")
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
    @FindBy(xpath = "//div[@class='controls']/div/input[@id='start-date']")
    public WebElement clickStartDate;
    @FindBy(xpath = "(//td[text()='18'])[1]")
    public WebElement chooseStartDate;
    @FindBy(xpath = "(//div[@class='dtpicker-days']/table/tbody/tr[4]/td[6])[2]")
    public WebElement clickFinishDate;
    @FindBy(xpath = "(//div[@class=\"dtpicker-days\"])[2]/table/tbody/tr[5]/td[5]")
    public WebElement chooseFinishDate;
    @FindBy(xpath = "(//div[@class=\"span12\"])[1]")
    public WebElement clickToAllWindow;
    @FindBy(xpath = "//i[@id=\"icon-certification\"]")
    public WebElement clickCertificate;
    @FindBy(xpath = "//div[@id=\"s2id_course-certification\"]")
    public WebElement chooseCertificate;
    @FindBy(xpath = "(//div[@class=\"select2-result-label\"])[2]")
    public WebElement classicChoose;
    @FindBy(xpath = "//i[@id=\"icon-level\"]")
    public WebElement clickLevel;
    @FindBy(xpath = "//div[@id=\"s2id_course-level\"]")
    public WebElement triangleOfLevel;
    @FindBy(xpath = "(//ul[@class='select2-results'])[7]")
    public WebElement listOfLevel;
    @FindBy(xpath = "//div[@aria-label=\"Close\"]")
    public WebElement closeBeta;
    @FindBy(xpath = "//input[@class=\"btn btn-primary\" and @name=\"submit_course\"]")
    public WebElement clickToSave;

    public CoursesPage addCourse() {
        webElementHelper
                .click(clickCourses)
                .click(clickAddCourse)
                .sendKeys(inputNameOfCourse, "BugsBunny")
                .click(getCategory)
                .click(chooseCategory)
                .sendKeys(inputDescription, faker.lorem().sentence())
                .click(clickCourseCode)
                .sendKeys(inputCourseCode, faker.number().digit())
                .click(clickPrice)
                .sendKeys(inputPrice, faker.number().digit())
                .click(clickVideo)
                .sendKeys(inputVideoURL, "https://www.youtube.com/watch?v=FctlT5sMnV0&ab_channel=Bairakgroup")
                .click(clickCapacity)
                .scrollDownPageAction(0,500)
                .sendKeys(inputCapacity, faker.number().digit())
                .click(clickTimeOptions)
                .click(clickStartDate)
                .click(chooseStartDate)
                .click(clickFinishDate)
                .click(chooseFinishDate)
                .click(clickToAllWindow)
                .click(clickCertificate)
                .click(chooseCertificate)
                .click(classicChoose)
                .click(clickLevel)
                .click(triangleOfLevel);
        List<WebElement> liElements = listOfLevel.findElements(By.tagName("li"));
        if (!liElements.isEmpty()) {
            int randomInt = random.nextInt(liElements.size());
            WebElement randomLi = liElements.get(randomInt);
            randomLi.click();
        }
        webElementHelper.click(closeBeta)
                .click(clickToSave);
        return this;
    }
}
