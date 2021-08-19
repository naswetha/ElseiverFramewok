package com.example.AutomationProject;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private RegistrationPage signUpPage;
    private BuySummerDress buySummerDress;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
        signUpPage       = new RegistrationPage(driver);
        buySummerDress   = new BuySummerDress(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void verifyRegistration() throws Exception {
        signUpPage.clickSignIn();
        signUpPage.enterEmail();
        signUpPage.clickSubmit();
        signUpPage.submitPersonalDetails();
        Assertions.assertTrue(signUpPage.verifySuccessfulRegistration());
    }

    @Test
    public void verifyBuyingSelectedSummerDress() throws Exception {
        buySummerDress.clickOnLogin();
        buySummerDress.selectSummerDress();
        Assertions.assertTrue(buySummerDress.verifyProductAddedtoCart());
    }
}
