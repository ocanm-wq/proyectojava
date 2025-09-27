package bar_poo;
import java.util.*;

// Clase controladora que maneja las operaciones CRUD para productos y clientes
public class Controlador {
    private List<Producto> productos;
    private List<Cliente> clientes;
    private String archivoProductos = "datos.txt";
    private String archivoClientes = "clientes.txt";

    // Constructor
    public Controlador() {
        this.productos = ArchivoUtil.cargarProductos(archivoProductos);
        this.clientes = ArchivoUtil.cargarClientes(archivoClientes);
    }

    // --- MÉTODOS PARA PRODUCTOS ---
    
    // Crear producto
    public void crearProducto(Producto p) {
        productos.add(p);
        ArchivoUtil.guardarProductos(productos, archivoProductos);
    }

    // Leer todos los productos
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (int i = 0; i < productos.size(); i++) {
                System.out.println((i + 1) + ". " + productos.get(i).mostrarInfo());
            }
        }
    }

    // Actualizar producto
    public void actualizarProducto(int index, Producto nuevo) {
        if (index >= 0 && index < productos.size()) {
            productos.set(index, nuevo);
            ArchivoUtil.guardarProductos(productos, archivoProductos);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Eliminar producto
    public void eliminarProducto(int index) {
        if (index >= 0 && index < productos.size()) {
            productos.remove(index);
            ArchivoUtil.guardarProductos(productos, archivoProductos);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // --- MÉTODOS PARA CLIENTES ---
    
    // Crear cliente
    public void crearCliente(Cliente c) {
        clientes.add(c);
        ArchivoUtil.guardarClientes(clientes, archivoClientes);
    }

    // Leer todos los clientes
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + ". " + clientes.get(i).mostrarInfo());
            }
        }
    }

    // Actualizar cliente
    public void actualizarCliente(int index, Cliente nuevo) {
        if (index >= 0 && index < clientes.size()) {
            clientes.set(index, nuevo);
            ArchivoUtil.guardarClientes(clientes, archivoClientes);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Eliminar cliente
    public void eliminarCliente(int index) {
        if (index >= 0 && index < clientes.size()) {
            clientes.remove(index);
            ArchivoUtil.guardarClientes(clientes, archivoClientes);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Getters de las listas (para uso interno)
    public List<Producto> getProductos() { return productos; }
    public List<Cliente> getClientes() { return clientes; }
}