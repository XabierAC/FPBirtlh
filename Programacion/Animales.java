public class Animales {
    private String nombre;

    public Animales(String nombre) {
        this.nombre = nombre;
    }

    public void hacerSonido() {
        System.out.println("Sonido generico de animal");
    }

    public static void main(String[] args) {
        Animales gato = new Gato("Whiskas");
        Animales perro = new Perro("Gos");

        perro.hacerSonido();
        gato.hacerSonido();
    }
}