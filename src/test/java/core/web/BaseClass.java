package core.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;

public class BaseClass {
    protected WebDriver driver;
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
        if(IsMAC)
            driver = new SafariDriver();
        else
            driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void close(){
        driver.close();
    }
    @AfterClass
    public void quit(){
        if(!IsMAC)
            driver.quit();
    }



}
