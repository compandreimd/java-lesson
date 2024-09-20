package pom.elements;

import core.web.AMenuPom;
import core.web.BaseClass;
import data.enums.EItem;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class UploadDownloadPagePOM extends AMenuPom {
    public static final String CHECKSUM = "04ec95ca2b997689dcc4d66c05063d1d3f2ef2a10b8b1f153c9db4bcde823852";
    @FindBy(xpath = "//a[@id='downloadButton']")
    public WebElement downloadButton;
    @FindBy(xpath = "//input[@id='uploadFile']")
    public WebElement uploadFile;
    @FindBy(xpath = "//p[@id='uploadedFilePath']")
    public WebElement uploadedFilePath;

    public void clickDownload(){
        downloadButton.click();
    }

    public File uploadFile(@NotNull File file){
        uploadFile.sendKeys(file.getAbsolutePath());
        return file;
    }

    public String getDefaultPath(@NotNull File file){
        return "C:\\fakepath\\" + file.getName();
    }
    public String getFilePath(){
        return uploadedFilePath.getText();
    }
    public UploadDownloadPagePOM(@NotNull BaseClass baseClass) {
        super(baseClass);

    }
}
