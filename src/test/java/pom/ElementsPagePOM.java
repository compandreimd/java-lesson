package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.elements.CheckBoxPagePOM;
import pom.elements.TextBoxPagePOM;


public class ElementsPagePOM extends APom {

    public ElementsPagePOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBox;

    @FindBy(xpath = "//span[text()='Check Box']")
    public WebElement checkBox;

    public TextBoxPagePOM clickTextBox(){
        textBox.click();
        waiter.until(d -> d.findElements(new By.ByTagName("body")));
        return  new TextBoxPagePOM(driver);
    }

    public CheckBoxPagePOM clickCheckBox(){
        checkBox.click();
        waiter.until(d -> d.findElements(new By.ByTagName("body")));
        return  new CheckBoxPagePOM(driver);
    }


}
