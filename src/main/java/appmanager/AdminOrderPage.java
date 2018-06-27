package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminOrderPage extends HelperBase {

    public AdminOrderPage(WebDriver driver) {
        super(driver);
    }

    private String successMessage = "Order status changed from Pending payment to Processing.";
    private String noOrdersFoundText = "No orders found";

    private By wooMenuLocator = By.id("toplevel_page_woocommerce");
    private By ordersMenuLocator = By.xpath("//ul[@class='wp-submenu wp-submenu-wrap']/li[2]/a[@href='edit.php?post_type=shop_order']");
    private By addOrderButtonLocator = By.xpath("//*[@id='wpbody-content']/div[3]/a[1]");
    private By orderStatusDropdownLocator = By.id("select2-order_status-container");
    private By orderStatusProcessingLocator = By.xpath("//span[contains(@class, 'select2-results')]/ul[1]/li[2]");
    private By createButtonLocator = By.xpath("//*[@id='woocommerce-order-actions']/div/ul/li[2]/input");
    private By noteTextLocator = By.cssSelector("div.note_content");
    private By orderListLocator = By.id("the-list");
    private By moveToTrashButtonLocator = By.className("submitdelete");
    private By noOrdersFoundLocator = By.className("colspanchange");


    public AdminOrderPage goToOrdersMenu() {
        click(wooMenuLocator);
        click(ordersMenuLocator);
        return this;
    }

    public AdminOrderPage clickOnAddOrderButton() {
        click(addOrderButtonLocator);
        return this;
    }

    public AdminOrderPage clickOnOrderStatusField() {
        click(orderStatusDropdownLocator);
        return this;
    }

    public AdminOrderPage changeOrderStatus() {
        click(orderStatusProcessingLocator);
        return this;
    }

    public AdminOrderPage clickOnCreateButton() {
        click(createButtonLocator);
        return this;
    }

    public boolean orderNoteMessageIsDisplayed() {
        return textIsDisplayed(successMessage, noteTextLocator);
    }

    public AdminOrderPage moveToTrashTestOrder() {
//        deleteTestData();
        hoverOnElement(orderListLocator);
        click(moveToTrashButtonLocator);
        return this;
    }

    public boolean noOrdersFoundTextIsDisplayed() {
        return textIsDisplayed(noOrdersFoundText, noOrdersFoundLocator);
    }

}