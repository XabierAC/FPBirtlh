package Clases_y_Objetos;

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
        if(edad <= 0) {
            System.out.println("Error: La edad introducida no puede ser negativa o cero");
        } else {
            this.edad = edad;
        }
    }

    public int getEdad() {
        return this.edad;
    }

    public static void main(String[] args) {
        Persona persona = new Persona("Xabier", 29);
        persona.saludar();
        persona.setEdad (28);
        persona.saludar();
    }
}
