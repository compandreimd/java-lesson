package tests.web;

import core.web.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pom.PracticeFormPagePom;
import pom.StartPagePOM;
import utils.ReadConfig;

public class FormsTest extends BaseClass {

    @Test
    public void clickPracticeForm() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        PracticeFormPagePom pagePom = startPagePOM.clickForms().clickPracticeForm();
        Thread.sleep(3000);

        // softAss  ert.assertAll("End!");
    }

}
