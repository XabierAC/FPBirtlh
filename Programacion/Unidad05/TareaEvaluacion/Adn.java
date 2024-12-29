package Programacion.Unidad05.TareaEvaluacion;
import java.io.*;
import java.util.*;
public class Adn {

    final double masaAdeninaA = 135.128;
    final double masaCitosinaC = 111.103;
    final double masaGuaninaG = 151.128;
    final double masaTiaminaT = 125.107;
    final double masaBasura = 100.000;
    final int minCodones = 5;
    final int portentajeCitosinaGuanina = 30;
    final int tiposNucleolitos = 4;
    final int nucleolitosCodon = 3;

    int[] nucleolitos = new int[tiposNucleolitos];
    double[] masaNucleolitos = new double[4];
    String[] listaCodones;

    /* Programa que sirve para generar información importante sobre nucleolitos, simulando que trabaja como los biólogos computacioneles. 
     * Mostrará cuantas veces aparece cada tipo de nucleolito, el porcentaje de masa correspondiente, los codones, indicarña si la 
     * secuencia podría ser un gen que codifica la proteina o no.
     */
    public static void main (String[] args) {
    
    }

    /* Método para escribir todos los resultados obtenidos en el fichero.
     * Tambien servira para mostrar los resultados por consola.
     * @param:  descripcionCadena indica el identificador de la cadena, esProteina indica si la cadena podria codificar la proteina, masaTotal indica la masa total de los nucleolitos
     * @return: no devuelve ningún valor. 
     */
    public static void escribirFichero(PrintStream escrituraFichero,String descripcionCadena, boolean esProteina, double masaTotal){

        escrituraFichero.println("Descripción: " + descripcionCadena);
        escrituraFichero.println("Nucleólitos: " + "Cadena de ADN");
        escrituraFichero.println("Contadores: " + "array nucleolitos");
        escrituraFichero.println("Masa (%): " + "array masaNucleolitos" + " de " + masaTotal);
        escrituraFichero.println("Lista Codones: " + "array con la lista de codones");
        escrituraFichero.println("Es proteina: " + esProteina);
    }

    /* Método para calcular la masa total de los distintos nucleolitos
     * @param: array nucleolitos con las veces que aparece cada tipo de nucleolito
     * @return: la masa total de los nucleolitos
     */
    public static double calculoMasaNucleolitos(double[] nucleolitos){
        double masaTotal = 0;

        return masaTotal;
    }

    /* Método para calcular el porcentaje de la masa total que tiene cada uno de los tipos de nucleolitos
     * @param: masaTotal del todos los nucleolitos, array de los nucleolitos para saber cuantos hay de cada tipo, masaNucleolitos para añadir los porcentajes al array
     * @return: el array con los porcentajes de cada nucleolito.
     */
    public static void calculoPorcentajeMasaNucleolitos(double masaTotal, double[] nucleolito, double[] masaNucleolitos){
        
    }

    /* Método para calcular los codones de la cadena de ADN
     * @param: cadenaAdn con la secuencia de ADN
     * @return: no devuelve ningún valor.
     */
    public static int calculoCodones(String cadenaAdn){
        int contador = 0;

        return contador;

    }

    /* Método para comprobar si la secuencia de ADN podría ser un gen que codifica una proteina
     * @param: no recibe ningún parámetro
     * @return: devuelve true si la secuencia de ADN podría ser un gen que codifica una proteina, false en caso contrario.
     */
    public static boolean comprobarEsProteina(){
        boolean esProteina = false;

        return esProteina;
    }
}