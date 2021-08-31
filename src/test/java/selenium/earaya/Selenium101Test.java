/*
package selenium.earaya;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD:src/test/java/selenium/Selenium101Test.java
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
=======
import org.openqa.selenium.edge.EdgeDriver;
>>>>>>> dbbfec2d806a78263e6a2831ad1b26436ede3e65:src/test/java/selenium/earaya/Selenium101Test.java

public class Selenium101Test {

    WebDriver driver; // es la instancia a crear del navegador - firefox, chrome, safari

    @BeforeClass
    public static void SetUp(){
        System.out.println("Setup");
<<<<<<< HEAD:src/test/java/selenium/Selenium101Test.java
        WebDriverManager.firefoxdriver().setup();
=======
        WebDriverManager.edgedriver().setup(); //vamos a crear una instancia de Google Chrome
>>>>>>> dbbfec2d806a78263e6a2831ad1b26436ede3e65:src/test/java/selenium/earaya/Selenium101Test.java
    }

    @Before
    public void init(){
        System.out.println("init");
<<<<<<< HEAD:src/test/java/selenium/Selenium101Test.java
        driver = new FirefoxDriver();
=======
        driver = new EdgeDriver();
>>>>>>> dbbfec2d806a78263e6a2831ad1b26436ede3e65:src/test/java/selenium/earaya/Selenium101Test.java
    }

    @After
    public void close(){
        System.out.println("After");
       if(driver != null){
           driver.close();
       }
    }

    @Test
    public void test() {
        // Your test code here
        System.out.println("Driver Chrome Configurado!");
    }


}
*/
