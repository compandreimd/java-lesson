package pom.elements;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPagePOM extends AMenuPom {
    public ElementsPagePOM(BaseClass baseClass) {
        super(baseClass);
    }

    @FindBy(xpath = "//div[text()='Please select an item from left to start practice.']")
    public WebElement selectDiv;

    public boolean hasSelectDIV() {
        try {
            return selectDiv.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }


}
