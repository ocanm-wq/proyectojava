package bar_poo;
// Clase Bebida hereda de Producto
public class Bebida extends Producto {
    private boolean alcoholica;

    // Método constructor
    public Bebida(String nombre, double precio, int cantidad, boolean alcoholica) {
        super(nombre, precio, cantidad);
        this.alcoholica = alcoholica;
    }// end constructor

    // Getter y setter específico
    public boolean isAlcoholica() { return alcoholica; }
    public void setAlcoholica(boolean alcoholica) { this.alcoholica = alcoholica; }
    // end Getter y setter

    // Sobrescritura del método (polimorfismo)
    @Override
    public String obtenerTipo() {
        return "Bebida";
    }// end obtenerTipo

    // Sobrescritura del método mostrarInfo
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Alcohólica: " + (alcoholica ? "Sí" : "No");
    }// end mostrarInfo
}// Fin de la clase Bebida
