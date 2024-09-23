package pom.forms;

import core.web.AMenuPom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PracticeFormPagePOM extends AMenuPom {
    public PracticeFormPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement userEmail;
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    public WebElement genderMale;
    @FindBy(xpath = "//label[@for='gender-radio-2']")
    public WebElement genderFemale;
    @FindBy(xpath = "//label[@for='gender-radio-3']")
    public WebElement genderOther;
    @FindBy(xpath = "//input[@id='userNumber']")
    public WebElement userNumber;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    public WebElement dateOfBirthInput;
    @FindBy(xpath = "//input[@id='subjectsInput']")
    public WebElement subjectsInput;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    public WebElement hobbySport;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    public WebElement hobbyReading;
    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    public WebElement hobbyMusic;
    @FindBy(xpath = "//input[@id='uploadPicture']")
    public WebElement uploadPicture;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement currentAddress;
    @FindBy(xpath = "//div[@id='state']")
    public WebElement state;
    @FindBy(xpath = "//div[@id='city']")
    public WebElement city;
    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submit;
    @FindBy(xpath = "//table[contains(@class, 'table')]//tbody/tr")
    public List<WebElement> lines;

    public String setFirstName(String value){
        firstName.sendKeys(value);
       return value;
    }

    public String setLastName(String value){
        lastName.sendKeys(value);
        return value;
    }

    public String setEmail(String value){
        userEmail.sendKeys(value);
        return value;
    }

    public enum Gender {
        Male, Female, Other   ;
    }

    public Gender setGender(Gender gender){
        WebElement element = switch (gender){
            case Male -> genderMale;
            case Female -> genderFemale;
            case Other ->  genderOther;
        };
        element.click();
        return gender;
    }

    public String setPhone(String value){
        userNumber.sendKeys(value);
        return value;
    }

    public Calendar setBirth(Calendar calendar){
        dateOfBirthInput.sendKeys(" ");
        Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
        month.selectByIndex(calendar.get(Calendar.MONTH));
        Select year = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
        year.selectByValue(calendar.get(Calendar.YEAR)+"");
        String day = "0";
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        if(date < 10){
            day += "0";
        }
        day += (date + "");
        driver.findElement(By.xpath("//div[contains(@class, 'react-datepicker__day--"+day+"') and not(contains(@class, 'react-datepicker__day--outside-month'))]")).click();
        return calendar;
    }

    public String setSubject(String value){
        subjectsInput.sendKeys(value);
        subjectsInput.sendKeys(Keys.ENTER);
        return value;
    }

    public enum Hobby {
        Sport,
        Reading,
        Music
    }

    public Hobby[] clickHobbies(Hobby[] hobby){
        goToElement(hobbySport);
        Arrays.stream(hobby).forEach(h -> {
            switch (h){
                case Sport -> hobbySport.click();
                case Music -> hobbyMusic.click();
                case Reading -> hobbyReading.click();
            }
        });
        return hobby;
    }

    public File sendImage(File file){
        uploadPicture.sendKeys(file.getAbsolutePath());
        return file;
    }

    public String setCurrentAddress(String value) {
        currentAddress.sendKeys(value);
        return value;
    }

    public String setState(int position){
        state.click();
        var element = driver.findElement(By.xpath("//div[@id='react-select-3-option-"+position+"']"));
        String text = element.getText();
        element.click();
        return text;
    }

    public String setCity(int position){
        city.click();
        var element = driver.findElement(By.xpath("//div[@id='react-select-4-option-"+position+"']"));
        String text = element.getText();
        element.click();
        return text;
    }

    public void clickSubmit(){
        goToElement(submit);
        submit.click();
    }
    public String formGetValue(int index){
       return lines.get(index).findElements(By.xpath("./td")).get(1).getText();
    }
}
