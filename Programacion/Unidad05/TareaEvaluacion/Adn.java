package Programacion.Unidad05.TareaEvaluacion;
import java.io.*;
import java.util.*;
public class Adn {

    static final double masaAdeninaA = 135.128;
    static final double masaCitosinaC = 111.103;
    static final double masaGuaninaG = 151.128;
    static final double masaTiaminaT = 125.107;
    static final double masaBasura = 100.000;
    static final int minCodones = 5;
    static final int portentajeCitosinaGuanina = 30;
    static final int tiposNucleotidos = 4;
    static final int nucleolitosCodon = 3;

    static int[] nucleotidos = new int[tiposNucleotidos];
    static double[] masaCadaNucleotido = {135.128, 111.103, 151.128, 125.107, 100.000};
    static double[] masaNucleotidos = new double[tiposNucleotidos];
    static String[] listaCodones;
    
    /* Programa que sirve para generar información importante sobre nucleotidos, simulando que trabaja como los biólogos computacioneles. 
     * Mostrará cuantas veces aparece cada tipo de nucleotido, el porcentaje de masa correspondiente, los codones, indicarña si la 
     * secuencia podría ser un gen que codifica la proteina o no.
     */
    public static void main (String[] args) {
        Scanner scannerLectura = null;
        PrintStream escrituraLineas = null;
        presentacion();
        try {
            // tengo que hacer que pida un fichero de entrada y uno de salida
            // Introduce el nombre del fichero: 
            // Introduce el nombre del fichero: 
            File ficheroLectura = new File("/Users/xabierac/Developer/Formacion Developer All/FPBirtlh/Programacion/Unidad05/TareaEvaluacion/dna.txt");
            scannerLectura = new Scanner(ficheroLectura);
            while (scannerLectura.hasNextLine()) {
                String descripcionCadena = scannerLectura.nextLine();
                String cadenaAdn = scannerLectura.nextLine().toUpperCase();
                // Trabamos para calcular todos los datos necesarios de la cadena y damos formato por pantalla y por fichero.
                int basura = calculoTipoNucleotidos(cadenaAdn, nucleotidos);
                double masaTotal = calculoMasaNucleotidos(nucleotidos, basura);
                calculoPorcentajeMasaNucleotidos(masaTotal, nucleotidos, masaNucleotidos);
                calculoCodones(cadenaAdn, nucleotidos);
                boolean esProteina = comprobarEsProteina(listaCodones, masaNucleotidos);
                escribir(System.out, descripcionCadena, esProteina, masaTotal, cadenaAdn, nucleotidos, masaNucleotidos, listaCodones);
                reinicioArrayNucleotidos(nucleotidos);

            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha localizado el archivo que queria leer. " + e.getMessage());
        } catch (Exception e){
            System.out.println("Ha habido un error inesperado." + e.getMessage());
        }
        scannerLectura.close();
    }

    /* Método para calcular cuantas veces aparece cada uno de los tipos de nucleotidos en la cadena.
     * @param: cadenaAdn con la secuencia de ADN de tipo String, array nucleotidos con el array donde vamos a indicar cuantas veces aparece cada tipo.
     * @return: devuelve el número de nucleotidos considerados basura.
     */
    public static int calculoTipoNucleotidos(String cadenaAdn, int[] nucleotidos){
        char tipoNucleolitoChar;
        int contadorBasura = 0;
        for (int i = 0; i < cadenaAdn.length(); i++) {
            tipoNucleolitoChar = cadenaAdn.charAt(i);
            if (tipoNucleolitoChar == 'A') {
                nucleotidos[0]++;
            } else if (tipoNucleolitoChar == 'C') {
                nucleotidos[1]++;
            } else if (tipoNucleolitoChar == 'G') {
                nucleotidos[2]++;
            } else if (tipoNucleolitoChar == 'T') {
                nucleotidos[3]++;
            } else if (tipoNucleolitoChar == '-') {
                contadorBasura ++;
            }
        }
        return contadorBasura;
    }

    /* Método para escribir todos los resultados obtenidos en el fichero.
     * Tambien servira para mostrar los resultados por consola.
     * @param:  descripcionCadena indica el identificador de la cadena, esProteina indica si la cadena podria codificar la proteina, masaTotal indica la masa total de los nucleolitos
     * @return: no devuelve ningún valor. 
     */
    public static void escribir(PrintStream escrituraFichero,String descripcionCadena, boolean esProteina, double masaTotal, String cadenaAdn, int[] nucleotidos, double[] masaNucleotidos, String[] listaCodones){

        escrituraFichero.println("Descripción: " + descripcionCadena);
        escrituraFichero.println("Nucleótidos: " + cadenaAdn);
        escrituraFichero.println("Contadores: " + Arrays.toString(nucleotidos));
        escrituraFichero.println("Masa (%): " + Arrays.toString(masaNucleotidos) + " de " + masaTotal);
        escrituraFichero.println("Lista Codones: " + Arrays.toString(listaCodones));
        escrituraFichero.println("Es proteina: " + esProteina);
        System.out.println();
        escrituraFichero.close();
    }

    /* Método para calcular la masa total de los distintos nucleotidos
     * @param: array nucleolitos con las veces que aparece cada tipo de nucleotido y contadorBasura con el nímero de nucleotidos considerados basura
     * @return: la masa total de los nucleotidos
     */
    public static double calculoMasaNucleotidos(int[] nucleotidos, int contadorBasura){
        double masaTotal = 0;
        int contador = 0;
        while (contador < tiposNucleotidos) {
            if (contador == 0) {
                masaTotal += nucleotidos[contador] * masaAdeninaA;
                contador ++;
            } else if (contador == 1){
                masaTotal += nucleotidos[contador] * masaCitosinaC;
                contador ++;
            } else if (contador == 2){
                masaTotal += nucleotidos[contador] * masaGuaninaG;
                contador ++;
            } else if (contador == 3){
                masaTotal += nucleotidos[contador] * masaTiaminaT;
                contador ++;
            }
        }
        masaTotal += contadorBasura * masaBasura;
        
        return masaTotal;
    }

    /* Método para calcular el porcentaje de la masa total que tiene cada uno de los tipos de nucleotidos
     * @param: masaTotal del todos los nucleotidos, array de los nucleotidos para saber cuantos hay de cada tipo, masaNucleotidos para añadir los porcentajes al array
     * @return: el array con los porcentajes de cada nucleotido.
     */
    public static void calculoPorcentajeMasaNucleotidos(double masaTotal, int[] nucleotidos, double[] masaNucleotidos){
        for (int i = 0; i < tiposNucleotidos; i ++) {
            masaNucleotidos[i] = nucleotidos[i] * masaCadaNucleotido[i] * 100 / masaTotal;
        }
    }

    /* Método para calcular los codones de la cadena de ADN y almacenarlos como tal en un array.
     * @param: cadenaAdn con la secuencia de ADN y nucleotidos con el array de la cantidad de cada tipo de nucleotido
     * @return: no devuelve ningún valor.
     */
    public static void calculoCodones(String cadenaAdn, int[] nucleotidos){
        int contador = 0;
        String palabra = "";
        int posArray = 0;
        int lenghtArray = 0;
        for (int i = 0; i < nucleotidos.length; i ++) {
            lenghtArray += nucleotidos[i];
        }
        listaCodones = new String[lenghtArray/3];
        for (int i = 0; i < cadenaAdn.length(); i ++) {
            char letra = cadenaAdn.charAt(i);
            if (letra != '-') {
                palabra += letra;
                contador ++;
            }
            if (contador == nucleolitosCodon) {
                listaCodones[posArray] = palabra;
                palabra = "";
                contador = 0;
                posArray ++;
            }
        }
    }

    /* Método para comprobar si la secuencia de ADN podría ser un gen que codifica una proteina
     * @param: listaCodones con la lista de los codones que genera la cadena, masaNucleotidos con el porcentaje de masa de cada tipo de nucleotido
     * @return: devuelve true si la secuencia de ADN podría ser un gen que codifica una proteina, false en caso contrario.
     */
    public static boolean comprobarEsProteina(String[] listaCodones, double[] masaNucleotidos){
        boolean esProteina = false;
        // Comienza por ATG, finaliza en TAA-TAG-TGA, contiene al menos 5 codones, C + G >= 30%
        if (listaCodones[0].equals("ATG") && listaCodones[listaCodones.length - 1].equals("TAA") || listaCodones[listaCodones.length - 1].equals("TAG") || listaCodones[listaCodones.length - 1].equals("TGA") && listaCodones.length >= minCodones && masaNucleotidos[1] + masaNucleotidos[2] >= portentajeCitosinaGuanina) {
            esProteina = true;
        }
        return esProteina;
    }
    
    /* Método para reiniciar el array de nucleotidos a 0 para que no se acumulen los de la cadena anterior al aparecer por consola o al guardarlos en el fichero de salida
     * @param: array de los nucleotidos
     * @return: no devuelve ningun valor.
     */
    public static void reinicioArrayNucleotidos(int[] nucleotidos) {
        for (int i =0; i < nucleotidos.length; i++) {
            nucleotidos[i] = 0;
        }
    }

    /* Metodo que muestra el mensaje de presentación del programa
     * @param: no recibe ningún parámetro
     * @return: no devuelve ningun valor
     */
    public static void presentacion() {
        System.out.println("Este programa genera información sobre");
        System.out.println("secuencias de nucleótidos de ADN contenidas en un fichero");
        System.out.println("También indicará si pueden codificar proteinas o no");
        System.out.println("Todos los resultados se guardarán en un fichero de salida");
    }
}
