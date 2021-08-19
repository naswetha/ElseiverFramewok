package com.example.AutomationProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BuySummerDress {
    Actions actions;
    WebDriver driver;

    public BuySummerDress(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
         actions=new Actions(driver);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signIn;

    @FindBy(css = "[data-test=menu-main-icon-search]")
    public WebElement searchButton;

    @FindBy(linkText = "DRESSES")
    public WebElement dresses;

    @FindBy(linkText = "Summer Dresses")
    public WebElement summerDresses;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]")
    public WebElement firstimage;
    //*[@id="center_column"]/ul/li[1]/div/div[1]/div/a[1]/img

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]/span")
    public WebElement moreButton;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement loginPassword;

    @FindBy(id = "SubmitLogin")
    public WebElement submitLogin;

    @FindBy(id = "color_11")
    public WebElement color;

    @FindBy(xpath = "//*[@id='quantity_wanted']")
    public WebElement quantity;

    @FindBy(xpath = "//*[@id='group_1']")
    public WebElement size;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span/text()")
    public WebElement proceedCheckout;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    public WebElement checkoutPageProceed;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    public WebElement addressPageProceed;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    public WebElement agreeTerms;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    public WebElement shippingPageProceed;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a/text()")
    public WebElement payByCheck;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    public WebElement confirmOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[1]/text()")
    public WebElement orderConfirmationText;

    public void clickOnLogin() throws Exception {
        signIn.click();
        email.sendKeys("testhds92@test.com");
        loginPassword.sendKeys("AVS@PKR");
        submitLogin.click();
    }

    public void selectSummerDress() throws Exception {
        dresses.click();
        summerDresses.click();
        actions.moveToElement(firstimage).perform();
        moreButton.click();
        quantity.sendKeys("2");
        Select stateSelect=new Select(size);
        stateSelect.selectByVisibleText("M");
        color.click();
        addToCart.click();
        Thread.sleep(2000);
    }

    public boolean verifyProductAddedtoCart(){
        return driver.getPageSource().contains("Product successfully added to your shopping cart");
    }
}
