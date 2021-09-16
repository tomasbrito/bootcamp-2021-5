package desafio.grupo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class Paquetes {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,10);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }
    final static String Ida = "ida";
    final static String Vuelta = "vuelta";
    final static String Destino1Desde = "desdeDestino1";
    final static String Destino2Desde = "desdeDestino2";
    final static String Destino1Hasta = "hastaDestino1";
    final static String Destino2Hasta = "hastaDestino2";
    final static String IdaCalendarioLateral = "idaCalendarioLateral";
    final static String VueltaCalendarioLateral = "vueltaCalendarioLateral";

    //localizadores
    By fechaIda = By.xpath("//input[@placeholder='Ida']");
    By fechaDesdeDestino1 = By.xpath("//input[contains(@class,'sbox-hotel-first-checkin-date')]");
    By fechaDesdeDestino2 = By.xpath("//input[contains(@class,'sbox-hotel-second-checkin-date')]");
    By fechaVuelta = By.xpath("//input[@placeholder='Vuelta']");
    By fechaHastaDestino1 = By.xpath("//input[contains(@class,'sbox-hotel-first-checkout-date')]");
    By fechaHastaDestino2 = By.xpath("//input[contains(@class,'sbox-hotel-second-checkout-date')]");
    By btnApicarCalendario = By.xpath("//button[contains(@class,'_dpmg2--desktopFooter-button-apply')]");


    @Test // Búsqueda de Paquete sin fecha definida
    public void tc009_busquedaPaqueteSinFecha() {
        driver.get("https://www.viajesfalabella.cl/");
        WebElement cOrigen = driver.findElement(By.xpath("//input[contains(@class,'sbox-places-first sbox-origin-container')]"));
        WebElement cDestino = driver.findElement(By.xpath("//input[contains(@class,'sbox-places-second')]"));
        WebElement btnBuscar = driver.findElement(By.xpath("//a[contains(@class, 'sbox-search')]"));
        WebElement checkboxSinFecha = driver.findElement(By.xpath("//*[contains(@class,'sbox-switch-container')]"));
        By localizadorOpcion = By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]");
        By localizadorCheckbox = By.xpath("//*[contains(@class, 'switch-container')]");
        String origen = "Buenos Aires";
        String destino = "Isla de Pascua";

        // 3- Introducir "Buenos Aires" en el campo origen y presionar la tecla enter.
        String opcionOrigen = seleccionarCiudadBusqueda(cOrigen, localizadorOpcion, origen);
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",opcionOrigen);

        // 5- Introducir "Isla de Pascua" en el campo destino y presionar la tecla enter.
         String opcionDestino = seleccionarCiudadBusqueda(cDestino,localizadorOpcion,destino);
        Assert.assertEquals("Isla de Pascua, Valparaíso, Chile",opcionDestino);

        // 6- Hacer click en el campo Todavía no elegí fecha.
        wait.until(ExpectedConditions.elementToBeClickable(localizadorCheckbox));
        checkboxSinFecha.click();

        // 7- Hacer click en el botón Buscar.
        btnBuscar.click();
        wait.until(ExpectedConditions.urlContains("paquetes-a-isla-de-pascua-desde-buenos-aires"));
        Assert.assertTrue(driver.getCurrentUrl().contains("paquetes-a-isla-de-pascua-desde-buenos-aires"));
    }

    @Test // Búsqueda de paquete Vuelo más auto
    public void tc010_busquedaPaqueteVueloMasAuto(){
        driver.get("https://www.viajesfalabella.cl/");
        WebElement btnVueloAuto = driver.findElement(By.xpath("//input[@value='va']"));
        WebElement cOrigen = driver.findElement(By.xpath("//input[contains(@class, 'sbox-places-first sbox-origin-container')]"));
        WebElement cDestino = driver.findElement(By.xpath("//input[contains(@class, 'sbox-places-second')]"));
        WebElement btnBuscar = driver.findElement(By.xpath("//a[contains(@class, 'sbox-search')]"));
        WebElement fechaIda = driver.findElement(By.xpath("//input[@placeholder='Ida']"));
        WebElement fechaVuelta = driver.findElement(By.xpath("//input[@placeholder='Vuelta']"));
        By localizadorOpcion = By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]");
        String origen = "Buenos Aires";
        String destino = "Bariloche";
        String yearMonth = "2021-12";
        // 2- Hacer click en botón “Vuelo + Auto”
        btnVueloAuto.click();

        // 4- Introducir "Buenos Aires" en el campo origen y presionar la tecla enter.
        String textOrigen = seleccionarCiudadBusqueda(cOrigen,localizadorOpcion,origen);
        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",textOrigen);

        //6- Introducir "Bariloche" en el campo destino y presionar la tecla enter.
        String textDestino = seleccionarCiudadBusqueda(cDestino,localizadorOpcion,destino);
        Assert.assertEquals("San Carlos de Bariloche, Rio Negro, Argentina",textDestino);

        // 7- Seleccionar campo fecha desde.  8- Seleccionar fecha 6 dic 2021.
        Assert.assertEquals("Lun, 6 dic 2021",seleccionarFecha("ida","6","12","2021"));
        Assert.assertEquals("Jue, 16 dic 2021",seleccionarFecha("vuelta","16","12","2021"));

        // 11- Hacer click en el botón Buscar.
         btnBuscar.click();
        wait.until(ExpectedConditions.urlContains("/trip/flight/"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/trip/flight/"));
    }

    @Test // Búsqueda de paquete con dos alojamientos
    public void tc011_busquedaPaqueteDosAlojamientos() {
        driver.get("https://www.viajesfalabella.cl/");
        WebElement btnVueloDosAlojamientos = driver.findElement(By.xpath("//input[@value='vhh']"));
        WebElement cOrigen = driver.findElement(By.xpath("//input[contains(@class, 'sbox-places-first sbox-origin-container')]"));
        WebElement cDestino = driver.findElement(By.xpath("//input[contains(@class, 'sbox-places-second')]"));
        WebElement fechaIda = driver.findElement(By.xpath("//input[@placeholder='Ida']"));
        WebElement fechaVuelta = driver.findElement(By.xpath("//input[@placeholder='Vuelta']"));
        WebElement btnBuscar = driver.findElement(By.xpath("//a[contains(@class, 'sbox-search')]"));
        By localizadorOpcion = By.xpath("//body/div[11]/div[1]/div[1]/ul[1]/li[1]");
        String origen = "Buenos Aires";
        String destino1 = "Isla Mujeres";
        String destino2 = "Cancun";

        // 2- Hacer click en el bóton Vuelo + 2 Alojamientos.
        btnVueloDosAlojamientos.click();

        // 4- Introducir "Buenos Aires" en el campo origen de la sección Vuelo ida y vuelta y presionar la tecla enter.
        String textOrigen = seleccionarCiudadBusqueda(cOrigen,localizadorOpcion,origen);

        //  6- Introducir "Isla Mujeres" en el campo destino de la sección Vuelo ida y vuelta y presionar la tecla enter.
        String textDestino1 =seleccionarCiudadBusqueda(cDestino,localizadorOpcion,destino1);

        Assert.assertEquals("Buenos Aires, Ciudad de Buenos Aires, Argentina",textOrigen);
        Assert.assertEquals("Isla Mujeres, Quintana Roo, México",textDestino1);

        //8- Seleccionar fecha ida “ 4 oct 2021”. 10- Seleccionar fecha vuelta “ 16 oct 2021”.

        Assert.assertEquals("Lun, 4 oct 2021",seleccionarFecha("ida","4","10","2021"));
        Assert.assertEquals("Sáb, 16 oct 2021",seleccionarFecha("vuelta","16","10","2021"));

        //13-  Seleccionar campo fecha desde. 14- Seleccionar fecha desde “ 4 oct 2021”.
        // 15-  Seleccionar campo fecha hasta. 16- Seleccionar fecha hasta “ 9 oct 2021”.

        Assert.assertEquals("Lun, 4 oct 2021",seleccionarFecha("desdeDestino1","4","10","2021"));
        Assert.assertEquals("Sáb, 9 oct 2021",seleccionarFecha("hastaDestino1","9","10","2021"));

        //  17- Seleccionar campo Segundo destino. 18- Introducir "Cancún" en el campo Segundo destino de la sección Elige donde alojarte y presionar la tecla enter.
       /*
        WebElement fechaDesde2 = driver.findElement(By.xpath("//input[contains(@class,'sbox-hotel-second-checkin-date')]"));
        WebElement fechaHasta2 = driver.findElement(By.xpath("//input[contains(@class,'sbox-hotel-second-checkout-date')]"));
*/      WebElement segundoDestino = driver.findElement(By.xpath("//input[contains(@class,'sbox-hotel-second-destination')]"));

        String textDestino2 =seleccionarCiudadBusqueda(segundoDestino,localizadorOpcion,destino2);

        Assert.assertEquals("Cancún, Quintana Roo, México",textDestino2);
        Assert.assertEquals("Sáb, 9 oct 2021",seleccionarFecha("desdeDestino2","9","10","2021"));
        Assert.assertEquals("Sáb, 16 oct 2021",seleccionarFecha("hastaDestino2","16","10","2021"));

        //  19- Hacer click en el botón Buscar.
        btnBuscar.click();

        // 20- Hacer click en el botón Ver resumen.
        By localizadorBtnResumen = By.xpath("//body[1]/div[13]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]");
        wait.until(ExpectedConditions.elementToBeClickable(localizadorBtnResumen));
        driver.findElement(localizadorBtnResumen).click();
        WebElement resumen = driver.findElement(By.xpath("//*[@id=\"pkg-wizard\"]/div/div[4]"));
        WebElement headerResumen = resumen.findElement(By.xpath("//body/div[@id='pkg-wizard']/div[1]/div[4]/div[1]/div[1]/div[1]"));
        Assert.assertEquals("El resumen de tu viaje", headerResumen.getText());
    }

    @Test // Proceso reserva de paquete seleccionado desde el home
    public void tc012_reservaPaqueteDesdeHome() throws InterruptedException {
        By locStepperContainer = By.xpath("//*[@class='wizard-stepper-container']");
        By locResumenViaje = By.xpath("//*[@class='sheet-container']");
        By adicionales = By.xpath("//*[@class='xs-card-component -eva-3-shadow-1 TRANSFER']");
        By btnConfirmarTraslado = By.xpath("//a[@class='eva-3-btn-ghost -lg -primary']");
        By btnVerViajeLocator = By.xpath("//a[@class='button -md eva-3-btn -primary']");
        By tituloVerViaje = By.className("texts");
        By checkboxHabitaciones = By.tagName("aloha-roompack-selection");
        By btnSiguienteHabitaciones = By.xpath("//*[@class='eva-3-btn -md -primary -eva-3-fwidth']");
        By btnSiguienteVuelo = By.xpath("//a[@class='-md eva-3-btn -primary']");
        By localizadorVuelo = By.xpath("//div[@class='itineraries']");
        By localizadorAviso = By.xpath(" //*[@class='eva-3-message eva-3-message--toast -eva-3-shadow-static -success -loading']");
        By locAvisoText = By.xpath("//h5[@class='message-title']");
        By quitarTrasladoDefault = By.xpath("//div[@class='remove-container -eva-3-tc-gray-0']");
        By btnQuitarTraslado = By.xpath("//button[@class='eva-3-btn -md -primary']");
        By habitaciones = By.xpath("//div[contains(@class,'sbox-ui-rooms-container sbox-passengers-picker-container')]");
        By btnMenosPersonas = By.xpath("//a[@class='steppers-icon-left sbox-3-icon-minus']");
        By aplicarHabitaciones = By.xpath("//body[1]/div[4]/div[1]/div[2]/a[1]");
        By btnBuscar = By.xpath("//a[contains(@class, 'sbox-search')]");
        By alojamientoSiguiente = By.xpath("//*[@class='eva-3-btn -md -primary -eva-3-fwidth']");


        driver.get("https://www.viajesfalabella.cl/");

        // 2- Seleccionar paquete “Montevideo saliendo de Santiago de Chile” de los paquetes sugeridos en la página.
        By ofertasPaquete = By.xpath("//a[contains(@class,'offer-href')]");

        WebElement paquete = driver.findElements(ofertasPaquete).get(6);
        paquete.click();

        wait.until(ExpectedConditions.urlContains("trip/accommodations/results/"));
        Assert.assertTrue(driver.getCurrentUrl().contains("trip/accommodations/results/"));

        WebElement fechaIda = driver.findElement(By.xpath("//input[@placeholder='Ida']"));
        WebElement fechaVuelta = driver.findElement(By.xpath("//input[@placeholder='Vuelta']"));

        // 4- Seleccionar fecha desde 6 dic 2021
        Assert.assertEquals("Lun, 6 dic 2021",seleccionarFecha("idaCalendarioLateral","6","12","2021"));
        Assert.assertEquals("Jue, 16 dic 2021",seleccionarFecha("vueltaCalendarioLateral","16","12","2021"));
        Thread.sleep(2000);

        // 7- Hacer click en  "habitaciones".
        driver.findElement(habitaciones).click();
        // 8- Seleccionar 1 adulto.
        driver.findElement(btnMenosPersonas).click();
        driver.findElement(aplicarHabitaciones).click();
        WebElement personas = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]"));

        Assert.assertEquals("1",personas.getAttribute("value"));

        driver.findElement(btnBuscar).click();

        Thread.sleep(2000);

        // 9- Seleccionar el alojamiento sugerido.  10- Hacer click en el botón siguiente.
        WebElement alojamientoSig = driver.findElement(alojamientoSiguiente);
        wait.until(ExpectedConditions.elementToBeClickable(alojamientoSig));
        alojamientoSig.click();
       Thread.sleep(2000);

        // CAMBIO PESTAÑA
        driver.close();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        Thread.sleep(2000);
        String urlNuevaPestaña = driver.getCurrentUrl();
        Assert.assertTrue(urlNuevaPestaña.contains("trip/accommodations/detail"));
        Assert.assertEquals("Esplendor by Wyndham Cervantes", driver.getTitle());

        // 11- Seleccionar habitación “Habitación Doble Estándar con Minibar”.
        //12- Hacer click en el botón siguiente.
        List<WebElement> habitacionesDisponibles = driver.findElements(checkboxHabitaciones);
        WebElement habitacionElegida = habitacionesDisponibles.get(2);
        habitacionElegida.click();
        driver.findElement(btnSiguienteHabitaciones).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(localizadorVuelo));

        //13- Seleccionar vuelo sugerido como primer resultado de busqueda.
        WebElement vuelo = driver.findElement(localizadorVuelo);
        //14- Hacer click en el botón siguiente.
        List<WebElement> vuelos = driver.findElements(localizadorVuelo);
        vuelos.get(1).findElement(btnSiguienteVuelo).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locStepperContainer));


        //15- Seleccionar quitar traslado compartido.
        //16- Presionar botón quitar.
        driver.findElement(quitarTrasladoDefault).click();
        driver.findElement(btnQuitarTraslado).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(localizadorAviso));
        String aviso = driver.findElement(locAvisoText).getText();
        Assert.assertEquals("Quitaste el transfer de tu paquete",aviso);


        //Thread.sleep(4000);
        // 17- Seleccionar agregar “Auto Premium”.
        // 18- Presionar botón agregar.
        List<WebElement> adds = driver.findElements(adicionales);
        adds.get(2).click();
        driver.findElement(btnConfirmarTraslado).click();

        Thread.sleep(2000);
        // 19- Hacer click en botón ver viaje.
        WebElement btnVerViaje = driver.findElement(btnVerViajeLocator);
        btnVerViaje.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(locResumenViaje));
        String titulos = driver.findElement(tituloVerViaje).getText();
        String titulo = titulos.split("\n")[0];
        Assert.assertEquals("Tu itinerario de viaje",titulo);

    }

    //Función para completar los campos de busqueda de ciudades.
    private String seleccionarCiudadBusqueda(WebElement element, By localizador, String ciudad) {
        element.sendKeys(ciudad);
        wait.until(ExpectedConditions.elementToBeClickable(localizador));
        String text= driver.findElement(localizador).getText();
        element.sendKeys(Keys.ENTER);
        return text;
    }
   private String seleccionarFecha(String tipoFecha,String dd, String mm, String aaaa) {
        switch (tipoFecha){
            case Ida:
                driver.findElement(fechaIda).click();
                selectDate(2,dd,mm,aaaa);
                return driver.findElement(fechaIda).getAttribute("value");
            case Vuelta:
                selectDate(2,dd,mm,aaaa);
                aplicarFecha(4);
                return driver.findElement(fechaVuelta).getAttribute("value");
            case Destino1Desde:
                return driver.findElement(fechaDesdeDestino1).getAttribute("value");
            case Destino2Desde:
                return driver.findElement(fechaDesdeDestino2).getAttribute("value");
            case Destino1Hasta:
                driver.findElement(fechaHastaDestino1).click();
                selectDate(1,dd,mm,aaaa);
                aplicarFecha(1);
                return driver.findElement(fechaHastaDestino1).getAttribute("value");
            case Destino2Hasta:
                return driver.findElement(fechaHastaDestino2).getAttribute("value");
            case IdaCalendarioLateral:
                driver.findElement(fechaIda).click();
                selectDate(4,dd,mm,aaaa);
                return driver.findElement(fechaIda).getAttribute("value");
            case VueltaCalendarioLateral:
                selectDate(4,dd,mm,aaaa);
                aplicarFecha(4);
                return driver.findElement(fechaVuelta).getAttribute("value");
            default:
                throw new IllegalStateException("Unexpected value: " + tipoFecha);
        }
    }

    private void selectDate(int nCalendar, String dd, String mm, String aaaa) {
        By actualM = By.xpath("//div[contains(@class,'_dpmg2--month-active')]");
        List<WebElement> actualMonth = driver.findElements(actualM);
        int actual = Integer.parseInt(actualMonth.get(nCalendar).getAttribute("data-month").substring(5));
        int clicks =  Integer.parseInt(mm)- actual;
        WebElement btnNext = driver.findElement(By.xpath("//body/div[5]/div[1]/div[2]/div[2]"));
        for (int i =1;i<=clicks;i++) btnNext.click();
        By locMes = By.xpath("//*[@data-month='"+ aaaa +"-"+ mm + "']");
        List<WebElement> month = driver.findElements(locMes);
        List<WebElement> days = month.get(nCalendar).findElements(By.tagName("span"));
        for (WebElement day : days) {
            if(day.getText().equals(dd)){
                day.click();
                break;
            }
        }
    }
    private void aplicarFecha(int indice){
        List<WebElement> btnApply = driver.findElements(btnApicarCalendario);
        btnApply.get(indice).click();
    }


}
