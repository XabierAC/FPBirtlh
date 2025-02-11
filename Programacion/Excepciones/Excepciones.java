package Excepciones;
import java.util.*;

public class Excepciones {
    public static void main(String[] args) {
        System.out.println("Introduce un número: ");
        Scanner inputSc = new Scanner(System.in);
        try {
            int numero = Integer.parseInt(inputSc.nextLine());
            System.out.println("El número introducido es: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("No has introducido un número entero");
        } finally {
            System.out.println("Esto se ejecutara siempre");
            inputSc.close();
        }
    }

}