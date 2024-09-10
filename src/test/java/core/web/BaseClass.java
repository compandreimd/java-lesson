package core.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    protected static WebDriver driver;
    protected boolean isInit = false;
    protected SoftAssert softAssert = new SoftAssert();
    protected ReadConfig readConfig = ReadConfig.getInstance();
    protected boolean IsMAC = System.getProperty("os.name").contains("Mac");
    @BeforeClass
    public void init(){
        if(IsMAC) {
            WebDriverManager.safaridriver().setup();
        }
        else {
            WebDriverManager.chromedriver().setup();
        }
    }
    @BeforeMethod
    public void setup(){


        SafariOptions options = new SafariOptions();
        if(driver == null || isInit) {
            try {
                driver = IsMAC ? new RemoteWebDriver(new URL(ReadConfig.getInstance().getValue("DRIVER")), options) : new ChromeDriver();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
            isInit = true;
        }

        driver.manage().window().maximize();

    }

    @AfterMethod
    public void close(){
       // if(!IsMAC)
            driver.close();

    }
    @AfterClass
    public void quit(){
        if(!IsMAC)
            driver.quit();

    }



}
