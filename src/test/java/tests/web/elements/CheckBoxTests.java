package tests.web.elements;

import core.web.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.StartPagePOM;
import pom.elements.CheckBoxElements;
import pom.elements.CheckBoxPagePOM;
import utils.ReadConfig;

import java.util.Arrays;

import static pom.elements.CheckBoxPagePOM.*;
import static pom.elements.CheckBoxElements.*;

public class CheckBoxTests extends BaseClass
{
    private boolean repeat = true;
    CheckBoxPagePOM checkBoxPagePOM;
    @BeforeMethod
    public void initCheckBox(){
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        checkBoxPagePOM = startPagePOM.clickElements().clickCheckBox();
    }
    @Test
    public void checkLevel0(){
        checkBoxPagePOM.clickElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), false);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        softAssert.assertAll("Level 0");
    }
    @Test
    public void checkLevel1() throws InterruptedException {
        if(repeat) checkLevel0();
        checkBoxPagePOM.openElement(Home);
        checkBoxPagePOM.clickElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Desktop);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Desktop), false, "Desktop");
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Documents);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Desktop), false, Desktop.toString());
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Documents), false, Documents.toString());
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
//        checkBoxPagePOM.clickElement(Downloads);
//        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
//        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
//        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_UNCHEKED);
//        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
//        softAssert.assertEquals(checkBoxPagePOM.hasResults(), false);
//        softAssert.assertEquals(checkBoxPagePOM.hasResult(Desktop), false, Desktop.toString());
//        Arrays.stream(ALL).forEach(it -> {
//            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
//        });


        softAssert.assertAll();
    }
}
