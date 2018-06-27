import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AdminCouponNew extends TestBase {

    @Test
    public void addNewCoupon() {
        app.loginToAdmin();
        app.adminCouponPage().clickOnWooCommerceMenu();
        app.adminCouponPage().clickOnWooCommerceMenu();
        app.adminCouponPage().clickOnCouponsMenu();
        app.adminCouponPage().clickOnAddCouponButton();
        app.adminCouponPage().clickOnGeneralTab();
        app.adminCouponPage().clickOnExpireDateField().insertExpireDate();
        app.adminCouponPage().insertCouponAmount();
        app.adminCouponPage().clickOnDiscountTypeDropdownLocator();
        app.adminCouponPage().chooseFixedCartOption();
        app.adminCouponPage().insertCouponCode();
        app.adminCouponPage().insertDescription();
        app.adminCouponPage().clickOnPublishButton();

        assertTrue(app.adminCouponPage().successMessageIsDisplayed());
    }

}