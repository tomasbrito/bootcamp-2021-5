package pom.grupo1.Pages;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pom.grupo1.base.SeleniumBase;
import org.openqa.selenium.WebElement;
import java.util.List;

public class VFTrasladosPage extends SeleniumBase {

    public VFTrasladosPage(WebDriver driver) {
        super(driver);
    }

    final int GENERAL_TIMEOUT_TIME = 5;

    //test1
    By btnBuscarBy = By.linkText("Buscar");
    By regresoCheckbox = By.xpath("//label[text()=\"Quiero agregar el regreso\"]");
    By destinoContainerBy = By.className("sbox-places");
    By desdeInputBy = By.tagName("input");
    By firstResultBy = By.xpath("//li[@class=\"item -active\"]");
    By hastaInputBy = By.xpath("//*[@placeholder=\"Ingresa un hotel o dirección adónde quieras ir\"]");
    By arriboInput = By.xpath("//input[@placeholder=\"Arribo\"]");
    By spanTagBy = By.tagName("span");
    By aplicarFechasButtonBy = By.xpath("(//button/*[text()=\"Aplicar\"])[2]");
    By resultContainerBy = By.xpath("//div[@class=\"results-cluster-container\"]");
    By pointsDescriptionListBy = By.xpath("//div[@class=\"points-description\"]/ul/li");

//    //test1
//    By alojamientosFormBy = By.className("sbox-dates");
//    By fechaTooltipsBy = By.className("validation-msg");
//    //test2
//    By noHeDecididoFechaCheckboxBy = By.xpath("//label[text()=\"Todavía no he decidido la fecha\"]");
//    By currencySelectBy = By.xpath("//select[@name=\"currency\"]");
//    By pricesListBy = By.className("landing-inline");
//    By loadingSpinnerBy = By.id("fullLoader");
//    //test3
//    By selectTagBy = By.tagName("select");
//    By habitacionesInputBy = By.xpath("//label[text()=\"Habitaciones\"]");
//    By minusButtonsBy = By.xpath("//a[contains(@class,\"steppers-icon-left\")]");
//    By plusButtonsBy = By.xpath("//a[contains(@class,\"steppers-icon-right\")]");
//    By btnAñadirHabitacionBy = By.xpath("//a[text()=\"Añadir habitación\"]");
//    By roomBlocksBy = By.xpath("//div[@class=\"_pnlpk-itemBlock\"]");
//    By btnHabitacionesAplicar = By.linkText("Aplicar");
//    By accommodationRoomBlocksBy = By.className("stepper__room");
//    //test4
//    By hotelsListBy = By.className("results-cluster-container");
//    By hotelNameBy = By.xpath("//span[contains(@class,\"accommodation-name\")]");
//    By btnVerDetalleBy = By.tagName("button");
//    By hotelPageTitleBy = By.xpath("//div[@class=\"main-info\"]//h1");
//    By btnReservarAhoraBy = By.xpath("//em[text()=\"Reservar ahora\"]");
//    By roomDetailsFetchingBy = By.xpath("//aloha-infobox-skeleton");
//    By btnSiguienteBy = By.xpath("//em[text()=\"Siguiente\"]");
//    By checkoutSpinnerBy = By.xpath("//div[@id=\"loading-init\"]");
//    By checkoutMsgBy = By.tagName("h2");
    // Test 3
    By airportInput = By.xpath("//input[@class='input-tag sbox-main-focus sbox-origin sbox-primary sbox-places-first places-inline']");
    By firstOption = By.xpath("//li[@class='item'][1]");
    By hotelInput = By.xpath("//div[@class='sbox-places']//input[@class='input-tag sbox-main-focus sbox-destination sbox-secondary sbox-places-second places-inline']");
    By directionLabels = By.xpath("//label[@class=\"radio-label-container\"]");
    // Test 4
    By hourSelect = By.xpath("//div[@class=\"select-container\"]/select[@class='select-tag sbox-time-arrival']");
    By firstVehicle = By.xpath("//div[@class='search-cluster ng-scope'][1]//button");
    By transferMethod = By.xpath("//payment-method-selector//li[3]//label");
    By bankSelect = By.xpath("//*[@id='card-selector-0']");
    By fiscalNameInput = By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].invoice.fiscalName\"]//input");
    By ruitNumberInput = By.xpath("//*[@id=\"invoice-fiscal-identification-number-0\"]");
    By directionInput = By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].invoice.fiscalAddress.street\"]//input");
    By firstNameInput = By.xpath("//*[@id=\"formData.travelers[0].firstName\"]//input");
    By lastNameInput = By.xpath("//*[@id=\"formData.travelers[0].lastName\"]//input");
    By airlineInput = By.xpath("//*[@id=\"transfer-info-departure-airline-0\"]");
    By flightNumberInput = By.xpath("//*[@id=\"transfer-info-departure-flightNumber-0\"]");
    By emailInput = By.xpath("//input[@class='contact-email input-tag ng-untouched ng-pristine ng-invalid']");
    By confirmEmailInput = By.xpath("//*[@id=\"checkout-content\"]//email-address//input-component[2]//input");
    By phoneAreaInput = By.xpath("//*[@id=\"formData.contactData.phones[0].areaCode\"]//input");
    By phoneNumberInput = By.xpath("//*[@id=\"formData.contactData.phones[0].number\"]//input");
    By buyTranslateButton = By.id("buy-button");
    By termsToolTip = By.xpath("//checkbox-component/span/span[2]");


    public void setAirportAndHotel(String airport, String hotel) {
        type(airport, airportInput);
        waitElementToBeClickable(firstOption, 4);
        click(firstOption);
        type(hotel, hotelInput);
        waitElementToBeClickable(firstOption, 4);
        click(firstOption);
    }

    public void setArriboDate(String yearMonth, String arriboDay) {
        click(arriboInput);

        WebElement arriboMonth = findElement(By.xpath("(//div[@data-month='" + yearMonth + "'])[2]"));
        List<WebElement> daysList = findChildrenElements(spanTagBy, arriboMonth);

        for (WebElement day : daysList) {
            if (day.getText().equals(arriboDay)) {
                day.click();
                break;
            }
        }
    }

    public void setHour(String hour) {
        selectByValue(hourSelect, hour);
    }

    public void setDirection(String direction) {
        String from = getText(airportInput);
        String to = getText(hotelInput);
        click(findElementByItsTextFromAList(direction, directionLabels));
        assertEquals(from, getText(hotelInput));
        assertEquals(to, getText(airportInput));
    }

    public void selectFirstVehicleOption() {
        waitElementToBeClickable(firstVehicle, 8);
        click(firstVehicle);
    }

    public void selectTransferMethod() {
        waitElementToBeClickable(transferMethod, 8);
        click(transferMethod);
        waitElementToBeClickable(bankSelect, 8);
        selectByIndex(bankSelect, 1);
    }

    public void setProofOfPayment(String fiscalName, String fiscalNumberRuit, String direction) {
        type(fiscalName, fiscalNameInput);
        type(fiscalNumberRuit, ruitNumberInput);
        type(direction, directionInput);
    }

    public void setWhoTravels(String firstName, String lastName) {
        type(firstName, firstNameInput);
        type(lastName, lastNameInput);
    }

    public void setAditionalInformation(String airline, String flightNumber) {
        type(airline, airlineInput);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        type(Keys.ARROW_DOWN, airlineInput);
        type(Keys.ENTER, airlineInput);
        type(flightNumber, flightNumberInput);
    }

    public void setEmailVouchers(String email) {
        type(email, emailInput);
        type(email, confirmEmailInput);
    }

    public void setPhoneNumberAndBuy(String areaCode, String phoneNumber) {
        type(areaCode, phoneAreaInput);
        type(phoneNumber, phoneNumberInput);
        click(buyTranslateButton);
        assertEquals("Acepta los términos y condiciones", getText(termsToolTip));
    }

    public void makeSearch() {
        click(btnBuscarBy);
    }

    public void checkAgregarRegreso() {
        click(regresoCheckbox);
    }

    public void selectDesde(String place) {
        WebElement destinoContainer = findElement(destinoContainerBy);
        WebElement destinoInput = findChildElement(desdeInputBy, destinoContainer);

        type(place, destinoInput);
        waitElementsToBeMoreThan(0, firstResultBy, GENERAL_TIMEOUT_TIME);
        click(firstResultBy);
    }

    public void selectHasta(String place) {
        WebElement destinoContainer = findElement(destinoContainerBy);
        WebElement hastaInput = findChildElement(hastaInputBy, destinoContainer);

        type(place, hastaInput);
        waitElementsToBeMoreThan(0, firstResultBy, GENERAL_TIMEOUT_TIME);
        click(firstResultBy);
    }

    public void selectDates(String yearMonth, String arriboDay, String partidaDay) {

        click(arriboInput);

        WebElement arriboMonth = findElement(By.xpath("(//div[@data-month='" + yearMonth + "'])[2]"));
        List<WebElement> daysList = findChildrenElements(spanTagBy, arriboMonth);

        for (WebElement day : daysList) {
            if (day.getText().equals(arriboDay)) {
                day.click();
                break;
            }
        }

        for (WebElement day : daysList) {
            if (day.getText().equals(partidaDay)) {
                day.click();
                break;
            }
        }

        click(aplicarFechasButtonBy);
    }

    public void waitForResultsPage(String expectedUrl) {
        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
        waitElementsToBeMoreThan(0, resultContainerBy, GENERAL_TIMEOUT_TIME);
    }

    public boolean isTrasladoInfoCorrect(String airportName, String hotelName) {
        List<WebElement> infoList = findElements(pointsDescriptionListBy);

        return getText(infoList.get(0)).contains(airportName) &&
                getText(infoList.get(2)).contains(hotelName);
    }


