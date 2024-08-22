package tests.models;

import core.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class Support  implements IAssertable<Support> {
    private String url;
    private String text;

    @Override
    public void asseratableEqual(SoftAssert softAssert, Support support) {
        softAssert.assertEquals(url, support.getUrl(), "Support.URL");
        softAssert.assertEquals(text, support.getText(), "Support.Text");
    }
}
