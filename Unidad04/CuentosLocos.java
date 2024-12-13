import java.util.*;
import java.io.*;

public class CuentosLocos {
    
	// Programa de lectura y creación de cuentos locos
    public static void main(String[] args) {
		// Scanner de tipo System in para leer los datos introducidos por el usuario mediante teclado
		Scanner teclado = new Scanner(System.in);
        presentacion();
		menuSeleccion(teclado);
    }
     // Metodo de presentación del programa
    public static void presentacion() {
		System.out.println("Bienvenidos y bienvenidas al juego de los cuentos locos.\n"
				+ "El programa te pedirá que introduzcas una serie de palabras\n"
				+ "que se utilizarán para completar una historia.\n" + "El resultado se guardará en un fichero.\n"
				+ "Puedes leer esas historias siempre que quieras.\n");		
	}

	/*Metodo para preguntar al usuario cual es el fichero de lectura
	 *Pide el nombre del fichero de entrada y comprueba si ese fichero existe, si no existe se lo indica al usuario
	 * y le pide un nuevo nombre de fichero
	 * @Param: Scanner teclado para leer los valores introducidos por teclado
	 * @Return: Devuelve un Scanner de tipo File para trabajar con el fichero de entrada.
	 */
	public static Scanner eleccionFicheroLectura(Scanner teclado) throws FileNotFoundException{
		String pathName = "";
		System.out.println("Nombre del fichero que quieres leer: ");
		pathName = "/Users/xabierac/Developer/GitHub/FPBirtlh/Unidad04/" + teclado.nextLine();
		File fichero = new File(pathName);
		while (!fichero.canRead()) {
			System.out.println("Fichero no encontrado. Inténtelo otra vez\n"
			+ "Nombre del fichero: ");
			fichero = new File(teclado.nextLine());
		}
		return new Scanner(fichero);
	}
	
	public static String eleccionFicheroSalida(Scanner teclado) {
		System.out.println(("Nombre del fichero de salida: "));
		String ficheroSalida = "/Users/xabierac/Developer/GitHub/FPBirtlh/Unidad04/" + teclado.nextLine();
		return ficheroSalida;
	}

	/*
	 * Método que crea el cuento loco. 
	 * Pide el nombre del fichero de entrada con el cuento loco y el de salida identifica las palabras a completar,
	 * las pide por teclado y escribe el cuento en el fichero de salida.
	 * Se gestiona cualquier excepción que pueda ocurrir mientras se lee o escribe el fichero.
	 * Las excepciones se tratarán en el mismo métood sin lanzarlas mediante throws. 
	 * @Param: Scanner teclado para leer valores introducidos por teclado No devuelve ningún valor.
	 * @Return: No devuelve ningún valor.
	 */
	public static void crearCuento(Scanner teclado) {
		Scanner scannerLectura = null;

		try {
			// Se utiliza para pedir al usuario el nombre del archivo de lectura sobre el que se va a trabajar.
			scannerLectura = eleccionFicheroLectura(teclado);

			// Fichero de salida en el que vamos a escribir el cuento rellenado por lo que nos diga el usuario.
			PrintStream ficheroSalida = new PrintStream(eleccionFicheroSalida(teclado));

			/* Recorremos el archivo de lectura y lo escribimos en el de salida, en el caso que haya 
			 * huecos por rellenar los mostramos por pantalla al usuario para que este nos diga que quiere
			 * introducir en dicho hueco, una palabra, una frase, un espacio en blanco...			
			 */ 
			escribirNuevoLibro(scannerLectura, ficheroSalida, teclado);

		} catch (FileNotFoundException excepcion) {
			System.out.println("Fichero no encontrado " + excepcion.getMessage());
		}
	    
	}

	/* Metodo que lee el archivo de lectura y lo pasa al archivo de salida
	 * Cada vez que hay un hueco que debe rellenear el usuario imprime por pantalla el tipo de dato que tiene que 
	 * seleccionar el usuario y lo escribe en el archivo de salida
	 * @Param: Scanner scannerLectura para leer el fichero de lectura
	 * @Param: PrintStream ficheroSalida para escribir en el fichero de salida
	 * @Param: Scanner teclado para leer los valores introducidos por el usuario mediante teclado
	 */
	public static void escribirNuevoLibro(Scanner scannerLectura, PrintStream ficheroSalida, Scanner teclado) {
		String linea = "";
		while (scannerLectura.hasNextLine()) {
			linea = scannerLectura.nextLine();
			ficheroSalida.println(procesarLinea(linea, teclado));
		}	
	}

	/* Metodo para procesar cada linea individualmente
	 * procesa cada palabra de cada linea que le llega como parametro para devolverla como otro String completo de linea
	 * @Param: String linea es la linea que se ha recogido como String en el metodo escribirNuevoLibro
	 * @Param: Scanner teclado para leer los valores introducidos por el usuario mediante teclado
	 * @Return String, valor que devuelve como linea completa para que sea asi escrito en el archivo de salida
	 */
	public static String procesarLinea(String linea, Scanner teclado) {
		String lineaProcesada = "";
		Scanner procesarLinea = new Scanner(linea);
		while (procesarLinea.hasNext()) {
			String palabra = procesarLinea.next();
			if (palabra.startsWith("<")) {
				int longitud = palabra.length();
				int posicionGuion = 0;
				palabra = palabra.substring(1, longitud - 1);
				longitud = palabra.length();
				posicionGuion = palabra.indexOf("-");
				while (posicionGuion != -1) {
					palabra = palabra.substring(0, posicionGuion) + " " + palabra.substring(posicionGuion+1, longitud);
					posicionGuion = palabra.indexOf("-");
				}
				System.out.println(palabra + ":");
				palabra = teclado.nextLine();
			}
			lineaProcesada += palabra + " ";
		}
		return lineaProcesada;
	}
	
	/*
	 * Método que muestra el contenido de un fichero. 
	 * Pide el nombre del fichero hasta que éste sea válido, lo lee línea a línea y lo visualiza por consola.
	 * Se gestiona cualquier excepción que pueda ocurrir mientras se lee el fichero.
	 * Las excepciones se tratarán en el mismo métood sin lanzarlas mediante throws. 
	 * @Param: Scanner teclado para leer valores introducidos por teclado 
	 * @Return: No devuelve ningún valor.
	 */
	public static void verCuento(Scanner teclado) {
		Scanner scannerLectura = null;
		System.out.println("Ver un cuento:");
		try {
			// Se utiliza para pedir al usuario el nombre del archivo de lectura sobre el que se va a trabajar.
			scannerLectura = eleccionFicheroLectura(teclado);
			mostrarPorPantalla(scannerLectura);

		} catch (FileNotFoundException excepcion) {
			System.out.println("Fichero no encontrado " + excepcion.getMessage());
		}
	    
	}

	public static void mostrarPorPantalla(Scanner scannerLectura) {
		PrintStream escribirPantalla = new PrintStream(System.out);
		while (scannerLectura.hasNextLine()) {
			String linea = scannerLectura.nextLine();
			escribirPantalla.println(linea);
		}
	}

	public static char menuSeleccion(Scanner teclado) {
		System.out.println("******* MENU *******");
		System.out.println("(C)rear un \"Mad Lib\"");
		System.out.println("(V)er un \"Mad Lib\"");
		System.out.println("(S)alir");
		System.out.println("Elija su opción:");
		String opcion = teclado.nextLine().toUpperCase();
		char opcionElegida = opcion.charAt(0);
		System.out.println(opcionElegida);
		return opcionElegida;
	}

}
