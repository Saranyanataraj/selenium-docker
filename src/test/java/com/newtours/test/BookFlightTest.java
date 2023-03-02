package com.newtours.test;

import com.tours.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class BookFlightTest extends BaseTest {

    private String noOfPassenger;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"noOfPassenger", "expectedPrice"})
    public void setupParameters(String noOfPassenger, String expectedPrice){
        this.noOfPassenger = noOfPassenger;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("selenium", "docker");
        registrationPage.enterUserCreds("selenium", "docker");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationPageTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPageTest")
    public void flightDetailsPageTest(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassenger);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPageTest")
    public void findFlightsPage() {
        FindFlightsPage findFlightsPage = new FindFlightsPage(driver);
        findFlightsPage.goToBillingAddressPage();
    }

    @Test(dependsOnMethods = "findFlightsPage")
    public void billingAddressPage() {
        BillingAddressPage billingAddressPage = new BillingAddressPage(driver);
        billingAddressPage.enterAddress("Kaveri Street");
        billingAddressPage.goToFlightItineraryPage();
    }

    @Test(dependsOnMethods = "billingAddressPage")
    public void flightItineraryPage() {
        FlightItineraryPage flightItineraryPage = new FlightItineraryPage(driver);
        String actualPrice = flightItineraryPage.getPrice();
        Assert.assertEquals(actualPrice.toString(), expectedPrice);
        flightItineraryPage.verifyItineraryDetails();
    }

}
