import models.ProductData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends TestBase {

    @Test(groups = {"end2end"})
    public void cartPage() {
        app.openCartPage();

        assertTrue(app.cartPage().emptyCartTextIsDisplayed());

        app.shopPage().openShopPage();
        app.shopPage().openRandomProduct();
        ProductData product = app.productPage().productInfoOnProductPage();
        app.shopPage().addProductToCart();
        app.openCartPage();
        ProductData productInCart = app.cartPage().productInfoInCart();

        assertEquals(product.getName(), productInCart.getName());
        assertEquals(product.getPrice(), productInCart.getPrice());
        System.out.println(String.valueOf(product.getName()));
        System.out.println(String.valueOf(productInCart.getName()));
        System.out.println(String.valueOf(product.getPrice()));
        System.out.println(String.valueOf(productInCart.getPrice()));

        //should increases item qty and total when "Add to cart" of the same product is clicked
        float totalBefore = app.cartPage().totalPriceBeforeIncrease();
        app.cartPage().clickOnProductNameInCart();
        app.shopPage().addProductToCart();
        app.openCartPage();
        float totalAfter = app.cartPage().totalPriceAfterIncrease();

        assertTrue(app.cartPage().qtyOfProductIsTwo());
        assertEquals(totalAfter, totalBefore * 2, 0.0);
        System.out.println(totalBefore);
        System.out.println(totalAfter);

        //should updates qty when updated via qty input
        app.cartPage().increaseQuantityOfProduct();
        app.cartPage().clickOnUpdateCartButton();
        assertTrue(app.cartPage().cartUpdatedTextIsDisplayed());
        assertTrue(app.cartPage().actualProductQty());

        //should go to the checkout page when "Proceed to Checkout" is clicked
        app.cartPage().clickOnProceedToCheckoutButton();
        assertTrue(app.checkoutPage().orderReviewIsOnPage());

        //should remove the item from the cart when remove is clicked
        app.openCartPage();
        app.cartPage().removeProductFromCart();
        assertTrue(app.cartPage().emptyCartTextIsDisplayed());


    }
}
