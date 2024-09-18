package pom.elements;

import condition.Ex;
import core.web.AMenuPom;
import core.web.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioPagePOM extends AMenuPom {
    public RadioPagePOM(BaseClass baseClass) {
        super(baseClass);
    }

    @FindBy(xpath = "//input[@id='yesRadio']")
    public WebElement yesRadio;
    @FindBy(xpath = "//input[@id='impressiveRadio']")
    public WebElement impressiveRadio;
    @FindBy(xpath = "//input[@id='noRadio']")
    public WebElement noRadio;
    @FindBy(xpath = "//label[@for='yesRadio']")
    public WebElement yesRadioLabel;
    @FindBy(xpath = "//label[@for='impressiveRadio']")
    public WebElement impressiveRadioLabel;
    @FindBy(xpath = "//label[@for='noRadio']")
    public WebElement noRadioLabel;
    @FindBy(xpath = "//span[@class='text-success']")
    public WebElement textSucces;

    public void clickYesRadio(){
        yesRadioLabel.click();
    }
    public void clickNoRadio(){
        noRadioLabel.click();
    }
    public void clickImpressiveRadio(){
        impressiveRadioLabel.click();
    }
    public boolean yesIsSelected(){
        return yesRadio.isSelected();
    }
    public boolean noIsSelected(){
        return noRadio.isSelected();
    }
    public boolean impressiveIsSelected(){
        return impressiveRadio.isSelected();
    }
    public boolean yesIsDisabled(){
        return !yesRadio.isEnabled();
    }
    public boolean noIsDisabled(){return !noRadio.isEnabled();}
    public boolean impressiveIsDisabled(){
        return !impressiveRadio.isEnabled();
    }
    public boolean displayedTextSuccess(){
        try {
            return textSucces.isDisplayed();
        }
        catch (Exception ex){
            return  false;
        }
    }
    public String getTextSuccess(){
        return textSucces.getText();
    }
}
