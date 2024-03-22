package ui.pages.accountAndSettings.gamification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BadgesBox extends GamificationPage {

    @FindBy(xpath = "//label[text()='Activity badges (4, 8, 16, 32, 64, 128, 256, 512 logins)']")
    public WebElement activityBadges;
    @FindBy (xpath = "//label[text()='Learning badges (1, 2, 4, 8, 16, 32, 64, 128 completed courses)']")
    public WebElement learningBadges;
    @FindBy (xpath = "//label[text()='Test badges (2, 4, 8, 16, 32, 64, 128, 256 passed tests)']")
    public WebElement testBadges;
    @FindBy (xpath = "//label[text()='Assignment badges (1, 2, 4, 8, 16, 32, 64, 128 passed assignments)']")
    public WebElement assignmentBadges;
    @FindBy (xpath = "//label[text()='Perfectionism badges (1, 2, 4, 8, 16, 32, 64, 128 tests or assignments with score 90%+)']")
    public WebElement perfectionismBadges;
    @FindBy (xpath = "//label[text()='Survey badges (1, 2, 4, 8, 16, 32, 64, 128 completed surveys)']")
    public WebElement surveyBadges;
    @FindBy (xpath = "//label[text()='Communication badges (2, 4, 8, 16, 32, 64, 128, 256 topics or comments)']")
    public WebElement communicationBadges;
    @FindBy (xpath = "//label[text()='Certification badges (1, 2, 4, 8, 16, 32, 64, 128 certificates)']")
    public WebElement certificationBadges;

    public BadgesBox clickActivityBadges() {
        webElementHelper.click(activityBadges);
        return this;
    }

    public BadgesBox clickLearningBadges() {
        webElementHelper.click(learningBadges);
        return this;
    }

    public BadgesBox clickTestBadges() {
        webElementHelper.click(testBadges);
        return this;
    }

    public BadgesBox clickAssignmentBadges() {
        webElementHelper.click(assignmentBadges);
        return this;
    }

    public BadgesBox clickPerfectionismBadges() {
        webElementHelper.click(perfectionismBadges);
        return this;
    }

    public BadgesBox clickSurveyBadges() {
        webElementHelper.click(surveyBadges);
        return this;
    }

    public BadgesBox clickCommunicationBadges() {
        webElementHelper.click(communicationBadges);
        return this;
    }

    public BadgesBox clickCertificationBadges() {
        webElementHelper.click(certificationBadges);
        return this;
    }
}
