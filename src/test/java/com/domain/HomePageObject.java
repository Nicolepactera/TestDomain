package com.domain;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by nicole.liu on 1/11/2017.
 */
public class HomePageObject {
    final WebDriver driver;

    @FindBy(how = How.CSS, using ="nav#main-navigation > div > a")
    public WebElement homePageHeader;

    @FindBy(how = How.LINK_TEXT, using ="Buy")
    public WebElement homePageBtnBuy;

    @FindBy(how = How.LINK_TEXT, using ="Rent")
    public WebElement homePageBtnRent;

    @FindBy(how = How.LINK_TEXT, using ="New Homes")
    public WebElement homePageBtnNewHomes;

    @FindBy(how = How.LINK_TEXT, using ="Sold")
    public WebElement homePageBtnSold;

    @FindBy(how = How.CSS, using ="#Terms_Mode-button > span.ui-selectmenu-text")
    public WebElement homePageMode;

    @FindBy(how = How.XPATH, using ="//*[@id=\"page-inner-wrap-nh\"]/div/div[1]/div/h1")
    public WebElement newHomesHeader;












    // This is a constructor, as every page need a base driver to find web elements
    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }
}
