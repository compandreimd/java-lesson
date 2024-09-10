package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.alerts.BrowserWindowPOM;
import pom.elements.CheckBoxPagePOM;
import pom.elements.RadioBoxPagePOM;
import pom.elements.TextBoxPagePOM;


public class AlertsPagePOM extends APom {

    public AlertsPagePOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindows;


    public BrowserWindowPOM clickBrowserWindows(){
        goToElement(browserWindows);
        browserWindows.click();
        waiter.until(d -> d.findElements(new By.ByTagName("body")));
        return  new BrowserWindowPOM(driver);
    }


}
