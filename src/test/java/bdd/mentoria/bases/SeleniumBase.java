package bdd.mentoria.bases;

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
    public WebElement findElement(By localizador){
        return driver.findElement(localizador);
    }

    public List<WebElement> findElements (By localizador){
        return driver.findElements(localizador);
    }

    public String getText(By localizador){
        return findElement(localizador).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }
    public void typeKey(Keys key, By locator){
        driver.findElement(locator).sendKeys(key);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public String getCurrentUrl(){
       return driver.getCurrentUrl();
    }

    public String getCurrentTitle(){
        return driver.getTitle();
    }




}
