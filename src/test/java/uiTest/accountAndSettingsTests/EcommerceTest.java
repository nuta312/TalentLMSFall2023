package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static ui.pages.TalentLMS_PAGES.MY_DOMAIN;
import static ui.pages.TalentLMS_PAGES.TALENTLMS;
import static ui.pages.TalentLMS_PAGES.ECOMMERCE;
import static org.testng.Assert.assertEquals;

public class EcommerceTest extends BaseTest {

    @Test(description = "Select stripe in e-commerce processor input")
    public void connectStripeTest() {
        browserManager.openByNavigate(MY_DOMAIN.toString() + TALENTLMS + ECOMMERCE);
        ecommercePage.clickSelect()
                .clickStripe()
                .clickConnectWithStripeButton();
        assertEquals(ecommercePage.stripeSiteGetStartedText.getText(), "Get started with Stripe");
    }
}
