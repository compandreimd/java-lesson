package tests.web;

import core.web.BaseClass;
import org.testng.annotations.Test;
import utils.ReadConfig;

public class DemoTest extends BaseClass {
    @Test
    public void setupDriver(){

    }

    @Test
    public void openWeb(){
        driver.get(ReadConfig.getInstance().getValue("URL"));
    }

}
