package pom.elements;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ButtonPagePOM extends AMenuPom {
    public static final String doubleClickMessage = "You have done a double click";
    public static final String rightClickMessage = "You have done a right click";
    public static final String clickMessage = "You have done a dynamic click";
    @FindBy(xpath = "//button[@id='doubleClickBtn']")
    public WebElement doubleClickBtn;
    @FindBy(xpath = "//button[@id='rightClickBtn']")
    public WebElement rightClickBtn;
    @FindBy(xpath = "//button[text()='Click Me']")
    public WebElement clickBtn;
    @FindBy(xpath = "//p[@id='doubleClickMessage']")
    public WebElement doubleClickMsg;
    @FindBy(xpath = "//p[@id='rightClickMessage']")
    public WebElement rightClickMsg;
    @FindBy(xpath = "//p[@id='dynamicClickMessage']")
    public WebElement clickMsg;

    Actions actions = new Actions(driver);

    public ButtonPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);
    }
    public void clickDouble(){
        goToElement(doubleClickBtn);
        actions.doubleClick(doubleClickBtn).perform();
    }
    public void clickRight(){
        goToElement(rightClickBtn);
        actions.contextClick(rightClickBtn).perform();
    }
    public void click(){
        goToElement(clickBtn);
        clickBtn.click();
    }

    public String getTextDouble(){
        try {
            return doubleClickMsg.getText();
        }
        catch (Exception ex){
            return null;
        }
    }
    public String getTextRight(){
        try {
            return rightClickMsg.getText();
        }
        catch (Exception ex){
            return null;
        }
    }
    public String getTextClick(){
        try {
            return clickMsg.getText();
        }
        catch (Exception ex){
            return null;
        }
    }
}
