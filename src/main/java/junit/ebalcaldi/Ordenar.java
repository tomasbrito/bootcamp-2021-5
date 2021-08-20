package junit.ebalcaldi;

public class Ordenar {
    public static String ordenar(char[] array) {
        imprimirArreglo(array);
        char aux = ' ';
        char numero = '1';
        String resultado = "";
        for(int i = 0; i < array.length; i++) {
            if(contieneNumero(numero, array)) {
                if(array[i] == aux) { //final
                    int inicio = getInicio(array, i);
                    int fin = getFin(array, inicio+1);
//					System.out.println(inicio);
//					System.out.println(fin);
                    resultado = getText(array, inicio, fin);
//					System.out.println("encontro el " +array[i]);
                    numero += (char) + 1;

                }
            }else {
                break;
            }
        }
        return resultado;
    }

    private static String getText(char[] array, int inicio, int fin) {
        String resultado = "";
        for(int i = inicio; i <= fin; i++) {
            resultado += array[i];
        }
        return resultado;
    }

    private static int getFin(char[] array, int inicio) {
        while(array[inicio] != ' ' && array[inicio] < array.length) {
            inicio++;
        }
        return inicio;
    }

    private static int getInicio(char[] array, int i) {
        while(array[i] != ' ' && array[i] > array.length) {
            i--;
        }
        return i;

    }

    private static boolean contieneNumero(char numero, char[] array) {
        for(int i = 0; i < array.length;i++) {
            if(array[i] == numero) {
//				System.out.println("Encontro el " +numero);
                return true;
            }
        }
        return false;
    }
    public static void imprimirArreglo(char[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "|");
        }
        System.out.println("");
    }
}
