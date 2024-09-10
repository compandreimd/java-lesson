package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class APom {
    protected WebDriver driver;
    protected WebDriverWait waiter;
    protected Actions action;

    protected void goToElement(WebElement element){
        getJSExecuter().executeScript("arguments[0].scrollIntoView(true)", element);
    }

    protected void goToAndClickElement(WebElement element){
        goToElement(element);
        element.click();
    }
    public APom(WebDriver driver){
        this.driver = driver;
        this.action = new Actions(driver);
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(120));
        PageFactory.initElements(driver, this);
    }
    public JavascriptExecutor getJSExecuter(){
        return (JavascriptExecutor) driver;
     }

     public String getCurrentPageHash(){
         return driver.getWindowHandle();
     }

     public Set<String> getPages(){
        return driver.getWindowHandles().stream().map(Objects::toString).collect(Collectors.toSet());
     }

     public Set<String> getNewPages(Set<String> old){
        return getPages().stream().filter(s -> !old.contains(s)).collect(Collectors.toSet());
     }
}
