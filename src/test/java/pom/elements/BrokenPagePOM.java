package pom.elements;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenPagePOM extends AMenuPom {
    @FindBy(xpath = "//div[@class='row']//img")
    public List<WebElement> images;
    @FindBy(xpath = "//div[@class='row']//a")
    public List<WebElement> links;
    public BrokenPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);
    }

    public boolean imageIsDisplayed(int index){
        return (Boolean) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].complete && " +
                        "typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
                        images.get(index));
    }

    public void click(int index){
        WebElement element = links.get(index);
        goToElement(element);
        element.click();
    }

    public int statusCode() throws IOException {
        HttpURLConnection cont=
                (HttpURLConnection)new URL(driver.getCurrentUrl())
                        .openConnection();
        // pass HEAD as parameter to setRequestMethod
        cont.setRequestMethod("HEAD");
        // obtain Response code
        cont.connect();
        int rs = cont.getResponseCode();
        cont.disconnect();
        return  rs;
    }

}
