package junit.earaya;


public class Calculadora {

    public int Suma(int numero1, int numero2){
        return numero1+numero2;
    }

    public int Resta(int numero1, int numero2){
        return numero1-numero2;
    }

    public int Multiplicacion(int numero1, int numero2){
        return numero1*numero2;
    }

    public int Division(int numero1, int numero2){
        int division =0;
        division = numero1/numero2;
        return division;
    }
}