package core.api;

import org.testng.asserts.SoftAssert;

public interface IAssertable<T> {
    void asseratableEqual(SoftAssert softAssert,T t);

}
