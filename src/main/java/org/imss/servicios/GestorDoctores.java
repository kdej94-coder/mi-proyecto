package org.imss.servicios;

import org.imss.modelos.Doctor;
import java.util.ArrayList;
import java.util.List;

public class GestorDoctores {
    private GestorArchivos<Doctor> gestorArchivos;
    private List<Doctor> doctores;
    private static final String RUTA_ARCHIVO = "db/doctores.csv";

    public GestorDoctores() {
        gestorArchivos = new GestorArchivos<>(RUTA_ARCHIVO);
        doctores = new ArrayList<>();
        cargarDoctores();
    }

    private void cargarDoctores() {
        List<String> lineas = gestorArchivos.cargar();
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 3) {
                doctores.add(new Doctor(datos[0], datos[1], datos[2]));
            }
        }
    }

    public void registrarDoctor(Doctor doctor) {
        doctores.add(doctor);
        guardarDoctores();
    }

    private void guardarDoctores() {
        if (!doctores.isEmpty()) {
            gestorArchivos.guardar(doctores, doctores.get(0).getEncabezadoCSV());
        }
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }
}
