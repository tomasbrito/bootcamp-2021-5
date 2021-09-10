package pom.grupo1.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.grupo1.base.SeleniumBase;

import java.util.ArrayList;
import java.util.List;

public class VFAlojamientosPage extends SeleniumBase {

    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    By btnBuscarBy = By.linkText("Buscar");
    By alojamientosFormBy = By.className("sbox-dates");
    By fechaTooltipsBy = By.className("validation-msg");

    public void makeSearch(){
        click(btnBuscarBy);
    }

    public List<String> getFechasTooltipsMsgs(){
        WebElement alojamientosForm = findElement(alojamientosFormBy);
        List<WebElement> fechasTooltips = findChildrenElements(fechaTooltipsBy, alojamientosForm);

        List<String> tooltipsMsgs = new ArrayList<>();

        for (WebElement tooltip: fechasTooltips){
            tooltipsMsgs.add(getText(tooltip));
        }

        return tooltipsMsgs;
    }
}
