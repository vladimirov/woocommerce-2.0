import models.ProductData;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends TestBase {

    @Test(enabled = true)
    public void cartPage() {
        app.openCartPage();

        assertTrue(app.cartPage().emptyCartTextIsDisplayed());

        app.shopPage().openShopPage();
        app.shopPage().openRandomProduct();
        ProductData product =  app.productPage().productInfoOnProductPage();
        app.shopPage().addProductToCart();
        app.openCartPage();
        ProductData productInCart = app.cartPage().productInfoInCart();

        assertEquals(product.getName(), productInCart.getName());
        System.out.println(String.valueOf(product.getName()));
        System.out.println(String.valueOf(productInCart.getName()));

        assertEquals(product.getPrice(), productInCart.getPrice());
        System.out.println(String.valueOf(product.getPrice()));
        System.out.println(String.valueOf(productInCart.getPrice()));

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
