package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.STARTER_PLAN;
import static pages.TalentLMS_PAGES.SUBSCRIPTION;
import static pages.TalentLMS_PAGES.BASIC_PLAN;
import static pages.TalentLMS_PAGES.PLUS_PLAN;
import static pages.TalentLMS_PAGES.PREMIUM_PLAN;

public class SubscriptionTest extends BaseTest {

    @Test(description = "Select 'Starter plan' on Subscription page and assert urls", groups = {"Subscriptions"}, priority = 0)
    public void clickStarterPlanButtonTest(){
        browserManager.openByNavigate(SUBSCRIPTION.toString());
        subscriptionPage.clickStarterPlanButton();
        assertEquals(STARTER_PLAN.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:starter-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Basic plan' on Subscription page", groups = {"Subscriptions"}, priority = 1)
    public void clickBasicPlanButtonTest(){
        subscriptionPage.clickBasicPlanButton();
        assertEquals(BASIC_PLAN.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:basic-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Plus plan' on Subscription page", groups = {"Subscriptions"}, priority = 2)
    public void clickPlusPlanButtonTest(){
        subscriptionPage.clickPlusPlanButton();
        assertEquals(PLUS_PLAN.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:plus-annual-c2022,mode:upgrade");
        browserManager.goBack();
    }

    @Test(description = "Select 'Premium plan' on Subscription page", groups = {"Subscriptions"}, priority = 3)
    public void clickPremiumPlanButtonTest(){
        subscriptionPage.clickPremiumPlanButton();
        assertEquals(PREMIUM_PLAN.toString(), "https://fall2023.talentlms.com/account/subscription_selectplan/plan:premium-annual-c2022,mode:upgrade");
    }
}
