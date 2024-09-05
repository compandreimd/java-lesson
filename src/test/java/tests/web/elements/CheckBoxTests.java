package tests.web.elements;

import core.web.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.StartPagePOM;
import pom.elements.CheckBoxPagePOM;
import utils.ReadConfig;

public class CheckBoxTests extends BaseClass
{
    @Test
    public void test1() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        CheckBoxPagePOM checkBoxPagePOM = startPagePOM.clickElements().clickCheckBox();
        checkBoxPagePOM.open("home");
        checkBoxPagePOM.click("home");
        softAssert.assertEquals(checkBoxPagePOM.hasIconCheck("home"), true);
        softAssert.assertEquals(checkBoxPagePOM.hasIconCheck("desktop"), true);
        softAssert.assertEquals(checkBoxPagePOM.hasIconCheck("documents"), true);
        softAssert.assertEquals(checkBoxPagePOM.hasIconCheck("downloads"), true);
        softAssert.assertAll();
        Thread.sleep(10000);
    }
}
