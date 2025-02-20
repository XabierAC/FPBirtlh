

public class CuentaBancaria {
    private String titular;
    private double saldo;


    public CuentaBancaria(String titular, double saldo) {
        setTitular(titular);
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Error: El saldo no puede ser negativo. Se establecera a 0.");
            this.saldo = 0;
        }
    }


    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            System.out.println("Se ha depositado la cantidad de " + cantidad + "€ en la cuenta de " + this.titular + ".");
        } else {
            System.out.println("Error: la cantidad a depositar no puede ser negativa ni 0.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            if (this.saldo >= cantidad) {
                this.saldo -= cantidad;
                System.out.println("Se ha retirado la cantidad de " + cantidad + "€ de la cuenta de " + this.titular + ".");
                System.out.println("El saldo actual es de: " + this.saldo + "€.");
            }else {
                System.out.println("Error: La cantidad a retirar es mayor que el saldo. El saldo actual es de: " + this.saldo + "€.");
            }
        } else {
            System.out.println("Error: La cantidad a retirar no puede ser negativa ni 0.");
        }
    }

    public void mostrarSaldo() {
        System.out.println("El saldo de la cuenta de " + this.titular + " es de " + this.saldo + "€.");
    }
}
