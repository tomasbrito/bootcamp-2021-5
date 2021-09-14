package pom.grupo1.Pages;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pom.grupo1.base.SeleniumBase;

public class VFVuelosPage extends SeleniumBase {

    public VFVuelosPage(WebDriver driver) {
        super(driver);
    }


    By originInput = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-origin-input sbox-primary sbox-places-first places-inline']");
    By destinationInput = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary sbox-places-second places-inline']");
    By originAndDestinationFirstOption = By.xpath("//li[@class='item'][1]");
    //div[@class='sbox-row -wrap sbox-dates-container -mb3-m -mb4-s -mh3-l']//input[@class='checkbox-tag sbox-bind-checked-no-specified-date']
    By dateCheckbox = By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[2]/span/label/input");
    //div[@class='sbox-row -wrap sbox-dates-container -mb3-m -mb4-s -mh3-l']//i[@class='checkbox-check sbox-3-icon-checkmark -mr1 sbox-ui-icon']
    By searchButton = By.xpath("//div[@class='sbox-button -ml3-l']//a[@class='sbox-3-btn -primary -md sbox-search']");
    By nextButton = By.xpath("//div[@id='clusters']/span[1]//span[@class='-eva-3-tc-purple-3']");
    By continueButton = By.xpath("//*[@id=\"passengers-modal-position\"]//a[@class='eva-3-btn -primary -lg']");
    By buyButton = By.id("buy-button");
    By resultsTitle = By.xpath("//h1[@class='landingTitle']");
    // Buy tooltips
    By cardToolTip = By.xpath("//card-storage/div//p");
    final String cardToolTipExpected = "Elige la tarjeta con la que quieres pagar";
    By firstNameToolTip = By.xpath("//*[@id=\"formData.travelers[0].firstName\"]/div/div/validation-error/span");
    final String fisrtNameToolTipExpected = "Ingresa el nombre del pasajero";
    By lastNameToolTip = By.xpath("//*[@id='formData.travelers[0].lastName']//validation-error/span");
    final String lastNameTooltipExpected = "Ingrese el apellido del pasajero";
    By birthDayToolTip= By.xpath("//*[@id='formData.travelers[0].birthdate.day']//validation-error/span");
    final String birthDayToolTipExpected = "Ingresa el día de nacimiento";
    By birthMonthToolTip = By.xpath("//*[@id=\"formData.travelers[0].birthdate.month\"]//validation-error/span");
    final String birthMonthToolTipExpected = "Ingresa el mes de nacimiento";
    By birthYearToolTip = By.xpath("//*[@id=\"formData.travelers[0].birthdate.year\"]//validation-error/span");
    final String birthYearToolTipExpected = "Ingresa el año de nacimiento";
    By emailToolTip = By.xpath("//div[@class='-md -top-left chk-input eva-3-input eva-3-validation-inline -invalid']//span[@class='validation-msg']");
    final String emailToolTipExpected = "Ingresa el email";
    By areaNumberToolTip = By.xpath("//*[@id=\"formData.contactData.phones[0].areaCode\"]/validation-error/span");
    final String numberToolTipsExpected = "Campo obligatório";
    By numberToolTip = By.xpath("//*[@id=\"formData.contactData.phones[0].number\"]/validation-error/span");
    By termsToolTip = By.xpath("//checkbox-component//span[@class='validation-msg']");
    final String termsToolTipExpected = "Acepta los términos y condiciones";
    // Test 2
    By nameInput = By.xpath("//*[@id=\"formData.travelers[0].firstName\"]//input");


    public void setOriginAndDestination(String origin, String destination) {
        type(origin, originInput);
        waitToBeClickable(originAndDestinationFirstOption, 8);
        type(Keys.TAB, originInput);
        type(destination, destinationInput);
        waitToBeClickable(originAndDestinationFirstOption, 8);
        type(Keys.ENTER, destinationInput);
        waitToBeClickable(nextButton, 8);
    }

    public void selectTheFirstOption() {
        assertTrue(getText(resultsTitle).contains("Vuelos a"));
        click(nextButton);
        click(continueButton);
    }

    public void dontSetDates() {
        click(dateCheckbox);
        click(searchButton);
    }

    public void setNameInBuySection(String name) {
        waitToBeClickable(nameInput, 30);
        type(name, nameInput);
    }

    public void goBack() {
        super.goBack();
        acceptAlert();
        waitToBeClickable(nextButton, 15);
    }

    public void clickBuyButtonAndValidateAllToolTips() {
        waitToBeClickable(buyButton, 30);
        click(buyButton);
        assertEquals(cardToolTipExpected, getText(cardToolTip));
        assertEquals(fisrtNameToolTipExpected, getText(firstNameToolTip));// Valida mensaje de error en nombre
        assertEquals(lastNameTooltipExpected, getText(lastNameToolTip));// Valida mensaje de error en apellido
        assertEquals(birthDayToolTipExpected, getText(birthDayToolTip));// Valida mensaje de error en día
        assertEquals(birthMonthToolTipExpected, getText(birthMonthToolTip));// Valida mensaje de error en mes
        assertEquals(birthYearToolTipExpected, getText(birthYearToolTip));// Valida mensaje de error en año
        assertEquals(emailToolTipExpected, getText(emailToolTip));// Valida mensaje de error en email
        assertEquals(numberToolTipsExpected, getText(areaNumberToolTip));// Valida mensaje de error en area
        assertEquals(numberToolTipsExpected, getText(numberToolTip));// Valida mensaje de error en numero
        assertEquals(termsToolTipExpected, getText(termsToolTip));// Valida mensaje de error en terminos y condiciones
    }

}
