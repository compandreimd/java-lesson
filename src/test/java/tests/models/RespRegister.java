package tests.models;


import core.IAssertable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class RespRegister implements IAssertable<RespRegister> {

    private int id;
    private String token;
    @Override
    public void asseratableEqual(SoftAssert softAssert, RespRegister respRegister) {
        softAssert.assertEquals(id, respRegister.id);
        softAssert.assertEquals(token, respRegister.token);
    }
}
