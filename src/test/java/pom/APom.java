package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class APom {
    protected WebDriver driver;
    protected WebDriverWait waiter;
    public APom(WebDriver driver){
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(120));
        PageFactory.initElements(driver, this);
    }
}
