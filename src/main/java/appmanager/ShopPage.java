package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ShopPage extends HelperBase {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    private String shopPageURL = "baseUrl" + "/shop";
    private String productOneUrl = "baseUrl" + "/flying-ninja";
    private String productTwoUrl = "baseUrl" + "/happy-ninja-2";


    private By addToCartButtonLocator = By.cssSelector("button.single_add_to_cart_button");
    private By productTitleLocator = By.className("woocommerce-loop-product__title");

    public ShopPage openShopPage() {
//        goToPage(shopPageURL);
        return this;
    }

    public ShopPage openRandomProduct() {
        List<WebElement> allProduct = driver.findElements(productTitleLocator);
        allProduct.get(new Random().nextInt(allProduct.size())).click();
        return this;
    }

    public ShopPage openFirstProductPageAndAddToCart() {
//        goToPage(productOneUrl);
        click(addToCartButtonLocator);
        return this;
    }

    public ShopPage openSecondProductPageAndAddToCart() {
//        goToPage(productTwoUrl);
        click(addToCartButtonLocator);
        return this;
    }

    public ShopPage clickOnAddToCartButton() {
        click(addToCartButtonLocator);
        return this;
    }



}