package Clases_y_Objetos;

import java.util.*;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        setEdad(edad);
    }

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años");
    }
    
    public void setEdad(int edad) {
        while (edad <= 0) {
            System.out.println("Error: La edad introducida no puede ser negativa o cero");
            System.out.println("Introduce una edad válida.");
            Scanner input = new Scanner(System.in);
            edad = Integer.parseInt(input.nextLine());
            input.close();
        }
        this.edad = edad;
    }

    public int getEdad() {
        return this.edad;
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Xabier", 29);
        persona.saludar();
    }
}
