package pom;

import core.web.APom;
import core.web.BaseClass;
import data.enums.EItem;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pom.alerts.AlertsFrameWindowPOM;
import pom.elements.ElementsPagePOM;
import pom.forms.FormPagePOM;
import utils.ReadConfig;

public class MainPagePOM  extends APom {
    public static final By BODY = By.xpath("//body");
    public static final String URL = ReadConfig.getInstance().getValue("URL");
    public static final String IMAGE = "https://demoqa.com/images/Toolsqa.jpg";
    public static final String BANNER_URL = "https://www.toolsqa.com/selenium-training/";
    public static final String BANNER_IMAGE = "https://demoqa.com/images/WB.svg";
    public MainPagePOM(BaseClass baseClass) {
        super(baseClass);
    }
    @FindBy(xpath = "//header/a")
    public WebElement header;
    @FindBy(xpath = "//header/a/img")
    public WebElement headerImage;
    @FindBy(xpath = "//div[@class='home-banner']/a")
    public WebElement banner;
    @FindBy(xpath = "//div[@class='home-banner']/a/img")
    public WebElement bannerImage;
    public boolean displayedCard(@NotNull EItem item){
        return  displayedElement(item.xPathCard());
    }
    public WebElement getCard(@NotNull EItem item){
        return  getElement(item.xPathCard());
    }
    public APom clickCard(@NotNull EItem item) {
        WebElement card = getCard(item);
        goToElement(card);
        card.click();
        return switch (item){
            case Elements -> new ElementsPagePOM(base);
            case Forms -> new FormPagePOM(base);
            case AlertsFrameWindow -> new AlertsFrameWindowPOM(base);
            default -> null;
        };
    }

}
