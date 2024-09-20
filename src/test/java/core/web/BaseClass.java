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


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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

    public static String TempDir;
    static {
        ChromeOptions options = new ChromeOptions();
        try {
            TempDir = Files.createTempDirectory("tmpDirPrefix").toFile().getAbsolutePath();
            System.out.println("Create temp dir:"+TempDir);
            options.setEnableDownloads(true);
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", TempDir);
            options.setExperimentalOption("prefs", chromePrefs);
           // options.addArguments("--test-type");
            options.addArguments("start-maximized", "disable-popup-blocking");
        } catch (IOException e) {

        }
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
        File file = new File(TempDir);
        file.deleteOnExit();
        driver.quit();
    }

    public String getPageHash(){
        return driver.getWindowHandle();
    }

    public Set<String> getPagesHash(){
        return driver.getWindowHandles();
    }

    public Set<String> getNewPagesHash(Set<String> old){
        return getPagesHash().stream().filter(nh -> !old.contains(nh)).collect(Collectors.toSet());
    }
}
