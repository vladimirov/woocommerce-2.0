import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShopTest extends TestBase{

    @Test(priority = 1)
    public void addProductToCart() {
        app.openCartPage();
        assertTrue(app.cartPage().emptyCartTextIsDisplayed());

        app.cartPage().clickOnReturnToShopButton();
        app.shopPage().addToCartButtonClick();
        shopPage.viewCartButtonClick();
        assertTrue(cartPage.removeButtonIsDisplayed());
        cartPage.removeFromCartButtonClick();
    }
//
//    @Test (priority = 2)
//    public void removeProductFromCart() {
//        cartPage.openEmptyCartPage();
//        cartPage.returnToShopButtonClick();
//        shopPage.addToCartButtonClick();
//        shopPage.viewCartButtonClick();
//        cartPage.removeFromCartButtonClick();
//        assertEquals(true, cartPage.returnToShopButtonIsDisplayed());
//    }
//
//    @Test (priority = 3)
//    public void cartPopUp() {
//        cartPage.openEmptyCartPage();
//        cartPage.returnToShopButtonClick();
//        shopPage.addToCartButtonClick();
//        shopPage.moveToCartPopUp();
//        assertEquals(true, shopPage.cartPopUpIsDisplayed());
//        cartPage.removeFromCartButtonClick();
//    }
//
//    @Test (priority = 4)
//    public void clickProduct() {
//        shopPage.openShopPage();
//        shopPage.productTitleClick();
//        assertEquals(true, shopPage.singleAddToCartButtonIsDisplayed());
//    }

    //goToPage

    //nextPage

    //sortBy
}
