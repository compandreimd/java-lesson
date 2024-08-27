package tests.api.models;

import core.api.IAssertable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.testng.asserts.SoftAssert;
import utils.ReadConfig;
import java.util.List;

@Data
@NoArgsConstructor
public class RespListUsers implements IAssertable<RespListUsers> {
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<User> data;
    private Support support;

    @Override
    public void asseratableEqual(SoftAssert softAssert, RespListUsers resp) {
        softAssert.assertEquals(per_page + "", ReadConfig.getInstance().getValue("PerPage"), "PerPaga");
        if(per_page == 0) per_page = 6;
        if(resp.getPer_page() == 0) resp.setPer_page(6);
        softAssert.assertEquals(this.total_pages, (resp.getTotal() / resp.getPer_page() + (resp.getTotal() % resp.getPer_page() == 0 ? 0 : 1)), "TotalPage");
        softAssert.assertEquals(this.total, resp.getTotal(), "Total");
        List<User> data = resp.getData().stream().toList();
        data.forEach(n -> {
            var exp = resp.getData().stream().filter(e -> e.getId() == n.getId()).findFirst().get();
            n.asseratableEqual(softAssert, exp);
        });
        support.asseratableEqual(softAssert, resp.getSupport());


    }
}
