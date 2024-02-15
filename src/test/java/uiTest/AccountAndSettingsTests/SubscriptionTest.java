package uiTest.AccountAndSettingsTests;

import org.testng.annotations.Test;
import pages.URL_TalentLMS;
import uiTest.BaseTest;
import static org.testng.Assert.assertEquals;
import static pages.URL_TalentLMS.*;

public class SubscriptionTest extends BaseTest {

    @Test(description = "Select 'Starter plan' on Subscription page and assert urls", groups = {"Subscriptions"}, priority = 0)
    public void clickStarterPlanButtonTest() {
        browserManager.openByNavigate(SUBSCRIPTION_PAGE.toString());
        subscriptionPage.clickStarterPlanButton();

        assertEquals(URL_TalentLMS.STARTER_PLAN_PAGE.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:starter-annual-c2022,mode:upgrade");

        browserManager.goBack();
    }

    @Test(description = "Select 'Basic plan' on Subscription page", groups = {"Subscriptions"}, priority = 1)
    public void clickBasicPlanButtonTest() {
        subscriptionPage.clickBasicPlanButton();

        assertEquals(URL_TalentLMS.BASIC_PLAN_PAGE.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:basic-annual-c2022,mode:upgrade");

        browserManager.goBack();
    }

    @Test(description = "Select 'Plus plan' on Subscription page", groups = {"Subscriptions"}, priority = 2)
    public void clickPlusPlanButtonTest() {
        subscriptionPage.clickPlusPlanButton();

        assertEquals(URL_TalentLMS.PLUS_PLAN_PAGE.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:plus-annual-c2022,mode:upgrade");

        browserManager.goBack();
    }

    @Test(description = "Select 'Premium plan' on Subscription page", groups = {"Subscriptions"}, priority = 3)
    public void clickPremiumPlanButtonTest() {
        subscriptionPage.clickPremiumPlanButton();

        assertEquals(URL_TalentLMS.PREMIUM_PLAN_PAGE.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:premium-annual-c2022,mode:upgrade");
    }

}
