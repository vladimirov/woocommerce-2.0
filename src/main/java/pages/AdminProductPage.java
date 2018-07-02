package pages;

import appmanager.HelperBase;
import com.google.common.base.Function;
import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.DataConverter;

import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;


public class AdminProductPage extends HelperBase {

    public AdminProductPage(WebDriver driver) {
        super(driver);
    }

    ProductData newProduct = ProductData.generate();

    public String name = newProduct.getName();
    public float price = newProduct.getPrice();
    public String description = newProduct.getDescription();

    private String attributeName = "Size";
    private String firstTestAttribute = "M";
    private String secondTestAttribute = "L";

    private By productsMenuLocator = By.id("menu-posts-product");
    private By allProductsDropdownLocator = By.xpath("//li[@id='menu-posts-product']/ul/li[2]");

    private By productSearchInAdminLocator = By.id("post-search-input");
    private By productSearchInAdminButtonLocator = By.id("search-submit");
    private By attributesMenuLocator = By.xpath("//a[@href='edit.php?post_type=product&page=product_attributes']");
    private By addAttributeButtonLocator = By.name("add_new_attribute");
    private By testAttributeLocator = By.xpath("//a[contains(text(),'Size')]");
    private By testAttributeNameLocator = By.id("tag-name");
    private By addNewSizeButtonLocator = By.cssSelector("input#submit");
    private By firstTestAttributeLocator = By.xpath("//a[contains(text(),'M')]");
    private By secondTestAttributeLocator = By.xpath("//a[contains(text(),'L')]");
    private By addNewProductButtonLocator = By.xpath("//div[@class='wrap']/a[1]");
    private By productNameLocator = By.xpath(".//*[@id='title']");
    private By productDescriptionLocator = By.id("tinymce");
    private By samplePermalinkLocator = By.id("sample-permalink");
    private By regularPriceLocator = By.id("_regular_price");
    private By inventoryProductDataLocator = By.xpath("//a[@href='#inventory_product_data']");
    private By productShortDescriptionLocator = By.id("tinymce");
    private By publishButtonLocator = By.id("publish");
    private By searchProductsInputLocator = By.id("woocommerce-product-search-field-0");
    private By postSearchInputLocator = By.id("post-search-input");
    private By searchProductsButtonLocator = By.id("search-submit");
    private By productNameInAdminLocator = By.className("row-title");
    private By trashButtonLocator = By.xpath("//span[@class='trash']");
    private By productDeletedMessageLocator = By.id("message");
    private By productNameInCartLocator = By.xpath("//*[@class='product-name']/a");
    private By noProductsFoundMessageLocator = By.cssSelector("td.colspanchange");
    //Variable product
    private By productTypeLocator = By.id("product-type");
    private By variableProductLocator = By.xpath("//select[@id='product-type']/optgroup/option[4]");
    private By attributesTabLocator = By.cssSelector("li.attribute_options.attribute_tab");
    private By addCustomAttributeButtonLocator = By.cssSelector("button.button.add_attribute");
    private By usedForVariationsCheckboxLocator = By.xpath("//input[@name='attribute_variation[0]']");
    private By variationsTabLocator = By.xpath("//a[@href='#variable_product_options']");
    private By saveAttributesButtonLocator = By.cssSelector("button.button.save_attributes.button-primary");
    private By attributeNameInputLocator = By.cssSelector("input.attribute_name");
    private By attributeValuesInputLocator = By.name("attribute_values[0]");
    private By goButtonLocator = By.cssSelector("a.button bulk_edit do_variation_action");
    private By goButtonAddVariationLocator = By.cssSelector("a.button bulk_edit do_variation_action");

    //Variable product - create test attributes
    public AdminProductPage chooseProductType() {
        click(productTypeLocator);
        click(variableProductLocator);
        return this;
    }

    public AdminProductPage setAttributes() {
        click(attributesTabLocator);
        click(addCustomAttributeButtonLocator);
        type(attributeNameInputLocator, attributeName);
        type(attributeValuesInputLocator, firstTestAttribute + "|" + secondTestAttribute);
        click(variationsTabLocator);
        click(attributesTabLocator);
        click(usedForVariationsCheckboxLocator);
        click(saveAttributesButtonLocator);
        return this;
    }

    public AdminProductPage setVariations() {
//        waitToBePresentAndClick(By.xpath("//a[@href='#general_product_data']"));
//        waitToBePresentAndClick(By.id("new-tag-product_tag"));
//        waitToBeStale(variationsTabLocator);
        // Waiting 30 seconds for an element to be present on the page, checking
        // for its presence once every 5 seconds.

        Wait wait = new FluentWait(driver)
                .withTimeout(5, SECONDS)
                .pollingEvery(3, SECONDS)
                .ignoring(TimeoutException.class);

        wait.until((Function) variableProductLocator);

        click(variationsTabLocator);
        click(goButtonLocator);
        click(goButtonAddVariationLocator);
        return this;
    }


    public AdminProductPage clickOnProductsMenu() {
        click(productsMenuLocator);
        return this;
    }

    public AdminProductPage clickOnAllProductsDropdown() {
        click(allProductsDropdownLocator);
        return this;
    }

    public AdminProductPage clickOnAddNewProductButton() {
        click(addNewProductButtonLocator);
        return this;
    }

    public AdminProductPage insertProductName() {
        type(productNameLocator, name);
        return this;
    }

    public AdminProductPage insertProductDescription() {
        driver.switchTo().frame("content_ifr");
        type(productDescriptionLocator, description);
        driver.switchTo().defaultContent();
        return this;
    }

    public AdminProductPage waitToBePresentSamplePermalink() {
        waitToBePresent(samplePermalinkLocator);
        return this;
    }

    public AdminProductPage insertRegularPrice() {
        type(regularPriceLocator, DataConverter.convertPriceValue(price));
        return this;
    }

    public AdminProductPage clickOnInventoryTab() {
        click(inventoryProductDataLocator);
        return this;
    }

    public AdminProductPage insertProductShortDescription() {
        driver.switchTo().frame("excerpt_ifr");
        type(productShortDescriptionLocator, description);
        driver.switchTo().defaultContent();
        return this;
    }

    public AdminProductPage clickOnPublishButton() {
        scrollTillElementIsVisible(productNameLocator);
        click(publishButtonLocator);
        return this;
    }

    public AdminProductPage findNewProductInAdmin() {
        type(productSearchInAdminLocator, name);
        submit(productSearchInAdminButtonLocator);
        return this;
    }

    public String actualProductNameInAdmin() {
        return driver.findElement(productNameInAdminLocator).getText();
    }

    public AdminProductPage findNewProductOnSite() {
        type(searchProductsInputLocator, name);
        submit(searchProductsInputLocator);
        return this;
    }

    public AdminProductPage moveToTrashTestProduct() {
        type(postSearchInputLocator, name);
        click(searchProductsButtonLocator);
        hoverOnElement(productNameInAdminLocator);
        click(trashButtonLocator);
        waitToBePresent(productDeletedMessageLocator);
        return this;
    }

    //Name that displays on Cart Page
    public boolean newSimpleProductIsDisplayedInCart() {
        return textIsDisplayed(productNameInCartLocator, name);
    }

    public boolean noProductsFoundTextIsDisplayed() {
        return textIsDisplayed(noProductsFoundMessageLocator, "No products found");
    }


}