package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.STARTER_PLAN;
import static ui.pages.TalentLMS_PAGES.SUBSCRIPTION;
import static ui.pages.TalentLMS_PAGES.BASIC_PLAN;
import static ui.pages.TalentLMS_PAGES.PLUS_PLAN;
import static ui.pages.TalentLMS_PAGES.PREMIUM_PLAN;
import static org.testng.Assert.assertEquals;

public class SubscriptionTest extends BaseTest {

    @Test(description = "Select 'Starter plan' on Subscription page and assert urls", groups = {"TLMS", "Smoke", "UI", "112"}, priority = 0)
    @Tag("Smoke")
    public void clickStarterPlanButtonTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + SUBSCRIPTION.getURL());
        talentLmsInitPages.subscriptionPage.clickStarterPlanButton();
        assertEquals(MY_DOMAIN.getURL() + TALENTLMS.getURL() + STARTER_PLAN.getURL(), "https://fall2023dg.talentlms.com/account/subscription_selectplan/plan:starter-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Basic plan' on Subscription page", groups = {"TLMS", "Smoke", "UI", "113"}, priority = 1)
    @Tag("Smoke")
    public void clickBasicPlanButtonTest() {
        talentLmsInitPages.subscriptionPage.clickBasicPlanButton();
        assertEquals(MY_DOMAIN.getURL() + TALENTLMS.getURL() + BASIC_PLAN.getURL(), "https://fall2023dg.talentlms.com/account/subscription_selectplan/plan:basic-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Plus plan' on Subscription page", groups = {"TLMS", "Smoke", "UI", "114"}, priority = 2)
    @Tag("Smoke")
    public void clickPlusPlanButtonTest() {
        talentLmsInitPages.subscriptionPage.clickPlusPlanButton();
        assertEquals(MY_DOMAIN.getURL() + TALENTLMS.getURL() + PLUS_PLAN.getURL(), "https://fall2023dg.talentlms.com/account/subscription_selectplan/plan:plus-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Premium plan' on Subscription page", groups = {"TLMS", "Smoke", "UI", "115"}, priority = 3)
    @Tag("Smoke")
    public void clickPremiumPlanButtonTest() {
        talentLmsInitPages.subscriptionPage.clickPremiumPlanButton();
        assertEquals(MY_DOMAIN.getURL() + TALENTLMS.getURL() + PREMIUM_PLAN.getURL(), "https://fall2023dg.talentlms.com/account/subscription_selectplan/plan:premium-annual-c2022,mode:upgrade");
    }
}
