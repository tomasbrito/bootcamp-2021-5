package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ATC05 {

    WebDriver driver;

    @BeforeClass
    public static void init(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //borrar cookies
        driver.manage().window().maximize();

    }

    @After
    public void close(){
        System.out.println("After");
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void atc05(){
        driver.get("http://automationpractice.com/");

        WebElement source = driver.findElement(By.xpath("//*[@id='search_query_top']"));

        source.sendKeys("Blouse");
        source.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector("#center_column a[class='product-name']")).click(); //presionar el primer elemento de la busqueda

        Select dropDown = new Select(driver.findElement(By.id("group_1")));
        dropDown.selectByVisibleText("L");

        WebElement colors = driver.findElement(By.id("color_to_pick_list"));
        List<WebElement> elements = colors.findElements(By.tagName("li"));

        for(WebElement element : elements){
            if(!element.getClass().equals("selected")){
                element.click();
                break;
            }
        }

        driver.findElement(By.xpath("//div[@class='box-cart-bottom']/div/p[@id='add_to_cart']")).click();
    }
}
