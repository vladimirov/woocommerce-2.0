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

    private By productsMenuLocator = By.id("menu-posts-product");
    private By allProductsDropdownLocator = By.xpath("//li[@id='menu-posts-product']/ul/li[2]");
    private By productSearchInAdminLocator = By.id("post-search-input");
    private By productSearchInAdminButtonLocator = By.id("search-submit");
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

    public boolean noProductsFoundTextIsDisplayed() {
        return textIsDisplayed(noProductsFoundMessageLocator, "No products found");
    }


}