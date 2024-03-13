package uiTest;

import ui.driver.Driver;
import ui.helper.BrowserManager;
import ui.helper.WebElementHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ui.pages.accountAndSettings.AccountUsersPage;
import ui.pages.accountAndSettings.BasicSettingsPage;
import ui.pages.accountAndSettings.ThemesPage;
import ui.pages.accountAndSettings.CertificatesPage;
import ui.pages.accountAndSettings.EcommercePage;
import ui.pages.accountAndSettings.DomainPage;
import ui.pages.accountAndSettings.SubscriptionPage;
import ui.pages.accountAndSettings.gamification.GamificationPage;
import ui.pages.accountAndSettings.gamification.PointsBox;
import ui.pages.accountAndSettings.gamification.BadgesBox;
import ui.pages.accountAndSettings.gamification.LevelsBox;
import ui.pages.accountAndSettings.gamification.RewardsBox;
import ui.pages.accountAndSettings.gamification.LeaderboardBox;
import ui.pages.categories.DeleteCategory;
import ui.pages.categories.DownloadCategoriesInfo;
import ui.pages.categories.EditTheCategories;
import ui.pages.categories.ViewCourseCatalog;
import ui.pages.categories.CategoriesPage;
import ui.pages.courses.CoursesPage;
import ui.pages.users.UsersPage;
import ui.pages.reports.ReportsPage;
import ui.pages.reports.TrainingMatrixPage;
import ui.pages.reports.ReportsIconAndLinkPage;
import ui.pages.reports.CoursesUnderReportsPage;
import ui.pages.reports.UsersUnderReportsPage;
import ui.pages.LoginPage;
import ui.pages.userTypes.UserTypesPage;
import ui.pages.userTypes.AddUserTypePage;
import ui.pages.importExport.ExportPage;
import java.util.List;

import static ui.pages.TalentLMS_PAGES.MAIN_PAGE;
import static ui.pages.TalentLMS_PAGES.LOGIN;

public class BaseTest {

    protected WebDriver driver;
    protected WebElementHelper webElementHelper;
    protected BrowserManager browserManager;
    protected BrowserManager.WindowHelper windowHelper;
    protected BrowserManager.FrameHelper frameHelper;
    protected LoginPage loginPage;
    protected BasicSettingsPage basicSettingsPage;
    protected AccountUsersPage accountUsersPage;
    protected ThemesPage themesPage;
    protected CertificatesPage certificatesPage;
    protected EcommercePage ecommercePage;
    protected DomainPage domainPage;
    protected SubscriptionPage subscriptionPage;
    protected GamificationPage gamificationPage;
    protected PointsBox pointsBox;
    protected BadgesBox badgesBox;
    protected LevelsBox levelsBox;
    protected RewardsBox rewardsBox;
    protected LeaderboardBox leaderboardBox;
    protected UsersPage usersPage;
    protected CategoriesPage categoriesPage;
    protected EditTheCategories editTheCategories;
    protected DeleteCategory deleteCategory;
    protected DownloadCategoriesInfo downloadCategoriesInfo;
    protected ViewCourseCatalog viewCourseCatalog;
    protected CoursesPage coursesPage;
    protected ReportsPage reportsPage;
    protected TrainingMatrixPage trainingMatrixPage;
    protected UserTypesPage userTypesPage;
    protected List<String> listUserTypes;
    protected ReportsIconAndLinkPage reportsIconAndLinkPage;
    protected CoursesUnderReportsPage coursesUnderReportsPage;
    protected UsersUnderReportsPage usersUnderReportsPage;
    protected AddUserTypePage addUserTypePage;
    protected ExportPage exportPage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = Driver.getDriver();
        webElementHelper = new WebElementHelper();
        browserManager = new BrowserManager(driver);
        windowHelper = new BrowserManager.WindowHelper(driver);
        frameHelper = new BrowserManager.FrameHelper(driver);
        loginPage = new LoginPage();
        usersPage = new UsersPage();
        basicSettingsPage = new BasicSettingsPage();
        accountUsersPage = new AccountUsersPage();
        themesPage = new ThemesPage();
        certificatesPage = new CertificatesPage();
        ecommercePage = new EcommercePage();
        domainPage = new DomainPage();
        subscriptionPage = new SubscriptionPage();
        gamificationPage = new GamificationPage();
        pointsBox =  new PointsBox();
        badgesBox = new BadgesBox();
        levelsBox = new LevelsBox();
        rewardsBox = new RewardsBox();
        leaderboardBox = new LeaderboardBox();
        categoriesPage = new CategoriesPage();
        editTheCategories = new EditTheCategories();
        deleteCategory = new DeleteCategory();
        downloadCategoriesInfo = new DownloadCategoriesInfo();
        viewCourseCatalog = new ViewCourseCatalog();
        coursesPage = new CoursesPage();
        reportsPage = new ReportsPage();
        trainingMatrixPage = new TrainingMatrixPage();
        userTypesPage = new UserTypesPage();
        reportsIconAndLinkPage = new ReportsIconAndLinkPage();
        coursesUnderReportsPage = new CoursesUnderReportsPage();
        usersUnderReportsPage = new UsersUnderReportsPage();
        addUserTypePage = new AddUserTypePage();
        exportPage = new ExportPage();
        driver.get(MAIN_PAGE.toString() + LOGIN);
        loginPage.doLogin();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
       Driver.closeDriver();
    }
}