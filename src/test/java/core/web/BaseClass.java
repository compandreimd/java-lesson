package core.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;

public class BaseClass {
    protected ChromeDriver driver;
    protected SoftAssert softAssert = new SoftAssert();
    protected ReadConfig readConfig = ReadConfig.getInstance();
    @BeforeClass
    public void init(){
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterMethod
    public void close(){
        driver.close();
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }



}
