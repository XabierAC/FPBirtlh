
/******************************************************************************************************************
 * 
 * Nombre: Xabier Aguirrebeitia Chica 
 * Fecha: 17/11/2024 
 * Modulo: Programación. 
 * UD: UD3 Estructúras de control. 
 * Tarea: Tarea Practica 01.
 * 
 * Descripción del programa: El objetivo de esta taréa es realizar un programa que calcule la nota media entre el examen parcial, el examen final y las
 * Unidades Didácticas para un alumno, ademas debería tener la capacidad para comprar los datos entre dos alumnos en caso de ser introducidos.
 * 
 * Enlace autoevaluación: https://docs.google.com/document/d/1u6JoAtE7-0qEzMY9ZjhV_jdP2pQ5hn-B/edit?usp=share_link&ouid=118079182232210410949&rtpof=true&sd=true
 * 
 *******************************************************************************************************************/

import java.util.Scanner;

public class NotaMedia {

    // Metodo que calcula la nota media entre el examen parcial, final y las
    // unidades para un alumno
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String textoParcialFinal = "";

        mensajeInicial();
        textoParcialFinal = "Parcial";
        double notaParcial = notaExamen(textoParcialFinal, teclado);
        textoParcialFinal = "Final";
        double notaFinal = notaExamen(textoParcialFinal, teclado);
        double notaTotalExamenes = notaTotalExamenes(notaParcial, notaFinal);
        double totalUnidades = notaUnidades(teclado);
        double totalFinal = notaTotal(notaTotalExamenes, totalUnidades);
        totalFinal(totalFinal);
        // compracionAlumnos(teclado, totalFinal);
    }

    // Muestra el mensaje de presentacion del programa
    public static void mensajeInicial() {
        System.out.println("Este programa lee las calificaciones de exámenes (parcial y final) y Unidades Didácticas");
        System.out.println("para calcular la nota final del módulo.");
        System.out.println("También podría hacerlo para 2 estudiantes y comparar sus notas. Funcionaría sin problemas.");
    }

    // Muestra la nota del examen parcial o final segun el dato introducido para que
    // realice uno u otro.
    public static double notaExamen(String textoParcialFinal, Scanner teclado) {
        int pesoExamen = 0;
        if (textoParcialFinal.equals("Parcial")) {
            System.out.print("PARCIAL:");
            System.out.println();
            pesoExamen = 40;
        } else {
            System.out.println("FINAL:");
            pesoExamen = 60;
        }
        System.out.println("Introduce la calificación del examen (0-100): ");
        int notaExamen = teclado.nextInt();
        System.out.println("¿Has obtenido puntos extra (1=Si, 2=No)? ");
        int obtencionPuntosExtra = teclado.nextInt();
        if (obtencionPuntosExtra == 2) {
            System.out.println("Nota final = " + notaExamen + " / 100");
        } else {
            System.out.println("Introduce el total de puntos extra (0-10):");
            int puntosExtra = teclado.nextInt();
            notaExamen = notaExamen + puntosExtra;
            if (notaExamen > 100) {
                notaExamen = 100;
            }
            System.out.println("Nota final = " + notaExamen + " / 100");
        }
        double notaFinal = calculoProporcion(notaExamen, pesoExamen);
        System.out.printf("Nota final ponderada = %.1f", notaFinal);
        System.out.println(" / " + pesoExamen);
        return notaFinal;
    }

    // Método que sirve para calcular la nota final ponderada entre el examen
    // parcial y el final y muestra el resultado por pantalla
    public static double notaTotalExamenes(double notaParcial, double notaFinal) {
        double notaFinalExamenes = notaParcial + notaFinal;
        System.out.println("TOTAL EXAMENES");
        System.out.printf("Nota final ponderada de los exámenes (sobre 100): %.1f.\n", notaFinalExamenes);
        return notaFinalExamenes;
    }

    // Método que sirve para calcular la nota media entre las unidades y muestra el
    // resultado por pantalla
    public static double notaUnidades(Scanner teclado) {
        System.out.println("UNIDADES:");
        System.out.println("Introduce el número de unidades:");
        int numUnidades = teclado.nextInt();
        double mediaUnidades = 0.0;
        for (int i = 1; i <= numUnidades; i++) {
            System.out.println("UD " + i + ":");
            System.out.println("Introduce el peso de la UD (0-100): ");
            int pesoUnidad = teclado.nextInt();
            System.out.println("Introduce la puntuación obtenida (0-100): ");
            int notaUnidad = teclado.nextInt();
            mediaUnidades = mediaUnidades + calculoProporcion(notaUnidad, pesoUnidad);
        }
        System.out.println("TOTAL UDs");
        System.out.printf("Nota final ponderada de las UDs (sobre 100): %.1f.\n", mediaUnidades);
        return mediaUnidades;
    }

    // Método que sirve para calcular el la proporciónal de la nota
    public static double calculoProporcion(int num1, int num2) {
        double resultado = num1 * num2;
        resultado = resultado / 100;
        return resultado;
    }

    // Método que sirve para mostrar la nota final de los dos examenes mas las
    // unidades, lo muestra por pantalla y
    // muestra un mensaje en función de dicha nota
    public static void totalFinal(double totalFinal) {
        System.out.printf("TOTAL FINAL: %.1f\n", totalFinal);
        if (totalFinal == 100) {
            System.out.println("La nota final en una escala del 0 al 4 es al menos: 4.0");
            System.out.println("Excelente trabajo");
        } else if (totalFinal < 100 && totalFinal >= 85) {
            System.out.println("La nota final en una escala del 0 al 4 es al menos: 3.0");
            System.out.println("Muy buen trabajo");
        } else if (totalFinal < 85 && totalFinal >= 75) {
            System.out.println("La nota final en una escala del 0 al 4 es al menos: 2.0");
            System.out.println("Buen trabajo");
        } else if (totalFinal < 75 && totalFinal >= 60) {
            System.out.println("La nota final en una escala del 0 al 4 es al menos: 1.5");
            System.out.println("Todavía tienes trabajo por hacer");
        } else if (totalFinal < 60) {
            System.out.println("La nota final en una escala del 0 al 4 es al menos: 0.0 ");
            System.out.println("Otra vez será");
        }
    }

    // Método que sirve para calcular la nota total entre la final de los dos
    // examenes y de las unidades
    public static double notaTotal(double notaTotalExamenes, double totalUnidades) {
        double notaExamenes = (notaTotalExamenes * 50) / 100;
        double totalUDs = (totalUnidades * 50) / 100;
        double notaFinal = notaExamenes + totalUDs;
        return notaFinal;
    }
    /********************
     * // Método que sirve para comparar la nota media de dos alumnos
     * private static void compracionAlumnos(Scanner teclado, double totalFinal1) {
     * String textoParcialFinal = "";
     * System.out.println("Quieres comparar las notas entre dos alumnos? (1=Sí,
     * 2=No)");
     * int consultaMasAlumnos = teclado.nextInt();
     * if (consultaMasAlumnos == 2) {
     * System.out.println("Vale, finalizamos el programa, gracias.");
     * } else {
     * double alumno1 = totalFinal1;
     * double alumno2 = 0.0;
     * textoParcialFinal = "Parcial";
     * double notaParcial = notaExamen(textoParcialFinal, teclado);
     * textoParcialFinal = "Final";
     * double notaFinal = notaExamen(textoParcialFinal, teclado);
     * double notaTotalExamenes = notaTotalExamenes(notaParcial, notaFinal);
     * double totalUnidades = notaUnidades(teclado);
     * double totalFinal2 = notaTotal(notaTotalExamenes, totalUnidades);
     * totalFinal(totalFinal2);
     * alumno2 = totalFinal2;
     * System.out.println("La nota del alumno 1 es: " + alumno1);
     * System.out.println("La nota del alumno 2 es: " + alumno2);
     * if (alumno1 < alumno2) {
     * System.out.println("El alumno 1 tiene peor nota que el alumno 2");
     * } else if (alumno1 > alumno2) {
     * System.out.println("El alumno 1 tiene mejor nota que el alumno 2");
     * } else {
     * System.out.println("Ambos alumnos tienen la misma nota");
     * }
     * }
     * }
     ***************/
}