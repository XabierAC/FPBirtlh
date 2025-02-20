
import java.util.*;
import java.io.*;

public class TaApren1 {
    public static void main (String[] args) throws FileNotFoundException{
        File fichero = new File("/Users/xabierac/Developer/Formacion Developer All/FPBirtlh/Programacion/Unidad04/datos.txt");
        Scanner leerFichero = new Scanner(fichero);
        int total = 0;
        double promedio = 0;
        int mayor = 0;
        int menor = 0;
        int validos = 0;
        String palabras = "";
        
        while (leerFichero.hasNextLine()) {
            if (leerFichero.hasNextInt()) {
                int numero = Integer.parseInt(leerFichero.nextLine());
                total += numero;
                validos ++;
                if (numero > mayor){
                    mayor = numero;
                }
                if (numero < menor || menor == 0) {
                    menor = numero;
                }
            } else {
                if (palabras == ""){
                    palabras = leerFichero.nextLine();
                }else {
                    palabras = palabras + "/" + leerFichero.nextLine();
                }
            }
        }
        promedio = total / validos;
        System.out.println("Total: " + total);
        System.out.println("Promedio: " + promedio);
        System.out.println("Mayor: " + mayor);
        System.out.println("Menor: " + menor);
        System.out.println("Validos: " + validos);
        Scanner palabrasInvalidas = new Scanner(palabras);
        palabrasInvalidas.useDelimiter("/");
        while (palabrasInvalidas.hasNext()){
            System.out.println(palabrasInvalidas.next());
        }
        leerFichero.close();
        palabrasInvalidas.close();
    }
}

