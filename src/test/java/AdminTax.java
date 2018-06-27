import org.testng.Assert;
import org.testng.annotations.Test;


public class AdminTax extends TestBase {

    @Test(priority = 1, groups = {"admin"})
    public void openTaxOptions() {
        app.loginToAdmin();
        app.adminTaxPage().clickOnTaxTab();

        Assert.assertTrue(app.adminTaxPage().checkTaxPageUrl());
    }

    @Test(priority = 2, groups = {"admin"})
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

        Assert.assertTrue(app.adminTaxPage().successMessageIsDisplayed());
    }

    @Test(priority = 3, groups = {"admin"})
    public void addTaxClasses() {
        app.adminTaxPage().clickOnTaxTab();
        app.adminTaxPage().removeAdditionalTaxClasses();
        app.adminTaxPage().addNewAdditionalTaxClass();
        app.adminTaxPage().saveChanges();
        Assert.assertTrue(app.adminTaxPage().newAdditionalTaxClassIsDisplayed());
    }


}