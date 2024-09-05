package pom.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPagePOM {
    ChromeDriver driver;

    public CheckBoxPagePOM(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    static String getXPath(String str) {
        return "//label[@for='tree-node-"+str+"']";
    }

    public WebElement getButton(String str){
       return driver.findElement(By.xpath(getXPath(str)+"/../button"));
    }
    public WebElement getLabel(String str){
        return driver.findElement(By.xpath(getXPath(str)));
    }
    public WebElement getIconCheck(String str){
        return driver.findElement(By.xpath(getXPath(str)+"//*[@class='rct-icon rct-icon-check']"));
    }

    public void click(String name){
        getLabel(name).click();
    }
    public void open(String name){
        getButton(name).click();
    }

    public boolean hasIconCheck(String name){
        try {
            return getIconCheck(name).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
}
