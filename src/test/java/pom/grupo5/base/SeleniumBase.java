package pom.grupo5.base;

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
    public SeleniumBase(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
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

    public String obtenerAtributoValue(By localizador){
        return encontrarElemento(localizador).getAttribute("value");
    }

    public void tipear(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
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

    public void ingresarTexto(By localizador,String s){
        driver.findElement(localizador).sendKeys(s);
    }
    public void ingresarEnter(By localizador){
        driver.findElement(localizador).sendKeys(Keys.ENTER);
    }
   // public void waitUrlContains(String s){ wait.until(ExpectedConditions.urlContains(s));}
    public String obtenerUrl(){
       return driver.getCurrentUrl();
    }


    public void esperarUrlContains(String s) {
        wait.until(ExpectedConditions.urlContains(s));
    }
}
