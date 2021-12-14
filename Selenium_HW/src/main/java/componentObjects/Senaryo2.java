package componentObjects;

import base.Components;
import common.customWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Senaryo2 {

    final WebDriver driver;
    public Senaryo2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "section[id='custom_html-2']")
    private WebElement contactInfo;

    @FindBy(css = "a[id='tg-scroll-to-top']")
    private WebElement upButton;

    @FindBy(css = "img[class='custom-logo']")
    private WebElement logo;


    public void checkPageCorrectness(String currentURL){
        String strUrl = driver.getCurrentUrl();
        if (strUrl.equals(currentURL))
        {
            System.out.println("URL Checked");
        }
    }

    public void pagescrollDown() throws InterruptedException {
        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void pagescrollUp() throws InterruptedException {
        Thread.sleep(5000);
        upButton.click();
    }

    public void checkContactInfo() throws InterruptedException {
        Thread.sleep(3000);
        if(contactInfo.isEnabled())
        {
            System.out.println("Contact Info Checked");
            pagescrollUp();
        }
    }

    public void logoCheck() {
        if(logo.isEnabled())
        {
            System.out.println("Page is up / Logo Checked");
        }
    }
}

