package pom.grupo3.base;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SeleniumBase {

    //atributos
    WebDriver driver;
    WebDriverWait wait;

    //Constructor
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
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

    public void tipear(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void enter(By locator) { driver.findElement(locator).sendKeys(Keys.ENTER);  }

    public void click(By  locator){
        driver.findElement(locator).click();
    }

    public void exwait (By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
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

    public void cambiarANuevaPestaña(){
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }

}

