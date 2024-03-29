package uiTest;

import org.testng.annotations.BeforeClass;
import ui.pages.LoginPage;
import ui.pages.users.UsersPage;
import ui.pages.groups.GroupsPage;
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
import ui.pages.reports.CoursesUnderReportsPage;
import ui.pages.reports.ReportsIconAndLinkPage;
import ui.pages.reports.ReportsPage;
import ui.pages.reports.TrainingMatrixPage;
import ui.pages.reports.UserReportsPage;
import ui.pages.reports.UsersUnderReportsPage;
import ui.pages.userTypes.UserTypesPage;
import ui.pages.userTypes.AddUserTypePage;
import ui.pages.importExport.ExportPage;
import java.util.List;

public class TalentLmsInitPages {

    public LoginPage loginPage;
    public BasicSettingsPage basicSettingsPage;
    public AccountUsersPage accountUsersPage;
    public ThemesPage themesPage;
    public CertificatesPage certificatesPage;
    public EcommercePage ecommercePage;
    public DomainPage domainPage;
    public SubscriptionPage subscriptionPage;
    public GamificationPage gamificationPage;
    public PointsBox pointsBox;
    public BadgesBox badgesBox;
    public LevelsBox levelsBox;
    public RewardsBox rewardsBox;
    public LeaderboardBox leaderboardBox;
    public UsersPage usersPage;
    public CategoriesPage categoriesPage;
    public EditTheCategories editTheCategories;
    public DeleteCategory deleteCategory;
    public DownloadCategoriesInfo downloadCategoriesInfo;
    public ViewCourseCatalog viewCourseCatalog;
    public CoursesPage coursesPage;
    public ReportsPage reportsPage;
    public TrainingMatrixPage trainingMatrixPage;
    public UserTypesPage userTypesPage;
    public List<String> listUserTypes;
    public ReportsIconAndLinkPage reportsIconAndLinkPage;
    public CoursesUnderReportsPage coursesUnderReportsPage;
    public UsersUnderReportsPage usersUnderReportsPage;
    public AddUserTypePage addUserTypePage;
    public ExportPage exportPage;
    public UserReportsPage userReportsPage;
    public GroupsPage groupsPage;

    @BeforeClass(alwaysRun = true)
    public void initPages() {
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
        groupsPage = new GroupsPage();
        userReportsPage = new UserReportsPage();
    }
}
