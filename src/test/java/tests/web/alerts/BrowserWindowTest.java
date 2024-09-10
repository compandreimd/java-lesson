package tests.web.alerts;

import core.web.BaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.SamplePagePOM;
import pom.StartPagePOM;
import pom.alerts.BrowserWindowPOM;
import utils.ReadConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BrowserWindowTest extends BaseClass {
    String mainPage;
    BrowserWindowPOM pom;
    SamplePagePOM samplePagePOM;
    public final static String SAMPLE_URL = ReadConfig.getInstance().getValue("URL")+"sample";
    @BeforeMethod
    public void initCheckBox(){
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        pom = startPagePOM.clickAlerts().clickBrowserWindows();

    }
    @Test
    public void clicks() throws InterruptedException {
        mainPage = pom.getCurrentPageHash();
        var pages = pom.getPages();
        pom.clickTabButton();
        pages = pom.getNewPages(pages);
        softAssert.assertEquals(pages.size(), 1);
        String hash =  pages.iterator().next();
        driver.switchTo().window(hash);
        softAssert.assertEquals(driver.getCurrentUrl(), SAMPLE_URL);
        if(samplePagePOM == null)
            samplePagePOM = new SamplePagePOM(driver);
        softAssert.assertEquals(samplePagePOM.getContent(), SamplePagePOM.CONTENT);
        System.out.println(samplePagePOM.getContent());
        driver.switchTo().window(mainPage);
        pages = pom.getPages();
        pom.clickWindowButton();
        pages = pom.getNewPages(pages);
        hash = pages.iterator().next();
        driver.switchTo().window(hash);
        softAssert.assertEquals(driver.getCurrentUrl(), SAMPLE_URL);

        if(samplePagePOM == null)
            samplePagePOM = new SamplePagePOM(driver);
        softAssert.assertEquals(samplePagePOM.getContent(), SamplePagePOM.CONTENT);


       softAssert.assertAll();
    }


}
