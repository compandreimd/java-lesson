package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ButtonPagePOM;
import pom.elements.ElementsPagePOM;

import java.util.Arrays;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class ButtonPageTest extends BaseClass {
    ButtonPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (ButtonPagePOM)((ElementsPagePOM) mainPOM.clickCard(EItem.Elements))
                .clickItemMenu(EItem.Buttons);
    }

    @Test
    public void buttonPageTest() throws InterruptedException {
        pom.click();
        pom.clickRight();
        pom.clickDouble();
        softAssert.assertEquals(pom.getTextClick(), ButtonPagePOM.clickMessage, "Click Message");
        softAssert.assertEquals(pom.getTextRight(), ButtonPagePOM.rightClickMessage, "Right Click Message");
        softAssert.assertEquals(pom.getTextDouble(), ButtonPagePOM.doubleClickMessage, "Double Click Message");
        softAssert.assertAll();

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
