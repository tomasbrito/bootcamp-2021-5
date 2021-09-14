package pom.grupo1.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumBase {

    WebDriver driver;

    public SeleniumBase(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement findChildElement(By locator, WebElement parent) {
        return parent.findElement(locator);
    }

    public List<WebElement> findChildrenElements(By locator, WebElement parent) {
        return parent.findElements(locator);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public void type(String text, WebElement element) {
        element.sendKeys(text);
    }

    public void type(String text, By locator) {
        driver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
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

    public void waitUrlContains(String expectedUrl, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.urlContains(expectedUrl));
        } catch (TimeoutException e) {
            System.out.println("Error waitUrlContains: " + expectedUrl);
        }
    }

    public void waitInvisibilityOf(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Error: waitInvisibilityOf");
        }
    }

    public void waitInvisibilityOf(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.invisibilityOf(findElement(locator)));
        } catch (TimeoutException e) {
            System.out.println("Error: waitInvisibilityOf");
        }
    }

    public void waitVisibilityOf(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Error: waitInvisibilityOf");
        }
    }

    public void waitVisibilityOf(By selector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.invisibilityOf(findElement(selector)));
        } catch (TimeoutException e) {
            System.out.println("Error: waitInvisibilityOf");
        }
    }

    public void waitElementToBeClickable(By selector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(findElement(selector)));
        } catch (TimeoutException e) {
            System.out.println("Error: waitElementToBeClickable");
        }
    }

    public void waitElementToBeClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Error: waitElementToBeClickable");
        }
    }

    public void waitPresenceOfElementLocated(By selector, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
        } catch (TimeoutException e) {
            System.out.println("Error: waitPresenceOfElementLocated");
        }
    }

    public void selectByValue(By locator, String value){
        Select select = new Select(findElement(locator));
        select.selectByValue(value);
    }

    public void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public void switchTab(int tabNum){
        ArrayList<String> browserTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabs.get(tabNum));
    }
}
