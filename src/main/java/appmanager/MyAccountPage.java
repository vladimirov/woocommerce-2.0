package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends HelperBase {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private String loginPageURL = "baseUrl" + "/my-account";
    private String ordersPageURL = "baseUrl" + "/my-account/orders";

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.xpath("//input[contains(@class, 'woocommerce-Button button')]");
    private By myAccountNavigationLocator = By.xpath("//div[contains(@class, 'entry-content')]");
    private By myAccountOrdersLocator = By.xpath("//li[contains(@class, 'woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders')]");


    public MyAccountPage openLoginPage() {
        driver.get(loginPageURL);
        return this;
    }

    public MyAccountPage inputUsername() {
        type(usernameLocator, "username from properties");
        return this;
    }

    public MyAccountPage inputPassword() {
        type(passwordLocator, "pass from properties ");
        return this;
    }

    public MyAccountPage loginButtonClick() {
        click(loginButtonLocator);
        return this;
    }

    public boolean myAccountNavigationIsDisplayed() {
        return isElementOnPage(myAccountNavigationLocator);
    }

    public MyAccountPage myAccountNavigationClick() {
        click(myAccountOrdersLocator);
        return this;
    }

    public boolean myAccountOrdersPage() {
        String currentURL = driver.getCurrentUrl();
        boolean result = ordersPageURL.equals(currentURL);
        return result;

    }

}
