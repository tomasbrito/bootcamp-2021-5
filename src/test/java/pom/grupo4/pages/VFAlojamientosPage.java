package pom.grupo4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pom.grupo4.base.SeleniumBase;

public class VFAlojamientosPage extends SeleniumBase {
    By botonFechaIda = By.xpath("//body[1]/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
    By campoFechaIda = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[30]/span[1]");
    By campoFechaVuelta = By.xpath("//body/div[1]/div[1]/div[5]/div[1]/div[4]/span[26]/span[1]");

    public VFAlojamientosPage(WebDriver driver) {
        super(driver);
    }

    public void clickearInputFecha(){
        click(botonFechaIda);
    }
    public void clickearFechaIda(){
        click(campoFechaIda);
    }
    public void clickearFechaVuelta(){
        click(campoFechaVuelta);
    }
    public String getFechaVueltaValue(){
        return encontrarElemento(campoFechaVuelta).getText();
    }

}
