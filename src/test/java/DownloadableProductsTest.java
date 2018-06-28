import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class DownloadableProductsTest extends TestBase {

    @Test(groups = {"admin"})
    public void canUpdateSettings() {
        app.loginToAdmin();
        app.adminProductsDownloadablePage().clickOnWooCommerceMenu();
        app.adminProductsDownloadablePage().clickOnSettingsMenu();
        app.adminProductsDownloadablePage().clickOnProductsTab();
        app.adminProductsDownloadablePage().clickOnDownloadableProductsTab();
        app.adminProductsDownloadablePage().selectFileDownloadMethod();
        app.adminProductsDownloadablePage().checkDownloadsRequireLogin();
        app.adminProductsDownloadablePage().checkGrantAccessAfterPayment();
        app.adminProductsDownloadablePage().saveChanges();

        assertTrue(app.adminProductsDownloadablePage().successMessageIsDisplayed());

        app.adminProductsDownloadablePage().selectFileDownloadMethodBack();
        app.adminProductsDownloadablePage().checkDownloadsRequireLogin();
        app.adminProductsDownloadablePage().checkGrantAccessAfterPayment();
        app.adminProductsDownloadablePage().saveChanges();

        assertTrue(app.adminProductsDownloadablePage().successMessageIsDisplayed());
    }
}