package pom.alerts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.APom;

public class BrowserWindowPOM extends APom {
    @FindBy(xpath = "//button[@id='tabButton']")
    public WebElement tabButton;
    @FindBy(xpath = "//button[@id='windowButton']")
    public WebElement windowButton;
    @FindBy(xpath = "//button[@id='messageWindowButton']")
    public WebElement messageWindowButton;
    public BrowserWindowPOM(WebDriver driver){
        super(driver);
    }

    public void clickTabButton(){
        goToAndClickElement(tabButton);
    }

    public void clickWindowButton(){
        goToAndClickElement(windowButton);
    }

    public void clickMessageWindowButton(){
        goToAndClickElement(messageWindowButton);
    }
}
