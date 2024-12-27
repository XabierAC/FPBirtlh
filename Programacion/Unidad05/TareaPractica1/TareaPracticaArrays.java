package Programacion.Unidad05.TareaPractica1;
import java.util.*;
import java.io.*;
public class TareaPracticaArrays {

    public static void main (String[] args) {
        File ficheroLectura = null;
        Scanner scannerFichero = null;
        PrintStream escrituraDatos = null;

        try {
            ficheroLectura = new File("/Users/xabierac/Developer/Formacion Developer All/FPBirtlh/Programacion/Unidad05/TareaPractica1/datos.txt");
            //ficheroLectura = new File("datos.txt");
            scannerFichero = new Scanner(ficheroLectura);
            scannerFichero.useLocale(Locale.ENGLISH);
            int[] arrayInteger = new int[10];
            int contadorArrayInteger = 0;
            double[] arrayDouble = new double[10];
            int contadorArrayDouble = 0;
            String[] arrayString = new String[10];
            int contadorArrayString = 0;
    
            while (scannerFichero.hasNext()) {
                if (scannerFichero.hasNextInt()){
                    contadorArrayInteger = leerInteger(contadorArrayInteger, scannerFichero.nextInt(), arrayInteger);

                } else if (scannerFichero.hasNextDouble()){
                    contadorArrayDouble = leerDouble(contadorArrayDouble, scannerFichero.nextDouble(), arrayDouble);
                } else {
                    contadorArrayString = leerString(contadorArrayString,scannerFichero.next(), arrayString);
                }
            }
            mensajeDatosProcesados(escrituraDatos, arrayInteger, arrayDouble, arrayString, contadorArrayInteger, contadorArrayString, contadorArrayDouble);
            mensajeEstadisticas(escrituraDatos, arrayInteger, arrayDouble, arrayString, contadorArrayInteger, contadorArrayString, contadorArrayDouble);
            escrituraFicheroSalida(escrituraDatos, arrayInteger, arrayDouble, arrayString, contadorArrayInteger, contadorArrayString, contadorArrayDouble);
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

    public static int leerString(int contadorArrayString, String nombre, String[] arrayStrings){
        arrayStrings[contadorArrayString] = nombre;
        contadorArrayString ++;
        return contadorArrayString;
    }

    public static void mensajeDatosProcesados(PrintStream escrituraDatos, int[] arrayInteger, double[] arrayDouble, String[] arrayString, int contadorArrayInteger, int contadorArrayString, int contadorArrayDouble){
        escrituraDatos = new PrintStream(System.out);
        escrituraDatos.println("--- Datos procesados ---");
        escrituraDatos.print("Edades: ");
        for (int i = 0; i < contadorArrayInteger; i++) {
            escrituraDatos.print(arrayInteger[i] + " ");
        }
        escrituraDatos.println();
        escrituraDatos.print("Nombres; ");
        for (int i = 0; i < contadorArrayString; i++) {
            escrituraDatos.print(arrayString[i] + " ");
        }
        escrituraDatos.println();
        escrituraDatos.print("Alturas; ");
        for (int i = 0; i < contadorArrayDouble; i++) {
            escrituraDatos.print(arrayDouble[i] + " ");
        }
        escrituraDatos.println();
        escrituraDatos.println();
    }

    public static void mensajeEstadisticas(PrintStream escrituraDatos, int[] arrayInteger, double[] arrayDouble, String[] arrayString, int contadorArrayInteger,  int contadorArrayString, int contadorArrayDouble){
        escrituraDatos = new PrintStream(System.out);
        double promedioEdad = 0;
        int edadMax = 0;
        int edadMin = 0;
        double promedioAltura = 0;
        double alturaMax = 0;
        double alturaMin = 0;
        for (int i = 0; i < contadorArrayInteger; i++) {
            promedioEdad += arrayInteger[i];
            if (arrayInteger[i] > edadMax){
                edadMax = arrayInteger[i];
            }
            if (arrayInteger[i] < edadMin || edadMin == 0) {
                edadMin = arrayInteger[i];
            }
        }
        promedioEdad = promedioEdad / contadorArrayInteger;
        for (int i = 0; i < contadorArrayDouble; i++) {
            promedioAltura += arrayDouble[i];
            if (arrayDouble[i] < alturaMin || alturaMin == 0) {
                alturaMin = arrayDouble[i]; 
            }
            if (arrayDouble[i] > alturaMax) {
                alturaMax = arrayDouble[i];
            }
        }
        promedioAltura = promedioAltura / contadorArrayDouble;
        escrituraDatos.println("--- Estadisticas ---");
        escrituraDatos.println("Promedio de edades: " + promedioEdad);
        escrituraDatos.println("Edad máxima: " + edadMax);
        escrituraDatos.println("Edad mínima: " +edadMin);
        escrituraDatos.println("Promedio de alturas: " + promedioAltura);
        escrituraDatos.println("Altura máxima: " + alturaMax);
        escrituraDatos.println("Altura mínima: " + alturaMin);
    }

    public static void escrituraFicheroSalida(PrintStream escrituraDatos, int[] arrayInteger, double[] arrayDouble, String[] arrayString, int contadorArrayInteger,  int contadorArrayString, int contadorArrayDouble){
        try {
            File ficheroSalida = new File("/Users/xabierac/Developer/Formacion Developer All/FPBirtlh/Programacion/Unidad05/TareaPractica1/salida.txt");
            //File ficheroSalida = new File("salida.txt");
            escrituraDatos = new PrintStream(ficheroSalida);
            escrituraDatos.print("Edades: ");
            for (int i = 0; i < contadorArrayInteger; i++) {
                escrituraDatos.print(arrayInteger[i] + " ");
            }
            escrituraDatos.println();
            escrituraDatos.print("Nombres: ");
            for (int i = 0; i < contadorArrayString; i++) {
                escrituraDatos.print(arrayString[i] + " ");
            }
            escrituraDatos.println();
            escrituraDatos.print("Alturas: ");
            for (int i = 0; i < contadorArrayDouble; i++) {
                escrituraDatos.print(arrayDouble[i] + " ");
            }
            escrituraDatos.println();

        } catch (FileNotFoundException e) {
            System.out.println("El fichero no ha sido creado o no se localiza." + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ha habido un error" + e.getMessage());
        }
       
    }  


}