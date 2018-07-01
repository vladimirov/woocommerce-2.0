import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShopTest extends TestBase{

    @Test(priority = 1)
    public void addProductToCart() {
        app.openCartPage();
        assertTrue(app.cartPage().emptyCartTextIsDisplayed());

        app.cartPage().clickOnReturnToShopButton();
        app.shopPage().addToCartRandomProduct();
        app.shopPage().viewCartButtonClick();
        assertTrue(app.cartPage().removeButtonIsDisplayed());

        app.cartPage().removeProductFromCart();
        assertTrue(app.cartPage().returnToShopButtonIsDisplayed());
    }

    @Test (priority = 2)
    public void cartPopUp() {
        app.openCartPage();
        app.cartPage().clickOnReturnToShopButton();
        app.shopPage().addToCartRandomProduct();
        app.shopPage().moveToCartPopUp();
        assertTrue(app.shopPage().cartWidgetIsDisplayed());

        app.shopPage().removeFromCartButtonClick();
    }

    //goToPage

    //nextPage

    //sortBy
}
