package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminOrderPage extends HelperBase {

    public AdminOrderPage(WebDriver driver) {
        super(driver);
    }

    private String successMessage = "Order status changed from Pending payment to Processing.";

    private By wooMenuLocator = By.id("toplevel_page_woocommerce");
    private By ordersMenuLocator = By.xpath("//ul[@class='wp-submenu wp-submenu-wrap']/li[2]/a[@href='edit.php?post_type=shop_order']");
    private By addOrderButtonLocator = By.xpath("//*[@id='wpbody-content']/div[3]/a[1]");
    private By orderStatusDropdownLocator = By.id("select2-order_status-container");
    private By orderStatusProcessingLocator = By.xpath("//select[@id='order_status']/option[2]");
    private By createButtonLocator = By.name("save");
    private By noteTextLocator = By.cssSelector("div.note_content");
    private By orderListLocator = By.id("the-list");
    private By noOrdersFoundLocator = By.className("colspanchange");
    private By orderHeadingLocator = By.cssSelector("h2.woocommerce-order-data__heading");
    private By orderHeadingInOrdersLocator = By.cssSelector("a.order-view");
    private By moveToTrashLocator = By.id("delete-action");
    private By orderDeletedMessageLocator = By.xpath("//div[@id='message']/p");


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
        return textIsDisplayed(noteTextLocator, successMessage);
    }

    public String orderNumberOnOrderCreationPage() {
        return extractElementPartialText(orderHeadingLocator, 7, 10);
    }

    public String orderNumberOnOrdersListPage() {
        return extractElementPartialText(orderHeadingInOrdersLocator, 1, 4);
    }

    public void moveToTrashTestOrder() {
        click(orderHeadingInOrdersLocator);
        click(moveToTrashLocator);
    }

    public boolean orderDeletedMessageIsDisplayed(){
        return textIsDisplayed(orderDeletedMessageLocator, "1 order moved to the Trash. Undo");
    }

}