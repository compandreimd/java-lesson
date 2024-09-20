package tests.web.elements;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteSource;
import core.web.BaseClass;
import data.enums.EItem;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.elements.ElementsPagePOM;
import pom.elements.UploadDownloadPagePOM;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class UploadDownloadPageTest extends BaseClass {

    UploadDownloadPagePOM pom;
    @BeforeMethod(dependsOnMethods = "setup")
    public void setPOM() {
        pom = (UploadDownloadPagePOM)((ElementsPagePOM) mainPOM.clickCard(EItem.Elements))
                .clickItemMenu(EItem.UploadDownload);
    }

    @Test
    public void brokenPageTest() throws IOException {
        try {
            pom.clickDownload();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            File tmp = new File(BaseClass.TempDir);
            waiter.until(d -> Arrays.stream(tmp.listFiles()).filter(f -> f.getName().toLowerCase().endsWith(".crdownload")).count() <= 0);
            File[] files = tmp.listFiles();
            softAssert.assertEquals(files.length, 1, "Must be one!");
            File file;
            if (files.length == 1)
                file = Arrays.stream(files).findFirst().get();
            else {
                file = Arrays.stream(files).filter(f -> f.getName() == "sampleFile.jpeg").findFirst().get();
            }
            ByteSource byteSource = com.google.common.io.Files.asByteSource(file);
            HashCode hc = byteSource.hash(Hashing.sha256());
            String checksum = hc.toString();
            softAssert.assertEquals(checksum, UploadDownloadPagePOM.CHECKSUM);
            pom.uploadFile(file);
            softAssert.assertEquals(pom.getFilePath(), pom.getDefaultPath(file), "Upload File Check");
            Arrays.stream(files).forEach(File::delete);

        }catch (Exception ex){
            softAssert.assertNull(ex, "Something was wrong: " + ex.getMessage());
        }
        softAssert.assertAll();
    }
}
