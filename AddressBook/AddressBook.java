import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private HashMap<String, String> contacts;
    private String filePath;

    public AddressBook(String filePath) {
        this.contacts = new HashMap<>();
        this.filePath = filePath;
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    contacts.put(parts[0].trim(), parts[1].trim());
                }
            }
            System.out.println("Contactos cargados exitosamente.");
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de contactos no encontrado. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al cargar los contactos: " + e.getMessage());
        }
    }

    public void save() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
            System.out.println("Cambios guardados exitosamente en el archivo.");
        } catch (IOException e) {
            System.out.println("Error al guardar los contactos: " + e.getMessage());
        }
    }

    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        System.out.println("Contactos:");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void create(String numero, String nombre) {
        if (contacts.containsKey(numero)) {
            System.out.println("El número ya existe en la agenda con el nombre: " + contacts.get(numero));
            return;
        }
        contacts.put(numero, nombre);
        System.out.println("Contacto creado exitosamente.");
    }

    public void delete(String numero) {
        if (contacts.containsKey(numero)) {
            String nombre = contacts.remove(numero);
            System.out.println("Contacto eliminado: " + numero + " : " + nombre);
        } else {
            System.out.println("El número de teléfono no existe en la agenda.");
        }
    }
}
