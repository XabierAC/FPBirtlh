/******************************************************************************************************************
 * 
 * Nombre: Xabier Aguirrebeitia Chica 
 * Fecha: 11/10/2024 
 * Modulo: Programación.
 * UD: UD1 Estructuras de un programa. 
 * Tarea: Tarea Evaluación 01. Realiza un programa en Java.
 * Descripción del programa: El objetivo de esta tarea es realizar un programa que visualice por consola una figura simétrica
 * Enlace autoevaluación: https://docs.google.com/document/d/1UrK7qoqUiU0mcMlXnCns6qN-oP2f7zyl/edit?usp=sharing&ouid=118079182232210410949&rtpof=true&sd=true
 *******************************************************************************************************************/

 public class Torre {
    
    public static void lineasVerticales() {
        //genera 12 espacios vacios
        for (int i=0;i<12;i++){
            System.out.print(" ");
        }
        //genera las 2 lineas verticales
        for (int i=0;i<2;i++){
            System.out.print("|");
        }
        //hace un salto de linea
        System.out.println();
    }
    
    public static void lineasDoblesPuntos() {
        //genera las 4 filas del metodo
        for (int i=0; i<4;i++){
            //genera espacios libres de mas a menos reduciendose de 3 en 3 en cada linea
            for (int j=0;j<9-3*i;j++){
                System.out.print(" ");
            }
            System.out.print("__/");
            //genera : multiplicandose por 3 en cada linea
            for (int k=0; k<3*i;k++){
                System.out.print(":");
            }
            System.out.print("||");
            //hace los puntos simetricos de la otra mitad de la figura
            for (int k=0; k<3*i;k++){
                System.out.print(":");
            }
            System.out.println("\\__");
        }
    }
    
    public static void lineasTriangulos() {
        //genera las 4 filas que genera el metodo
        for (int i=0; i<4;i++){
            //genera 2 espacios vacios por cada fila, se generan 2 nuevos espacios vacios en cada nueva fila
            for (int k=0;k<2*i;k++){
                System.out.print(" ");
            }
            System.out.print("\\_");
            //genera los triangulos necesarios para cada fila, se van reduciendo 2 triangulos por cada fila
            for (int j=0; j<11-2*i;j++){
                System.out.print("/\\");
            }
            System.out.println("_/");
        }
    
    }
    
    public static void lineaComillas() {
        System.out.print("|");
        //coloca 12 comillas dobles
        for (int i=0;i<12;i++){
            System.out.print("\"\"");
        }
        System.out.println("|");
    }
    
	public static void main (String[] args) {
    // realiza 4 llamadas al metodo lineasVerticales()	
		for (int i=0; i<4;i++){
		    lineasVerticales();
		}
		lineasDoblesPuntos();
		lineaComillas();
		lineasTriangulos();
	// realiza 12 llamadas al metodo lineasVerticales()
		for (int i=0; i<12;i++){
		    lineasVerticales();
		}
		lineasDoblesPuntos();
		lineaComillas();
	}

}