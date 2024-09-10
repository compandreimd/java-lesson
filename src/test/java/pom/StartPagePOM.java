package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPagePOM extends APom {
    public StartPagePOM(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elements;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement forms;

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    public WebElement alerts;

    public ElementsPagePOM clickElements(){
        elements.click();
        waiter.until(d -> d.findElements(new By.ByTagName("body")));
        return  new ElementsPagePOM(driver);
    }

    public FormsPagePOM clickForms(){
        goToElement(forms);
        forms.click();
        return  new FormsPagePOM(driver);
    }

    public AlertsPagePOM clickAlerts(){
        goToElement(alerts);
        alerts.click();
        return  new AlertsPagePOM(driver);
    }

}
