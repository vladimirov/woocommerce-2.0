import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductCreationTest extends TestBase{

    @Test(groups = {"admin"})
    public void addNewProduct() {
        app.loginToAdmin();

        app.adminProductPage().clickOnProductsMenu();
        app.adminProductPage().clickOnAddNewProductButton();
        app.adminProductPage().insertProductName();
        app.adminProductPage().insertProductDescription();
        app.adminProductPage().waitToBePresentSamplePermalink();
        app.adminProductPage().insertRegularPrice();
        app.adminProductPage().clickOnInventoryTab();
        app.adminProductPage().insertProductShortDescription();
        app.adminProductPage().clickOnPublishButton();
        app.adminProductPage().goToBasePage();
        app.adminProductPage().findNewProductOnSite();

        Assert.assertEquals(app.adminProductPage().name, app.productPage().actualProductName());
        Assert.assertEquals(app.adminProductPage().price, app.productPage().actualProductPrice());
    }
}
