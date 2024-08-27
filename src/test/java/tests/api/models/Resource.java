package tests.api.models;

import core.api.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;

@Data
@NoArgsConstructor
public class Resource implements IAssertable<Resource> {
    private int id;
    private String name;
    private int year;
    private String color;
    private String pantone_value;

    @Override
    public void asseratableEqual(SoftAssert softAssert, Resource resource) {
        softAssert.assertEquals(id, resource.getId(), "Resource.Id");
        softAssert.assertEquals(name, resource.getName(), "Resource.Name");
        softAssert.assertEquals(year, resource.getYear(), "Resource.Year");
        softAssert.assertEquals(color, resource.getColor(), "Resource.Color");
        softAssert.assertEquals(pantone_value, resource.getPantone_value(), "Resource.PantoneValue");
    }
}
