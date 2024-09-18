package core.web;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class APom {

    protected WebDriver driver;
    protected WebDriverWait waiter;
    protected BaseClass base;
    public APom(@NotNull BaseClass baseClass){
        base = baseClass;
        waiter = baseClass.getWaiter();
        driver = baseClass.getDriver();
        PageFactory.initElements(driver, this);

    }
    protected void goToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }
    protected WebElement getElement(By locator){
       return driver.findElement(locator);
    }
    protected List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }
    protected WebElement getElement(String xpath){
        return getElement(By.xpath(xpath));
    }
    protected List<WebElement> getElements(String xpath){
        return getElements(By.xpath(xpath));
    }
    protected boolean displayedElement(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }
    protected boolean displayedElement(String xpath){
        return displayedElement(By.xpath(xpath));
    }


}
