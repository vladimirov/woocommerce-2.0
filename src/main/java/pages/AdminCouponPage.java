package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;

public class AdminCouponPage extends HelperBase {

    public AdminCouponPage(WebDriver driver) {
        super(driver);
    }

    private By wooCommerceMenuLocator = By.xpath(".//*[@id='toplevel_page_woocommerce']/a/div[3]");
    private By couponsMenuLocator = By.xpath(".//*[@id='toplevel_page_woocommerce']/ul/li[3]/a");
    private By addCouponButtonLocator = By.xpath("//*[@id='wpbody-content']/div[3]/a");
    private By couponCodeTextFieldLocator = By.id("title");
    private By descriptionTextFieldLocator = By.id("woocommerce-coupon-description");
    private By discountTypeDropdownLocator = By.id("discount_type");
    private By fixedCartOptionLocator = By.xpath("//*[@id='discount_type']/option[2]");
    private By generalTabLocator = By.xpath("//*[@id='coupon_options']/ul/li[1]/a/span");
    private By couponAmountLocator = By.id("coupon_amount");
    private By expireDateFieldLocator = By.id("expiry_date");
    private By expireDateLocator = By.xpath("//div[@id='ui-datepicker-div']/table/tbody/tr[5]/td[4]/a");
    private By publishButtonLocator = By.id("publish");
    private By couponUpdatedMessageLocator = By.xpath("//div[@id='message']/p");
    private By moveToTrashButtonLocator = By.id("delete-action");


    public AdminCouponPage clickOnWooCommerceMenu() {
        click(wooCommerceMenuLocator);
        return this;
    }

    public AdminCouponPage clickOnCouponsMenu() {
        click(couponsMenuLocator);
        return this;
    }

    public AdminCouponPage clickOnAddCouponButton() {
        click(addCouponButtonLocator);
        return this;
    }

    public AdminCouponPage clickOnGeneralTab() {
        click(generalTabLocator);
        return this;
    }

    public AdminCouponPage clickOnExpireDateField() {
        click(expireDateFieldLocator);
        return this;
    }

    public AdminCouponPage insertExpireDate() {
        click(expireDateLocator);
        return this;
    }

    public AdminCouponPage insertCouponAmount() {
        type(couponAmountLocator, "100");
        return this;
    }

    public AdminCouponPage clickOnDiscountTypeDropdownLocator() {
        click(discountTypeDropdownLocator);
        return this;
    }

    public AdminCouponPage chooseFixedCartOption() {
        click(fixedCartOptionLocator);
        return this;
    }

    public AdminCouponPage insertCouponCode() {
        type(couponCodeTextFieldLocator, "code-" + new Date().getTime());
        return this;
    }

    public AdminCouponPage insertDescription() {
        type(descriptionTextFieldLocator, "Test coupon");
        return this;
    }

    public AdminCouponPage clickOnPublishButton() {
        click(publishButtonLocator);
        return this;
    }

    public boolean successMessageIsDisplayed() {
        return textIsDisplayed(couponUpdatedMessageLocator, "Coupon updated.");
    }

    public AdminCouponPage moveToTrashTestCoupon() {
        click(moveToTrashButtonLocator);
        return this;
    }

    public boolean successDeletionMessageIsDisplayed() {
        return textIsDisplayed(couponUpdatedMessageLocator, "1 coupon moved to the Trash. Undo");
    }

}