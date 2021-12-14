package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class BaseUITestCase {

        protected static WebDriver driver = null;

        public void beforeMethod(){
            System.setProperty("webdriver.chrome.driver","./src/main/resources/drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        public void afterMethod(){
            driver.quit();
        }
}
