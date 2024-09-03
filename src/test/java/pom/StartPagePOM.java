package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPagePOM {
    ChromeDriver driver;
    public StartPagePOM(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[text()='Elements']")
    public WebElement elements;

    @FindBy(xpath = "//h5[text()='Forms']")
    public WebElement forms;

    public ElementsPagePOM clickElements(){
        elements.click();
        return  new ElementsPagePOM(driver);
    }

    public FormsPagePOM clickForms(){
        forms.click();
        return  new FormsPagePOM(driver);
    }

}
