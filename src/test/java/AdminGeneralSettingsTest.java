import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AdminGeneralSettingsTest extends TestBase {

    //TODO Extract in one class
    @BeforeMethod
    public void gotoWoocommerceSettings() {
        app.loginToAdmin();
        app.adminSettingsGeneralPage().clickOnWooCommerceMenu();
        app.adminSettingsGeneralPage().clickOnSettingsMenu();
    }

    @Test(groups = {"admin"}, priority = 1)
    public void updateGeneralSettings() {
        assertTrue(app.adminSettingsGeneralPage().generalTabIsActive());
    }

    @Test(groups = {"admin"}, priority = 2)
    public void selectSellingLocation() {
        app.adminSettingsGeneralPage().clickOnSellingLocationDropdown();
        app.adminSettingsGeneralPage().clickOnSetToAllCountriesItem();
        app.adminSettingsGeneralPage().saveChanges();

        assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
    }

    @Test(groups = {"admin"}, priority = 3)
    public void setBaseLocation() {
        app.adminSettingsGeneralPage().clickOnBaseLocationDropdown();
        app.adminSettingsGeneralPage().setBaseLocation();
        app.adminSettingsGeneralPage().saveChanges();

        assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
    }

    //TODO
    @Test(groups = {"admin"}, priority = 4, enabled = false)
    public void setSellToSpecificCountries() {
        app.adminSettingsGeneralPage().clickOnSellingLocationDropdown();
        app.adminSettingsGeneralPage().chooseSellToSpecificCountriesItem();
        app.adminSettingsGeneralPage().clickOnChooseCountriesInputField();
        app.adminSettingsGeneralPage().chooseFromSpecificCountriesSuggestions();
        app.adminSettingsGeneralPage().saveChanges();

        assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
    }

    @Test(groups = {"admin"}, priority = 5)
    public void setCurrencyOptions() {
        app.adminSettingsGeneralPage().setThousandSeparator();
        app.adminSettingsGeneralPage().setDecimalSeparator();
        app.adminSettingsGeneralPage().setNumberOfDecimals();
        app.adminSettingsGeneralPage().saveChanges();

        assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
    }

    @Test(groups = {"admin"}, priority = 6)
    public void downloadableProducts() {
        app.adminSettingsGeneralPage().clickOnProductsTab();
        app.adminSettingsGeneralPage().clickOnDownloadableProducts();
        app.adminSettingsGeneralPage().clickOnFileDownloadableMethodDropdown();
        app.adminSettingsGeneralPage().chooseRedirectOnlyItem();
        app.adminSettingsGeneralPage().clickOnDownloadsRequireLoginCheckbox();
        app.adminSettingsGeneralPage().clickOnGrantAccessCheckbox();
        app.adminSettingsGeneralPage().clickOnSaveChangesInProducts();
        assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
        //Uncheck all items
        app.adminSettingsGeneralPage().clickOnFileDownloadableMethodDropdown();
        app.adminSettingsGeneralPage().chooseForceDownloadsItem();
        app.adminSettingsGeneralPage().clickOnDownloadsRequireLoginCheckbox();
        app.adminSettingsGeneralPage().clickOnGrantAccessCheckbox();
        app.adminSettingsGeneralPage().clickOnSaveChangesInProducts();

        assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());

    }

}