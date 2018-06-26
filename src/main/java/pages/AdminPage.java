package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {

    public AdminPage(WebDriver driver){super(driver);}

    private By adminBarLocator = By.cssSelector("a.ab-item");


    public boolean adminBarIsDisplayed() {
        return isElementPresent(adminBarLocator);
    }

}
