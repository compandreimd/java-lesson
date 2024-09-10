package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.alerts.BrowserWindowPOM;


public class SamplePagePOM extends APom {

    public static final String CONTENT = "This is a sample page";
    public SamplePagePOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement content;

    public String getContent(){
        return content.getText();
    }

}
