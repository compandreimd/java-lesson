package pom.elements;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import pom.APom;

public class CheckBoxPagePOM extends APom {
    public static final int STATUS_CHEKED = 10;
    public static final int STATUS_UNCHEKED = 0;
    public static final int STATUS_SEMICHEKED = 5;
    public static final int STATUS_NOTFOUND = -1;
    public CheckBoxPagePOM(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@id='result']")
    public WebElement result;
    @Contract(pure = true)
    private static @NotNull String getXPath(CheckBoxElements element) {
        return "//label[@for='tree-node-"+element.toString()+"']";
    }
    private static String getResultPath(CheckBoxElements element){
        return "//div[@id='result']/span[text()='"+ element.toString()+"']";
    }
    public WebElement getResult(CheckBoxElements element){
        return driver.findElement(By.xpath(getResultPath(element)));
    }
    public WebElement getButton(CheckBoxElements element){
       return driver.findElement(By.xpath(getXPath(element)+"/../button"));
    }
    public WebElement getLabel(CheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)));
    }
    public WebElement getIconUnCheck(CheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"//*[@class='rct-icon rct-icon-uncheck']"));
    }
    public WebElement getIconSemiCheck(CheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"//*[@class='rct-icon rct-icon-half-check']"));
    }
    public WebElement getIconCheck(CheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"//*[@class='rct-icon rct-icon-check']"));
    }

    public void clickElement(CheckBoxElements element){
        getLabel(element).click();
    }
    public void openElement(CheckBoxElements element){
        getButton(element).click();
    }

    public boolean hasIconUnCheck(CheckBoxElements element){
        try {
            return getIconUnCheck(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public boolean hasIconSemiCheck(CheckBoxElements element){
        try {
            return getIconSemiCheck(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public boolean hasIconCheck(CheckBoxElements element){
        try {
            return getIconCheck(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public boolean hasResult(CheckBoxElements element){
        try {
            return getResult(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public int getCheckStatus(CheckBoxElements element){
        if(hasIconCheck(element)) return STATUS_CHEKED;
        if(hasIconSemiCheck(element)) return STATUS_SEMICHEKED;
        if(hasIconUnCheck(element)) return STATUS_UNCHEKED;
        return STATUS_NOTFOUND;
    }
    public boolean hasResults(){
        try {
            return result.isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }


}
