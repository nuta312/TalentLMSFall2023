package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static pages.TalentLMS_PAGES.MY_DOMAIN;
import static pages.TalentLMS_PAGES.TALENTLMS;
import static pages.TalentLMS_PAGES.STARTER_PLAN;
import static pages.TalentLMS_PAGES.SUBSCRIPTION;
import static pages.TalentLMS_PAGES.BASIC_PLAN;
import static pages.TalentLMS_PAGES.PLUS_PLAN;
import static pages.TalentLMS_PAGES.PREMIUM_PLAN;
import static org.testng.Assert.assertEquals;

public class SubscriptionTest extends BaseTest {

    @Test(description = "Select 'Starter plan' on Subscription page and assert urls", groups = {"Subscriptions"}, priority = 0)
    public void clickStarterPlanButtonTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + SUBSCRIPTION);
        subscriptionPage.clickStarterPlanButton();
        assertEquals(MY_DOMAIN.toString() + TALENTLMS + STARTER_PLAN, "https://fall2023.talentlms.com/account/subscription_selectplan/plan:starter-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Basic plan' on Subscription page", groups = {"Subscriptions"}, priority = 1)
    public void clickBasicPlanButtonTest() {
        subscriptionPage.clickBasicPlanButton();
        assertEquals(MY_DOMAIN.toString() + TALENTLMS + BASIC_PLAN, "https://fall2023.talentlms.com/account/subscription_selectplan/plan:basic-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Plus plan' on Subscription page", groups = {"Subscriptions"}, priority = 2)
    public void clickPlusPlanButtonTest() {
        subscriptionPage.clickPlusPlanButton();
        assertEquals(MY_DOMAIN.toString() + TALENTLMS + PLUS_PLAN, "https://fall2023.talentlms.com/account/subscription_selectplan/plan:plus-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Premium plan' on Subscription page", groups = {"Subscriptions"}, priority = 3)
    public void clickPremiumPlanButtonTest() {
        subscriptionPage.clickPremiumPlanButton();
        assertEquals(MY_DOMAIN.toString() + TALENTLMS + PREMIUM_PLAN, "https://fall2023.talentlms.com/account/subscription_selectplan/plan:premium-annual-c2022,mode:upgrade");
    }
}
