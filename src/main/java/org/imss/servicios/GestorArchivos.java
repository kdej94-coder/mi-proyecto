package org.imss.servicios;

import org.imss.interfaces.Exportable;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica para manejar la persistencia de datos en archivos CSV.
 */
public class GestorArchivos<T extends Exportable> {
    private String rutaArchivo;

    public GestorArchivos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
        crearArchivoSiNoExiste();
    }

    private void crearArchivoSiNoExiste() {
        try {
            // Asegurar que exista la carpeta db
            Files.createDirectories(Paths.get("db"));
            
            File archivo = new File(rutaArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error al crear archivo base: " + e.getMessage());
        }
    }

    public void guardar(List<T> lista, String encabezado) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            bw.write(encabezado);
            bw.newLine();
            for (T elemento : lista) {
                bw.write(elemento.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar archivo " + rutaArchivo + ": " + e.getMessage());
        }
    }

    public List<String> cargar() {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;
            while ((linea = br.readLine()) != null) {
                // Ignorar el encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea);
                }
            }
        } catch (FileNotFoundException e) {
            // No pasa nada, retornará lista vacía
        } catch (IOException e) {
            System.err.println("Error al cargar archivo " + rutaArchivo + ": " + e.getMessage());
        }
        return lineas;
    }
}
