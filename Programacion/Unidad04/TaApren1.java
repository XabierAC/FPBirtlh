import java.util.*;
import java.io.*;

public class TaApren1 {
    public static void main (String[] args) throws FileNotFoundException{
        File fichero = new File("/Users/xabierac/Developer/GitHub/FPBirtlh/Unidad04/numeros.txt");
        //System.out.println(fichero.getAbsolutePath());
        Scanner leerFichero = new Scanner(fichero);
        System.out.println(fichero.canRead());
        
        

        double sumaTotal = 0;
        while (leerFichero.hasNext()) {
            if (leerFichero.hasNextDouble()) {
                sumaTotal = sumaTotal+leerFichero.nextDouble();
            } else {
                leerFichero.next();
            }
        }
        System.out.println("La suma de todos los numeros es: " + sumaTotal);
        leerFichero.close();
    }
}
