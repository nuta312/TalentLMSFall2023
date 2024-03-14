package uiTest.accountAndSettingsTests;

import io.qameta.allure.testng.Tag;
import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.ECOMMERCE;
import static org.testng.Assert.assertEquals;

public class EcommerceTest extends BaseTest {

    @Test(description = "Select stripe in e-commerce processor input", groups = {"TLMS", "Regression", "UI", "105"})
    @Tag("Regression")
    public void connectStripeTest() {
        browserManager.openByNavigate(MY_DOMAIN.getURL() + TALENTLMS.getURL() + ECOMMERCE.getURL());
        talentLmsInitPages.ecommercePage.clickSelect()
                .clickStripe()
                .clickConnectWithStripeButton();
        assertEquals(talentLmsInitPages.ecommercePage.stripeSiteGetStartedText.getText(), "Get started with Stripe");
    }
}
