
import java.util.ArrayList;
import java.util.Collections;

public class Ordenar{
                public static void Main(String[] args) {
                        ArrayList<String> Stringlista = new ArrayList<String>();
                        Stringlista.add("ch4arif");
                        Stringlista.add("s2oy");
                        Stringlista.add("jazm3in");
                        Stringlista.add("ho1la");

                        for (String datos : Stringlista) {
                                System.out.println(datos);
                        }

                        Collections.sort(Stringlista);
                        System.out.println("DESPUES DE ORDENAR...");
                        for (String datos : Stringlista) {
                                System.out.println(datos);


                        }
                }
        }






/**
 * Code Kata: Ordenar Cadena.
 * Cada palabra de la cadena contendrá un solo número.
 * Este número es la posición que debería tener la palabra en el resultado.
 *
 * Nota: Los números pueden ser del 1 al 9.
 * Por lo tanto, 1 será la primera palabra (no 0).
 *
 * Si la cadena de entrada está vacía,
 * devuelve una cadena vacía.
 * Las palabras en la cadena de entrada solo contendrán números consecutivos válidos.
 *
 * Ejemplos:
 *    "oraci4on un3a e2s Es1ta" -> "Es1ta e2s un3a oraci4on"
 *
 */


