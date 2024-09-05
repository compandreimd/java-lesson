package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPagePOM extends APom{

    public FormsPagePOM(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    public WebElement practiceForm;

    public PracticeFormPagePom clickPracticeForm(){
        practiceForm.click();
        waiter.until(d -> d.findElements(new By.ByTagName("body")));
        return  new PracticeFormPagePom(driver);
    }
}
