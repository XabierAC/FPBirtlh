import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Locale;

public class SimuladorHipoteca {

    // Metodo que muestra unas tablas de cuotas anuales segun los intereses y el
    // dinero solicitado para la hipoteca y ademas muestra las amortizaciones segun
    // los intereses y plazos indicados por el usuario
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        teclado.useLocale(Locale.ENGLISH);
        mensajeInicial();
        double dineroSolicitado = cantidadSolicitada(teclado);
        mostrarAmortizacion(teclado, dineroSolicitado);
    }

    // Metodo que genera el mensaje inicial a mostrar al usuario
    public static void mensajeInicial() {
        System.out.println("Esto es un simulador de hipoteca");
        System.out.println("PRIMERO");
        System.out.println("Solicita el monto del préstamo (euros) e imprime una tabla con diferentes opciones según el interés y plazo");
        System.out.println("SEGUNDO");
        System.out.println("Solicita el monto del préstamo (euros), la tasa de interés anual a pagar (%) y el plazo (años)");
        System.out.println("Calcula para cada año, el capital pendiente y la cuota a pagar, intereses y amortización");
        System.out.println();
    }

    // Muestra las tablas de intereses segun el plazo de amortizacion para la
    // cantidad solicitada al banco y devuelve el dinero que ha solicitado el
    // usuario para utilizarlo mas adelante en otro metodo
    public static double cantidadSolicitada(Scanner teclado) {
        System.out.println("Introduce la cantidad solicitada para el préstamo: ");
        double dineroSolicitado = teclado.nextDouble();
        System.out.println();
        System.out.println("PRIMERO");
        System.out.println("Estas son las cuotas a pagar para diferentes intereses y plazos");
        // Muestra las cuotas anuales para hipotecas entre 20 y 25 años segun el porcentaje de interes aplicado
        for (int i = 20; i < 26; i++) {
            System.out.print(i + " Años \t");
            for (double j = 3.00; j <= 5.00; j = j + 0.5) {
                double interes = j / 100;
                double cuotaAnual = cuotaAnual(dineroSolicitado, interes, i);
                String numDecimal = redondeoDecimales(cuotaAnual);
                System.out.print(numDecimal + "(" + j + "%) \t");
            }
            System.out.println();
        }
        return dineroSolicitado;
    }

    // Metodo que redondea los numeros a 2 decimales
    public static String redondeoDecimales(double numero) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String resultado = decimalFormat.format(numero);
        return resultado;
    }

    // Muestra la amortizacion e interes de cada año segun la cantidad indicada al
    // inicio con el interes y plazo seleccionados
    public static void mostrarAmortizacion(Scanner teclado, double dineroSolicitado) {
        double amortizacion = 0.00;
        double capitalPendiente = dineroSolicitado;
        double interesPagar = 0.00;
        System.out.println();
        System.out.println("SEGUNDO");
        System.out.println("Introduce el interés anual que se aplicará al préstamo en %: ");
        double interesSolicitado = teclado.nextDouble();
        interesSolicitado = interesSolicitado / 100;
        System.out.println("Introduce el número de años que va a durar el préstamo: ");
        int duracionPrestamo = teclado.nextInt();
        double cuota = cuotaAnual(capitalPendiente, interesSolicitado, duracionPrestamo);
        String cuotaDecimal = redondeoDecimales(cuota);
        for (int i = 1; i <= duracionPrestamo; i++) {
            System.out.println("Año: " + i);
            capitalPendiente = capitalPendiente - amortizacion;
            String capitalPendienteDecimal = redondeoDecimales(capitalPendiente);
            System.out.println("\t Capital Pendiente: " + capitalPendienteDecimal);
            System.out.println("\t Cuota Anual: " + cuotaDecimal);
            interesPagar = capitalPendiente * interesSolicitado;
            String interesPagarDecimal = redondeoDecimales(interesPagar);
            System.out.println("\t Intereses a pagar: " + interesPagarDecimal);
            amortizacion = cuota - interesPagar;
            String amortizacionDecimal = redondeoDecimales(amortizacion);
            System.out.println("\t Amortización: " + amortizacionDecimal);

        }
    }

    // Metodo que calcula la cuota anual segun la formula indicada
    public static double cuotaAnual(double dinero, double interes, int duracion) {
        double resultado = (dinero * interes) / (1 - Math.pow(1 + interes, -duracion));
        return resultado;
    }
}