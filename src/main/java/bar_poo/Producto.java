package bar_poo;
// Clase base (padre) que representa un producto en el restaurante
public class Producto {
    // Atributos privados (encapsulamiento)
    private String nombre;
    private double precio;
    private int cantidad;

    // Método constructor
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }// end constructor

    // Getters
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    // end Getters

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    // end Setters

    // Método que será sobrescrito en las clases hijas (polimorfismo)
    public String obtenerTipo() {
        return "Producto general";
    }// end obtenerTipo

    // Método para mostrar información del producto
    public String mostrarInfo() {
        return "Nombre: " + nombre + ", Precio: $" + precio + ", Cantidad: " + cantidad;
    }// end mostrarInfo
}// Fin de la clase Producto
