package common;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class customWait {

    private static final int TIMEOUT_WAIT_SECONDS = 10;

    public static void waitUntilElementVisible(WebDriver driver, WebElement element){
        try {
            WebDriverWait wait;
            wait = new WebDriverWait(driver, TIMEOUT_WAIT_SECONDS);
            WebElement button = wait.until(ExpectedConditions.visibilityOf(element));
        } catch(TimeoutException e) {
            //log (with element description)
            throw e;
        }
    }

    public static void waitUntilElementClickable(WebDriver driver, WebElement element){
        try {
            WebDriverWait wait;
            wait = new WebDriverWait(driver, TIMEOUT_WAIT_SECONDS);
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(element));

            //  WebElement myDynamicTextElement = (new WebDriverWait(driver,TIMEOUT_WAIT_SECONDS ))
            //          .until(ExpectedConditions.elementToBeClickable(element));
        } catch(TimeoutException e) {
            //log
            throw e;
        }
    }

}
