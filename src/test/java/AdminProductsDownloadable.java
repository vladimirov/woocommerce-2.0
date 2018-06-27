import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AdminProductsDownloadable extends TestBase {

    @Test(groups = {"admin"})
    public void canUpdateSettings() {
        app.loginToAdmin();

        app.adminProductsDownloadablePage().clickOnProductsTab();
        app.adminProductsDownloadablePage().clickOnDownloadableProductsTab();

//        assertTrue(app.adminProductsDownloadablePage().checkDownloadableProductsUrl());

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