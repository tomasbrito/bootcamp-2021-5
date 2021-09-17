package pom.grupo3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo3.base.SeleniumBase;

import java.util.List;

public class VFAlojamientoG3 extends SeleniumBase {

    final int TIMEOUT_GENERAL = 3;

    public VFAlojamientoG3(WebDriver driver) {
        super(driver);
    }

    By btnBuscar = By.linkText("Buscar");
    By origenBy = By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[1]/div/div/div/div/div/input");
    By destinoBy = By.xpath("//*[@id=\"sboxContainer-packages\"]/div/div/div[3]/div[2]/div[2]/div[1]/div/div/div/input");
    By FechaIda = By.xpath("//*[@id=\"sboxContainer-hotels\"]/div/div/div[3]/div[2]/div[2]/div/div/div[1]/div/input");
    By entradaInput = By.xpath("//input[@placeholder=\"Entrada\"]");
    By spanTagBy = By.tagName("span");
    By aplicarFechasBy = By.xpath("//button/*[text()=\"Aplicar\"]");
    By primerResultadoBy = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[2]/aloha-button/button/em");////li[@class="item -active"]
    By habitacionesBy = By.xpath("//label[text()=\"Habitaciones\"]");
    By adultoMas = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div/a[2]");
    By menorMas = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div/a[2]");
    By btnHabitacionesAplicar = By.linkText("Aplicar");
    By menorListaEdad = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select");
    By resultContainerBy = By.xpath("//div[@class=\"results-cluster-container\"]");
    By btnVerHabitacion = By.xpath("/html/body/aloha-app-root/aloha-detail/div/div[2]/div[2]/div/aloha-infobox-container/aloha-infobox-wrapper-container/div/div/div/aloha-infobox-shopping-content/div/div[2]/aloha-button/button/em");//By.linkText("Ver habitaciones");
    By precioTotalBy = By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-detail-price-container/aloha-price-container/aloha-summary-price/div/span[2]");
    By btnReservarAhora = By.xpath("//*[@id=\"roompacks-container-wrapper\"]/aloha-roompacks-container/aloha-roompacks-grid-container/div[2]/div[2]/aloha-reservation-summary-container/div/aloha-next-step-button/aloha-button/button/em");
    By btnSiguiente = By.linkText("Siguiente");
    By hotelsListBy = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]");//className: results-cluster-container
    By nombreHotelBy = By.xpath("//span[contains(@class,\"accommodation-name\")]");
    By tituloHotel = By.xpath("//*[@id=\"checkout-content\"]/div[2]/div/purchase-detail-component/div/products-detail-component-v2/div/div/product-title-v2/div/div[2]/div");
    By precioActual = By.xpath("//*[@id=\"chk-total-price\"]/div[2]/money/div/span[3]");
    By checkCMRpuntos = By.id("cmr-split");
    By textBoxCMRpuntos = By.id("cmr-payer-identification-number");
    By fueraDeCMR = By.xpath("//*[@id=\"checkout-content\"]/div[1]/cmr-split/div/div/div/div/div/div[1]/span");
    By mensajeErrorCMR = By.xpath("//*[@id=\"formData.paymentData.cashPayments[0].payeeIdentification.number\"]/div/div/validation-error/span");
    By errorEdad = By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[3]/div/div[2]/p");
    By campoPrecioDesde = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[2]/aloha-filter/aloha-slider-filter/ul/div[3]/div[1]/aloha-input/div/div/input");//By.xpath("//input[@type='number'][0]");
    By campoPrecioHasta = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[2]/aloha-filter/aloha-slider-filter/ul/div[3]/div[2]/aloha-input/div/div/input");//By.xpath("//input[@type='number'][1]");
    By btnAplicarFiltroPrecio = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[1]/aloha-filter-list/div/ul/li[2]/aloha-filter/aloha-slider-filter/ul/aloha-button/button/em");

    public void selectDestino(String place) {
        WebElement destino = encontrarElemento(origenBy);

        tipear(place, destino);
        waitElementsToBeMoreThan(0, primerResultadoBy, TIMEOUT_GENERAL);
        enter(origenBy);
        //click(primerResultadoBy);
    }

    public void selecFecha(String year_month, String entrada_day, String salida_day) { //elegir fecha inicio,fin, y aplicar
        click(entradaInput);

        WebElement entradaMonth = encontrarElemento(By.xpath("//div[@data-month='" + year_month + "']"));
        List<WebElement> daysList = findChildrenElements(spanTagBy, entradaMonth);

        for (WebElement day : daysList) {
            if (day.getText().equals(entrada_day)) {
                day.click();
                break;
            }
        }
        for (WebElement day : daysList) {
            if (day.getText().equals(salida_day)) {
                day.click();
                break;
            }
        }
        click(aplicarFechasBy);
    }



    public void addAdult(int cant_adult) {
        click(habitacionesBy);
        for (int i = 0; i < cant_adult; i = i + 2) {
            click(adultoMas);
        }
    }

    public void addkid(int cant_niños) {
        for (int i = 0; i < cant_niños; i = i + 2) {
            click(menorMas);
        }
        click(btnHabitacionesAplicar);
    }

    public void edadMenor(String edad_menor) {
        elmentoVisible(edad_menor);
        click(btnHabitacionesAplicar);
    }

    public void busqueda() {
        click(btnBuscar);
    }

    public void waitForResultsPage(String expectedUrl) {
        waitUrlContains(expectedUrl, TIMEOUT_GENERAL);
        waitElementsToBeMoreThan(0, resultContainerBy, TIMEOUT_GENERAL);
    }
    public String nombrePrimerHotel() {
        List<WebElement> listaHoteles = encontrarElementos(hotelsListBy);
        return obtenerTexto(elementoHijo(nombreHotelBy, listaHoteles.get(0)));
    }

    public void switchToHotelTab(String URLesperada) {
        cambioPestaña(1);
        waitUrlContains(URLesperada, TIMEOUT_GENERAL);
        //Assert.assertTrue(URLactual().contains(URLesperada));
    }


    public String ReservarPimerElemento() { //llegar hasta el formulario depago del primer elemento de la búsqueda
        String URLDetalleHabitacion = "accommodations/detail/";
        String URLFormularioPago = "checkout";
        click(primerResultadoBy);

        waitForResultsPage(URLDetalleHabitacion);
        click(btnVerHabitacion);
        String precioTotal = obtenerTexto(precioTotalBy);
        //click(btnReservarAhora);
        //String precioXNoche = obtenerTexto(precioPorNocheBy);
        waitElementsToBeMoreThan(0, btnSiguiente, TIMEOUT_GENERAL);
        click(btnSiguiente);

        waitForResultsPage(URLFormularioPago);
        return precioTotal;
    }

    public String obtenerNombreHotel() {
        return obtenerTexto(tituloHotel);
    }
    public String precioFinal() {
        return obtenerTexto(precioActual);
    }

    public String activarCMRpuntos(String codigoInvalido) {
        click(checkCMRpuntos);
        tipear(codigoInvalido, textBoxCMRpuntos);
        click(fueraDeCMR);
        return obtenerTexto(mensajeErrorCMR);
    }

    public String obtenerMensajeErrorEdad() {
        return obtenerTexto(errorEdad);
    }

    public void aplicarHabitaciones() {
        click(btnHabitacionesAplicar);
    }

    public void filtrarPorPrecio(String precioDesde, String precioHasta) {
        tipear(precioDesde, campoPrecioDesde);
        //tipear(precioHasta, campoPrecioHasta);//el campo no se borra automaticamente
        click(campoPrecioHasta);
        click(btnAplicarFiltroPrecio);
    }
}
