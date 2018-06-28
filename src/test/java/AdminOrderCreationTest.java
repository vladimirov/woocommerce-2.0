import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AdminOrderCreationTest extends TestBase {

    @Test(groups = {"admin"})
    public void addNewOrder() {
        app.openAdminUrl();
        app.adminOrderPage().goToOrdersMenu();
        app.adminOrderPage().clickOnAddOrderButton();
        app.adminOrderPage().clickOnOrderStatusField();
        app.adminOrderPage().changeOrderStatus();
        String orderNumber = app.adminOrderPage().orderNumberOnOrderCreationPage();
        app.adminOrderPage().clickOnCreateButton();

        assertTrue(app.adminOrderPage().orderNoteMessageIsDisplayed());
        app.adminOrderPage().goToOrdersMenu();

        assertEquals(orderNumber, app.adminOrderPage().orderNumberOnOrdersListPage());
    }
}
