package pages;

import appmanager.HelperBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends HelperBase {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private String homePageUrl = "baseUrl";
    private String expectedUrl = "baseUrl";
    public String expectedData = "Flying Ninja";


    private By siteLogoLocator = By.xpath("//h1[contains(@class, 'beta site-title')]");
    private By searchLocator = By.xpath("//input[@id='woocommerce-product-search-field-0']");


    public HomePage openHomePage() {
        driver.get(homePageUrl);
        return this;
    }

    public HomePage siteLogoClick() {
        click(siteLogoLocator);
        return this;
    }

    public boolean checkHomePageUrl() {
        return getPageUrl(expectedUrl);
    }

    public HomePage inputSearch() {
        type(searchLocator, expectedData);
        return this;
    }

    public HomePage submitSearch() {
        driver.findElement(searchLocator).submit();
        return this;
    }

}
