package ui.pages.accountAndSettings.gamification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PointsBox extends GamificationPage {

    @FindBy(xpath = "//label[text()='Each login gives']")
    public WebElement eachLogin;
    @FindBy(xpath = "//input[contains(@name,'unit_completion_points')]")
    public WebElement inputEachlLogin;
    @FindBy(xpath = "//label[text()='Each unit completion gives']")
    public WebElement eachUnitCompletion;
    @FindBy(xpath = "//input[contains(@name,'unit_completion_points')]")
    public WebElement inputEachUnitCompletion;
    @FindBy(xpath = "//label[text()='Each course completion gives']")
    public WebElement eachCourseCompletion;
    @FindBy(xpath = "//input[contains(@name,'course_completion_points')]")
    public WebElement inputEachCourseCompletion;
    @FindBy(xpath = "//label[text()='Each certificate gives']")
    public WebElement eachCertificate;
    @FindBy(xpath = "//input[contains(@name,'certification_points')]")
    public WebElement inputEachCertificate;
    @FindBy(xpath = "//label[text()='Each successful test completion gives']")
    public WebElement eachSuccessfulTest;
    @FindBy(xpath = "//input[contains(@name,'test_completion_points')]")
    public WebElement inputEachSuccessfulTest;
    @FindBy(xpath = "//label[text()='Each successful assignment completion gives']")
    public WebElement eachSuccessfulAssignment;
    @FindBy(xpath = "//input[contains(@name,'assignment_completion_points')]")
    public WebElement inputEachSuccessfulAssignment;
    @FindBy(xpath = "//label[text()='Each successful ILT completion gives']")
    public WebElement eachSuccessfulILT;
    @FindBy(xpath = "//input[contains(@name,'ilt_completion_points')]")
    public WebElement inputEachSuccessfulILT;
    @FindBy(xpath = "//label[text()='Each discussion topic or comment gives']")
    public WebElement eachDiscussionTopicOrComment;
    @FindBy(xpath = "//input[contains(@name,'discussion_topic_comment_points')]")
    public WebElement inputEachDiscussionTopicOrComment;
    @FindBy(xpath = "Each upvote on discussion comments gives")
    public WebElement eachUpvoteOnDiscussionComments;
    @FindBy(xpath = "//input[contains(@name,'discussion_upvote_comment_points')]")
    public WebElement inputEachUpvoteOnDiscussionComments;

    public PointsBox clickEachLogin() {
        webElementHelper.click(eachLogin);
        return this;
    }

    public PointsBox inputEachLoginPoints(String points) {
        webElementHelper.sendKeys(inputEachlLogin, points);
        return this;
    }

    public PointsBox clickEachUnitCompletion() {
        webElementHelper.click(eachUnitCompletion);
        return  this;
    }

    public PointsBox inputEachUnitCompletionPoints(String points) {
        webElementHelper.sendKeys(inputEachUnitCompletion, points);
        return this;
    }

    public PointsBox clickEachCourseCompletion() {
        webElementHelper.click(eachCourseCompletion);
        return this;
    }

    public PointsBox inputEachCourseCompletionPoints(String points) {
        webElementHelper.sendKeys(inputEachCourseCompletion, points);
        return this;
    }

    public PointsBox clickEachCertificate() {
        webElementHelper.click(eachCertificate);
        return this;
    }

    public PointsBox inputEachCertificatePoints(String points) {
        webElementHelper.sendKeys(inputEachCertificate, points);
        return this;
    }

    public PointsBox clickEachSuccessfulTest() {
        webElementHelper.click(eachSuccessfulTest);
        return this;
    }

    public PointsBox inputEachSuccessfulTestPoints(String points) {
        webElementHelper.sendKeys(inputEachSuccessfulTest, points);
        return this;
    }

    public PointsBox clickEachSuccessfulAssignment() {
        webElementHelper.click(eachSuccessfulAssignment);
        return this;
    }

    public PointsBox inputEachSuccessfulAssignmentPoints(String points) {
        webElementHelper.sendKeys(inputEachSuccessfulAssignment, points);
        return this;
    }

    public PointsBox clickEachSuccessfulILT() {
        webElementHelper.click(eachSuccessfulILT);
        return  this;
    }

    public PointsBox inputEachSuccessfulILTPoints(String points) {
        webElementHelper.sendKeys(inputEachSuccessfulILT, points);
        return this;
    }

    public PointsBox clickEachDiscussionTopicOrComment() {
        webElementHelper.click(eachDiscussionTopicOrComment);
        return  this;
    }

    public PointsBox inputEachDiscussionTopicOrCommentPoints(String points) {
        webElementHelper.sendKeys(inputEachDiscussionTopicOrComment, points);
        return this;
    }

    public PointsBox clickEachUpvoteOnDiscussionComments() {
        webElementHelper.click(eachUpvoteOnDiscussionComments);
        return  this;
    }

    public PointsBox inputEachUpvoteOnDiscussionCommentsPoints(String points) {
        webElementHelper.sendKeys(inputEachUpvoteOnDiscussionComments, points);
        return this;
    }
}
