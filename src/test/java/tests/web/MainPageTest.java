package tests.web;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.Test;
import pom.MainPagePOM;

import java.util.Arrays;

import static pom.MainPagePOM.*;


public class MainPageTest extends BaseClass {

    @Test
    public void mainPageTest() {
        softAssert.assertEquals(driver.getCurrentUrl(), URL, "URL is changed!");
        softAssert.assertEquals(mainPOM.header.getAttribute("href"), driver.getCurrentUrl(), "Header URL ");
        softAssert.assertEquals(mainPOM.headerImage.getAttribute("src"), IMAGE, "Header Image ");
        softAssert.assertEquals(mainPOM.banner.getAttribute("href"), BANNER_URL, "Banner URL ");
        softAssert.assertEquals(mainPOM.bannerImage.getAttribute("src"), BANNER_IMAGE, "Banner Image ");
        Arrays.stream(EItem.MAIN).forEach(item -> {
            softAssert.assertEquals(mainPOM.displayedCard(item), true, "Don't have main card " + item.name());
            mainPOM.clickCard(item);
            softAssert.assertEquals(driver.getCurrentUrl(), URL + item.getPath(), "Redirect url for " + item.name());
            driver.navigate().back();
        });
        softAssert.assertAll();
    }
}
