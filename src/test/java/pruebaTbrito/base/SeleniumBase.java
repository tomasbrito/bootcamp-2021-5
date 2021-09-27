package pruebaTbrito.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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
    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void tipear(String text, WebElement element) {
        element.sendKeys(text);
    }
    public void type(Keys key, By locator) {
        driver.findElement(locator).sendKeys(key);
    }
    public void enter(By locator) { driver.findElement(locator).sendKeys(Keys.ENTER);  }
    public void click(By  locator){
        driver.findElement(locator).click();
    }
    public void exwait (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
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

    public void switchToIframe(){
        driver.switchTo().frame(0);
    }

}

