package pom.alerts;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsFrameWindowPOM extends AMenuPom {

    public AlertsFrameWindowPOM(@NotNull BaseClass baseClass) {
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