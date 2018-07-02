package pages;

import appmanager.HelperBase;
import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DataConverter;

import java.util.List;


public class CartPage extends HelperBase {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private float totalPriceBefore;

    private By returnToShopLocator = By.cssSelector("a.button.wc-backward");
    private By productNameInCartLocator = By.xpath("//*[@class='product-name']/a");
    private By productPriceLocator = By.xpath("//td[@class='product-subtotal']/span");
    private By cartItemsList = By.className("woocommerce-cart-form__cart-item");
    private By emptyCartTextLocator = By.className("cart-empty");
    private By qtyLocator = By.cssSelector("input.input-text.qty.text");
    private By updateCartButtonLocator = By.name("update_cart");
    private By cartUpdatedMessageLocator = By.cssSelector("div.woocommerce-message");
    private By removeProductFromCartLocator = By.xpath("//td[@class='product-remove']/a");
    private By proceedToCheckoutButton = By.cssSelector("a.checkout-button.button.alt.wc-forward");
    private By totalLocator = By.xpath("//td[@class='product-subtotal']/span");


    public ProductData productInfoInCart() {
        waitToBePresent(productNameInCartLocator);
        waitToBePresent(productPriceLocator);
        String name = driver.findElement(productNameInCartLocator).getText();
        float price = DataConverter.parsePriceValue(driver.findElement(productPriceLocator).getText());
        return new ProductData(name, price);
    }

    public float totalPriceBeforeIncrease() {
        totalPriceBefore = DataConverter.parsePriceValue(driver.findElement(totalLocator).getText());
        return totalPriceBefore;
    }

    public float totalPriceAfterIncrease() {
        return totalPriceBefore * 2;
    }


    public boolean validateNumberOfItemsInCart() {
        List<WebElement> allCartItems = driver.findElements(cartItemsList);
        return allCartItems.size() == 1;
    }

    public CartPage clickOnProceedToCheckoutButton() {
        scrollDownToFooter();
        click(proceedToCheckoutButton);
        waitToBePresent(By.id("order_review"));//
        return this;
    }

    public CartPage increaseQuantityOfProduct() {
        type(qtyLocator, "4");
        return this;
    }

    public CartPage clickOnUpdateCartButton() {
        click(updateCartButtonLocator);
        return this;
    }

    public CartPage clickOnReturnToShopButton() {
        click(returnToShopLocator);
        return this;
    }

    public boolean cartUpdatedTextIsDisplayed() {
        return textIsDisplayed(cartUpdatedMessageLocator, "Cart updated.");
    }

    public boolean actualProductQty() {
        return elementHasValue(qtyLocator, "4");
    }

    public boolean qtyOfProductIsTwo() {
        return elementHasValue(qtyLocator, "2");
    }

    public CartPage removeProductFromCart() {
        click(removeProductFromCartLocator);
        return this;
    }

    public boolean removeButtonIsDisplayed() {
        return isElementOnPage(removeProductFromCartLocator);
    }

    public boolean returnToShopButtonIsDisplayed() {
        return isElementOnPage(returnToShopLocator);
    }

    public boolean emptyCartTextIsDisplayed() {
        return textIsDisplayed(emptyCartTextLocator, "Your cart is currently empty.");
    }

    public CartPage clickOnProductNameInCart() {
        click(productNameInCartLocator);
        return this;
    }

}
