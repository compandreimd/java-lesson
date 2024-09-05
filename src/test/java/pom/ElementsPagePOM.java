package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.elements.CheckBoxPagePOM;
import pom.elements.TextBoxPagePOM;


public class ElementsPagePOM {
    ChromeDriver driver;

    public ElementsPagePOM(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBox;

    @FindBy(xpath = "//span[text()='Check Box']")
    public WebElement checkBox;

    public TextBoxPagePOM clickTextBox(){
        textBox.click();
        return  new TextBoxPagePOM(driver);
    }

    public CheckBoxPagePOM clickCheckBox(){
        checkBox.click();
        return  new CheckBoxPagePOM(driver);
    }


}
