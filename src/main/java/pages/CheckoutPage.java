package pages;

import appmanager.HelperBase;
import models.BuyerData;
import models.ProductData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DataConverter;


public class CheckoutPage extends HelperBase {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    BuyerData buyer = BuyerData.generate();

    private By firstNameLocator = By.id("billing_first_name");
    private By lastNameLocator = By.id("billing_last_name");
    private By streetAddressLocator = By.id("billing_address_1");
    private By cityLocator = By.id("billing_city");
    private By stateLocator = By.id("billing_state");

    private By postcodeLocator = By.id("billing_postcode");
    private By emailLocator = By.id("billing_email");
    private By phoneLocator = By.id("billing_phone");
    private By placeOrderButtonLocator = By.id("place_order");
    private By orderReviewHeadingLocator = By.id("order_review_heading");
    private By successNoticeLocator = By.xpath("//div[@class='woocommerce-order']/p");
    private By orderedProductNameLocator = By.xpath("//td[@class='woocommerce-table__product-name product-name']/a");
    private By orderedProductPriceLocator = By.xpath("//td[@class='woocommerce-table__product-total product-total']/span");
//    private By orderedProductQtyLocator = By.className("product-quantity");
    private By orderedProductQtyLocator = By.cssSelector("strong.product-quantity");
    private By orderNumberLocator = By.xpath("//li[@class='woocommerce-order-overview__order order']/strong");


    public CheckoutPage enterFirstName() {
        type(firstNameLocator, buyer.getName());
        return this;
    }

    public CheckoutPage enterLastName() {
        type(lastNameLocator, buyer.getSurname());
        return this;
    }

    public CheckoutPage enterStreetAddress() {
        type(streetAddressLocator, buyer.getAddress());
        return this;
    }

    public CheckoutPage enterCity() {
        type(cityLocator, buyer.getCity());
        return this;
    }

    public CheckoutPage enterState() {
        type(stateLocator, buyer.getState());
        return this;
    }

    public CheckoutPage enterPostcode() {
        type(postcodeLocator, String.valueOf(buyer.getPost()));
        return this;
    }

    public CheckoutPage enterPhone() {
        type(phoneLocator, String.valueOf(buyer.getPhone()));
        return this;
    }

    public CheckoutPage enterEmail() {
        type(emailLocator, buyer.getEmail());
        return this;
    }

    public CheckoutPage placeOrderButtonClick() {
        scrollTillElementIsVisible(placeOrderButtonLocator);
        waitToBeStale(placeOrderButtonLocator);
        click(placeOrderButtonLocator);
        return this;
    }

    public boolean successNoticeTextIsDisplayed() {
        return textIsDisplayed(successNoticeLocator, "Thank you. Your order has been received.");
    }

    public boolean orderReviewHeadingIsOnPage() {
        return isElementOnPage(orderReviewHeadingLocator);
    }

    public ProductData validateProductDataInOrderDetails() {
        waitToBePresent(orderedProductNameLocator);
        waitToBePresent(orderedProductPriceLocator);
        String name = driver.findElement(orderedProductNameLocator).getText();
        float price = DataConverter.parsePriceValue(driver.findElement(orderedProductPriceLocator).getText());
        return new ProductData(name, price);
    }

    public boolean validateQtyOfProductInOrderDetails() {
        String qty = extractElementPartialText(orderedProductQtyLocator, 2, 3);
        return qty.equals("1");
    }

    public String orderNumberOnOrdersPage() {
        return extractElementText(orderNumberLocator);
    }

}
