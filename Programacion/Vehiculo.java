public class Vehiculo {
    private String marca;

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    public void acelerar() {
        System.out.println("El vehículo está acelerando");
    }

    public static void main(String[] args) {
        Vehiculo moto = new Moto("Ducati", 999);
        Vehiculo camion = new Camion("Man", 2);

        camion.acelerar();
        moto.acelerar();
    }
}
