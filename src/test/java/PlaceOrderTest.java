import models.ProductData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PlaceOrderTest extends TestBase {

    @Test(groups = {"end2end"})
    public void placeOrderTest() {
        app.openBaseUrl();
        app.shopPage().openShopPage();
        app.shopPage().openRandomProduct();
        ProductData product = app.productPage().productInfoOnProductPage();
        app.productPage().addProductToCart();
        app.openCartPage();
        ProductData productInCart = app.cartPage().productInfoInCart();

        //Validate quantity of items in cart, name and price of the product
        assertTrue(app.cartPage().validateNumberOfItemsInCart());
        assertEquals(product.getName(), productInCart.getName());
        assertEquals(product.getPrice(), productInCart.getPrice());

        app.cartPage().clickOnProceedToCheckoutButton();
        app.checkoutPage().enterFirstName();
        app.checkoutPage().enterLastName();
        app.checkoutPage().enterStreetAddress();
        app.checkoutPage().enterCity();
        app.checkoutPage().enterState();
        app.checkoutPage().enterPostcode();
        app.checkoutPage().enterPhone();
        app.checkoutPage().enterEmail();
        app.checkoutPage().placeOrderButtonClick();
        ProductData productInOrders = app.checkoutPage().validateProductDataInOrderDetails();

        //Validate name, price and quantity of the product in orders page
        assertTrue(app.checkoutPage().successNoticeTextIsDisplayed());
        assertEquals(product.getName(), productInOrders.getName());
        assertEquals(product.getPrice(), productInOrders.getPrice());
        assertTrue(app.checkoutPage().validateQtyOfProductInOrderDetails());

        //Validate order number in admin
        String orderNumber = app.checkoutPage().orderNumberOnOrdersPage();
        app.login();
        app.adminOrderPage().goToOrdersMenu();
        assertEquals(orderNumber, app.adminOrderPage().orderNumberOnOrdersListPage());

        //Delete test order
        app.adminOrderPage().moveToTrashTestOrder();
        assertTrue(app.adminOrderPage().orderDeletedMessageIsDisplayed());

    }
}