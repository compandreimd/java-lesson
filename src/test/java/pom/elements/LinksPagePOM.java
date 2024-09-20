package pom.elements;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LinksPagePOM extends AMenuPom {
    @FindBy(xpath = "//a[@id='simpleLink']")
    public WebElement simpleLink;
    @FindBy(xpath = "//a[@id='dynamicLink']")
    public WebElement dynamicLink;
    @FindBy(xpath = "//a[@id='created']")
    public WebElement created;
    @FindBy(xpath = "//a[@id='moved']")
    public WebElement moved;
    @FindBy(xpath = "//a[@id='unauthorized']")
    public WebElement unauthorized;
    @FindBy(xpath = "//a[@id='forbidden']")
    public WebElement forbidden;
    @FindBy(xpath = "//a[@id='invalid-url']")
    public WebElement invalidURL;
    @FindBy(xpath = "//p[@id='linkResponse']")
    public WebElement linkResponse;

    public LinksPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);
    }

    public void click(String id){
        WebElement element = switch (id){
            case "simpleLink" -> simpleLink;
            case "dynamicLink" -> dynamicLink;
            case "created" -> created;
            case "moved" -> moved;
            case "unauthorized" -> unauthorized;
            case "forbidden" -> forbidden;
            case "invalid-url" -> invalidURL;
            default -> driver.findElement(By.xpath("//*[@id='"+id+"']"));
        };
        goToElement(element);
        element.click();
    }

    public String getResponseDefault(String id){
        return switch (id){
            case "created" -> "Link has responded with staus 201 and status text Created";
            case "moved" -> "Link has responded with staus 301 and status text Moved Permanently";
            case "unauthorized" -> "Link has responded with staus 401 and status text Unauthorized";
            case "forbidden" -> "Link has responded with staus 403 and status text Forbidden";
            case "invalid-url" -> "Link has responded with staus 404 and status text Not Found";
            default -> null;
        };
    }
    public String getLinkResponse(){
        return linkResponse.getText();
    }
}
