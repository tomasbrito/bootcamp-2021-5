package pom.grupo1.Pages;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pom.grupo1.base.SeleniumBase;

import java.util.List;

public class VFVuelosPage extends SeleniumBase {

    public VFVuelosPage(WebDriver driver) {
        super(driver);
    }


    By originInput = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-origin-input sbox-primary sbox-places-first places-inline']");
    By destinationInput = By.xpath("//input[@class='input-tag sbox-main-focus sbox-bind-reference-flight-roundtrip-destination-input sbox-secondary sbox-places-second places-inline']");
    By originFirstOption = By.xpath("//div[@class='ac-group-container'][1]//li[@class='item'][1]");
    By destinationFirstOption = By.xpath("//div[@class='ac-group-container'][1]//li[@class='item'][1]");
    //div[@class='sbox-row -wrap sbox-dates-container -mb3-m -mb4-s -mh3-l']//input[@class='checkbox-tag sbox-bind-checked-no-specified-date']
    By dateCheckbox = By.xpath("//*[@id=\"sboxContainer-flights\"]/div/div/div[3]/div[2]/div[2]/span/label");
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
    final String lastNameTooltipExpected = "Ingresa el apellido del pasajero";
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
    // Test 3
    By goingDate = By.xpath("//input[@class='input-tag sbox-bind-value-start-date-segment-1 sbox-bind-reference-flight-start-date-input ']");
    By todayDate = By.cssSelector("div._dpmg2--month-active > div._dpmg2--dates > span._dpmg2--today");
    By daysAvailable = By.cssSelector("div._dpmg2--month-active > div._dpmg2--dates > span._dpmg2--available");
    // Test 4
    By flightTypeCheckbox = By.xpath("//label[@class='radio-label-container']");
    By addAChild = By.xpath("//span[@class='passenger-container'][2]//*[@class='steppers-icon-right eva-3-icon-plus']");
    By childAge = By.id("eva-select");
    By childBirthDay = By.id("traveler-birthday-day-1");
    By childBirthMonth = By.id("traveler-birthday-month-1");
    By childBirthyear = By.id("traveler-birthday-year-1");
    By childBirthYears = By.xpath("//*[@id=\"traveler-birthday-year-1\"]/option");
    By childBirthdateToolTip = By.xpath("//*[@id=\"formData.travelers[1].birthdate.day\"]/div/validation-error");


    public void setTypeOfFlight(String text) {
        click(findElementByItsTextFromAList(text, flightTypeCheckbox));
    }

    public void setOriginAndDestination(String origin, String destination) {
        type(origin, originInput);
        waitElementToBeClickable(originFirstOption, 88);
        type(Keys.TAB, originInput);
        type(destination, destinationInput);
        waitElementToBeClickable(destinationFirstOption, 88);
        type(Keys.ENTER, destinationInput);
    }

    public void selectTheFirstOption() {
        waitElementToBeClickable(resultsTitle, 15);
        assertTrue(getText(resultsTitle).contains("Vuelos a"));
        click(nextButton);
        click(continueButton);
    }

    public void selectTheFirstOptionWithAChild(String age) {
        assertTrue(getText(resultsTitle).contains("Vuelos a"));
        click(nextButton);
        click(addAChild);
        waitElementToBeClickable(childAge, 4);
        selectByValue(childAge, age);
        click(continueButton);
        waitElementToBeClickable(buyButton, 30);
    }

    public void setChildAgeInBuySection() {
        assertTrue(getCurrentUrl().contains("checkout"));
        selectByValue(childBirthDay, "1");
        selectByValue(childBirthMonth, "1");
        int year = 2010;//findElements(childBirthYears).size();
        selectByValue(childBirthyear, String.valueOf(year));//String.valueOf(year)
        assertEquals("La fecha de nacimiento ingresada no coincide con el rango de edad de un pasajero menor", getText(childBirthdateToolTip));
    }

    public void dontSetDates() {
        click(dateCheckbox);
        click(searchButton);
        waitElementToBeClickable(nextButton, 18);
    }

    public void setDatesFromToday(int goingDay, int comingDay, String goingDayExpected) {
        click(goingDate);
        waitElementToBeClickable(todayDate, 4);
        click(getElementFromAList(goingDay, findElements(daysAvailable)));
        click(getElementFromAList(comingDay, findElements(daysAvailable)));
        assertEquals(goingDayExpected, getValue(goingDate));
    }

    public void setNameInBuySection(String name) {
        waitElementToBeClickable(nameInput, 30);
        type(name, nameInput);
    }

    public void validateEmptyNameInput() {
        waitElementToBeClickable(nameInput, 15);
        assertEquals("", getText(nameInput));
    }

    public void goBack() {
        super.goBack();
        acceptAlert();
        waitElementToBeClickable(nextButton, 15);
    }

    public void clickBuyButtonAndValidateAllToolTips() {
        waitElementToBeClickable(buyButton, 30);
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
