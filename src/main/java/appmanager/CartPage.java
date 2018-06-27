package appmanager;

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

    ProductPage productPage = new ProductPage(driver);

    private String cartPageURL = "baseUrl" + "/cart";
    private String emptyCartText = "Your cart is currently empty.";
    private String flyingNinjaText = "Flying Ninja";
    private String happyNinjaText = "Happy Ninja";
    private String quantityOfProduct = "2";
    private String expectedValueOfFirstProduct = "4";
    private String expectedValueOfSecondProduct = "3";

    private By productNameInCartLocator = By.xpath("//*[@class='product-name']/a");
    private By productPriceLocator = By.xpath("//td[@class='product-subtotal']/span");
    private By cartItemsList = By.className("woocommerce-cart-form__cart-item");
    private By emptyCartTextLocator = By.className("cart-empty");
    private By qtyLocator = By.xpath("//input[@class='input-text qty text']");
    private By removeProductLocator = By.cssSelector("td.product-remove");

    private By flyingNinjaProductLocator = By.xpath("//*[@id='post-5']/div/div/form/table/tbody/tr[1]/td[3]/a");
    private By happyNinjaProductLocator = By.xpath("//*[@id='post-5']/div/div/form/table/tbody/tr[2]/td[3]/a");
    private By qtyOfFirstProductLocator = By.xpath("//*[@id='post-5']/div/div/form/table/tbody/tr[1]/td[5]/div/input");
    private By qtyOfSecondProductLocator = By.xpath("//*[@id='post-5']/div/div/form/table/tbody/tr[2]/td[5]/div/input");

    private By updateCartButtonLocator = By.name("update_cart");
    private By removeFirstProductButtonLocator = By.xpath("//*[@id='post-5']/div/div/form/table/tbody/tr[1]/td[1]/a");
    private By totalPriceLocator = By.xpath("//*[@id='post-5']/div/div/form/table/tbody/tr[1]/td[6]/span");
    private By proceedToCheckoutButton = By.cssSelector("a.checkout-button.button.alt.wc-forward");



    public CartPage openCartPage() {
//        goToPage(cartPageURL);
        return this;
    }

    public ProductData validateProductDataInCart() {
        waitToBePresent(productNameInCartLocator);
        waitToBePresent(productPriceLocator);
        String name = driver.findElement(productNameInCartLocator).getText();
        float price = DataConverter.parsePriceValue(driver.findElement(productPriceLocator).getText());

        return new ProductData(name, price);
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

    public boolean emptyCartTextIsDisplayed() {
        return textIsDisplayed(emptyCartText, emptyCartTextLocator);
    }

    public boolean flyingNinjaTextIsDisplayed() {
        return textIsDisplayed(flyingNinjaText, flyingNinjaProductLocator);
    }

    public boolean happyNinjaTextIsDisplayed() {
        return textIsDisplayed(happyNinjaText, happyNinjaProductLocator);
    }

    public CartPage goToFlyingNinjaProductPage() {
        click(flyingNinjaProductLocator);
        return this;
    }

    public boolean quantityOfItemsIsTwo() {
        return elementHasValue(quantityOfProduct, qtyOfFirstProductLocator);
    }

    public CartPage increaseQuantityOfFirstProduct() {
        clear(qtyOfFirstProductLocator);
        type(qtyOfFirstProductLocator, "4");
        return this;
    }

    public CartPage increaseQuantityOfSecondProduct() {
        clear(qtyOfSecondProductLocator);
        type(qtyOfSecondProductLocator, "3");
        return this;
    }

    public CartPage clickOnUpdateCartButton() {
        click(updateCartButtonLocator);
        return this;
    }

    public boolean getActualQtyOfFirstProduct() {
        return elementHasValue(expectedValueOfFirstProduct, qtyOfFirstProductLocator);
    }

    public boolean getActualQtyOfSecondProduct() {
        return elementHasValue(expectedValueOfSecondProduct, qtyOfSecondProductLocator);
    }

    public CartPage clickOnRemoveButton() throws InterruptedException {
        Thread.sleep(2000);
        click(removeFirstProductButtonLocator);
        return this;
    }

    public boolean productNameIsDisplayed() {
        return textIsDisplayed(flyingNinjaText, flyingNinjaProductLocator);
    }

    public boolean productQtyIsDisplayed() {
        return elementHasValue("1", qtyOfFirstProductLocator);
    }

    public boolean productSubtotalIsDisplayed() {
        return textIsDisplayed("kr12.00", totalPriceLocator);
    }


    public CartPage waitToBeStale() {
        waitToBeStale(totalPriceLocator);
        return this;
    }

    public boolean productSubtotalAfterIncreaseQty() {
        return textIsDisplayed("kr48.00", totalPriceLocator);
    }

    public boolean qtyOfProductIsFive() {
        return elementHasValue(productPage.newQty, qtyLocator);
    }

    public CartPage removeProductFromCart() {
        click(removeProductLocator);
        waitToBePresent(emptyCartTextLocator);
        return this;
    }


}
