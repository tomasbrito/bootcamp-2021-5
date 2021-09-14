package pom.grupo1.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo1.base.SeleniumBase;

import java.util.ArrayList;
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
