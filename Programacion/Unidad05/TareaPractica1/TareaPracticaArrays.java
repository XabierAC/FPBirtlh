package Programacion.Unidad05.TareaPractica1;
import java.util.*;
import java.io.*;
public class TareaPracticaArrays {

    public static void main (String[] args) {
        File ficheroLectura = null;
        Scanner scannerFichero = null;
        int[] arrayInteger = new int[10];
        int contadorArrayInteger = 0;
        double[] arrayDouble = new double[10];
        int contadorArrayDouble = 0;
        String[] arrayString = new String[10];
        int contadorArrayString = 0;

        try {
            ficheroLectura = new File("/Users/xabierac/Developer/Formacion Developer All/FPBirtlh/Programacion/Unidad05/TareaPractica1/datos.txt");
            scannerFichero = new Scanner(ficheroLectura);
            scannerFichero.useLocale(Locale.ENGLISH);
            while (scannerFichero.hasNext()) {
                if (scannerFichero.hasNextInt()){
                    contadorArrayInteger = leerInteger(contadorArrayInteger, scannerFichero.nextInt(), arrayInteger);
                } else if (scannerFichero.hasNextDouble()){
                    contadorArrayDouble = leerDouble(contadorArrayDouble, scannerFichero.nextDouble(), arrayDouble);
                } else {
                    contadorArrayString = leerString(contadorArrayString,scannerFichero.next(), arrayString);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero que buscabas, ha habido un error" + e.getMessage());
        } catch (Exception e){
            System.out.println("Ha habido un error" + e.getMessage());
        }
        scannerFichero.close();
    }

    public static int leerInteger(int contadorArrayInteger, int numero, int[] arrayInteger){
        arrayInteger[contadorArrayInteger] = numero;
        contadorArrayInteger ++;
        return contadorArrayInteger;
    }

    public static int leerDouble(int contadorArrayDouble, double numero, double[] arrayDouble){
        arrayDouble[contadorArrayDouble] = numero;
        contadorArrayDouble ++;
        return contadorArrayDouble;
    }

    public static int leerString(int contadorArrayString, String nombre, String[] arraStrings){
        arraStrings[contadorArrayString] = nombre;
        contadorArrayString ++;
        return contadorArrayString;
    }
}