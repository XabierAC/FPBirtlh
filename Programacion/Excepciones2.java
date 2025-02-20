
import java.util.*;

public class Excepciones2 {
    public static void main(String[] args) {
        Scanner inputSC = new Scanner(System.in);
        int num1 = 0, num2 = 1; //Inicializamos las variables, el num2 como 1 para evitar la division entre 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                System.out.println("Introduce un número: ");
                num1 = Integer.parseInt(inputSC.nextLine());
                System.out.println("Introduce el segundo número: ");
                num2 = Integer.parseInt(inputSC.nextLine());
                int resultado = num1 / num2;
                System.out.println("El resultado es: " + resultado);
                entradaValida = true; //Si llegamos hasta aqui, la entrada es valida
            } catch (NumberFormatException e1) {
                System.out.println("El números introducido no es un número válido. Intentalo de nuevo");
            } catch (ArithmeticException e2) {
                System.out.println("No se puede dividir entre 0. Intentalo de nuevo");
            } catch (Exception e3){
                e3.printStackTrace();
            }
        }
        System.out.println("Operación finalizada");
        inputSC.close();

    }
}

