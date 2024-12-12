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
  }
  public static void tratamientoDatos() {
    
  }
} 
