/******************************************************************************************************************
 * 
 * Nombre: Xabier Aguirrebeitia Chica 
 * Fecha: 30/10/2024 
 * Modulo: Programación. 
 * UD: UD2 Trabajandonoslos con métodos y objetos. 
 * Tarea: Tarea Evaluación 01. Realiza un programa en Java.
 * 
 * Descripción del programa: El objetivo de esta tarea es realizar un programa que muestre por consola las cuotas anuales y segun una cantidad de dinero solicitada 
 * por el usuario y después muestra la amortización anual segun los años que quiera de hipoteca el usuario y el interes que haya seleccionado.
 * 
 * Enlace autoevaluación: 
 * 
 *******************************************************************************************************************/

import java.util.Scanner;
import java.util.Random;

public class Adivina {

    public static void main (String[] args) {
        Scanner teclado = new Scanner(System.in);
        textoPresentacion();
        double intentosTotales = 0;
        int victorias = 0;
        int partidasJugadas = 0;
        int mejorPartida = 10;
        do{
            int resultadoPartida = jugarPartida(teclado);
            if (resultadoPartida == 20) {
                intentosTotales = intentosTotales + 10;
                partidasJugadas = partidasJugadas + 1;
            }else {
                intentosTotales = intentosTotales + resultadoPartida;  
                victorias = victorias + 1;
                partidasJugadas = partidasJugadas + 1;
                mejorPartida = Math.min(mejorPartida, resultadoPartida);
            }
        } while (seguirJugando(teclado));
        mostrarEstadisticas(intentosTotales, victorias, partidasJugadas, mejorPartida);
    }

    //Metodo que muestra por pantalla el mensaje de presentación del juego
    public static void textoPresentacion(){
        System.out.println("El programa genera un número aleatorio del 1 al 100");
        System.out.println("El usuario o usuaria debe adivinarlo en máximo 10 intentos");
        System.out.println("El programa le dará pistas cada vez que falle");
    }
    
    //Metodo que gestiona cada una de las partidas de forma individual
    public static int jugarPartida(Scanner teclado){
        final int maxIntentos = 10;
        int intentos = 1;
        Random random = new Random(20);
        System.out.println("Adivina un número del 1 al 100");
        int numRandom = random.nextInt(100)+1;
        int numeroIntroducido = 0;
        do {
            System.out.println("Adivina el número: ");
            //metodo que compruebe si el dato es valido, y en caso de no serlo se repita hasta que introduzca uno correcto
            numeroIntroducido = datoCorrecto(teclado);
            if (numRandom < numeroIntroducido){
                System.out.println("El número es menor.");
                intentos ++;
            } else if (numRandom > numeroIntroducido){
                System.out.println("El número es mayor.");
                intentos ++;
            }
            if (intentos > 10) {
                System.out.println("No has adivinado el número secreto: " + numRandom);
                intentos = 20;
            }
        }while (!comprobarNumeros(numRandom,numeroIntroducido) && intentos <= maxIntentos);
        if (intentos <= 10){
            System.out.println("Has adivinado en " + intentos + " intentos.");
        }
        return intentos;

    }
    //Metodo para comprobar si el numero creado de forma aleatoria y el introducido por el usuario o usuaria es el mismo
    public static boolean comprobarNumeros(int numRandom, int numeroIntroducido){
        if (numRandom == numeroIntroducido){
            return true;
        }
        return false;
    }
    
    //Metodo que pregunta al usuario si quiere seguir jugando mas partidas
    public static boolean seguirJugando(Scanner teclado) {
        System.out.println("¿Quieres jugar otra vez (S/N)?");
        String palabraIntroducida = teclado.next();
        palabraIntroducida = palabraIntroducida.toLowerCase();
        if (palabraIntroducida.startsWith("s")){
            return true;
        }
        return false;
    }
    
    //Metodo que sirve para mostrar las estadisticas de todas las partidas que ha jugado el usuario
    public static void mostrarEstadisticas(double intentosTotales, int victorias, int partidasJugadas, int mejorPartida){
        System.out.println("Resultados del juego:");
        System.out.println("Partidas jugadas: " + partidasJugadas);
        System.out.printf("Intentos realizados: %.0f\n", intentosTotales);
        System.out.println("Partidas ganadas: " + victorias);
        double mediaPartidas = intentosTotales / partidasJugadas;
        System.out.println("Intentos por partida: " + mediaPartidas);
        System.out.println("Mejor partida: " + mejorPartida);
    }

    //Metodo que sirve para comprobar si el dato que ha introducido el usuario es correcto y pedirle uno nuevo si no lo fuese
    public static int datoCorrecto(Scanner teclado){
        while (!teclado.hasNextInt()){
            System.out.println("El dato no es correcto.");
            System.out.println("Introduzca un nuevo número (0-100).");
            System.out.println("Adivina el número: ");
            teclado.next();
        }
        int datoIntroducido = teclado.nextInt();
        while (datoIntroducido < 0 || datoIntroducido > 100){
            System.out.println("El número esta fuera de rango.");
            System.out.println("Introduzca un nuevo número (0-100).");
            System.out.println("Adivina el número: ");
            datoIntroducido = teclado.nextInt();
        }
        return datoIntroducido;
    }
}