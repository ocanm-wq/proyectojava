package bar_poo;
// Clase que representa un cliente del restaurante
public class Cliente {
    // Atributos privados (encapsulamiento)
    private String id;
    private String nombre;
    private String telefono;
    private String email;
    //end atributos

    // Método constructor
    public Cliente(String id, String nombre, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }// end constructor

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getEmail() { return email; }
    // end Getters

    // Setters
    public void setId(String id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public void setEmail(String email) { this.email = email; }
    // end Setters

    // Método para mostrar información del cliente
    public String mostrarInfo() {
        return "ID: " + id + ", Nombre: " + nombre + ", Tel: " + telefono + ", Email: " + email;
    }// end mostrarInfo
}// Fin de la clase Cliente