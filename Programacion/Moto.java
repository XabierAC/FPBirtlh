public class Moto extends Vehiculo{
    private int cilindrada;

    public Moto(String marca, int cilindrada) {
        super(marca);
        this.cilindrada = cilindrada;
    }
    @Override
    public void acelerar() {
        System.out.println("La moto acelera con potencia");
    }
}
