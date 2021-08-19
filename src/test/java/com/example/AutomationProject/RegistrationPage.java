package com.example.AutomationProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign in")
    public WebElement signIn;

    public void clickSignIn(){
        signIn.click();
    }

    public void enterEmail(){
        emailInbox.sendKeys("testhds69@test.com");   }

    @FindBy(css = "[name='email_create']")
    public WebElement emailInbox;

    @FindBy(xpath = "//button[@name=\"SubmitCreate\"]")
    public WebElement submitButton;

    @FindBy(xpath = "//input[@id=\"id_gender1\"]")
    public WebElement gender;

    @FindBy(id = "passwd")
    public WebElement password;

    @FindBy(name = "customer_lastname")
    public WebElement lastName;

    @FindBy(name = "customer_firstname")
    public WebElement firstName;

    @FindBy(id = "firstname")
    public WebElement firstName1;

    @FindBy(id = "lastname")
    public WebElement lastName1;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(name = "id_state")
    public WebElement state;

    @FindBy(name = "postcode")
    public WebElement postcode;

    @FindBy(name = "id_country")
    public WebElement country;

    @FindBy(id = "phone_mobile")
    public WebElement mobileNumber;

    @FindBy(xpath = "//input[@name=\"alias\"]")
    public WebElement office;

    @FindBy(name = "submitAccount")
    public WebElement submitAccountButton;

    public void clickSubmit(){
        submitButton.click();
    }

    public void submitPersonalDetails() throws Exception {
        gender.click();
        firstName.sendKeys("Ram");
        lastName.sendKeys("Rahim");
        password.sendKeys("AVS@PKR");
        firstName1.sendKeys("Ram");
        lastName1.sendKeys("Rahim");
        address.sendKeys("4,toppice close");
        company.sendKeys("rampet");
        city.sendKeys("hyd");
        Select stateSelect=new Select(state);
        stateSelect.selectByValue("4");
        postcode.sendKeys("51610");
        Select countrySelect=new Select(country);
        countrySelect.selectByVisibleText("United States");
        mobileNumber.sendKeys("123456789");
        office.sendKeys("London");
        submitAccountButton.click();
        Thread.sleep(7000);
    }

    public boolean verifySuccessfulRegistration(){
        return driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders");
    }
}

