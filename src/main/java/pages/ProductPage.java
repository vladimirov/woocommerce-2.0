package pages;

import appmanager.HelperBase;
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
    private By productPriceLocator = By.xpath("//p[@class='price']/span");
    private By productOnSalePriceLocator = By.xpath("//p[@class='price']/ins/span");
    private By productAddToCartButtonLocator = By.name("add-to-cart");
    private By qtyLocator = By.cssSelector("input.input-text.qty.text");

//    private ProductData productData = null;
//    Set<ProductData> pData = new HashSet<>();

    public ProductData productInfoOnProductPage() {
        waitToBePresent(productTitleLocator);
        String name = driver.findElement(productTitleLocator).getText();
        try {
            float price = DataConverter.parsePriceValue(driver.findElement(productPriceLocator).getText());
            return new ProductData(name, price);
        } catch (Exception ex) {
            float price = DataConverter.parsePriceValue(driver.findElement(productOnSalePriceLocator).getText());
            return new ProductData(name, price);
        }
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
