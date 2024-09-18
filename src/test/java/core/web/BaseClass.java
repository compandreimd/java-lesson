package core.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pom.MainPagePOM;
import utils.ReadConfig;


import java.time.Duration;


public class BaseClass{

    protected static WebDriver driver;
    protected WebDriverWait waiter;
    protected SoftAssert softAssert = new SoftAssert();
    protected MainPagePOM mainPOM = new MainPagePOM(this);
    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getWaiter() {
        return waiter;
    }
    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    static {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public BaseClass(){
        waiter =  new WebDriverWait(driver, Duration.ofMinutes(5));
    }
    @BeforeSuite
    public void init(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        softAssert = new SoftAssert();
        driver.get(ReadConfig.getInstance().getValue("URL"));
    }

    @AfterSuite(alwaysRun = true)
    public void quit(){
        driver.quit();
    }
}
