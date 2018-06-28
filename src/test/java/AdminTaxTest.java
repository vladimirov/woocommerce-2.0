import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class AdminTaxTest extends TestBase {

    //TODO Extract in one class
    @BeforeMethod
    public void gotoWoocommerceSettings() {
        app.openAdminUrl();
        app.adminSettingsGeneralPage().clickOnWooCommerceMenu();
        app.adminSettingsGeneralPage().clickOnSettingsMenu();
    }

    @Test(groups = {"admin"}, priority = 1)
    public void setTaxOptions() {
        app.adminTaxPage().clickOnTaxTab();
        app.adminTaxPage().selectNoInPricesEnteredWithTax();
        app.adminTaxPage().selectCalculateTaxBasedOn();
        app.adminTaxPage().selectShippingTaxClass();
        app.adminTaxPage().uncheckRounding();
        app.adminTaxPage().selectDisplayPricesInTheShop();
        app.adminTaxPage().selectDisplayPricesDuringCartAndCheckout();
        app.adminTaxPage().selectDisplayTaxTotals();
        app.adminTaxPage().saveChanges();

        assertTrue(app.adminTaxPage().successMessageIsDisplayed());
    }

    @Test(groups = {"admin"}, priority = 2)
    public void addTaxClasses() {
        app.adminTaxPage().clickOnTaxTab();
        app.adminTaxPage().removeAdditionalTaxClasses();
        app.adminTaxPage().addNewAdditionalTaxClass();
        app.adminTaxPage().saveChanges();

        assertTrue(app.adminTaxPage().newAdditionalTaxClassIsDisplayed());
    }

}