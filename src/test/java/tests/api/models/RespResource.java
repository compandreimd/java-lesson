package tests.api.models;

import core.api.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class RespResource implements IAssertable<RespResource> {
    private Resource data;
    private Support support;

    @Override
    public void asseratableEqual(SoftAssert softAssert, RespResource resp) {
        data.asseratableEqual(softAssert, resp.getData());
        support.asseratableEqual(softAssert, resp.getSupport());
    }
}
