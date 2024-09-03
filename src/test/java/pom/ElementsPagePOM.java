package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ElementsPagePOM {
    ChromeDriver driver;

    public ElementsPagePOM(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Text Box']")
    public WebElement textBox;

    public TextBoxPagePOM clickTextBox(){
        textBox.click();
        return  new TextBoxPagePOM(driver);
    }


}
