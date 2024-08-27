package tests.api.models;

import core.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class RespUpdateUser implements IAssertable<RespUpdateUser> {
    private String name;
    private String job;
    private String updatedAt;
    @Override
    public void asseratableEqual(SoftAssert softAssert, RespUpdateUser resp) {
        softAssert.assertEquals(name, resp.getName(), "Name");
        softAssert.assertEquals(job, resp.getJob(), "Job");
    }
}
