package tests.models;

import core.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class RespUsers implements IAssertable<RespUsers> {
    private User data;
    private Support support;

    @Override
    public void asseratableEqual(SoftAssert softAssert, RespUsers respUsers) {
            data.asseratableEqual(softAssert, respUsers.getData());
            support.asseratableEqual(softAssert, respUsers.getSupport());
    }
}
