package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ButtonPagePOM;
import pom.elements.DynamicPagePOM;
import pom.elements.ElementsPagePOM;

import java.time.Duration;
import java.util.Arrays;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class DynamicPageTest extends BaseClass {
    DynamicPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (DynamicPagePOM)((ElementsPagePOM) mainPOM.clickCard(EItem.Elements))
                .clickItemMenu(EItem.Dynamic);
    }
    public AtomicLong time = new AtomicLong(0);
    @Test
    public void dynamicPageTest() throws InterruptedException {
        softAssert.assertEquals(pom.getDynamicText(), DynamicPagePOM.TEXT);
        softAssert.assertEquals(pom.isEnable(), false, "Enable start");
        softAssert.assertNotEquals(pom.getColorClass(), "mt-4 text-danger btn btn-primary", "Color start");
        softAssert.assertNotEquals(pom.hasDisplay(), false, "Display start");
        waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        waiter.until(d -> {
            time.addAndGet(1);
            return d.findElement(By.xpath("//button[@id='visibleAfter']")).isDisplayed();
        });
        waiter =   new WebDriverWait(driver, Duration.ofMinutes(5));
        softAssert.assertNotEquals(pom.isEnable(), false, "Enable start");
        softAssert.assertEquals(pom.getColorClass(), "mt-4 text-danger btn btn-primary", "Color start");
        softAssert.assertEquals(pom.hasDisplay(), false, "Display start");

    }
    @Test
    void elementShowMenuTest() {
        Arrays.stream(EItem.ELEMENTS).forEach(eItem -> {
            softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), true, "Menu Displayed " + eItem.name());
            pom.clickItemMenu(eItem);
            softAssert.assertEquals(driver.getCurrentUrl(), URL + eItem.getPath(), "Redirect menu url for " + eItem.name());
            driver.navigate().back();
        });
        Stream.concat(Stream.concat(Stream.concat(Arrays.stream(EItem.FORMS),
                                        Arrays.stream(EItem.ALERTS)),
                                Stream.concat(Arrays.stream(EItem.WIDGETS), Arrays.stream(EItem.INTERACTIONS))),
                        Arrays.stream(EItem.BOOK))
                .forEach(eItem -> {
                    softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), false, "Menu Displayed " + eItem.toString());

                });
        softAssert.assertAll();
    }
}
