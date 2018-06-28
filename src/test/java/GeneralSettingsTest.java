import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GeneralSettingsTest extends TestBase {

//    @Test(groups = {"admin"}, priority = 1)
//    public void updateGeneralSettings() {
//        app.loginToAdmin();
//        app.adminSettingsGeneralPage().clickOnWooCommerceMenu();
//        app.adminSettingsGeneralPage().clickOnSettingsMenu();
//
//        Assert.assertTrue(app.adminSettingsGeneralPage().generalTabIsActive());
//    }

    @Test(groups = {"admin"}, priority = 2)
    public void selectSellingLocation() {
        app.loginToAdmin();
        app.adminSettingsGeneralPage().clickOnWooCommerceMenu();
        app.adminSettingsGeneralPage().clickOnSettingsMenu();
        app.adminSettingsGeneralPage().clickOnSellingLocationDropdown();
        app.adminSettingsGeneralPage().clickOnSetToAllCountriesItem();
        app.adminSettingsGeneralPage().saveChanges();

        Assert.assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
    }
//
//    //    @Test (priority = 3, groups = {"admin"})
//    public void setBaseLocation() {
//        app.adminSettingsGeneralPage().clickOnBaseLocationDropdown();
//        app.adminSettingsGeneralPage().setBaseLocation();
//        app.adminSettingsGeneralPage().saveChanges();
//
//        Assert.assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
//    }
//
//    //    @Test (priority = 4, groups = {"admin"})
//    public void setSellToSpecificCountries() {
//        app.adminSettingsGeneralPage().clickOnSellingLocationDropdown();
//        app.adminSettingsGeneralPage().chooseSellToSpecificCountriesItem();
//        app.adminSettingsGeneralPage().clickOnChooseCountriesInputField();
//        app.adminSettingsGeneralPage().chooseFromSpecificCountriesSuggestions();
//        app.adminSettingsGeneralPage().saveChanges();
//
//        Assert.assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
//    }
//
//    @Test(priority = 5, groups = {"admin"})
//    public void setCurrencyOptions() {
//        app.adminSettingsGeneralPage().setThousandSeparator();
//        app.adminSettingsGeneralPage().setDecimalSeparator();
//        app.adminSettingsGeneralPage().setNumberOfDecimals();
//        app.adminSettingsGeneralPage().saveChanges();
//
//        Assert.assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
//    }
//
//    @Test(priority = 6, groups = {"admin"})
//    public void downloadableProducts() {
//        app.adminSettingsGeneralPage().clickOnProductsTab();
//        app.adminSettingsGeneralPage().clickOnDownloadableProducts();
//        app.adminSettingsGeneralPage().clickOnFileDownloadableMethodDropdown();
//        app.adminSettingsGeneralPage().chooseRedirectOnlyItem();
//        app.adminSettingsGeneralPage().clickOnDownloadsRequireLoginCheckbox();
//        app.adminSettingsGeneralPage().clickOnGrantAccessCheckbox();
//        app.adminSettingsGeneralPage().clickOnSaveChangesInProducts();
//        Assert.assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
//        //Uncheck all items
//        app.adminSettingsGeneralPage().clickOnFileDownloadableMethodDropdown();
//        app.adminSettingsGeneralPage().chooseForceDownloadsItem();
//        app.adminSettingsGeneralPage().clickOnDownloadsRequireLoginCheckbox();
//        app.adminSettingsGeneralPage().clickOnGrantAccessCheckbox();
//        app.adminSettingsGeneralPage().clickOnSaveChangesInProducts();
//
//        Assert.assertTrue(app.adminSettingsGeneralPage().successMessageIsDisplayed());
//
//    }

}