package componentObjects;

import base.Components;
import common.customWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Senaryo3 {

    final WebDriver driver;
    public Senaryo3(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "span[class='count']")
    private WebElement cartButton;

    @FindBy(css = "label[data-automation-id='woo-commerce-subscription-opt-in]")
    private WebElement mailSelectbox;

    @FindBy(css = "textarea[id='order_comments']")
    private WebElement orderNote;

    @FindBy(css = "input[id='billing_email']")
    private WebElement email;

    @FindBy(css = "input[id='billing_phone']")
    private WebElement phone;

    @FindBy(css = "input[id='billing_city']")
    private WebElement town;

    @FindBy(css = "input[id='billing_postcode']")
    private WebElement postCode;

    @FindBy(css = "input[id='billing_address_1']")
    private WebElement address;

    @FindBy(css = "input[id='billing_first_name']")
    private WebElement firstName;

    @FindBy(css = "input[id='billing_last_name']")
    private WebElement lastName;

    @FindBy(css = "a[class='checkout-button button alt wc-forward']")
    private WebElement checkoutButton;

    @FindBy(css = "td[data-title='Price']")
    private WebElement price;

    @FindBy(css = "table[class='shop_table shop_table_responsive cart woocommerce-cart-form__contents']")
    private WebElement cartTable;

    @FindBy(css = "a[class='added_to_cart wc-forward']")
    private WebElement viewCartButton;

    @FindBy(css = "li[id='menu-item-834']")
    private WebElement shopButton;

    @FindBy(css = "select[name='orderby']")
    private WebElement selectBox;

    @FindBy(css = "li[class='zakra-article product type-product post-214 status-publish first instock product_cat-dresses product_cat-woman has-post-thumbnail shipping-taxable purchasable product-type-simple']")
    private WebElement firstLiElement;

    @FindBy(css = "li[class='zakra-article product type-product post-213 status-publish instock product_cat-dresses product_cat-man has-post-thumbnail sale shipping-taxable purchasable product-type-simple']")
    private WebElement secondLiElement;

    @FindBy(css = "li[class='zakra-article product type-product post-212 status-publish last instock product_cat-dresses product_cat-woman has-post-thumbnail sale shipping-taxable purchasable product-type-simple']")
    private WebElement thridLiElement;

    public void checkPageCorrectness(String currentURL){
        String strUrl = driver.getCurrentUrl();
        if (strUrl.equals(currentURL))
        {
            System.out.println("URL Checked");
        }
    }
    public void clickToShopButton()
    {
        shopButton.click();
    }

    public void selectBoxButton()
    {
        Select dropdown = new Select(selectBox);
        dropdown.selectByVisibleText(Components.DROPDOWN_OPTION);

    }

    public void clickToAddCardButton() throws InterruptedException {
        Thread.sleep(3000);
        ArrayList<WebElement>  list= new ArrayList<WebElement> ();
        list.add(firstLiElement);
        list.add(secondLiElement);
        list.add(thridLiElement);

        for(int i=0;i<list.size();i++)
        {
            WebElement newElement =  list.get(i);
            WebElement urunButton=getLinksElementWithText(Components.ADD_CART_BUTTON,"a", list.get(i));
            urunButton.click();
        }
        Thread.sleep(5000);
        viewCartButton.click();
        checkTableExist();
    }

    public void checkTableExist() throws InterruptedException {
        Thread.sleep(3000);
        if(cartTable.isEnabled())
        {
            System.out.println("Table exist");
            clickCheckoutButton();
        }
    }

    public void clickCheckoutButton() throws InterruptedException {
        checkoutButton.click();
    }

    public void fillBilling() throws InterruptedException {
        firstName.sendKeys(Components.FIRST_NAME);
        lastName.sendKeys(Components.LAST_NAME);
        address.sendKeys(Components.ADDRESS);
        orderNote.sendKeys(Components.ORDER_NOTE);
        postCode.sendKeys(Components.POSTCODE);
        town.sendKeys(Components.TOWN);
        phone.sendKeys(Components.PHONE);
        email.sendKeys(Components.EMAIL);
       // mailSelectbox.click();

    }
    public void getPrice() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> List =null;
        List = driver.findElements(By.className("woocommerce-cart-form__cart-item cart_item"));

    }

    public void clickToCartButton() throws InterruptedException {
        customWait.waitUntilElementClickable(driver,cartButton);
        cartButton.click();
    }

        private WebElement getLinksElementWithText(String titleText, String tagName,WebElement element){
        List<WebElement> List =null;
        List = element.findElements(By.tagName(tagName));

        switch (tagName)
        {
            case ("input"):
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

