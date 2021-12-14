package componentObjects;

import base.Components;
import common.customWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Senaryo1 {

    final WebDriver driver;
    public Senaryo1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[name='update_cart']")
    private WebElement updateCard;

    @FindBy(css = "p[class='cart-empty woocommerce-info']")
    private WebElement removeMessage;

    @FindBy(css = "div[class='quantity']")
    private WebElement amountField;

    @FindBy(css = "td[data-title='Total']")
    private WebElement total;

    @FindBy(css = "a[class='remove']")
    private WebElement removeButton;

    @FindBy(css = "td[data-title='Price']")
    private WebElement price;

    @FindBy(css = "span[class='count']")
    private WebElement cartButton;

    @FindBy(css = "div[data-id='8e959e0']")
    private WebElement shopNowButton;

    @FindBy(css = "li[class='zakra-article product type-product post-205 status-publish first instock product_cat-featured product_cat-shoes product_cat-woman has-post-thumbnail sale featured shipping-taxable purchasable product-type-simple']")
    private WebElement firstLiElement;

    public void checkPageCorrectness(String currentURL){
        String strUrl = driver.getCurrentUrl();
        if (strUrl.equals(currentURL))
        {
            System.out.println("URL Checked");
        }
    }
    public void clickToShopNowButton()
    {
        customWait.waitUntilElementClickable(driver,shopNowButton);
        WebElement urunButton=getLinksElementWithText(Components.SHOP_NOW_BUTTON,"span",shopNowButton);
        urunButton.click();
    }

    public void clickToAddCardButton() throws InterruptedException {
        customWait.waitUntilElementClickable(driver,firstLiElement);
        WebElement urunButton=getLinksElementWithText(Components.ADD_CART_BUTTON,"a",firstLiElement);
        urunButton.click();
        Thread.sleep(3000);
        clickToCartButton();

    }

    public void clickToCartButton() throws InterruptedException {
        customWait.waitUntilElementClickable(driver,cartButton);
        cartButton.click();
    }

    public void changeAmount() throws InterruptedException {
        driver.findElement(By.cssSelector("[title$=Qty]")).clear();
        driver.findElement(By.cssSelector("[title$=Qty]")).sendKeys( "3");
        updateCard.click();
        Thread.sleep(5000);
        if (!price.getText().equals(total.getText()))
        {
            System.out.println("Changed Price");
            removeButton();
        }
    }

    public void removeButton() throws InterruptedException {
        removeButton.click();
        Thread.sleep(5000);
        if(removeMessage.isEnabled())
        {
            System.out.println("Checked message");
        }
    }

        private WebElement getLinksElementWithText(String titleText, String tagName,WebElement element){
        List<WebElement> List =null;
        List = element.findElements(By.tagName(tagName));

        switch (tagName)
        {
            case ("button"):
            {
                for (WebElement button:List){
                    if (button.getText().equals(titleText)){
                        return button;
                    }
                }
            }
            case ("a"):
            {
                for (WebElement a:List){
                    if (a.getText().equals(titleText)){
                        return a;
                    }
                    if (a.getClass().equals(titleText)){
                        return a;
                    }
                }
            }
            case ("div"):
            {
                for (WebElement div:List){
                    if (div.getText().equals(titleText)){
                        return div;
                    }
                }
            }
            case ("span"):
            {
                for (WebElement span:List){
                    if (span.getText().equals(titleText)){
                        System.out.println(span.getText());
                        return span;
                    }
                }
            }
        }
        return null;
    }
}

