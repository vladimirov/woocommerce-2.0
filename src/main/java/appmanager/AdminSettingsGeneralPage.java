package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AdminSettingsGeneralPage extends HelperBase {

    public AdminSettingsGeneralPage(WebDriver driver) {
        super(driver);
    }

    String active = "active";
    String successMessage = "Your settings have been saved.";
    String baseLocation = "United States (US)";
    String sellingLocation = "United States (US) test";

    private By wooCommerceMenuLocator = By.id("toplevel_page_woocommerce");//AdminOrdersPage
    private By settingsMenuLocator = By.xpath("//*[@id='toplevel_page_woocommerce']/ul/li[5]/a");
    private By generalTabLocator = By.xpath("//*[@id='mainform']/nav/a[1]");
    private By sellingLocationLocator = By.id("select2-woocommerce_allowed_countries-container");
    private By setToAllCountriesLocator = By.xpath("//ul[@id='select2-woocommerce_allowed_countries-results']/li[1]");
    private By saveChangesButtonLocator = By.name("save");
    private By settingsSavedMessageLocator = By.xpath("//div[@id='message']/p");
    private By locationDropdownLocator = By.cssSelector("span.selection");
    private By locationInputLocator = By.xpath("//span[@class='select2-search select2-search--dropdown']/input");
    private By searchResultLocator = By.cssSelector("li.select2-results__option.select2-results__option--highlighted");
    private By sellToSpecificCountriesItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[3]");

//    private By chooseCountriesLocator = By.cssSelector("#mainform > table:nth-child(9) > tbody > tr:nth-child(3) > td > span > span.selection > span > ul > li > input");
    private By chooseCountriesInputLocator = By.cssSelector("input.select2-search__field");
    private By chooseCountriesULLocator = By.cssSelector("ul.select2-selection__rendered");
    private By chooseCountriesSpanLocator = By.cssSelector("span.select2.select2-container.select2-container--default.select2-container--below");
    private By chooseCountriesLocator = By.xpath("//td[@class='forminp']/select[1]/option[1]");

    private By allCountriesLocator = By.cssSelector("a.select_all button");


    private By specificSellingLocationItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[1]");
    private By thousandSeparatorLocator = By.id("woocommerce_price_thousand_sep");
    private By decimalSeparatorLocator = By.id("woocommerce_price_decimal_sep");
    private By numberOfDecimalsLocator = By.id("woocommerce_price_num_decimals");
    private By productsTabLocator = By.xpath("//*[@id='mainform']/nav/a[2]");
    private By downloadableProductsLocator = By.xpath("//*[@id='mainform']/ul/li[4]/a");
    private By fileDownloadMethodLocator = By.id("select2-woocommerce_file_download_method-container");
    private By redirectOnlyItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[3]");
    private By downloadsRequireLoginLocator = By.id("woocommerce_downloads_require_login");
    private By grantAccessLocator = By.id("woocommerce_downloads_grant_access_after_payment");
    private By saveChangesInProductsLocator = By.name("save");
    private By forceDownloadsItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[1]");


    public AdminSettingsGeneralPage clickOnWooCommerceMenu() {
        click(wooCommerceMenuLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnSettingsMenu() {
        click(settingsMenuLocator);
        return this;
    }

    public boolean generalTabIsActive() {
        return elementHasClass(active, generalTabLocator);
    }

    public AdminSettingsGeneralPage clickOnSellingLocationDropdown() {
        click(sellingLocationLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnSetToAllCountriesItem() {
        click(setToAllCountriesLocator);
        return this;
    }

    public AdminSettingsGeneralPage saveChanges() {
        scrollDownToFooter();
        click(saveChangesButtonLocator);
        return this;
    }

    public boolean successMessageIsDisplayed() {
        return textIsDisplayed(successMessage, settingsSavedMessageLocator);
    }


    public AdminSettingsGeneralPage clickOnBaseLocationDropdown() {
        click(locationDropdownLocator);
        return this;
    }

    public AdminSettingsGeneralPage setBaseLocation() {
        click(locationInputLocator);
        type(locationInputLocator, baseLocation);
        click(searchResultLocator);
        return this;
    }

    public AdminSettingsGeneralPage chooseSellToSpecificCountriesItem() {
        click(sellToSpecificCountriesItemLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnChooseCountriesInputField() {
//        click(chooseCountriesLocator);
        click(allCountriesLocator);
//        type(chooseCountriesLocator, sellingLocation);
        return this;
    }

    public AdminSettingsGeneralPage chooseFromSpecificCountriesSuggestions() {
        click(specificSellingLocationItemLocator);
        return this;
    }

    public AdminSettingsGeneralPage setThousandSeparator() {
        clear(thousandSeparatorLocator);
        type(thousandSeparatorLocator, ",");
        return this;
    }

    public AdminSettingsGeneralPage setDecimalSeparator() {
        clear(decimalSeparatorLocator);
        type(decimalSeparatorLocator, ".");
        return this;
    }

    public AdminSettingsGeneralPage setNumberOfDecimals() {
        clear(numberOfDecimalsLocator);
        type(numberOfDecimalsLocator, "2");
        return this;
    }

    //downloadableProducts
    public AdminSettingsGeneralPage clickOnProductsTab() {
        click(productsTabLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnDownloadableProducts() {
        click(downloadableProductsLocator);
        return this;
    }


    public AdminSettingsGeneralPage clickOnFileDownloadableMethodDropdown() {
        click(fileDownloadMethodLocator);
        return this;
    }

    public AdminSettingsGeneralPage chooseRedirectOnlyItem() {
        click(redirectOnlyItemLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnDownloadsRequireLoginCheckbox() {
        click(downloadsRequireLoginLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnGrantAccessCheckbox() {
        click(grantAccessLocator);
        return this;
    }

    public AdminSettingsGeneralPage clickOnSaveChangesInProducts() {
        click(saveChangesInProductsLocator);
        return this;
    }

    public AdminSettingsGeneralPage chooseForceDownloadsItem() {
        click(forceDownloadsItemLocator);
        return this;
    }

}