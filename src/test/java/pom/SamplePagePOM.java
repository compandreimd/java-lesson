package pom;

import core.web.APom;
import core.web.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SamplePagePOM extends APom {

    public static final String CONTENT = "This is a sample page";
    public SamplePagePOM(BaseClass driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1")
    public WebElement content;

    public String getContent(){
        return content.getText();
    }

}
