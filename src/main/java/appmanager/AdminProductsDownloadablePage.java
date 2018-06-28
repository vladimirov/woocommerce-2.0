package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminProductsDownloadablePage extends HelperBase {

    public AdminProductsDownloadablePage(WebDriver driver) {
        super(driver);
    }

    private String successMessage = "Your settings have been saved.";

    private By wooCommerceMenuLocator = By.id("toplevel_page_woocommerce");
    private By settingsMenuLocator = By.xpath("//*[@id='toplevel_page_woocommerce']/ul/li[5]/a");
    private By productsTabLocator = By.xpath("//*[@id='mainform']/nav/a[2]");
    private By downloadableProductsLocator = By.linkText("Downloadable products");
    private By fileDownloadMethodLocator = By.id("select2-woocommerce_file_download_method-container");
    private By redirectOnlyItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[3]");
    private By forceDownloadsItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[1]");
    private By downloadsRequireLoginLocator = By.id("woocommerce_downloads_require_login");
    private By grantAccessAfterPaymentLocator = By.id("woocommerce_downloads_grant_access_after_payment");
    private By saveChangesButtonLocator = By.name("save");
    private By settingsSavedMessageLocator = By.xpath("//div[@id='message']/p");


    public AdminProductsDownloadablePage clickOnWooCommerceMenu() {
        click(wooCommerceMenuLocator);
        return this;
    }

    public AdminProductsDownloadablePage clickOnSettingsMenu() {
        click(settingsMenuLocator);
        return this;
    }

    public AdminProductsDownloadablePage clickOnProductsTab() {
        click(productsTabLocator);
        return this;
    }

    public AdminProductsDownloadablePage clickOnDownloadableProductsTab() {
        click(downloadableProductsLocator);
        return this;
    }

    public AdminProductsDownloadablePage selectFileDownloadMethod() {
        click(fileDownloadMethodLocator);
        click(redirectOnlyItemLocator);
        return this;
    }

    public AdminProductsDownloadablePage selectFileDownloadMethodBack() {
        click(fileDownloadMethodLocator);
        click(forceDownloadsItemLocator);
        return this;
    }

    public AdminProductsDownloadablePage checkDownloadsRequireLogin() {
        click(downloadsRequireLoginLocator);
        return this;
    }

    public AdminProductsDownloadablePage checkGrantAccessAfterPayment() {
        click(grantAccessAfterPaymentLocator);
        return this;
    }

    public AdminProductsDownloadablePage saveChanges() {
        click(saveChangesButtonLocator);
        return this;
    }

    public boolean successMessageIsDisplayed() {
        return textIsDisplayed(successMessage, settingsSavedMessageLocator);
    }

}