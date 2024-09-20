package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.BrokenPagePOM;
import pom.elements.ButtonPagePOM;
import pom.elements.ElementsPagePOM;
import utils.ReadConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenPageTest extends BaseClass {

    BrokenPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (BrokenPagePOM)((ElementsPagePOM) mainPOM.clickCard(EItem.Elements))
                .clickItemMenu(EItem.BrokenLinks);
    }

    @Test
    public void brokenPageTest() throws IOException {
        softAssert.assertEquals(pom.imageIsDisplayed(0), true, "Ok Image");
        softAssert.assertEquals(pom.imageIsDisplayed(1), false, "Error Image");
        pom.click(0);
        driver.navigate().back();
        softAssert.assertEquals(pom.statusCode(),  HttpStatus.SC_OK, "Good Link");
        pom.click(1);
        softAssert.assertEquals(pom.statusCode(),  HttpStatus.SC_INTERNAL_SERVER_ERROR, "Bad Link");
        driver.navigate().back();

        softAssert.assertAll();
    }
}
