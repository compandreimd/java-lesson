package pom.alerts;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ReadConfig;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BrowserPagePOM extends AMenuPom {
    public static final String SAMPLE_URL = ReadConfig.getInstance().getValue("URL")+"sample";
    public static final String MSG_CONTENT = "<html><head></head><body>Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.</body></html>";
    public static final String MessageWindowButton = "//button[@id='messageWindowButton']";
    public BrowserPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);
    }
    @FindBy(xpath = "//button[@id='tabButton']")
    public WebElement tabButton;
    @FindBy(xpath = "//button[@id='windowButton']")
    public WebElement windowButton;
    @FindBy(xpath = MessageWindowButton)
    public WebElement messageWindowButton;

    public void clickTabButton(){
        goToElement(tabButton);
        tabButton.click();
    }
    public void clickWindowButton(){
        goToElement(windowButton);
        windowButton.click();
    }
    public void clickMessageWindowButton(){
        goToElement(messageWindowButton);
        messageWindowButton.click();
    }
}
