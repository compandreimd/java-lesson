package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ButtonPagePOM;
import pom.elements.ElementsPagePOM;
import pom.elements.LinksPagePOM;
import utils.ReadConfig;

import java.time.Duration;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class LinksPageTest extends BaseClass {
    LinksPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (LinksPagePOM) ((ElementsPagePOM) mainPOM.clickCard(EItem.Elements))
                .clickItemMenu(EItem.Links);
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


    @Test
    public void buttonPageTest(){
        String mainPage = getPageHash();
        Set<String> pages = getPagesHash();
        pom.click("simpleLink");
        pages = getNewPagesHash(pages);
        softAssert.assertEquals(pages.size(), 1, "New Page on simple Link");
        driver.switchTo().window(pages.iterator().next());
        softAssert.assertEquals(driver.getCurrentUrl(), ReadConfig.getInstance().getValue("URL"));
        driver.close();
        driver.switchTo().window(mainPage);
        pages = getPagesHash();
        pom.click("dynamicLink");
        pages = getNewPagesHash(pages);
        softAssert.assertEquals(pages.size(), 1, "Dynamic Page on simple Link");
        driver.switchTo().window(pages.iterator().next());

        softAssert.assertEquals(driver.getCurrentUrl(), ReadConfig.getInstance().getValue("URL"));
        driver.close();
        driver.switchTo().window(mainPage);
        pom.click("created");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        softAssert.assertEquals(pom.getLinkResponse(), pom.getResponseDefault("created"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        pom.click("moved");
        softAssert.assertEquals(pom.getLinkResponse(), pom.getResponseDefault("moved"));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        pom.click("unauthorized");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        softAssert.assertEquals(pom.getLinkResponse(), pom.getResponseDefault("unauthorized"));
        pom.click("forbidden");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        softAssert.assertEquals(pom.getLinkResponse(), pom.getResponseDefault("forbidden"));
        pom.click("invalid-url");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(600));
        softAssert.assertEquals(pom.getLinkResponse(), pom.getResponseDefault("invalid-url"));

        softAssert.assertAll();
    }
}
