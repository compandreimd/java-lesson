package tests.web;

import core.web.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;

public class DemoTest extends BaseClass {
    @Test
    public void setupDriver(){

    }

    @Test
    public void openWeb(){
        driver.get(ReadConfig.getInstance().getValue("URL"));
    }

    @Test
    public void clickElement() throws InterruptedException {
        driver.get(ReadConfig.getInstance().getValue("URL"));
        WebElement element =driver.findElement(By.xpath("//h5[text()='Elements']"));
        element.click();
      //h5[text()="Elements"]
    }
    @Test
    public void clickTextBox() throws InterruptedException {
        JavascriptExecutor executor = driver;
        driver.get(ReadConfig.getInstance().getValue("URL"));
        String userName = "compandre" + Math.random();
        String email = "red@alert.com";
        String addrs = "b" + Math.random();
        String pAddrs = "p" + Math.random();
        WebElement element =driver.findElement(By.xpath("//h5[text()='Elements']"));
        element.click();
        element = driver.findElement(By.xpath("//span[text()='Text Box']"));
        element.click();
        element = driver.findElement(By.xpath("//input[@id='userName']"));
        element.sendKeys(userName);
        element = driver.findElement(By.xpath("//input[@id='userEmail']"));
        element.sendKeys(email);
        element = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        element.sendKeys(pAddrs);
        element = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        element.sendKeys(addrs);
        element = driver.findElement(By.xpath("//button[@id='submit']"));
        executor.executeScript("arguments[0].scrollIntoView(true)", element);
        element.click();
        element = driver.findElement(By.xpath("//p[@id='name']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(element.getText(), "Name:"+userName, "Show Name");
        element = driver.findElement(By.xpath("//p[@id='email']"));
        softAssert.assertEquals(element.getText(), "Email:"+email, "Show Email");
        element = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        softAssert.assertEquals(element.getText(), "Current Address :"+pAddrs, "Show CA");
        element = driver.findElement(By.xpath("//p[@id='permanentAddress']"));
        softAssert.assertEquals(element.getText(), "Permananet Address :"+addrs, "Show PA");

        //  element.click();
        //h5[text()="Elements"]
        softAssert.assertAll("End!");
    }

}
