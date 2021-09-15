package pom.grupo4.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBase {

    //atributos
    WebDriver driver;

    //Constructor
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
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

    public String getUrl(){
        return driver.getCurrentUrl();
    }
    public void enter(By localizador){
        driver.findElement(localizador).sendKeys(Keys.ENTER);
    }
}
