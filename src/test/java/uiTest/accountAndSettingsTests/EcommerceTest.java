package uiTest.accountAndSettingsTests;

import org.testng.annotations.Test;
import uiTest.BaseTest;

import static org.testng.Assert.assertEquals;
import static pages.TalentLMS_PAGES.ECOMMERCE;

public class EcommerceTest extends BaseTest {

    @Test(description = "Select stripe in e-commerce processor input")
    public void connectStripeTest() {
        browserManager.openByNavigate(ECOMMERCE.toString());
        ecommercePage.clickSelect()
                .clickStripe()
                .clickConnectWithStripeButton();
        assertEquals(ecommercePage.stripeSiteGetStartedText.getText(), "Get started with Stripe");
    }
}
