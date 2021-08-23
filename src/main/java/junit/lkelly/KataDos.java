package junit.lkelly;

import java.util.ArrayList;
import java.util.Arrays;

/* altERnaTIng cAsE <=> ALTerNAtiNG CaSe

    Description:
    altERnaTIng cAsE <=> ALTerNAtiNG CaSe
    Define String.prototype.toAlternatingCase (or a similar function/method such as to_alternating_case/toAlternatingCase/ToAlternatingCase in your selected language; see the initial solution for details) such that each lowercase letter becomes uppercase and each uppercase letter becomes lowercase. For example:

    StringUtils.toAlternativeString("hello world") == "HELLO WORLD"
    StringUtils.toAlternativeString("HELLO WORLD") == "hello world"
    StringUtils.toAlternativeString("hello WORLD") == "HELLO world"
    StringUtils.toAlternativeString("HeLLo WoRLD") == "hEllO wOrld"
    StringUtils.toAlternativeString("12345") == "12345" // Non-alphabetical characters are unaffected
    StringUtils.toAlternativeString("1a2b3c4d5e") == "1A2B3C4D5E"
    StringUtils.toAlternativeString("StringUtils.toAlternatingCase") == "sTRINGuTILS.TOaLTERNATINGcASE"
    As usual, your function/method should be pure, i.e. it should not mutate the original string.
    *
*
* */


public class KataDos {
    public static String toAlternativeString(String hello_world) {
        ArrayList<String> cadenaSeparada = separar(hello_world);
        ArrayList<String> cadenaAlternativa = new ArrayList<String>();
        for (String palabra:
                cadenaSeparada) {
            cadenaAlternativa.add(arrayToString(cambioAlternativas(palabra)));
        }

        return arrayToString(cadenaAlternativa);
    }

    private static ArrayList<String> cambioAlternativas(String cadena){
        ArrayList<String> resultado = new ArrayList<String>();
        for (int i=0; i<=cadena.length()-1;i++){
            String caracter = String.valueOf(cadena.charAt(i));
            if(isLowerCase(caracter)) caracter = caracter.toUpperCase();
            else  caracter = caracter.toLowerCase();
            resultado.add(caracter);
        }
        return resultado;
    }
    // Método para convertir un ArrayList<String> a un String
    private static String arrayToString(ArrayList<String> a){
        String salida = "";
        for (int i=0; i<= a.size()-1; i++){
            salida = salida + a.get(i);
        }
        return salida;
    }
    //Método para seprarar subcadenas de la cadena original
    private static ArrayList<String> separar(String s){
        return new ArrayList<String>(Arrays.asList(s.split("")));
    }

    // Método para saber si un String esta en minusculas (TRUE si esta en minuscula)
    private static  boolean isLowerCase(String s){
        boolean lowerCase = false;
        if(s.equals(s.toLowerCase())) lowerCase = true;
        return lowerCase;
    }
}
