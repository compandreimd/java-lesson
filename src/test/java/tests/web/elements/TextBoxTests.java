package tests.web;

import core.web.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pom.StartPagePOM;
import pom.TextBoxPagePOM;
import utils.ReadConfig;

public class TextBoxTests extends BaseClass {


    @Test
    public void clickTextBox() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        String userName = "compandre" + Math.random();
        String email = "red@alert.com";
        String addrs = "b" + Math.random();
        String pAddrs = "p" + Math.random();
        TextBoxPagePOM textBoxPagePOM = startPagePOM.clickElements().clickTextBox();
        userName = textBoxPagePOM.sendKeysUserName(userName);
        email = textBoxPagePOM.sendKeysUserEmail(email);
        addrs = textBoxPagePOM.sendKeysCurrentAddress(addrs);
        pAddrs = textBoxPagePOM.sendKeysPermanent(pAddrs);
        executor.executeScript("arguments[0].scrollIntoView(true)", textBoxPagePOM.submit);
        textBoxPagePOM.clickSumit();

        softAssert.assertEquals(
                textBoxPagePOM.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(textBoxPagePOM.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(textBoxPagePOM.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(textBoxPagePOM.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }
    @Test
    public void clickTextBoxNoName() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        String userName = "compandre" + Math.random();
        String email = "red@alert.com";
        String addrs = "b" + Math.random();
        String pAddrs = "p" + Math.random();
        TextBoxPagePOM textBoxPagePOM = startPagePOM.clickElements().clickTextBox();
        email = textBoxPagePOM.sendKeysUserEmail(email);
        addrs = textBoxPagePOM.sendKeysCurrentAddress(addrs);
        pAddrs = textBoxPagePOM.sendKeysPermanent(pAddrs);
        executor.executeScript("arguments[0].scrollIntoView(true)", textBoxPagePOM.submit);
        textBoxPagePOM.clickSumit();

        softAssert.assertEquals(textBoxPagePOM.hasName(), false);
        softAssert.assertEquals(textBoxPagePOM.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(textBoxPagePOM.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(textBoxPagePOM.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }
    @Test
    public void clickTextBoxNoEmail() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        String userName = "compandre" + Math.random();
        String addrs = "b" + Math.random();
        String pAddrs = "p" + Math.random();
        TextBoxPagePOM textBoxPagePOM = startPagePOM.clickElements().clickTextBox();
        userName = textBoxPagePOM.sendKeysUserName(userName);
        addrs = textBoxPagePOM.sendKeysCurrentAddress(addrs);
        pAddrs = textBoxPagePOM.sendKeysPermanent(pAddrs);
        executor.executeScript("arguments[0].scrollIntoView(true)", textBoxPagePOM.submit);
        textBoxPagePOM.clickSumit();

        softAssert.assertEquals(
                textBoxPagePOM.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(textBoxPagePOM.hasEmail(), false);
        softAssert.assertEquals(textBoxPagePOM.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(textBoxPagePOM.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }

    @Test
    public void clickTextBoxWrongEmail() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        String userName = "compandre" + Math.random();
        String addrs = "b" + Math.random();
        String email = "e" + Math.random();
        String pAddrs = "p" + Math.random();
        TextBoxPagePOM textBoxPagePOM = startPagePOM.clickElements().clickTextBox();
        userName = textBoxPagePOM.sendKeysUserName(userName);
        email =  textBoxPagePOM.sendKeysUserEmail(email);
        addrs = textBoxPagePOM.sendKeysCurrentAddress(addrs);
        pAddrs = textBoxPagePOM.sendKeysPermanent(pAddrs);

        executor.executeScript("arguments[0].scrollIntoView(true)", textBoxPagePOM.submit);
        textBoxPagePOM.clickSumit();
        softAssert.assertEquals(textBoxPagePOM.userEmail.getAttribute("class"),
                "mr-sm-2 field-error form-control", "Class is not set");
        softAssert.assertEquals(textBoxPagePOM.hasName(), false, "No name!");
        softAssert.assertEquals(textBoxPagePOM.hasEmail(), false, "No email!");
        softAssert.assertEquals(textBoxPagePOM.hasAddress(), false, "No address!");
        softAssert.assertEquals(textBoxPagePOM.hasPermanent(), false, "No permanent!");
        softAssert.assertAll("Has Data!");
    }

    @Test
    public void clickTextBoxNoCurrent() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        String userName = "compandre" + Math.random();
        String email = "red@alert.com";
        String pAddrs = "p" + Math.random();
        TextBoxPagePOM textBoxPagePOM = startPagePOM.clickElements().clickTextBox();
        userName = textBoxPagePOM.sendKeysUserName(userName);
        email = textBoxPagePOM.sendKeysUserEmail(email);
        pAddrs = textBoxPagePOM.sendKeysPermanent(pAddrs);
        executor.executeScript("arguments[0].scrollIntoView(true)", textBoxPagePOM.submit);
        textBoxPagePOM.clickSumit();

        softAssert.assertEquals(
                textBoxPagePOM.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(textBoxPagePOM.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(textBoxPagePOM.hasAddress(), false);
        softAssert.assertEquals(textBoxPagePOM.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }
    @Test
    public void clickTextBoxNoPermanent() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        String userName = "compandre" + Math.random();
        String email = "red@alert.com";
        String addrs = "b" + Math.random();
        TextBoxPagePOM textBoxPagePOM = startPagePOM.clickElements().clickTextBox();
        userName = textBoxPagePOM.sendKeysUserName(userName);
        email = textBoxPagePOM.sendKeysUserEmail(email);
        addrs = textBoxPagePOM.sendKeysCurrentAddress(addrs);
        executor.executeScript("arguments[0].scrollIntoView(true)", textBoxPagePOM.submit);
        textBoxPagePOM.clickSumit();

        softAssert.assertEquals(
                textBoxPagePOM.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(textBoxPagePOM.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(textBoxPagePOM.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(textBoxPagePOM.hasPermanent(), false);
        softAssert.assertAll("Wrong Data!");
    }
}
