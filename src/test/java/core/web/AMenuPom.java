package core.web;

import data.enums.EItem;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import pom.elements.*;
import pom.forms.PracticeFormPagePOM;

public class AMenuPom  extends APom{
    public AMenuPom(@NotNull BaseClass baseClass) {
        super(baseClass);
    }
    public WebElement getItemMenu(@NotNull EItem item){
        return getElement(item.xPathMenu());
    }
    public APom clickItemMenu(@NotNull EItem item){
        WebElement element = getElement(item.xPathMenu());
        goToElement(element);
        element.click();
        return switch (item){
            case TextBox -> new TextBoxPagePOM(base);
            case CheckBox -> new CheckPagePOM(base);
            case RadioButton -> new RadioPagePOM(base);
            case WebTables -> new WebTablesPagePOM(base);
            case Buttons -> new ButtonPagePOM(base);
            case Links -> new LinksPagePOM(base);
            case BrokenLinks ->  new BrokenPagePOM(base);
            case UploadDownload -> new UploadDownloadPagePOM(base);
            case Dynamic -> new DynamicPagePOM(base);
            case PracticeForm -> new PracticeFormPagePOM(base);
            default -> null;
        };
    }
}
