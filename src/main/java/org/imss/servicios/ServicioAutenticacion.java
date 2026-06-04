package org.imss.servicios;

import org.imss.modelos.Administrador;
import java.util.ArrayList;
import java.util.List;

public class ServicioAutenticacion {
    private GestorArchivos<Administrador> gestorArchivos;
    private List<Administrador> administradores;
    private static final String RUTA_ARCHIVO = "db/administradores.csv";

    public ServicioAutenticacion() {
        gestorArchivos = new GestorArchivos<>(RUTA_ARCHIVO);
        administradores = new ArrayList<>();
        cargarAdministradores();
    }

    private void cargarAdministradores() {
        List<String> lineas = gestorArchivos.cargar();
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 2) {
                administradores.add(new Administrador(datos[0], datos[1]));
            }
        }
        // Crear administrador por defecto si no hay ninguno en el archivo
        if (administradores.isEmpty()) {
            Administrador adminPorDefecto = new Administrador("admin", "1234");
            administradores.add(adminPorDefecto);
            gestorArchivos.guardar(administradores, adminPorDefecto.getEncabezadoCSV());
        }
    }

    public boolean login(String id, String password) {
        for (Administrador admin : administradores) {
            if (admin.getId().equals(id) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
