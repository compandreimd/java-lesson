package tests.api.models;

import core.api.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class RespCreateUser implements IAssertable<RespCreateUser> {
    private String name;
    private String job;
    private String id;
    private String createdAt;
    @Override
    public void asseratableEqual(SoftAssert softAssert, RespCreateUser resp) {
        softAssert.assertEquals(name, resp.getName(), "Name");
        softAssert.assertEquals(job, resp.getJob(), "Job");



    }
}
