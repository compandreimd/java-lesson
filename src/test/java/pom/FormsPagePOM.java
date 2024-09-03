package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPagePOM {
    ChromeDriver driver;

    public FormsPagePOM(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceForm;

    public PracticeFormPagePom clickPracticeForm(){
        practiceForm.click();
        return  new PracticeFormPagePom(driver);
    }
}
