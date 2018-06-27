import org.testng.Assert;
import org.testng.annotations.Test;


public class AdminOrderNew extends TestBase{

    @Test (groups = {"admin"})
    public void addNewOrder() {
        app.loginToAdmin();
        app.adminOrderPage().goToOrdersMenu();
//        adminOrderPage.clickOnAddOrderButton();
//        adminOrderPage.clickOnOrderStatusField();
//        adminOrderPage.changeOrderStatus();
//        adminOrderPage.clickOnCreateButton();
//
//        Assert.assertTrue(adminOrderPage.orderNoteMessageIsDisplayed());

    }
}
