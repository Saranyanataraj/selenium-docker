package com.tours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightItineraryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement flightConfirmationTxt;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> priceTxt;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOff;

    public FlightItineraryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void verifyItineraryDetails() {
        this.wait.until(ExpectedConditions.visibilityOf(flightConfirmationTxt));
        System.out.println("flightConfirmationTxt: " + flightConfirmationTxt.getText());
        System.out.println("priceTxt: " + priceTxt.get(1).getText());
        this.signOff.click();
    }

    public String getPrice() {
        return priceTxt.get(1).getText();
    }


}
