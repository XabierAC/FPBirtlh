public class Gato extends Animales {
    
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void hacerSonido() {
        System.out.println("Miau Miau");
    }
}

