package pom.elements;

import core.web.AMenuPom;
import core.web.BaseClass;
import data.enums.ECheckBoxElements;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckPagePOM extends AMenuPom {
    public CheckPagePOM(BaseClass baseClass) {
        super(baseClass);
    }
    public static final int STATUS_CHEKED = 10;
    public static final int STATUS_UNCHEKED = 0;
    public static final int STATUS_SEMICHEKED = 5;
    public static final int STATUS_NOTFOUND = -1;

    @FindBy(xpath = "//div[@id='result']")
    public WebElement result;
    @Contract(pure = true)
    private static @NotNull String getXPath(ECheckBoxElements element) {
        return "//label[@for='tree-node-"+element.toString()+"']";
    }
    private static String getResultPath(ECheckBoxElements element){
        return "//div[@id='result']/span[text()='"+ element.toString()+"']";
    }
    public WebElement getResult(ECheckBoxElements element){
        return driver.findElement(By.xpath(getResultPath(element)));
    }
    public WebElement getButton(ECheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"/../button"));
    }
    public WebElement getLabel(ECheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)));
    }
    public WebElement getIconUnCheck(ECheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"//*[@class='rct-icon rct-icon-uncheck']"));
    }
    public WebElement getIconSemiCheck(ECheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"//*[@class='rct-icon rct-icon-half-check']"));
    }
    public WebElement getIconCheck(ECheckBoxElements element){
        return driver.findElement(By.xpath(getXPath(element)+"//*[@class='rct-icon rct-icon-check']"));
    }

    public void clickElement(ECheckBoxElements element){
        getLabel(element).click();
    }
    public void openElement(ECheckBoxElements element){
        getButton(element).click();
    }

    public boolean hasIconUnCheck(ECheckBoxElements element){
        try {
            return getIconUnCheck(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public boolean hasIconSemiCheck(ECheckBoxElements element){
        try {
            return getIconSemiCheck(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public boolean hasIconCheck(ECheckBoxElements element){
        try {
            return getIconCheck(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public boolean hasResult(ECheckBoxElements element){
        try {
            return getResult(element).isDisplayed();
        }
        catch (Exception ex){
            return false;
        }
    }
    public int getCheckStatus(ECheckBoxElements element){
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
