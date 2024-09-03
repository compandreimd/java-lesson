package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TextBoxPagePOM {
    ChromeDriver driver;

    public TextBoxPagePOM(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement userName;
    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmail;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement currentAddress;
    @FindBy(xpath = "//textarea[@id='permanentAddress']")
    public WebElement permanentAddress;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submit;
    @FindBy(xpath = "//p[@id='name']")
    public WebElement checkName;
    @FindBy(xpath = "//p[@id='email']")
    public WebElement checkEmail;
    @FindBy(xpath = "//p[@id='currentAddress']")
    public WebElement checkCurrentAddress;
    @FindBy(xpath = "//p[@id='permanentAddress']")
    public WebElement checkPermanentAddress;

    public void clickSumit(){
        submit.click();
    }

    public String sendKeysUserName(String value) {
        userName.sendKeys(value);
        return value;
    }

    public String sendKeysUserEmail(String value) {
        userEmail.sendKeys(value);
        return value;
    }

    public String sendKeysCurrentAddress(String value) {
        currentAddress.sendKeys(value);
        return value;
    }

    public String  sendKeysPermanent(String value) {
        permanentAddress.sendKeys(value);
        return value;
    }

    public String getTextName(){
        return checkName.getText();
    }

    public String getTextEmail(){
        return checkEmail.getText();
    }
    public String getTextCurrentAddress(){
        return checkCurrentAddress.getText();
    }
    public String getTextPermanentAddress(){
        return checkPermanentAddress.getText();
    }

    public boolean hasName(){
        try {
            return  checkName.isDisplayed();
        }
        catch (Exception ex){
            return  false;
        }
    }
    public boolean hasEmail(){
        try {
            return  checkEmail.isDisplayed();
        }
        catch (Exception ex){
            return  false;
        }
    }

    public boolean hasAddress(){
        try {
            return  checkEmail.isDisplayed();
        }
        catch (Exception ex){
            return  false;
        }
    }

    public boolean hasPermanent(){
        try {
            return  checkEmail.isDisplayed();
        }
        catch (Exception ex){
            return  false;
        }
    }
}
