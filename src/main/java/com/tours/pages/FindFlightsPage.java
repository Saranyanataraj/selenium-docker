package com.tours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FindFlightsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "reserveFlights")
    private WebElement continueBtn;

    public void goToBillingAddressPage() {
        this.continueBtn.click();
    }

}
