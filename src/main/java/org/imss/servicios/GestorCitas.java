package org.imss.servicios;

import org.imss.modelos.Cita;
import java.util.ArrayList;
import java.util.List;

public class GestorCitas {
    private GestorArchivos<Cita> gestorArchivos;
    private List<Cita> citas;
    private static final String RUTA_ARCHIVO = "db/citas.csv";

    public GestorCitas() {
        gestorArchivos = new GestorArchivos<>(RUTA_ARCHIVO);
        citas = new ArrayList<>();
        cargarCitas();
    }

    private void cargarCitas() {
        List<String> lineas = gestorArchivos.cargar();
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 5) {
                citas.add(new Cita(datos[0], datos[1], datos[2], datos[3], datos[4]));
            }
        }
    }

    public boolean registrarCita(Cita nuevaCita) {
        // Validación de conflicto de horario para el doctor
        for (Cita cita : citas) {
            if (cita.getIdDoctor().equals(nuevaCita.getIdDoctor()) &&
                cita.getFechaHora().equals(nuevaCita.getFechaHora())) {
                return false; // Conflicto de horario
            }
        }
        citas.add(nuevaCita);
        guardarCitas();
        return true;
    }

    private void guardarCitas() {
        if (!citas.isEmpty()) {
            gestorArchivos.guardar(citas, citas.get(0).getEncabezadoCSV());
        }
    }

    public List<Cita> getCitas() {
        return citas;
    }
}
