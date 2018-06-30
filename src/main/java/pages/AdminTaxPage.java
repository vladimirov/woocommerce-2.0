package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminTaxPage extends HelperBase {

    public AdminTaxPage(WebDriver driver) {
        super(driver);
    }

    String successMessage = "Your settings have been saved.";
    String additionalTax = "Fancy";

    private By wooCommerceMenuLocator = By.id("toplevel_page_woocommerce");
    private By settingsMenuLocator = By.xpath("//*[@id='toplevel_page_woocommerce']/ul/li[5]/a");
    private By taxTabLocator = By.xpath("//*[@id='mainform']/nav/a[3]");
    private By pricesEnteredWithNoTaxLocator = By.xpath(".//*[@id='mainform']/table/tbody/tr[1]/td/fieldset/ul/li[2]/label/input");
    private By calculateTaxBasedOnLocator = By.xpath(".//*[@id='select2-woocommerce_tax_based_on-container']");
    private By customerShippingAddressItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[1]");
    private By shippingTaxClassLocator = By.xpath(".//*[@id='select2-woocommerce_shipping_tax_class-container']");
    private By standardItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[2]");
    private By roundingCheckboxLocator = By.id("woocommerce_tax_round_at_subtotal");
    private By displayPricesInShopLocator = By.id("select2-woocommerce_tax_display_shop-container");
    private By excludingTaxItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[2]");
    private By displayPricesDuringCartLocator = By.id("select2-woocommerce_tax_display_cart-container");
    private By includingTaxItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[1]");
    private By displayTaxTotalsLocator = By.id("select2-woocommerce_tax_total_display-container");
    private By singleTotalItemLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[1]");
    private By saveChangesButtonLocator = By.name("save");
    private By settingsSavedMessageLocator = By.xpath("//div[@id='message']/p");
    private By additionalTaxClassesLocator = By.id("woocommerce_tax_classes");
    private By newAdditionalTaxClassLocator = By.xpath("//a[contains(text(),'Fancy')]");


    public AdminTaxPage clickOnWooCommerceMenu() {
        click(wooCommerceMenuLocator);
        return this;
    }

    public AdminTaxPage clickOnSettingsMenu() {
        click(settingsMenuLocator);
        return this;
    }

    public AdminTaxPage clickOnTaxTab() {
        click(taxTabLocator);
        return this;
    }

    public AdminTaxPage selectNoInPricesEnteredWithTax() {
        click(pricesEnteredWithNoTaxLocator);
        return this;
    }

    public AdminTaxPage selectCalculateTaxBasedOn() {
        click(calculateTaxBasedOnLocator);
        click(customerShippingAddressItemLocator);
        return this;
    }


    public AdminTaxPage selectShippingTaxClass() {
        click(shippingTaxClassLocator);
        click(standardItemLocator);
        return this;
    }

    public AdminTaxPage uncheckRounding() {
        waitToBePresent(roundingCheckboxLocator);
        if (driver.findElement(roundingCheckboxLocator).isSelected()) {
            click(roundingCheckboxLocator);
        }
        return this;
    }

    public AdminTaxPage selectDisplayPricesInTheShop() {
        click(displayPricesInShopLocator);
        click(excludingTaxItemLocator);
        return this;
    }

    public AdminTaxPage selectDisplayPricesDuringCartAndCheckout() {
        click(displayPricesDuringCartLocator);
        click(includingTaxItemLocator);
        return this;
    }

    public AdminTaxPage selectDisplayTaxTotals() {
        click(displayTaxTotalsLocator);
        click(singleTotalItemLocator);
        return this;
    }

    public AdminTaxPage saveChanges() {
        scrollDownToFooter();
        click(saveChangesButtonLocator);
        return this;
    }

    public boolean successMessageIsDisplayed() {
        return textIsDisplayed(settingsSavedMessageLocator, successMessage);
    }

    public AdminTaxPage removeAdditionalTaxClasses() {
        clear(additionalTaxClassesLocator);
        return this;
    }

   public AdminTaxPage addNewAdditionalTaxClass() {
        type(additionalTaxClassesLocator, additionalTax);
        return this;
    }

    public boolean newAdditionalTaxClassIsDisplayed() {
        return isElementOnPage(newAdditionalTaxClassLocator);
    }

}