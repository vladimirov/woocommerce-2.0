package appmanager;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.internal.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.AssertJUnit.fail;

public class HelperBase {

    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    protected WebDriver driver;
    public WebDriverWait wait;
    public int timeOutInSeconds = 10;
    public WebElement element;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOutInSeconds);
    }

    protected void click(By locator) {
        logger.info("CLICK ON ELEMENT: " + locator);
        try {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
        } catch (StaleElementReferenceException ignored) {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
        }
    }

    protected void type(By locator, String text) {
        logger.info("SEND TO " + locator + " KEYS " + text);
        try {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
            element.clear();
            element.sendKeys(text);
        } catch (StaleElementReferenceException ignored) {
            element = wait.until(presenceOfElementLocated(locator));
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    protected void submit(By locator) {
        logger.info("SUBMIT ELEMENT: " + locator);
        driver.findElement(locator).submit();
    }

    protected void clear(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT AND CLEAR: " + locator);
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            element.clear();
        } catch (StaleElementReferenceException ignored) {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            element.clear();
        }
    }

    protected void attach(By locator, File file) {
        if (file != null) {
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    public void waitToBePresent(By locator) {
        try {
            logger.info("ELEMENT HAS BEEN FOUND: " + locator);
            element = wait.until(visibilityOfElementLocated(locator));
        } catch (NullPointerException ignored) {
            element = wait.until(presenceOfElementLocated(locator));
            logger.info("ELEMENT HAS NOT BEEN FOUND: " + locator);
        }
    }

    public void waitTillElementIsNotVisible(By locator) {
        logger.info("WAIT TILL ELEMENT IS NOT VISIBLE: " + locator);
        wait.until(invisibilityOfElementLocated(locator));
    }

    public void waitForPageToLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoad = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };

        Wait<WebDriver> wait = new WebDriverWait(driver, 60);
        try {
            wait.until(pageLoad);
        } catch (Throwable pageLoadWaitError) {
            fail("Timeout during page load");
        }
    }

    protected void waitToBeStale(By locator) {
        logger.info("WAIT ELEMENT TO BE STALE: " + locator);
        try {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.stalenessOf(element));
        } catch (StaleElementReferenceException ignored) {
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.stalenessOf(element));
        }
    }

    protected void hoverOnElement(By locator) {
        logger.info("HOVER ON ELEMENT: " + locator);
        element = driver.findElement(locator);
        (new Actions(driver)).moveToElement(element).perform();
    }

    public void screenShot() {
        File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String filename = new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
        File dest = new File("C:\\Projects\\Wordpress/" + filename);
        Utils.copyFile(scr, dest);
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementOnPage(By locator) {
        logger.info("TRY TO FIND ELEMENT: " + locator);
        try {
            logger.info("ELEMENT IS ON PAGE: " + locator);
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            logger.info("ELEMENT IS NOT FOUND: " + locator);
            return false;
        }
    }

    protected boolean isTextDisplayed(By locator, String text) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        logger.info("ACTUAL TEXT:   " + element.getText());
        logger.info("EXPECTED TEXT: " + text);
        return element.getText().equals(text);
    }

    protected void scrollUp() {
        logger.info("SCROLL UP");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)", "");
    }

    protected void scrollTillElementIsVisible(By locator) {
        logger.info("SCROLL TILL ELEMENT IS VISIBLE: " + locator);
        element = wait.until(presenceOfElementLocated(locator));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    protected void scrollDownToFooter() {
        logger.info("SCROLL DOWN TO THE FOOTER");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected boolean textIsDisplayed(By locator, String text) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        logger.info("ACTUAL TEXT:   " + element.getText());
        logger.info("EXPECTED TEXT: " + text);
        return element.getText().equals(text);
    }

    protected boolean elementHasClass(By locator, String active) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        String classes = element.getAttribute("class");
        for (String c : classes.split("-")) {
            if (c.equals(active)) {
                return true;
            }
        }
        return false;
    }

    protected boolean getPageUrl(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        if (expectedUrl.equals(currentUrl)) {
            logger.info("ACTUAL PAGE: " + expectedUrl);
            return true;
        } else {
            logger.info("EXPECTED PAGE: " + expectedUrl);
            logger.info("ACTUAL PAGE:   " + driver.getCurrentUrl());
            return false;
        }
    }

    protected boolean elementHasValue(By locator, String expectedValue) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        logger.info("EXPECTED VALUE: " + expectedValue);
        logger.info("ACTUAL VALUE:   " + element.getAttribute("value"));
        return element.getAttribute("value").equals(expectedValue);
    }

    protected String extractElementPartialText(By locator, int beginIndex, int endIndex) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        logger.info("ELEMENT PARTIAL TEXT IS: " + element.getText().substring(beginIndex, endIndex));
        return element.getText().substring(beginIndex, endIndex);
    }

    protected String extractElementText(By locator) {
        logger.info("WAIT ELEMENT TO BE PRESENT: " + locator);
        element = wait.until(presenceOfElementLocated(locator));
        logger.info("ELEMENT TEXT IS: " + element.getText());
        return element.getText();
    }

}

