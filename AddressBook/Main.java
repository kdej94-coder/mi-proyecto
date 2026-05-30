import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "contacts.csv";
        AddressBook addressBook = new AddressBook(filePath);
        
        // Cargar contactos al iniciar
        addressBook.load();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Agenda Telefónica ---");
            System.out.println("1. Mostrar contactos (list)");
            System.out.println("2. Crear nuevo contacto (create)");
            System.out.println("3. Borrar contacto (delete)");
            System.out.println("4. Guardar y Salir");
            System.out.print("Seleccione una opción: ");
            
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addressBook.list();
                    break;
                case "2":
                    System.out.print("Ingrese el número telefónico: ");
                    String numero = scanner.nextLine().trim();
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine().trim();
                    
                    if (numero.isEmpty() || nombre.isEmpty()) {
                        System.out.println("El número y el nombre no pueden estar vacíos.");
                    } else {
                        addressBook.create(numero, nombre);
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el número telefónico a eliminar: ");
                    String numeroEliminar = scanner.nextLine().trim();
                    if (numeroEliminar.isEmpty()) {
                        System.out.println("El número no puede estar vacío.");
                    } else {
                        addressBook.delete(numeroEliminar);
                    }
                    break;
                case "4":
                    addressBook.save();
                    exit = true;
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
        
        scanner.close();
    }
}
