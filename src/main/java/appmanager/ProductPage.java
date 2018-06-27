package appmanager;

import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DataConverter;

public class ProductPage extends HelperBase {

    String newQty = "5";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By productTitleLocator = By.cssSelector("h1.product_title.entry-title");
    private By productPriceLocator = By.cssSelector("p.price");
    private By productAddToCartButtonLocator = By.xpath("//button[contains(@type, 'submit')]");
    private By qtyLocator = By.cssSelector("input.input-text.qty.text");


    public ProductData getOpenedProductInfo() {
        waitToBePresent(productTitleLocator);
        waitToBePresent(productPriceLocator);
        String name = driver.findElement(productTitleLocator).getText();
        float price = DataConverter.parsePriceValue(driver.findElement(productPriceLocator).getText());
        return new ProductData(name, price);
    }

    public ProductPage addProductToCart() {
        click(productAddToCartButtonLocator);
        return this;
    }

    public String actualProductName() {
        return driver.findElement(productTitleLocator).getText();
    }

    public float actualProductPrice() {
        return DataConverter.parsePriceValue(driver.findElement(productPriceLocator).getText());
    }

    public ProductPage setNewQty() {
        clear(qtyLocator);
        type(qtyLocator, newQty);
        return this;
    }

    public ProductPage clickOnAddToCartButton() {
        click(productAddToCartButtonLocator);
        return this;
    }

//    public ProductPage productCartContentsClick() {
//        waitToBePresentAndClick(productCartContentsLocator);
//        return this;
//    }
//
//    public ProductPage quantityOfGoodsOnCartPageClick() {
//        waitToBePresentAndClick(productCartQuantityLocator);
//        return this;
//    }
//
//    public String getQuantityOfGoodsOnCartPage() {
//        quantityOfGoodsOnCartPage = driver.findElement(productCartQuantityLocator).getAttribute("value");
//        return quantityOfGoodsOnCartPage;
//    }

}
