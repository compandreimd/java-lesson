package tests.web.elements;

import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ElementsPagePOM;
import pom.elements.WebTablesPagePOM;

import java.util.Arrays;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;
import static pom.elements.WebTablesPagePOM.*;

public class WebTablesPageTest extends BaseClass {
    WebTablesPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (WebTablesPagePOM) ((ElementsPagePOM) mainPOM
                .clickCard(EItem.Elements))
                .clickItemMenu(EItem.WebTables);
    }


    @Test
    void elementShowMenuTest() {
        Arrays.stream(EItem.ELEMENTS).forEach(eItem -> {
            softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), true, "Menu Displayed " + eItem.name());
            pom.clickItemMenu(eItem);
            softAssert.assertEquals(driver.getCurrentUrl(), URL + eItem.getPath(), "Redirect menu url for " + eItem.name());
            driver.navigate().back();
        });
        Stream.concat(Stream.concat(Stream.concat(Arrays.stream(EItem.FORMS),
                                        Arrays.stream(EItem.ALERTS)),
                                Stream.concat(Arrays.stream(EItem.WIDGETS), Arrays.stream(EItem.INTERACTIONS))),
                        Arrays.stream(EItem.BOOK))
                .forEach(eItem -> {
                    softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), false, "Menu Displayed " + eItem.toString());

                });
        softAssert.assertAll();
    }

    @Test
    void webTablesPageTest(){
         softAssert.assertEquals(pom.headers.size(),HEADERS.length, "Count header");
        int pages = pom.getPageValue();
        softAssert.assertEquals(pages, DEFAULT_PAGE_SIZE, "Select page size");
        softAssert.assertEquals(pages, pom.getRows().size(), "Showed Rows Size");
        int i = 0;
        for (;i < DEFAULT_ROWS.length ; i++)
            softAssert.assertEquals(pom.getRows().get(i).toString(),DEFAULT_ROWS[i].toString(), "Row " + i + " it's not same!");
        for(; i < pages; i++)
            softAssert.assertEquals(pom.getRows().get(i).toString(), EMPTY_ROW.toString(), "Row " + i + " it's not same!");
        softAssert.assertEquals(pom.isDisabledNext(), true, "Disable next");
        softAssert.assertEquals(pom.isDisabledPrev(), true, "Disable previous");
        softAssert.assertEquals(pom.getTotalPages(), "1", "Total Pages");
        softAssert.assertEquals(pom.getCurrentPage(), "1", "Current Page");

        int rnd = (int)Math.floor(Math.random() * pom.getPageOptions().size());
        pages = pom.choosePageOption(pom.getPageOptions().get(rnd));
        softAssert.assertEquals(pages, pom.getRows().size(), "Changed Rows Size");
        i = 0;
        for (;i < DEFAULT_ROWS.length ; i++)
            softAssert.assertEquals(pom.getRows().get(i).toString(),DEFAULT_ROWS[i].toString(), "Row " + i + " it's not same as change!");
        for(; i < pages; i++)
            softAssert.assertEquals(pom.getRows().get(i).toString(), EMPTY_ROW.toString(), "Row " + i + " something added!");
        softAssert.assertEquals(pom.isDisabledNext(), true, "Disable next");
        softAssert.assertEquals(pom.isDisabledPrev(), true, "Disable previous");
        softAssert.assertEquals(pom.getTotalPages(), "1", "Total Pages");
        softAssert.assertEquals(pom.getCurrentPage(), "1", "Current Page");
        pages = pom.choosePageOption(pom.getPageOptions().get(0));
        softAssert.assertEquals(pages, pom.getRows().size(), "Changed Rows Size");
        i = 0;
        for (;i < DEFAULT_ROWS.length ; i++)
            softAssert.assertEquals(pom.getRows().get(i).toString(),DEFAULT_ROWS[i].toString(), "Row " + i + " it's not same as change!");
        for(; i < pages; i++)
            softAssert.assertEquals(pom.getRows().get(i).toString(), EMPTY_ROW.toString(), "Row " + i + " something added!");
        softAssert.assertEquals(pom.isDisabledNext(), true, "Disable next");
        softAssert.assertEquals(pom.isDisabledPrev(), true, "Disable previous");
        softAssert.assertEquals(pom.getTotalPages(), "1", "Total Pages");
        softAssert.assertEquals(pom.getCurrentPage(), "1", "Current Page");
        var row = new Row();
        row
                .setFirstName("A"+Math.random())
                .setLastName("A"+Math.random())
                .setAge("100"+Math.random())
                .setUserEmail("aed@alert.com"+Math.random())
                .setSalary("1200"+Math.random())
                .setDepartment("ADEP"+Math.random());
        pom.clickAdd().submit(row) ;
        softAssert.assertEquals(pom.getRows().get(3).toString(),row.toString(), "New Row" + 4 + " it's not same as change!");
        softAssert.assertAll();
    }
}
