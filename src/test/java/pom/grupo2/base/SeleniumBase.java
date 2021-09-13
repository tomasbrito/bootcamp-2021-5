package pom.grupo2.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBase {

    WebDriver driver;

    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement encontrarElemento(By localizador) {
        return driver.findElement(localizador);
    }

    public List<WebElement> encontrarElementos(By localizador) {
        return driver.findElements(localizador);
    }


    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By localizador) {
        return encontrarElemento(localizador).getText();
    }

    public void type(String text, By localizador) {
        driver.findElement(localizador).sendKeys(text);
    }

    public void click(By localizador) {
        driver.findElement(localizador).click();
    }

    public boolean isDisplayed(By localizador) {
        try {
            return driver.findElement(localizador).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}