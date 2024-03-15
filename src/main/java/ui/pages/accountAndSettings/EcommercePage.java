package ui.pages.accountAndSettings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.pages.BasePage;

import static ui.helper.FakeDataHelper.faker;

public class EcommercePage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Select your e-commerce processor')]")
    public WebElement inputSelect;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[2]")
    public WebElement inputPayPal;
    @FindBy(xpath = "//input[@class='span3']")
    public WebElement inputAddressPayPal;
    @FindBy(xpath = "//span[contains(text(),'PayPal')]")
    public WebElement inputPaypalClick;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[3]")
    public WebElement inputStripe;
    @FindBy(xpath = "//a[contains(@href, 'Digital')]")
    public WebElement connectWithStripeButton;
    @FindBy(xpath = "//span[text()='Get started with Stripe']")
    public WebElement stripeSiteGetStartedText;
    @FindBy(xpath = "(//div[@class='select2-result-label'])[1]")
    public WebElement inputSelectYour;
    @FindBy(id = "show-subscription")
    public WebElement inputSubscription;
    @FindBy(id = "show-discount")
    public WebElement inputDiscounts;
    @FindBy(id = "global_discount")
    public WebElement inputDiscountsCheckMark;
    @FindBy(id = "global_discount_percentage")
    public WebElement inputDiscountPercent;
    @FindBy(id = "show-invoices")
    public WebElement inputInvoices;
    @FindBy(id = "issue_invoices")
    public WebElement inputInvoicesCheckMark;
    @FindBy(id = "invoices_message")
    public WebElement inputInvoicesText;
    @FindBy(xpath = "//a[contains(text(),'Coupons')]")
    public WebElement clickCouponsText;
    @FindBy(xpath = "//a[contains(text(),'Add coupon')]")
    public WebElement clickAddCouponBtn;
    @FindBy(xpath = "//input[@name='code']")
    public WebElement inputCode1;
    @FindBy(xpath = "//input[@name='valid_from']")
    public WebElement inputFrom1;
    @FindBy(xpath = "/html[1]/body[1]/div[15]/div[1]/table[1]/tbody[1]/tr[4]/td[1]")
    public WebElement inputFrom20;
    @FindBy(xpath = "//input[@name='valid_to']")
    public WebElement clickToField;
    @FindBy(xpath = "/html[1]/body[1]/div[16]/div[1]/table[1]/tbody[1]/tr[4]/td[6]")
    public WebElement clickCalendarDayTo;
    @FindBy(xpath = "//input[@name='percentage_discount']")
    public WebElement inputPercentageOff;
    @FindBy(xpath = "//span[text()='Switch to fixed amount discount']")
    public WebElement inputSwitchToFixed;
    @FindBy(xpath = "//span[text()='US Dollar']")
    public WebElement inputUsDollar;
    @FindBy(xpath = "//input[@name='max_redemptions']")
    public WebElement inputRedemptions;
    @FindBy(xpath = "(//ul[@class='select2-choices'])[2]")
    public WebElement inputValidForCourses;
    @FindBy(xpath = "(//ul[@class='select2-choices'])[3]")
    public WebElement inputValidForGroups;
    @FindBy(xpath = "(//ul[@class='select2-choices'])[4]")
    public WebElement inputValidForCategories;
    @FindBy(xpath = "//input[@name='submit_coupon']")
    public WebElement clickAddCoupon;
    @FindBy(xpath = "//a[@href='javascript:hideCouponModal()']")
    public WebElement clickCancel;
    @FindBy(id = "show-credits")
    public WebElement clickCredits1;
    @FindBy(id = "tl-ecommerce-credits")
    public WebElement clickActivateCredits;
    @FindBy(xpath = "//span[text()='Add credits']")
    public WebElement clickAddCredits;
    @FindBy(xpath = "//div[text()='Add credits']")
    public WebElement clickAddCredits2;
    @FindBy(xpath = "//div[contains(text(),'Reset credits')]")
    public WebElement clickResetCredits;
    @FindBy(xpath = "(//label[@class='radio inline'])[1]")
    public WebElement clickAllUsers;
    @FindBy(xpath = "(//label[@class='radio inline'])[2]")
    public WebElement clickSpecificUser;
    @FindBy(xpath = "//span[text()='Reset credits']")
    public WebElement clickSpecificUser2;
    @FindBy(id = "s2id_autogen4")
    public WebElement clickTypeUser;
    @FindBy(xpath = "//div[@class='select2-result-label']")
    public WebElement clickTypeUser2;
    @FindBy(xpath = "//input[@name='credits_to_add']")
    public WebElement inputCredits;
    @FindBy(xpath = "//input[@name='submit_ecommerce']")
    public WebElement saveButton;
    @FindBy(xpath = "//a[text()='E-commerce timeline']")
    public WebElement commerceTimelineButton;
    @FindBy(xpath = "//a[text()='cancel']")
    public WebElement cancel2Button;
    @FindBy(xpath = "//div[text()='E-commerce settings updated successfully']")
    public WebElement ecommerceSuccessMessage;

    public EcommercePage clickSelect() {
        webElementHelper.click(inputSelect);
        return this;
    }

    public EcommercePage clickPayPal() {
        webElementHelper.scrollToElement(inputPayPal);
        webElementHelper.click(inputPayPal);
        return this;
    }

    public EcommercePage fillUpPayPalEmailAddress() {
        inputAddressPayPal.sendKeys(faker.internet().emailAddress());
        return this;
    }

    public EcommercePage clickStripe() {
        webElementHelper.scrollToElement(inputStripe);
        webElementHelper.click(inputStripe);
        return this;
    }

    public EcommercePage clickConnectWithStripeButton() {
        webElementHelper.click(connectWithStripeButton);
        return this;
    }

    public EcommercePage clickSelectYour() {
        webElementHelper.scrollToElement(inputSelectYour);
        webElementHelper.click(inputSelectYour);
        return this;

    }

    public EcommercePage clickSubscription() {
        webElementHelper.scrollToElement(inputSubscription);
        webElementHelper.click(inputSubscription);
        return this;
    }

    public EcommercePage clickDiscounts() {
        webElementHelper.scrollToElement(inputDiscounts);
        webElementHelper.click(inputDiscounts);
        return this;
    }

    public EcommercePage clickDiscountsCheckMark() {
        webElementHelper.click(inputDiscountsCheckMark);
        return this;
    }

    public EcommercePage clickDiscountsPercent() {
        webElementHelper.sendKeys(inputDiscountPercent, "30");
        return this;
    }

    public EcommercePage clickInvoices() {
        webElementHelper.click(inputInvoices);
        return this;
    }

    public EcommercePage clickInvoicesCheckMark() {
        webElementHelper.click(inputInvoicesCheckMark);
        return this;
    }

    public EcommercePage invoicesText() {
        webElementHelper.sendKeys(inputInvoicesText, "Add your business info here. This info will be added to end-user invoices.");
        return this;
    }

    public EcommercePage clickCoupons() {
        webElementHelper.scrollToElement(clickCouponsText);
        webElementHelper.click(clickCouponsText);
        return this;
    }

    public EcommercePage clickCouponsAdd() {
        webElementHelper.scrollToElement(clickAddCouponBtn);
        webElementHelper.click(clickAddCouponBtn);
        return this;
    }

    public EcommercePage inputCode() {
        webElementHelper.sendKeys(inputCode1, "234567789977");
        return this;
    }

    public EcommercePage inputFrom() {
        webElementHelper.click(inputFrom1);
        return this;
    }

    public EcommercePage inputFrom20() {
        webElementHelper.scrollToElement(inputFrom20);
        webElementHelper.click(inputFrom20);
        return this;
    }

    public EcommercePage clickTo() {
        webElementHelper.click(clickToField);
        return this;
    }

    public EcommercePage clickToCalendar() {
        webElementHelper.scrollToElement(clickCalendarDayTo);
        webElementHelper.click(clickCalendarDayTo);
        return this;
    }

    public EcommercePage inputPercentage() {
        webElementHelper.sendKeys(inputPercentageOff, "30");
        return this;
    }

    public EcommercePage inputAdd() {
        webElementHelper.click(clickAddCoupon);
        return this;

    }

    public EcommercePage clickCredits1(){
        webElementHelper.click(clickCredits1);
        return this;
    }

    public EcommercePage clickActivateCredits(){
        webElementHelper.click(clickActivateCredits);
        return this;
    }

    public EcommercePage clickAddCredit(){
        webElementHelper.scrollToElement(clickAddCredits);
        webElementHelper.click(clickAddCredits);
        return this;
    }

    public EcommercePage clickResetCredit1(){
        webElementHelper.click(clickResetCredits);
        return this;
    }

    public EcommercePage clickAllUser1(){
        webElementHelper.click(clickAllUsers);
        return this;
    }

    public EcommercePage clickSpecificUser1(){
        webElementHelper.click(clickSpecificUser);
        return this;
    }

    public EcommercePage clickTypeUser1(){
        webElementHelper.sendKeys(clickTypeUser, "Gul");
        return this;
    }

    public EcommercePage clickTypeUser2(){
        webElementHelper.scrollToElement(clickTypeUser2);
        webElementHelper.click(clickTypeUser2);
        return this;
    }

    public EcommercePage clickSpecificUser2(){
        webElementHelper.click(clickSpecificUser2);
        return this;
    }

    public EcommercePage clickAddCredits2(){
        webElementHelper.click(clickAddCredits2);
        return this;
    }

    public EcommercePage clickCredits(){
        webElementHelper.sendKeys(inputCredits, "10000");
        return this;
    }

    public EcommercePage clickSave(){
        webElementHelper.click(saveButton);
        return this;
    }

    public EcommercePage clickCancel(){
        webElementHelper.click(cancel2Button);
        return this;
    }

    public EcommercePage clickE_commerceTimeline(){
        webElementHelper.click(commerceTimelineButton);
        return this;
    }
}
