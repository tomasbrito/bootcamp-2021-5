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
    By destinoBy = By.xpath("//input[@placeholder='Ingresa una ciudad, alojamiento o atracción']");
    By firstOptionBy = By.xpath("(//span[@class='item-text'])[1]");
    By entradaInput = By.xpath("//input[@placeholder=\"Entrada\"]");
    By spanTagBy = By.tagName("span");
    By aplicarFechasBy = By.xpath("//button/*[text()=\"Aplicar\"]");
    By primerResultadoBy = By.xpath("(//em[@class='btn-text'])[5]");
    By habitacionesBy = By.xpath("//label[text()=\"Habitaciones\"]");
    By adultoMas = By.xpath("(//a[@class='steppers-icon-right sbox-3-icon-plus'])[1]");
    By menorMas = By.xpath("(//a[@class='steppers-icon-right sbox-3-icon-plus'])[2]");
    By btnHabitacionesAplicar = By.linkText("Aplicar");
    By resultContainerBy = By.xpath("//div[@class=\"results-cluster-container\"]");
    By btnVerHabitacion = By.xpath("(//em[@class='btn-text'])[3]");
    By precioTotalBy = By.xpath("//div[@id='roompacks-container-wrapper']/aloha-roompacks-container[1]/aloha-roompacks-grid-container[1]/div[2]/div[2]/aloha-reservation-summary-container[1]/div[1]/aloha-detail-price-container[1]/aloha-price-container[1]/aloha-summary-price[1]/div[1]/span[2]");
    By btnReservarAhora = By.xpath("(//em[@class='btn-text'])[5]");
    By btnSiguiente = By.xpath("//em[text()='Siguiente']");
    By hotelsListBy = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]");//className: results-cluster-container
    By nombreHotelBy = By.xpath("//span[contains(@class,\"accommodation-name\")]");
    By tituloHotel = By.xpath("//*[@id=\"checkout-content\"]/div[2]/div/purchase-detail-component/div/products-detail-component-v2/div/div/product-title-v2/div/div[2]/div");
    By precioActual = By.xpath("(//span[@class='amount'])[3]");
    By checkCMRpuntos = By.xpath("(//i[contains(@class,'checkbox-check eva-3-icon-checkmark')])[1]");
    By textBoxCMRpuntos = By.id("cmr-payer-identification-number");
    By fueraDeCMR = By.xpath("//span[@class='-eva-3-icon-sm -eva-3-bold']");
    By mensajeErrorCMR = By.xpath("//span[text()[normalize-space()='Ingresa un valor válido']]");
    By errorEdad = By.xpath("(//p[@class='message-title sbox-3-h5'])[1]");
    By campoPrecioDesde = By.xpath("(//input[@class='input-tag'])[4]");
    By campoPrecioHasta = By.xpath("(//input[@class='input-tag'])[5]");
    By btnAplicarFiltroPrecio = By.xpath("(//em[@class='btn-text'])[3]");
    By listaResultadosBy = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]");
    By precioPrimerResultado = By.xpath("/html/body/aloha-app-root/aloha-results/div/div/div/div[2]/div[2]/aloha-list-view-container/div[2]/div[1]/aloha-cluster-container/div/div/div[2]/aloha-cluster-pricebox-container/div/div[2]/div[1]/aloha-price-container/aloha-summary-price/div/span[2]");

    public void selectDestino(String place) {
        WebElement destino = encontrarElemento(destinoBy);

        tipear(place, destino);
        exwait(firstOptionBy);
        enter(destinoBy);
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

        String URLFormularioPago = "checkout";
        click(primerResultadoBy);

        cambiarANuevaPestaña();
        exwait(btnVerHabitacion);
        click(btnVerHabitacion);
        exwait(precioTotalBy);
        String precioTotal = obtenerTexto(precioTotalBy);
        exwait(btnReservarAhora);
        click(btnReservarAhora);
        waitElementsToBeMoreThan(0, btnSiguiente, TIMEOUT_GENERAL);
        cambiarANuevaPestaña();
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

    /*public void obtenerAlojamientoDeListaResultados(int posicion) {
        List<WebElement> resultados = encontrarElementos(listaResultadosBy);
        return
    }*/

    public boolean comparar(String pDesde, String pHasta) {
        String aux = obtenerTexto(precioPrimerResultado);
        aux = aux.replace(".","");
        int precio = Integer.parseInt(aux);
        int precioDesde = Integer.parseInt(pDesde);
        int precioHasta = Integer.parseInt(pHasta);
        return (precio >= precioDesde && precio <= precioHasta)? true:false;
    }
}
