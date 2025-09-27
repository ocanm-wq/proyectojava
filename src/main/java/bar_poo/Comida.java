package bar_poo;
// Clase Comida hereda de Producto
public class Comida extends Producto {
    private String tipo; // ej: "Postre", "Plato fuerte"

    // Método constructor
    public Comida(String nombre, double precio, int cantidad, String tipo) {
        super(nombre, precio, cantidad); // Llama al constructor de la clase padre
        this.tipo = tipo;
    } // end constructor

    // Getter y setter específico
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    // end Getter y setter

    // Sobrescritura del método (polimorfismo)
    @Override
    public String obtenerTipo() {
        return "Comida";
    }// end obtenerTipo

    // Sobrescritura del método mostrarInfo
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Tipo: " + tipo;
    }// end mostrarInfo
}// Fin de la clase Comida