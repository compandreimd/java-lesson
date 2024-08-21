package tests.models;

import core.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class User implements IAssertable<User> {
    private int id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;

    @Override
    public void asseratableEqual(SoftAssert softAssert, User user) {
        softAssert.assertEquals(id, user.getId(), "User.Id");
        softAssert.assertEquals(email, user.getEmail(), "User.Email");
        softAssert.assertEquals(first_name, user.getEmail(), "User.FirstNAME");
        softAssert.assertEquals(last_name, user.getEmail(), "User.LastName");
        softAssert.assertEquals(avatar, user.getEmail(), "User.Avatar");
    }
}
