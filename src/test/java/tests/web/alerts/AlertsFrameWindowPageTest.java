package tests.web.alerts;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.alerts.AlertsFrameWindowPOM;

import java.util.Arrays;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class AlertsFrameWindowPageTest extends BaseClass {
    AlertsFrameWindowPOM pom;

    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (AlertsFrameWindowPOM) mainPOM
                .clickCard(EItem.AlertsFrameWindow);

    }
    @Test
    void formsShowMenuTest() {
        Arrays.stream(EItem.ALERTS).forEach(eItem -> {
            softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), true, "Menu Displayed " + eItem.name());
            pom.clickItemMenu(eItem);
            softAssert.assertEquals(driver.getCurrentUrl(), URL + eItem.getPath(), "Redirect menu url for " + eItem.name());
            driver.navigate().back();
        });
        Stream.concat(Stream.concat(Stream.concat(
                Arrays.stream(EItem.ELEMENTS),
                Arrays.stream(EItem.FORMS)),
        Stream.concat(
                Arrays.stream(EItem.WIDGETS),
                Arrays.stream(EItem.INTERACTIONS))),
                Arrays.stream(EItem.BOOK))
                .forEach(eItem -> {
                    softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), false, "Menu Displayed " + eItem.toString());

                });
        softAssert.assertAll();
    }
    @Test
    void formPageTest() {
        softAssert.assertEquals(pom.hasSelectDIV(), true);
        softAssert.assertAll();
    }
}
