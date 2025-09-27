package bar_poo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Clase utilitaria para leer y escribir en archivos de texto
public class ArchivoUtil {

    // Método para guardar una lista de productos en el archivo
    public static void guardarProductos(List<Producto> productos, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Producto p : productos) {
                // Guardar cada producto en formato: Tipo|Nombre|Precio|Cantidad|AtributoExtra
                if (p instanceof Comida) {
                    Comida c = (Comida) p;
                    writer.println("Comida|" + c.getNombre() + "|" + c.getPrecio() + "|" + c.getCantidad() + "|" + c.getTipo());
                } else if (p instanceof Bebida) {
                    Bebida b = (Bebida) p;
                    writer.println("Bebida|" + b.getNombre() + "|" + b.getPrecio() + "|" + b.getCantidad() + "|" + b.isAlcoholica());
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
        }
    }

    // Método para cargar productos desde el archivo
    public static List<Producto> cargarProductos(String nombreArchivo) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos[0].equals("Comida")) {
                    productos.add(new Comida(datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), datos[4]));
                } else if (datos[0].equals("Bebida")) {
                    productos.add(new Bebida(datos[1], Double.parseDouble(datos[2]), Integer.parseInt(datos[3]), Boolean.parseBoolean(datos[4])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
        return productos;
    }

    // Método para guardar una lista de clientes en el archivo
    public static void guardarClientes(List<Cliente> clientes, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Cliente c : clientes) {
                writer.println(c.getId() + "|" + c.getNombre() + "|" + c.getTelefono() + "|" + c.getEmail());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar clientes: " + e.getMessage());
        }
    }

    // Método para cargar clientes desde el archivo
    public static List<Cliente> cargarClientes(String nombreArchivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split("\\|");
                if (datos.length == 4) {
                    clientes.add(new Cliente(datos[0], datos[1], datos[2], datos[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
        return clientes;
    }
}
