package selenium.lkelly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ManejoDeObjetos {

    WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void init(){
        driver = new ChromeDriver();
    }

    @After
    public void close(){
        if(driver != null){
            driver.close();
        }
    }

    @Test
    public void atc_dropdown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select manejoDropdown = new Select(dropdown);
        manejoDropdown.selectByValue("1"); //Option 1
        manejoDropdown.selectByValue("2"); //Option 2
        manejoDropdown.selectByVisibleText("Option 1");
        manejoDropdown.selectByVisibleText("Option 2");

    }
}
