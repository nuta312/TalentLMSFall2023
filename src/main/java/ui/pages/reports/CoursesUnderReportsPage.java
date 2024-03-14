package ui.pages.reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

public class CoursesUnderReportsPage extends BasePage {

    @FindBy(xpath = "(//div/a[contains(text(),'Courses')])[2]")
    public WebElement coursesLink;
    @FindBy(xpath = "(//span[@class='tl-formatted-course-name'])[1]")
    public WebElement advancedFeatures;
    @FindBy(xpath = "(//span[@class='tl-formatted-course-name'])[2]")
    public WebElement contentAndTLMS;
    @FindBy(xpath = "(//span[@class='tl-formatted-course-name'])[3]")
    public WebElement employeeTraining;
    @FindBy(xpath = "(//span[@class='tl-formatted-course-name'])[4]")
    public WebElement gettingWithStartingAndLearning;
    @FindBy(xpath = "(//span[@class='tl-formatted-course-name'])[5]")
    public WebElement giveYourCourseAName;
    @FindBy(xpath = "(//span[@class='tl-formatted-course-name'])[6]")
    public WebElement introductionToTLMS;
    @FindBy(xpath = "//span[@title='What is TalentLibrary? (006)']")
    public WebElement whatIsTLMSLibrary;
    @FindBy(id = "scorm-tab")
    public WebElement scormTab;
    @FindBy(xpath = "//a/span[contains(text(),'What is TalentLibrary?')]")
    public WebElement whatIsTLMSLibraryNested;
    @FindBy(xpath = "//h3[@class='tl-table-no-data-title']")
    public WebElement assertText;

    public CoursesUnderReportsPage clickAdvancedFeatures() {
        webElementHelper.click(advancedFeatures);
        return this;
    }

    public CoursesUnderReportsPage clickContentAndTLMS() {
        webElementHelper.click(contentAndTLMS);
        return this;
    }

    public CoursesUnderReportsPage clickEmployeeTraining() {
        webElementHelper.click(employeeTraining);
        return this;
    }

    public CoursesUnderReportsPage clickGettingWithStarting() {
        webElementHelper.click(gettingWithStartingAndLearning);
        return this;
    }

    public CoursesUnderReportsPage clickGiveYourCourseAName() {
        webElementHelper.click(giveYourCourseAName);
        return this;
    }

    public CoursesUnderReportsPage clickIntroductionToTLMS() {
        webElementHelper.click(introductionToTLMS);
        return this;
    }

    public CoursesUnderReportsPage clickWhatIsTLMSLibrary() {
        webElementHelper.click(whatIsTLMSLibrary);
        return this;
    }

    public CoursesUnderReportsPage clickScormTab() {
        webElementHelper.click(scormTab);
        return this;
    }

    public CoursesUnderReportsPage clickNestedWhatIsTLMSLibrary() {
        webElementHelper.click(whatIsTLMSLibraryNested);
        return this;
    }
}