//    public void waitForResultsPage(String expectedUrl) {
//        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
//        waitElementsToBeMoreThan(0, resultContainerBy, GENERAL_TIMEOUT_TIME);
//    }
//
//    public List<String> getFechasTooltipsMsgs() {
//        WebElement alojamientosForm = findElement(alojamientosFormBy);
//        List<WebElement> fechasTooltips = findChildrenElements(fechaTooltipsBy, alojamientosForm);
//
//        List<String> tooltipsMsgs = new ArrayList<>();
//
//        for (WebElement tooltip : fechasTooltips) {
//            tooltipsMsgs.add(getText(tooltip));
//        }
//
//        return tooltipsMsgs;
//    }
//
//
//
//
//    public void selectOneAdultPerRoom(int roomAmount) {
//        for (int i = 0; i < roomAmount * 2; i = i + 2) {
//            click(findElements(minusButtonsBy).get(i));
//        }
//    }
//
//    public void selectOneChildPerRoom(int roomAmount) {
//
//        for (int i = 1; i < (roomAmount * 2) + 1; i = i + 2) {
//            click(findElements(plusButtonsBy).get(i));
//        }
//    }
//
//    public void addRoom(int roomAmount) {
//        click(habitacionesInputBy);
//
//        waitVisibilityOf(btnAñadirHabitacionBy, GENERAL_TIMEOUT_TIME);
//
//        for (int i = 0; i < roomAmount; i++) {
//            click(btnAñadirHabitacionBy);
//
//        }
//
//        waitVisibilityOf(findElements(roomBlocksBy).get(1), GENERAL_TIMEOUT_TIME);
//        boolean isSecondRoomDisplayed = isDisplayed(findElements(roomBlocksBy).get(1));
//
//        Assert.assertTrue(isSecondRoomDisplayed);
//    }
//
//    public void setChildrenAge(String age, int amount) {
//
//        for (int i = 0; i < amount; i++) {
//            WebElement ageList = findChildElement(selectTagBy, findElements(roomBlocksBy).get(i));
//            selectByValue(ageList, age);
//        }
//
//        click(btnHabitacionesAplicar);
//    }
//
//
//    public void selectCurrencyType(String currency) {
//        selectByValue(currencySelectBy, currency);
//    }
//
//    public void waitResultsRefresh() {
//        waitInvisibilityOf(loadingSpinnerBy, GENERAL_TIMEOUT_TIME);
//    }
//
//    public boolean isCurrencyIn(String displayedCurrency) {
//        List<WebElement> pricesList = findElements(pricesListBy);
//
//        try {
//            for (WebElement price : pricesList) {
//                boolean isDisplayedCurrency = getText(price).contains(displayedCurrency);
//                Assert.assertTrue(isDisplayedCurrency);
//            }
//            return true;
//
//        } catch (AssertionFailedError e) {
//            return false;
//        }
//
//    }
//
//    public int getRoomsAmount() {
//        return findElements(accommodationRoomBlocksBy).size();
//    }
//
//    public String getFirstHotelName() {
//        List<WebElement> hotelsList = findElements(hotelsListBy);
//        return getText(findChildElement(hotelNameBy, hotelsList.get(0)));
//    }
//
//    public void selectFirstHotel() {
//        List<WebElement> hotelsList = findElements(hotelsListBy);
//        click(findChildElement(btnVerDetalleBy, hotelsList.get(0)));
//    }
//
//    public void switchToHotelTab(String expectedUrl) {
//        switchTab(1);
//        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
//        Assert.assertTrue(getCurrentUrl().contains(expectedUrl));
//    }
//
//    public String getHotelTitle() {
//        return getText(hotelPageTitleBy);
//    }
//
//    public void bookFirstVacant(String expectedUrl) {
//        waitInvisibilityOf(roomDetailsFetchingBy, GENERAL_TIMEOUT_TIME);
//
//        waitElementToBeClickable(btnReservarAhoraBy, GENERAL_TIMEOUT_TIME);
//        click(btnReservarAhoraBy);
//
//        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
//
//    }
//
//    public void reviewAndConfirmHotel(String expectedMsg, String expectedUrl) {
//        waitPresenceOfElementLocated(btnSiguienteBy, GENERAL_TIMEOUT_TIME);
//        click(btnSiguienteBy);
//
//        waitUrlContains(expectedUrl, GENERAL_TIMEOUT_TIME);
//        waitInvisibilityOf(checkoutSpinnerBy, GENERAL_TIMEOUT_TIME);
//
//        waitPresenceOfElementLocated(checkoutMsgBy, GENERAL_TIMEOUT_TIME);
//        Assert.assertEquals(expectedMsg, getText(checkoutMsgBy));
//    }
}
