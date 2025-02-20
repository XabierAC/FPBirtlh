

public class Libro {

    private String titulo;
    private String autor;
    private int anio;
    private double precio;

    public Libro(String titulo, String autor, int anio, double precio) {
        setTitulo(titulo);
        setAutor(autor);
        setAnio(anio);
        setPrecio(precio);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public String getAutor() {
        return this.autor;
    }

    public void setAnio(int anio) {
        if (anio > 0) {
            this.anio = anio;
        } else {
            System.out.println("El año debe ser positivo");
        }
    }


    public int getAnio() {
        return this.anio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            System.out.println("El precio debe ser positivo");
        }
    }


    public double getPrecio() {
        return this.precio;
    }

    public void mostrarDetalles() {
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Año: " + getAnio());
        System.out.println("Precio: " + String.format("%.2f", getPrecio()) + "€");
    }

    public static void main(String[] args) {
        Libro libro1 = new Libro("El señor de los anillos", "J.R.R. Tolkien", 1954, 30.5);
        libro1.mostrarDetalles();
    }
}