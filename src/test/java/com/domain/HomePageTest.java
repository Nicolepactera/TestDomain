package com.domain;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by nicole.liu on 1/11/2017.
 */
public class HomePageTest {

    WebDriver driver;
    HomePageObject homePage;

    @BeforeTest
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.domain.com.au/");
        homePage = PageFactory.initElements(driver, HomePageObject.class);

        //Verify if the Domain home page is loaded successfully
        try {
            homePage.homePageHeader.isDisplayed();

        } catch (NoSuchElementException e) {
            System.out.println("This site can't be reached");
            // e.printStackTrace();
            driver.quit();
            System.exit(1);
        }



    }

    @Test
    public void testHomePageBuy(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        homePage.homePageBtnBuy.click();
        Assert.assertEquals("Buy",homePage.homePageMode.getText());
    }

    @Test
    public void testHomePageRent(){

        homePage.homePageBtnRent.click();
        Assert.assertEquals("Rent",homePage.homePageMode.getText());
    }

    @Test
    public void testHomePageNewHomes(){

        homePage.homePageBtnNewHomes.click();
        Assert.assertEquals("Find New Homes",homePage.newHomesHeader.getText());
    }

    @Test
    public void testHomePageSold(){

        homePage.homePageBtnSold.click();
        Assert.assertEquals("Sold",homePage.homePageMode.getText());
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
    }


}
