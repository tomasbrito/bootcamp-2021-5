package junit.earaya;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value = Parameterized.class)
public class CalculadoraTest {

      /*  Pruebas a realizar para metodo Multiplicacion
            +*+ = + // 5,5,25
            +*- = - // 5,-5,-25
            -*+ = - // -5,5,-25
            -*- = + // -5,-5,25
  */
    //atributos
    private int numero1, numero2, resultado;

    //Contructor: es donde yo defino la union de los atributos con la interaccion hacia los test
    public CalculadoraTest(int num1, int num2, int res){
        this.resultado = res;
        this.numero1 = num1;
        this.numero2 = num2;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> obtenerData(){
        List<Object[]> datosDePrueba = new ArrayList<>();
        datosDePrueba.add(new Object[] {5,5,25}); // +*+
        datosDePrueba.add(new Object[] {5,-5,-25}); // +*-
        datosDePrueba.add(new Object[] {-5,5,-25}); // -*+
        datosDePrueba.add(new Object[] {-5,-5,25}); // -*-
        return datosDePrueba;
    }

    @Test
    public void signosDeMultipliacion(){
        Calculadora cal1 = new Calculadora();
        Assert.assertEquals(resultado,cal1.Multiplicacion(numero1,numero2));
    }


}
