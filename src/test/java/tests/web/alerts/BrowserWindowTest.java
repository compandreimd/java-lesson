package tests.web.alerts;

import core.web.BaseClass;
import data.enums.EItem;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.SamplePagePOM;
import pom.alerts.AlertsFrameWindowPOM;
import pom.alerts.BrowserPagePOM;
import pom.forms.FormPagePOM;
import pom.forms.PracticeFormPagePOM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static pom.MainPagePOM.BODY;
import static pom.MainPagePOM.URL;
import static pom.alerts.BrowserPagePOM.MessageWindowButton;
import static pom.alerts.BrowserPagePOM.SAMPLE_URL;
import static pom.alerts.BrowserPagePOM.MSG_CONTENT;

public class BrowserWindowTest extends BaseClass {

    BrowserPagePOM pom;
    SamplePagePOM samplePagePOM;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (BrowserPagePOM) ((AlertsFrameWindowPOM) mainPOM
                .clickCard(EItem.AlertsFrameWindow))
                .clickItemMenu(EItem.Browser);
    }


    @Test
    public void browserWindow(){
        String mainPage = getPageHash();
        var pages = getPagesHash();
        pom.clickTabButton();
        pages = getNewPagesHash(pages);
        softAssert.assertEquals(pages.size(), 1);
        String hash =  pages.iterator().next();
        driver.switchTo().window(hash);
        softAssert.assertEquals(driver.getCurrentUrl(), SAMPLE_URL);
        if(samplePagePOM == null)
            samplePagePOM = new SamplePagePOM(this);
        softAssert.assertEquals(samplePagePOM.getContent(), SamplePagePOM.CONTENT);
        driver.close();
        driver.switchTo().window(mainPage);
        pages =getPagesHash();
        pom.clickWindowButton();
        pages = getNewPagesHash(pages);
        hash = pages.iterator().next();
        driver.switchTo().window(hash);
        softAssert.assertEquals(driver.getCurrentUrl(), SAMPLE_URL);
        driver.close();
        driver.switchTo().window(mainPage);
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        WebDriver tmpDriver = new ChromeDriver(options);
        tmpDriver.get(driver.getCurrentUrl());
        WebDriverWait webDriverWait = new WebDriverWait(tmpDriver, Duration.ofMinutes(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(BODY));

        tmpDriver.findElement(By.xpath(MessageWindowButton)).click();
        pages = tmpDriver.getWindowHandles();
        var it = pages.iterator();
        while (it.hasNext()){
            hash = it.next();
        }
        tmpDriver.switchTo().window(hash);

        softAssert.assertEquals(tmpDriver.getPageSource(), MSG_CONTENT);
        tmpDriver.quit();
        softAssert.assertAll();
    }

    @Test
    public void formsShowMenuTest() {
        Arrays.stream(EItem.FORMS).forEach(eItem -> {
            softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), true, "Menu Displayed " + eItem.name());
            pom.clickItemMenu(eItem);
            softAssert.assertEquals(driver.getCurrentUrl(), URL + eItem.getPath(), "Redirect menu url for " + eItem.name());
            driver.navigate().back();
        });
        Stream.concat(Stream.concat(Stream.concat(
                                        Arrays.stream(EItem.ELEMENTS),
                                        Arrays.stream(EItem.ALERTS)),
                                Stream.concat(
                                        Arrays.stream(EItem.WIDGETS),
                                        Arrays.stream(EItem.INTERACTIONS))),
                        Arrays.stream(EItem.BOOK))
                .forEach(eItem -> {
                    softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), false, "Menu Displayed " + eItem.toString());

                });
        softAssert.assertAll();
    }


}
