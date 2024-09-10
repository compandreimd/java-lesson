package tests.web.elements;

import core.web.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.StartPagePOM;
import pom.elements.RadioBoxPagePOM;
import utils.ReadConfig;

public class RadioBoxTests extends BaseClass {

    RadioBoxPagePOM radioBoxPagePOM;
    @BeforeMethod
    public void initCheckBox(){
        driver.get(ReadConfig.getInstance().getValue("URL"));
        StartPagePOM startPagePOM = new StartPagePOM(driver);
        radioBoxPagePOM = startPagePOM.clickElements().clickRadioButton();
    }
    @Test
    public void op0en() throws InterruptedException {
        radioBoxPagePOM.click(1);
        Thread.sleep(1000);
    }
}
