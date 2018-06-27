import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class AdminOrderNew extends TestBase {

    @Test(groups = {"admin"})
    public void addNewOrder() {
        app.loginToAdmin();
        app.adminOrderPage().goToOrdersMenu();
        app.adminOrderPage().clickOnAddOrderButton();
        app.adminOrderPage().clickOnOrderStatusField();
        app.adminOrderPage().changeOrderStatus();
        app.adminOrderPage().clickOnCreateButton();

        assertTrue(app.adminOrderPage().orderNoteMessageIsDisplayed());

    }
}
