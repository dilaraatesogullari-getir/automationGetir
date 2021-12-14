package testSuits;

import base.BaseUITestCase;
import base.PageURLs;
import componentObjects.Senaryo3;
import org.junit.Before;
import org.junit.Test;


public class senaryo3TestCases extends BaseUITestCase {

    Senaryo3 Senaryo3;

    @Before
    public void beforeMethod() {
        super.beforeMethod();
        driver.get(PageURLs.MAIN_PAGE_URL);
        Senaryo3 = new Senaryo3(driver);
    }

    @Test
    public void loginPage() throws InterruptedException {
        Senaryo3.checkPageCorrectness(PageURLs.MAIN_PAGE_URL);
        Senaryo3.clickToShopButton();
        Senaryo3.checkPageCorrectness(PageURLs.PRODUCT_PAGE_URL);
        Senaryo3.selectBoxButton();
        Senaryo3.clickToAddCardButton();
        Senaryo3.checkPageCorrectness(PageURLs.CART_PAGE_URL);
        Senaryo3.fillBilling();
        Senaryo3.clickToCartButton();

    }

 /* @After
    public void afterMethod(){
        super.afterMethod();
    }*/
}
