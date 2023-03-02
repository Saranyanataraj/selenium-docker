package com.tours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BillingAddressPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public BillingAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_53_addr_line1")
    private WebElement address;


    @FindBy(name = "buyFlights")
    private WebElement continueBtn;

    public void enterAddress(String text) {
        this.address.sendKeys(text);
    }

    public void goToFlightItineraryPage(){
        this.continueBtn.click();
    }

}
