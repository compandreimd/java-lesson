package pom.elements;

import core.web.AMenuPom;
import core.web.APom;
import core.web.BaseClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class WebTablesPagePOM extends AMenuPom {
    public static class Row {
        private @Nullable String firstName;
        private String lastName;
        private String userEmail;
        private String age;
        private String salary;
        private String department;

        public Row() {
        }

        public Row(String firstName, String lastName, String userEmail, String age, String salary, String department) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.userEmail = userEmail;
            this.age = age;
            this.salary = salary;
            this.department = department;
        }

        public String getFirstName() {
            return firstName;
        }

        public Row setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public Row setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public Row setUserEmail(String userEmail) {
            this.userEmail = userEmail;
            return this;
        }

        public String getAge() {
            return age;
        }

        public Row setAge(String age) {
            this.age = age;
            return this;
        }

        public String getSalary() {
            return salary;
        }

        public Row setSalary(String salary) {
            this.salary = salary;
            return this;
        }

        public String getDepartment() {
            return department;
        }

        public Row setDepartment(String department) {
            this.department = department;
            return this;
        }

        private String getDefaultOrValue(String value) {
            if (value == null) return " ";
            return value;
        }

        @Override
        public String toString() {
            return getDefaultOrValue(firstName) + ","
                    + getDefaultOrValue(lastName) + ","
                    + getDefaultOrValue(age) + ","
                    + getDefaultOrValue(userEmail) + ","
                    + getDefaultOrValue(salary) + ","
                    + getDefaultOrValue(department);

        }
    }

    public static class RegistrationForm extends APom {
        @FindBy(xpath = "//input[@id='firstName']")
        public WebElement firstName;
        @FindBy(xpath = "//input[@id='lastName']")
        public WebElement lastName;
        @FindBy(xpath = "//input[@id='userEmail']")
        public WebElement userEmail;
        @FindBy(xpath = "//input[@id='age']")
        public WebElement age;
        @FindBy(xpath = "//input[@id='salary']")
        public WebElement salary;
        @FindBy(xpath = "//input[@id='department']")
        public WebElement department;
        @FindBy(xpath = "//button[@id='submit']")
        public WebElement submit;

        public RegistrationForm(@NotNull WebTablesPagePOM parent) {
            super(parent.base);
        }

        public void submit(@NotNull Row row) {
            if (row.firstName != null)
                firstName.sendKeys(row.firstName);
            if (row.lastName != null)
                lastName.sendKeys(row.lastName);
            if (row.userEmail != null)
                userEmail.sendKeys(row.userEmail);
            if (row.age != null)
                age.sendKeys(row.age);
            if (row.salary != null)
                salary.sendKeys(row.salary);
            if (row.department != null)
                department.sendKeys(row.department);
            submit.click();
        }

    }

    public static final String[] HEADERS = {
            "First Name",
            "Last Name",
            "Age",
            "Email",
            "Salary",
            "Department",
            "Action"
    };

    public static final Row[] DEFAULT_ROWS = {
            new Row("Cierra", "Vega",
                    "cierra@example.com", "39", "10000", "Insurance"),
            new Row("Alden", "Cantrell",
                    "alden@example.com", "45", "12000", "Compliance"),
            new Row("Kierra", "Gentry",
                    "kierra@example.com", "29", "2000", "Legal")
    };

    public static final int DEFAULT_PAGE_SIZE = 10;
    public static final Row EMPTY_ROW = new Row();

    public WebTablesPagePOM(BaseClass baseClass) {
        super(baseClass);
    }

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    public WebElement addNewRecord;
    public RegistrationForm registrationForm = new RegistrationForm(this);
    @FindBy(xpath = "//button[@id='searchBox']")
    public WebElement searchBox;
    @FindBy(xpath = "//div[@role='columnheader']")
    public List<WebElement> headers;

    @FindBy(xpath = "//span[@class='select-wrap -pageSizeOptions']/select")
    public WebElement pageSizeSelect;
    @FindBy(xpath = "//div[@class='-previous']/button")
    public WebElement previous;
    @FindBy(xpath = "//div[@class='-next']/button")
    public WebElement next;
    @FindBy(xpath = "//div[@class='-pageJump']/input")
    public WebElement pageJump;
    @FindBy(xpath = "//span[@class='-totalPages']")
    public WebElement totalPages;
    private Select select;

    public Select getPageSelect() {
        if (select == null)
            select = new Select(pageSizeSelect);
        return select;
    }

    public int getPageValue() {
        Select select = getPageSelect();
        try {
            return Integer.parseInt(select.getFirstSelectedOption().getAttribute("value"));
        } catch (Exception ex) {
            return -1;
        }
    }

    public List<String> getPageOptions() {
        return getPageSelect().getOptions().stream().map(t -> t.getText()).toList();
    }

    public int choosePageOption(String value) {
        getPageSelect().selectByVisibleText(value);
        return getPageValue();
    }

    public boolean isDisabledPrev() {
        return !previous.isEnabled();
    }

    public boolean isDisabledNext() {
        return !next.isEnabled();
    }

    public String getCurrentPage() {
        return pageJump.getDomProperty("value");
    }

    public String getTotalPages() {
        return totalPages.getText();
    }

    public RegistrationForm clickAdd() {
        goToElement(addNewRecord);
        addNewRecord.click();
        return registrationForm;
    }

    protected Row  formWebElement(@NotNull WebElement row) {
        Row rs = new Row();
        List<WebElement> cells = row.findElements(By.xpath(".//div[@role='gridcell']"));
        rs.setFirstName(cells.get(0).getText());
        rs.setLastName(cells.get(1).getText());
        rs.setAge(cells.get(2).getText());
        rs.setUserEmail(cells.get(3).getText());
        rs.setSalary(cells.get(4).getText());
        rs.setDepartment(cells.get(5).getText());
        return rs;
    }

    public List<Row> getRows() {
        List<WebElement> rows = driver.findElements(By.xpath("//div[@role='rowgroup']"));

        return rows.stream().map(this::formWebElement).toList();
    }
}

