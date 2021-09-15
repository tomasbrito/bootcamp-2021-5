package pom.grupo1.Pages;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.grupo1.base.SeleniumBase;

public class VFTrasladosPage extends SeleniumBase {

    public VFTrasladosPage(WebDriver driver) {
        super(driver);
    }

    // Test 3
    By airportInput = By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']");
    By firstOption = By.xpath("//li[@class='item'][1]");
    By hotelInput = By.xpath("//div[@class='sbox-places']//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By directionLabels = By.xpath("//label[@class=\"radio-label-container\"]");



    public void setAirportAndHotel(String airport, String hotel) {
        type(airport, airportInput);
        waitElementToBeClickable(firstOption, 4);
        click(firstOption);
        type(hotel, hotelInput);
        waitElementToBeClickable(firstOption, 4);
        click(firstOption);
    }

    public void setDirection(String direction) {
        String from = getText(airportInput);
        String to = getText(hotelInput);
        click(findElementByItsTextFromAList(direction, directionLabels));
        assertEquals(from, getText(hotelInput));
        assertEquals(to, getText(airportInput));
    }

}
