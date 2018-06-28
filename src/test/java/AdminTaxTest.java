import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class AdminTaxTest extends TestBase {

    @BeforeMethod
    public void gotoWoocommerceSettings() {
        app.loginToAdmin();
        app.adminSettingsGeneralPage().clickOnWooCommerceMenu();
        app.adminSettingsGeneralPage().clickOnSettingsMenu();
    }

    @Test(groups = {"admin"}, priority = 1)
    public void openTaxOptions() {
        app.adminTaxPage().clickOnTaxTab();

        assertTrue(app.adminTaxPage().checkTaxPageUrl());
    }

//    @Test(priority = 2, groups = {"admin"})
//    public void setTaxOptions() {
//        app.adminTaxPage().clickOnTaxTab();
//        app.adminTaxPage().selectNoInPricesEnteredWithTax();
//        app.adminTaxPage().selectCalculateTaxBasedOn();
//        app.adminTaxPage().selectShippingTaxClass();
//        app.adminTaxPage().uncheckRounding();
//        app.adminTaxPage().selectDisplayPricesInTheShop();
//        app.adminTaxPage().selectDisplayPricesDuringCartAndCheckout();
//        app.adminTaxPage().selectDisplayTaxTotals();
//        app.adminTaxPage().saveChanges();
//
//        assertTrue(app.adminTaxPage().successMessageIsDisplayed());
//    }
//
//    @Test(priority = 3, groups = {"admin"})
//    public void addTaxClasses() {
//        app.adminTaxPage().clickOnTaxTab();
//        app.adminTaxPage().removeAdditionalTaxClasses();
//        app.adminTaxPage().addNewAdditionalTaxClass();
//        app.adminTaxPage().saveChanges();
//        assertTrue(app.adminTaxPage().newAdditionalTaxClassIsDisplayed());
//    }


}