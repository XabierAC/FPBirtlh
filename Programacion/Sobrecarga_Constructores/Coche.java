package Sobrecarga_Constructores;

public class Coche {
    private String marca;
    private String modelo;
    private int year;
    private String color;

    public Coche(String marca, String modelo, int year, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = year;
        this.color = color;
    }

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
        this.year = 2020;
        this.color = "blanco";
    }

    public Coche(String marca, int year) {
        this.marca = marca;
        this.modelo = "Desconocido";
        this.year = year;
        this.color = "negro";
    }

    public Coche() {
        this.marca = "Desconocido";
        this.modelo = "Desconocido";
        this.year = -1;
        this.color = "Desconocido";
    }

    public void mostrarDetalles() {
        System.out.println("El coche es de la marca " + marca + " modelo " + modelo + ", del año " + year + " y de color " + color);
    }
    public static void main(String[] args) {
        // Usando el constructor con todos los parámetros
        Coche coche1 = new Coche("Toyota", "Corolla", 2022, "rojo");
        coche1.mostrarDetalles();

        // Usando el constructor con solo marca y modelo
        Coche coche2 = new Coche("Ford", "Mustang");
        coche2.mostrarDetalles();
    
        // Usando el constructor con solo marca y año
        Coche coche3 = new Coche("BMW", 2020);
        coche3.mostrarDetalles();
    
        // Usando el constructor por defecto
        Coche coche4 = new Coche();
        coche4.mostrarDetalles();
    }
}
