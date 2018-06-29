package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {
    private final Properties properties;
    WebDriver driver;
    private String browser;

    private SessionHelper sessionHelper;
    private SiteHelper siteHelper;
    private AdminHelper adminHelper;
    private AdminCouponPage adminCouponPage;
    private AdminOrderPage adminOrderPage;
    private AdminProductPage adminProductPage;
    private AdminProductsDownloadablePage adminProductsDownloadablePage;
    private AdminGeneralSettingsPage adminGeneralSettingsPage;
    private AdminTaxPage adminTaxPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private ProductPage productPage;
    private ShopPage shopPage;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));
//        dbHelper = new DbHelper();
        switch (browser) {
            case BrowserType.CHROME: {
                System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                this.driver = new ChromeDriver(capabilities);
                break;
            }
            case BrowserType.FIREFOX: {
                System.setProperty("webdriver.chrome.driver", "C:\\Windows\\geckodriver.exe");
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                driver = new FirefoxDriver(capabilities);
                break;
            }
            case BrowserType.IE:
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().window().maximize();
        this.driver.manage().deleteAllCookies();

        siteHelper = new SiteHelper(driver);
        adminHelper = new AdminHelper(driver);
        adminCouponPage = new AdminCouponPage(driver);
        adminOrderPage = new AdminOrderPage(driver);
        adminProductPage = new AdminProductPage(driver);
        adminProductsDownloadablePage = new AdminProductsDownloadablePage(driver);
        adminGeneralSettingsPage = new AdminGeneralSettingsPage(driver);
        adminTaxPage = new AdminTaxPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage = new HomePage(driver);
        myAccountPage = new MyAccountPage(driver);
        productPage = new ProductPage(driver);
        shopPage = new ShopPage(driver);
    }

    public void loginToAdmin() {
        driver.get(properties.getProperty("web.adminUrl"));
        sessionHelper = new SessionHelper(driver);
        sessionHelper.loginToAdmin(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));
    }

    public void openBaseUrl() {
        driver.get(properties.getProperty("web.baseUrl"));
    }

    public void openCartPage() {
        driver.get(properties.getProperty("web.baseUrl") + "cart");
    }


    public void stop() {
        driver.quit();
    }


    public SiteHelper site() {
        return siteHelper;
    }

    public AdminHelper adminHelper() {
        return adminHelper;
    }

    public AdminCouponPage adminCouponPage() {
        return adminCouponPage;
    }

    public AdminOrderPage adminOrderPage() {
        return adminOrderPage;
    }

    public AdminProductPage adminProductPage() {
        return adminProductPage;
    }

    public AdminProductsDownloadablePage adminProductsDownloadablePage() {
        return adminProductsDownloadablePage;
    }

    public AdminGeneralSettingsPage adminSettingsGeneralPage() {
        return adminGeneralSettingsPage;
    }

    public AdminTaxPage adminTaxPage() {
        return adminTaxPage;
    }

    public CartPage cartPage() {
        return cartPage;
    }

    public CheckoutPage checkoutPage() {
        return checkoutPage;
    }

    public HomePage homePage() {
        return homePage;
    }

    public MyAccountPage myAccountPage() {
        return myAccountPage;
    }

    public ProductPage productPage() {
        return productPage;
    }

    public ShopPage shopPage() {
        return shopPage;
    }
}