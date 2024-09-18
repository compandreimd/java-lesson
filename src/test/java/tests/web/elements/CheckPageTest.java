package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.MainPagePOM;
import pom.elements.CheckPagePOM;
import pom.elements.ElementsPagePOM;

import java.util.Arrays;
import java.util.stream.Stream;

import static data.enums.ECheckBoxElements.*;
import static pom.MainPagePOM.URL;
import static pom.elements.CheckPagePOM.*;

public class CheckPageTest extends BaseClass {
    CheckPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (CheckPagePOM) ((ElementsPagePOM) mainPOM
                .clickCard(EItem.Elements))
                .clickItemMenu(EItem.CheckBox);
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
    public void checkLevel0(){
        pom.clickElement(Home);
        softAssert.assertEquals(pom.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(pom.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), true, it.toString());
        });
        pom.clickElement(Home);
        softAssert.assertEquals(pom.getCheckStatus(Home), STATUS_UNCHEKED);
        softAssert.assertEquals(pom.hasResults(), false);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), false, it.toString());
        });
        softAssert.assertAll("Level 0");
    }
    @Test
    public void checkLevel1() throws InterruptedException {
        pom.openElement(Home);
        pom.clickElement(Home);
        softAssert.assertEquals(pom.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Desktop), STATUS_CHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(pom.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), true, it.toString());
        });
        pom.clickElement(Desktop);
        softAssert.assertEquals(pom.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(pom.hasResults(), true);
        softAssert.assertEquals(pom.hasResult(Desktop), false, "Desktop");
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), true, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), true, it.toString());
        });
        pom.clickElement(Documents);
        softAssert.assertEquals(pom.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Documents), STATUS_UNCHEKED);
        softAssert.assertEquals(pom.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(pom.hasResults(), true);
        softAssert.assertEquals(pom.hasResult(Desktop), false, Desktop.toString());
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), false, it.toString());
        });
        softAssert.assertEquals(pom.hasResult(Documents), false, Documents.toString());
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(pom.hasResult(it), true, it.toString());
        });



        softAssert.assertAll();
    }
}
