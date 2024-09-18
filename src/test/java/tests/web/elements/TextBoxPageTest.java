package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.MainPagePOM;
import pom.elements.ElementsPagePOM;
import pom.elements.TextBoxPagePOM;

import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;


public class TextBoxPageTest extends BaseClass{
    TextBoxPagePOM pom;

    String userName = "compandre" + Math.random();
    String email = "red@alert.com";
    String addrs = "b" + Math.random();
    String pAddrs = "p" + Math.random();

    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (TextBoxPagePOM) ((ElementsPagePOM) mainPOM
                .clickCard(EItem.Elements))
                .clickItemMenu(EItem.TextBox);
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
    public void clickTextBox() throws InterruptedException {

        userName = pom.sendKeysUserName(userName);
        email = pom.sendKeysUserEmail(email);
        addrs = pom.sendKeysCurrentAddress(addrs);
        pAddrs = pom.sendKeysPermanent(pAddrs);

        pom.clickSumit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        softAssert.assertEquals(
                pom.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(pom.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(pom.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(pom.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }

    @Test
    public void clickTextBoxNoName() throws InterruptedException {
        email = pom.sendKeysUserEmail(email);
        addrs = pom.sendKeysCurrentAddress(addrs);
        pAddrs = pom.sendKeysPermanent(pAddrs);
        pom.clickSumit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        softAssert.assertEquals(pom.hasName(), false);
        softAssert.assertEquals(pom.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(pom.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(pom.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }

    @Test
    public void clickTextBoxNoEmail() throws InterruptedException {
        userName = pom.sendKeysUserName(userName);
        addrs = pom.sendKeysCurrentAddress(addrs);
        pAddrs = pom.sendKeysPermanent(pAddrs);
        pom.clickSumit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        softAssert.assertEquals(
                pom.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(pom.hasEmail(), false);
        softAssert.assertEquals(pom.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(pom.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }

    @Test
    public void clickTextBoxWrongEmail() throws InterruptedException {
        userName = pom.sendKeysUserName(userName);
        email = pom.sendKeysUserEmail("qwey");
        pAddrs = pom.sendKeysPermanent(pAddrs);
        pom.clickSumit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        softAssert.assertEquals(pom.userEmail.getAttribute("class"),
                "mr-sm-2 field-error form-control", "Class is not set");
        softAssert.assertEquals(pom.hasName(), false, "No name!");
        softAssert.assertEquals(pom.hasEmail(), false, "No email!");
        softAssert.assertEquals(pom.hasAddress(), false, "No address!");
        softAssert.assertEquals(pom.hasPermanent(), false, "No permanent!");
        softAssert.assertAll("Has Data!");
    }

    @Test
    public void clickTextBoxNoCurrent() throws InterruptedException {
        userName = pom.sendKeysUserName(userName);
        email = pom.sendKeysUserEmail(email);
        pAddrs = pom.sendKeysPermanent(pAddrs);
        pom.clickSumit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        softAssert.assertEquals(
                pom.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(pom.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(pom.hasAddress(), false);
        softAssert.assertEquals(pom.getTextPermanentAddress(), "Permananet Address :"+pAddrs, "Show PA");
        softAssert.assertAll("Wrong Data!");
    }
    @Test
    public void clickTextBoxNoPermanent() throws InterruptedException {
        userName = pom.sendKeysUserName(userName);
        email = pom.sendKeysUserEmail(email);
        addrs = pom.sendKeysCurrentAddress(addrs);
        pom.clickSumit();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        softAssert.assertEquals(
                pom.getTextName(),
                "Name:"+userName,
                "Show Name");
        softAssert.assertEquals(pom.getTextEmail(), "Email:"+email, "Show Email");
        softAssert.assertEquals(pom.getTextCurrentAddress(), "Current Address :"+addrs, "Show CA");
        softAssert.assertEquals(pom.hasPermanent(), false);
        softAssert.assertAll("Wrong Data!");
    }
}
