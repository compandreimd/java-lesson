package tests.api.models;

import core.api.IAssertable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespError implements IAssertable<RespError> {
    private String error;

    @Override
    public void asseratableEqual(SoftAssert softAssert, RespError respError) {
        softAssert.assertEquals(error, respError.error);
    }
}
