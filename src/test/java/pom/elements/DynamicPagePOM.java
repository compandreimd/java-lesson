package pom.elements;

import condition.Ex;
import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DynamicPagePOM extends AMenuPom {
    public static final String TEXT = "This text has random Id";
    @FindBy(xpath = "//div[@class='row']/div/div/p")
    public WebElement dynamicText;
    @FindBy(xpath = "//button[@id='enableAfter']")
    public WebElement enableAfter;
    @FindBy(xpath = "//button[@id='colorChange']")
    public WebElement colorChange;
    @FindBy(xpath = "//button[@id='visibleAfter']")
    public WebElement visibleAfter;

    Actions actions = new Actions(driver);

    public DynamicPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);
    }

    public String getDynamicText(){
        return dynamicText.getText();
    }

    public boolean hasDisplay(){
        try{
            return visibleAfter.isDisplayed();
        }
        catch(Exception ex){
            return false;
        }

    }
    public boolean isEnable(){
       return enableAfter.isEnabled();
    }
    public String color(){
        return  colorChange.getCssValue("color");
    }
    public String getColorClass(){
        return colorChange.getAttribute("color");
    }
}
