import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class ProductCreationTest extends TestBase {

    @Test(groups = {"admin"})
    public void addNewProduct() {
        app.loginToAdmin();
        app.adminProductPage().clickOnProductsMenu();
        app.adminProductPage().clickOnAllProductsDropdown();
        app.adminProductPage().clickOnAddNewProductButton();
        app.adminProductPage().insertProductName();
        app.adminProductPage().insertProductDescription();
        app.adminProductPage().waitToBePresentSamplePermalink();
        app.adminProductPage().insertRegularPrice();
        app.adminProductPage().clickOnInventoryTab();
        app.adminProductPage().insertProductShortDescription();
        app.adminProductPage().clickOnPublishButton();
        //assert that product is in admin
        app.adminProductPage().clickOnAllProductsDropdown();
        app.adminProductPage().findNewProductInAdmin();
        assertEquals(app.adminProductPage().name, app.adminProductPage().actualProductNameInAdmin());
        //assert that product is on site
        app.openBaseUrl();
        app.adminProductPage().findNewProductOnSite();
        assertEquals(app.adminProductPage().name, app.productPage().actualProductName());
        assertEquals(app.adminProductPage().price, app.productPage().actualProductPrice());
    }

    @AfterMethod
    public void deleteTestProduct(){
        app.openAdminUrl();
        app.adminProductPage().clickOnProductsMenu();
        app.adminProductPage().clickOnAllProductsDropdown();
        app.adminProductPage().moveToTrashTestProduct();

        assertTrue(app.adminProductPage().noProductsFoundTextIsDisplayed());
    }
}
