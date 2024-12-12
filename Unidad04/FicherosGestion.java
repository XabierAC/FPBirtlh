//Archivo de la Tarea Práctica 1 de Prog04
import java.util.*;
import java.io.*;

public class FicherosGestion {
  //Programa para coger los datos de un fichero, pasarlos a otro y generar nuevos datos a partir de los del primer fichero
  public static void main (String[] args) throws FileNotFoundException{
    File ficheroEntrada = null;
    Scanner teclado = new Scanner(System.in);
    boolean sePuedeLeer = false;
    //Pedimos al usuario que nos diga que archivo queremos leer, en caso de que no encuentre el archivo lo indicamos y le pedimos un nuevo archivo
    do{
      System.out.println("Introduce el nombre del Fichero de entrada:");
      ficheroEntrada = new File("/Users/xabierac/Developer/GitHub/FPBirtlh/Unidad04/" + teclado.nextLine());
      if (ficheroEntrada.canRead()) {
        sePuedeLeer = true;
      } else {
        System.out.println("Fichero no encontrado. Inténtalo otra vez");
      }
    }while (!sePuedeLeer);   
    //Creamos el archivo nuevo en el que vamos a guardar los datos con los que hemos trabajado
    System.out.println("Introduce el nombre del Fichero de salida");
    File ficheroSalida = new File("/Users/xabierac/Developer/GitHub/FPBirtlh/Unidad04/" + teclado.nextLine());  
    PrintStream escribirFichero = new PrintStream(ficheroSalida);
    tratamientoDatos(ficheroEntrada, escribirFichero);
    escribirFichero.close();
    teclado.close();
  }
  public static void tratamientoDatos(File ficheroEntrada,PrintStream escribirFichero) throws FileNotFoundException{
    Scanner leerDatos = new Scanner(ficheroEntrada);
    int suma = 0;
    double promedio = 0;
    int mayor = 0;
    int menor = 0;
    int validados = 0;
    int cont = 0;
    String palabra1 = "";
    String palabra2 = "";
    while (leerDatos.hasNextLine()) {
      if (leerDatos.hasNextInt()){
        int numero = leerDatos.nextInt();
        suma += numero;
        cont ++;
        validados ++;
        if (mayor < numero) {
          mayor = numero;
        }
        if (menor > numero || menor == 0) {
          menor = numero;
        }
      }else {
        if (palabra1 == "") {
          palabra1 = leerDatos.nextLine();
        } else {
          palabra2 = leerDatos.nextLine();
        }
      }
      
    }
    promedio = suma / cont;
    escribirEnNuevoFichero(suma, promedio, mayor, menor, validados, palabra1, palabra2, escribirFichero);
    mostrarPorPantalla(suma, promedio, mayor, menor, validados, palabra1, palabra2);
    leerDatos.close();
  }
  public static void escribirEnNuevoFichero(int suma, double promedio, int mayor, int menor, int validados, String palabra1, String palabra2, PrintStream escribirFichero){
    escribirFichero.println("Lineas correctas:");
    escribirFichero.println("\t Suma: " + suma);
    escribirFichero.println("\t Promedio: " + promedio);
    escribirFichero.println("\t Mayor: " + mayor);
    escribirFichero.println("\t Menor: " + menor);
    escribirFichero.println("\t Número validados: " + validados);
    escribirFichero.println("Lineas incorrectas:");
    escribirFichero.println("\t Linea inválida: " + palabra1);
    escribirFichero.println("\t Linea inválida: " + palabra2);
  }
  public static void mostrarPorPantalla(int suma, double promedio, int mayor, int menor, int calidados, String palabra1, String palabra 2){
    PrintStream escribirPantalla = System.out;
    escribirFichero.println("Lineas correctas:");
    escribirFichero.println("\t Suma: " + suma);
    escribirFichero.println("\t Promedio: " + promedio);
    escribirFichero.println("\t Mayor: " + mayor);
    escribirFichero.println("\t Menor: " + menor);
    escribirFichero.println("\t Número validados: " + validados);
    escribirFichero.println("Lineas incorrectas:");
    escribirFichero.println("\t Linea inválida: " + palabra1);
    escribirFichero.println("\t Linea inválida: " + palabra2);
    escribirPantalla.close();
  }
/***Suma de todos los números (Suma)
La media de todos los números enteros (Promedio).
Número mayor
Número menor
Cantidad de números enteros ***/
} 
