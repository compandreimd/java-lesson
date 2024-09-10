package pom.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.APom;

public class RadioBoxPagePOM extends APom {
    @FindBy(xpath = "//p[@class='mt-3']")
    WebElement result;
    @FindBy(xpath = "//label[@for='yesRadio']")
    WebElement yes;
    @FindBy(xpath = "//label[@for='impressiveRadio']")
    WebElement impressive;
    @FindBy(xpath = "//label[@for='noRadio']")
    WebElement no;

    public void click(int index){
        WebElement element = switch (index)
        {
            case 1 -> yes;
            case 0 -> no;
            default -> impressive;
        };
        goToElement(element);
        element.click();
    }
    public RadioBoxPagePOM(WebDriver driver){
        super(driver);
    }
}
