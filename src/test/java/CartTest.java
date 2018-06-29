import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends TestBase {

    @Test
    public void cartPage() {
        //should displays no item in the cart
        app.openCartPage();
        assertTrue(app.cartPage().emptyCartTextIsDisplayed());

        //should adds the product to the cart when "Add to cart" is clicked
        app.shopPage().openShopPage();
        app.shopPage().openRandomProduct();
//        productInfo = app.productPage().getOpenedProductInfo();
        app.shopPage().addProductToCart();
        app.openCartPage();
        app.cartPage().validateProductDataInCart();


//        app.shopPage().openSecondProductPageAndAddToCart();
//        app.goTo().gotoCartPage();
//        assertTrue(app.cartPage().flyingNinjaTextIsDisplayed());
//        assertTrue(app.cartPage().happyNinjaTextIsDisplayed());

//        //should increases item qty when "Add to cart" of the same product is clicked
//        app.cartPage().goToFlyingNinjaProductPage();
//        app.shopPage().addProductToCart();
//        app.cartPage().openCartPage();
//        assertTrue(app.cartPage().quantityOfItemsIsTwo());
//
//        //should updates qty when updated via qty input
//        app.cartPage().increaseQuantityOfFirstProduct();
//        app.cartPage().increaseQuantityOfSecondProduct();
//        app.cartPage().clickOnUpdateCartButton();
//        assertEquals(app.cartPage().getActualQtyOfFirstProduct(), true);
//        assertEquals(app.cartPage().getActualQtyOfSecondProduct(), true);
//
//        //should remove the item from the cart when remove is clicked
//        app.cartPage().clickOnRemoveButton();
//        app.cartPage().clickOnRemoveButton();
//        assertTrue(app.cartPage().emptyCartTextIsDisplayed());
//
//        //should update subtotal in cart totals when adding product to the cart
//        app.shopPage().openFirstProductPageAndAddToCart();
//        app.cartPage().openCartPage();
//        assertEquals(app.cartPage().productNameIsDisplayed(), true);
//        assertEquals(app.cartPage().productQtyIsDisplayed(), true);
//        assertEquals(app.cartPage().productSubtotalIsDisplayed(), true);
//
//        app.cartPage().increaseQuantityOfFirstProduct();
//        app.cartPage().clickOnUpdateCartButton();
//        app.cartPage().waitToBeStale();
//        assertEquals(app.cartPage().productSubtotalAfterIncreaseQty(), true);
//
//        //should go to the checkout page when "Proceed to Chcekout" is clicked
//        app.cartPage().clickOnProceedToCheckoutButton();
//        assertEquals(app.checkoutPage().orderReviewIsOnPage(), true);

    }
}
