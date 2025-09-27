package bar_poo;
import java.util.Scanner;

// Clase principal con menú interactivo
public class Main {
    // Método principal
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controlador controlador = new Controlador();
        int opcion;

        do {
            System.out.println("\n--- Sistema de Gestión del Restaurante ---");
            System.out.println("1. Gestión de Productos");
            System.out.println("2. Gestión de Clientes");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> menuProductos(scanner, controlador);
                case 2 -> menuClientes(scanner, controlador);
                case 3 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void menuProductos(Scanner scanner, Controlador controlador) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarProducto(scanner, controlador);
                case 2 -> controlador.listarProductos();
                case 3 -> actualizarProducto(scanner, controlador);
                case 4 -> eliminarProducto(scanner, controlador);
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void menuClientes(Scanner scanner, Controlador controlador) {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Clientes ---");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> agregarCliente(scanner, controlador);
                case 2 -> controlador.listarClientes();
                case 3 -> actualizarCliente(scanner, controlador);
                case 4 -> eliminarCliente(scanner, controlador);
                case 5 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void agregarProducto(Scanner scanner, Controlador controlador) {
        System.out.print("Tipo (1: Comida, 2: Bebida): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Tipo de comida (ej: Postre): ");
            String tipoComida = scanner.nextLine();
            controlador.crearProducto(new Comida(nombre, precio, cantidad, tipoComida));
            System.out.println("Comida agregada exitosamente.");
        } else if (tipo == 2) {
            System.out.print("¿Es alcohólica? (true/false): ");
            boolean alcoholica = scanner.nextBoolean();
            controlador.crearProducto(new Bebida(nombre, precio, cantidad, alcoholica));
            System.out.println("Bebida agregada exitosamente.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void actualizarProducto(Scanner scanner, Controlador controlador) {
        controlador.listarProductos();
        System.out.print("Índice del producto a actualizar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < controlador.getProductos().size()) {
            Producto viejo = controlador.getProductos().get(index);
            System.out.print("Nuevo nombre (" + viejo.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) nombre = viejo.getNombre();

            System.out.print("Nuevo precio (" + viejo.getPrecio() + "): ");
            String precioStr = scanner.nextLine();
            double precio = precioStr.isEmpty() ? viejo.getPrecio() : Double.parseDouble(precioStr);

            System.out.print("Nueva cantidad (" + viejo.getCantidad() + "): ");
            String cantStr = scanner.nextLine();
            int cantidad = cantStr.isEmpty() ? viejo.getCantidad() : Integer.parseInt(cantStr);

            Producto nuevo;
            if (viejo instanceof Comida) {
                Comida c = (Comida) viejo;
                System.out.print("Nuevo tipo (" + c.getTipo() + "): ");
                String tipo = scanner.nextLine();
                if (tipo.isEmpty()) tipo = c.getTipo();
                nuevo = new Comida(nombre, precio, cantidad, tipo);
            } else {
                Bebida b = (Bebida) viejo;
                System.out.print("¿Es alcohólica? (" + b.isAlcoholica() + "): ");
                String alcStr = scanner.nextLine();
                boolean alcoholica = alcStr.isEmpty() ? b.isAlcoholica() : Boolean.parseBoolean(alcStr);
                nuevo = new Bebida(nombre, precio, cantidad, alcoholica);
            }

            controlador.actualizarProducto(index, nuevo);
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void eliminarProducto(Scanner scanner, Controlador controlador) {
        controlador.listarProductos();
        System.out.print("Índice del producto a eliminar: ");
        int index = scanner.nextInt() - 1;
        controlador.eliminarProducto(index);
        System.out.println("Producto eliminado exitosamente.");
    }

    private static void agregarCliente(Scanner scanner, Controlador controlador) {
        System.out.print("ID del cliente: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        controlador.crearCliente(new Cliente(id, nombre, telefono, email));
        System.out.println("Cliente agregado exitosamente.");
    }

    private static void actualizarCliente(Scanner scanner, Controlador controlador) {
        controlador.listarClientes();
        System.out.print("Índice del cliente a actualizar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index >= 0 && index < controlador.getClientes().size()) {
            Cliente viejo = controlador.getClientes().get(index);
            System.out.print("Nuevo ID (" + viejo.getId() + "): ");
            String id = scanner.nextLine();
            if (id.isEmpty()) id = viejo.getId();

            System.out.print("Nuevo nombre (" + viejo.getNombre() + "): ");
            String nombre = scanner.nextLine();
            if (nombre.isEmpty()) nombre = viejo.getNombre();

            System.out.print("Nuevo teléfono (" + viejo.getTelefono() + "): ");
            String telefono = scanner.nextLine();
            if (telefono.isEmpty()) telefono = viejo.getTelefono();

            System.out.print("Nuevo email (" + viejo.getEmail() + "): ");
            String email = scanner.nextLine();
            if (email.isEmpty()) email = viejo.getEmail();

            Cliente nuevo = new Cliente(id, nombre, telefono, email);
            controlador.actualizarCliente(index, nuevo);
            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void eliminarCliente(Scanner scanner, Controlador controlador) {
        controlador.listarClientes();
        System.out.print("Índice del cliente a eliminar: ");
        int index = scanner.nextInt() - 1;
        controlador.eliminarCliente(index);
        System.out.println("Cliente eliminado exitosamente.");
    }
}