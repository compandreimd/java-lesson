package tests.web.elements;

import condition.Ex;
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
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
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
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Desktop);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
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
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
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
       checkBoxPagePOM.clickElement(Downloads);
     //  Thread.sleep(10000);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), false);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        checkBoxPagePOM.openElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), false);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        softAssert.assertAll();
    }
    @Test
    public void checkLevel2() throws InterruptedException {
        if(repeat) checkLevel1();
        checkBoxPagePOM.openElement(Home);
        checkBoxPagePOM.clickElement(Home);
        checkBoxPagePOM.openElement(Desktop);
        checkBoxPagePOM.openElement(Documents);
        checkBoxPagePOM.openElement(Downloads);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.openElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.openElement(Home);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        Arrays.stream(ALL).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Notes);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Home), false, Home.toString());
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Desktop), false, Desktop.toString());
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Notes), false, Notes.toString());
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Commands);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Home), false, Home.toString());
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(Office);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Home), false, Home.toString());
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Documents), false, Documents.toString());
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Workspace), true, Workspace.toString());
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Office), false, Office.toString());
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });

        checkBoxPagePOM.clickElement(Workspace);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Home), false, Home.toString());
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOWNLOAD).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), true, it.toString());
        });
        checkBoxPagePOM.clickElement(WordFile);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_SEMICHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_CHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), true);
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Home), false, Home.toString());
        Arrays.stream(DESKTOP).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        Arrays.stream(DOCUMENTS).forEach(it -> {
            softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        softAssert.assertEquals(checkBoxPagePOM.hasResult(Downloads), false, Downloads.toString());
        softAssert.assertEquals(checkBoxPagePOM.hasResult(WordFile), false, WordFile.toString());
        softAssert.assertEquals(checkBoxPagePOM.hasResult(ExcelFile), true, ExcelFile.toString());
        checkBoxPagePOM.clickElement(ExcelFile);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Home), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Desktop), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Documents), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Downloads), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_UNCHEKED);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(React), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Angular), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Veu), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Public), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Private), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Classified), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(General), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.hasResults(), false);
        Arrays.stream(ALL).forEach(it -> {
                softAssert.assertEquals(checkBoxPagePOM.hasResult(it), false, it.toString());
        });
        softAssert.assertAll();
        checkBoxPagePOM.openElement(Documents);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Workspace), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Office), STATUS_NOTFOUND);
        checkBoxPagePOM.openElement(Desktop);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Notes), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(Commands), STATUS_NOTFOUND);
        checkBoxPagePOM.openElement(Downloads);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(WordFile), STATUS_NOTFOUND);
        softAssert.assertEquals(checkBoxPagePOM.getCheckStatus(ExcelFile), STATUS_NOTFOUND);
        checkBoxPagePOM.openElement(Home);
    }
}
