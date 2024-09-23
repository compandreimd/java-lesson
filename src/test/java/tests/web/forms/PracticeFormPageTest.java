package tests.web.forms;

import core.web.BaseClass;
import data.enums.EItem;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ElementsPagePOM;
import pom.elements.WebTablesPagePOM;
import pom.forms.FormPagePOM;
import pom.forms.PracticeFormPagePOM;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

import static pom.MainPagePOM.URL;

public class PracticeFormPageTest extends BaseClass {
    PracticeFormPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (PracticeFormPagePOM) ((FormPagePOM) mainPOM
                .clickCard(EItem.Forms))
                .clickItemMenu(EItem.PracticeForm);
    }

    public void check(String a, String b){
        System.out.println(a);
        System.out.println(b);

    }
    @Test
    public void practiceForm(){
        String name = pom.setFirstName("FN") + " " + pom.setLastName("LN");
        String email = pom.setEmail("red@alert.com");
        String gender = pom.setGender(PracticeFormPagePOM.Gender.Male).toString();
        String phone = pom.setPhone("0123456789");
        SimpleDateFormat sdf =new SimpleDateFormat("dd MMMM,yyyy", Locale.ENGLISH);
        Calendar calendar = new GregorianCalendar(1987, Calendar.APRIL, 20, 4, 0);
        String date =  sdf.format(pom.setBirth(calendar).getTime());
        String subj = pom.setSubject("Maths");
        subj += ", "+ pom.setSubject("English");
        pom.clickHobbies(new PracticeFormPagePOM.Hobby[]{
           PracticeFormPagePOM.Hobby.Reading, PracticeFormPagePOM.Hobby.Sport
        }).toString();
        String hobies = "Reading, Sports";
        pom.goToElement(pom.uploadPicture);
        pom.sendImage(new File("src/test/resources/sampleFile.jpeg"));
        String file = "sampleFile.jpeg";
        String address = pom.setCurrentAddress("CA");
        String stateCity = pom.setState(2) + " " + pom.setCity(1);
        pom.clickSubmit();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        softAssert.assertEquals(pom.formGetValue(0), name);
        softAssert.assertEquals(pom.formGetValue(1), email);
        softAssert.assertEquals(pom.formGetValue(2), gender);
        softAssert.assertEquals(pom.formGetValue(3), phone);
        softAssert.assertEquals(pom.formGetValue(4), date);
        softAssert.assertEquals(pom.formGetValue(5), subj);
        softAssert.assertEquals(pom.formGetValue(6), hobies);
        softAssert.assertEquals(pom.formGetValue(7), file);
        softAssert.assertEquals(pom.formGetValue(8), address);
        softAssert.assertEquals(pom.formGetValue(9), stateCity);

        softAssert.assertAll();
    }

    @Test
    public void formsShowMenuTest() {
        Arrays.stream(EItem.FORMS).forEach(eItem -> {
            softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), true, "Menu Displayed " + eItem.name());
            pom.clickItemMenu(eItem);
            softAssert.assertEquals(driver.getCurrentUrl(), URL + eItem.getPath(), "Redirect menu url for " + eItem.name());
            driver.navigate().back();
        });
        Stream.concat(Stream.concat(Stream.concat(
                                        Arrays.stream(EItem.ELEMENTS),
                                        Arrays.stream(EItem.ALERTS)),
                                Stream.concat(
                                        Arrays.stream(EItem.WIDGETS),
                                        Arrays.stream(EItem.INTERACTIONS))),
                        Arrays.stream(EItem.BOOK))
                .forEach(eItem -> {
                    softAssert.assertEquals(pom.getItemMenu(eItem).isDisplayed(), false, "Menu Displayed " + eItem.toString());

                });
        softAssert.assertAll();
    }


}
