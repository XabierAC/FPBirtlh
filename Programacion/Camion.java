public class Camion extends Vehiculo{
    private int numPuertas;

    public Camion(String marca, int numPuertas) {
        super(marca);
        this.numPuertas = numPuertas;
    }

    @Override
    public void acelerar() {
        System.out.println("El camion esta acelerando rapidamente");
    }
}
