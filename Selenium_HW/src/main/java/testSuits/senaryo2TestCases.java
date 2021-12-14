package testSuits;

import base.BaseUITestCase;
import base.PageURLs;
import componentObjects.Senaryo1;
import componentObjects.Senaryo2;
import org.junit.Before;
import org.junit.Test;


public class senaryo2TestCases extends BaseUITestCase {

    Senaryo2 Senaryo2;

    @Before
    public void beforeMethod() {
        super.beforeMethod();
        driver.get(PageURLs.MAIN_PAGE_URL);
        Senaryo2 = new Senaryo2(driver);
    }

    @Test
    public void loginPage() throws InterruptedException {
        Senaryo2.checkPageCorrectness(PageURLs.MAIN_PAGE_URL);
        Senaryo2.pagescrollDown();
        Senaryo2.checkContactInfo();
        Senaryo2.logoCheck();
    }

 /* @After
    public void afterMethod(){
        super.afterMethod();
    }*/
}
