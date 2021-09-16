package pom.grupo3.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class SeleniumBase {
    //atributos
    WebDriver driver;
    WebDriverWait wait;
    //Constructor
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,15);
    }
    //Metodos envolver la tecnologia Selenium -> Wrapper
    public WebElement encontrarElemento(By localizador){
        return driver.findElement(localizador);
    }
    public List<WebElement> encontrarElementos (By localizador){
        return driver.findElements(localizador);
    }
    public String obtenerTexto(By localizador){
        return encontrarElemento(localizador).getText();
    }
    public String obtenerTexto(WebElement localizador){
        return localizador.getText();
    }
    public String URLactual() {
        return driver.getCurrentUrl();
    }
    public void tipear(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void tipear(String text, WebElement element) {
        element.sendKeys(text);
    }
    public void enter(By locator) { driver.findElement(locator).sendKeys(Keys.ENTER);  }
    public void click(By  locator){
        driver.findElement(locator).click();
    }
    public void exwait (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementsToBeMoreThan(int amount, By locator, int timeout) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(500));
        try {
            fluentWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, amount));
        } catch (TimeoutException e) {
            System.out.println("Error: waitElementsToBeMoreThan");
        }
    }
    public Boolean estaDesplegado(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void goToUrl(String url){
        driver.get(url);
    }
    public List<WebElement> findChildrenElements(By locator, WebElement parent) {
        return parent.findElements(locator);
    }
    public void cambiarANuevaPestaña(){
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
    public WebElement elementoHijo(By locator, WebElement parent) {
        return parent.findElement(locator);
    }
    public void waitUrlContains(String expectedUrl, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.urlContains(expectedUrl));
        } catch (TimeoutException e) {
            System.out.println("Error waitUrlContains: " + expectedUrl);
        }
    }
    public void elmentoVisible(String cadena) {
        Select edad = new Select(driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div/div/select")));
        edad.selectByVisibleText(cadena);
    }

    public void cambioPestaña(int tabNum){
        /*ArrayList<String> pestaña = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pestaña.get(tabNum));*/
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            //Thread.sleep(1000);
        }
    }
}

