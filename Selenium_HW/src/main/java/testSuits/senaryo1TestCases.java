package testSuits;
import base.BaseUITestCase;
import base.PageURLs;
import componentObjects.Senaryo1;
import org.junit.*;
import org.junit.Test;


public class senaryo1TestCases extends BaseUITestCase {

    Senaryo1 Senaryo1;

    @Before
    public void beforeMethod() {
        super.beforeMethod();
        driver.get(PageURLs.MAIN_PAGE_URL);
        Senaryo1 = new Senaryo1(driver);
    }

    @Test
    public void loginPage() throws InterruptedException {
        Senaryo1.checkPageCorrectness(PageURLs.MAIN_PAGE_URL);
        Senaryo1.clickToShopNowButton();
        Senaryo1.checkPageCorrectness(PageURLs.PRODUCT_PAGE_URL);
        Senaryo1.clickToAddCardButton();
        Senaryo1.clickToCartButton();
        Senaryo1.changeAmount();
    }

 /* @After
    public void afterMethod(){
        super.afterMethod();
    }*/
}
