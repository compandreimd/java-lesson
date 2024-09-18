package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ElementsPagePOM;
import pom.elements.RadioPagePOM;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class RadioPageTest extends BaseClass {
    RadioPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (RadioPagePOM) ((ElementsPagePOM) mainPOM.clickCard(EItem.Elements)).clickItemMenu(EItem.RadioButton);
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
    void radioPageTest() {
        softAssert.assertEquals(pom.yesIsSelected(), false, "Init Selected yes!");
        softAssert.assertEquals(pom.noIsSelected(), false, "Init Selected no!");
        softAssert.assertEquals(pom.impressiveIsSelected(), false, "Init Selected impressive!");
        softAssert.assertEquals(pom.yesIsDisabled(), false, "Init Disabled yes!");
        softAssert.assertEquals(pom.noIsDisabled(), true, "Init Disabled no!");
        softAssert.assertEquals(pom.impressiveIsDisabled(), false, "Init Disabled impressive!");
        softAssert.assertEquals(pom.displayedTextSuccess(), false, "Text Success!");
        pom.clickYesRadio();
        softAssert.assertEquals(pom.getTextSuccess(), "Yes", "Text yes!");
        pom.clickNoRadio();
        softAssert.assertEquals(pom.yesIsSelected(), true, "Selected yes!");
        softAssert.assertEquals(pom.noIsSelected(), false, "Selected no!");
        softAssert.assertEquals(pom.impressiveIsSelected(), false, "Selected impressive!");
        softAssert.assertEquals(pom.getTextSuccess(), "Yes", "Text yes!");
        pom.clickImpressiveRadio();
        softAssert.assertEquals(pom.getTextSuccess(), "Impressive", "Text impressive!");
        pom.clickNoRadio();
        softAssert.assertEquals(pom.yesIsSelected(), false, "Selected yes step 2!");
        softAssert.assertEquals(pom.noIsSelected(), false, "Selected no step 2!");
        softAssert.assertEquals(pom.impressiveIsSelected(), true, "Selected impressive step 2!");
        softAssert.assertEquals(pom.getTextSuccess(), "Impressive", "Text impressive!");
        softAssert.assertAll();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
    }
}
