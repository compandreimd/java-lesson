package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.MainPagePOM;
import pom.elements.ElementsPagePOM;

import java.util.Arrays;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class ElementsPageTest extends BaseClass {
    ElementsPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (ElementsPagePOM) mainPOM.clickCard(EItem.Elements);
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
    void elementPageTest() {
        softAssert.assertEquals(pom.hasSelectDIV(), true);
        softAssert.assertAll();
    }
}
