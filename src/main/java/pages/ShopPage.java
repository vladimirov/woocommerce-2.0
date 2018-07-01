package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


public class ShopPage extends HelperBase {

    public ShopPage(WebDriver driver) {
        super(driver);
    }

    private By addToCartButtonLocator = By.xpath("//a[contains(text(),'Add to cart')]");
    private By viewCartButtonLocator = By.cssSelector("a.added_to_cart.wc-forward");
    private By productTitleLocator = By.className("woocommerce-loop-product__title");
    private By shopMenuLocator = By.linkText("Shop");
    private By cartContentsLocator = By.cssSelector("a.cart-contents");
    private By cartWidgetLocator = By.cssSelector("div.widget.woocommerce.widget_shopping_cart");
    private By removeFromCartLocator = By.cssSelector("a.remove.remove_from_cart_button");

    public ShopPage openShopPage() {
        click(shopMenuLocator);
        return this;
    }

    public ShopPage openRandomProduct() {
        List<WebElement> allProduct = driver.findElements(productTitleLocator);
        allProduct.get(new Random().nextInt(allProduct.size())).click();
        return this;
    }

    public ShopPage addToCartRandomProduct() {
        List<WebElement> allProduct = driver.findElements(addToCartButtonLocator);
        allProduct.get(new Random().nextInt(allProduct.size())).click();
        return this;
    }

    public ShopPage addProductToCart() {
        click(addToCartButtonLocator);
        return this;
    }

    public ShopPage viewCartButtonClick() {
        click(viewCartButtonLocator);
        return this;
    }

    public ShopPage moveToCartPopUp() {
        hoverOnElement(cartContentsLocator);
        return this;
    }

    public boolean cartWidgetIsDisplayed(){
        return isElementOnPage(cartWidgetLocator);
    }

    public ShopPage removeFromCartButtonClick() {
        click(removeFromCartLocator);
        return this;
    }
}
