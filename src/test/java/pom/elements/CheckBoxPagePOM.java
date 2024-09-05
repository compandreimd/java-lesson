package pom;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPagePOM {
    ChromeDriver driver;

    public CheckBoxPagePOM(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
