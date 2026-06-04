package org.imss.servicios;

import org.imss.modelos.Paciente;
import java.util.ArrayList;
import java.util.List;

public class GestorPacientes {
    private GestorArchivos<Paciente> gestorArchivos;
    private List<Paciente> pacientes;
    private static final String RUTA_ARCHIVO = "db/pacientes.csv";

    public GestorPacientes() {
        gestorArchivos = new GestorArchivos<>(RUTA_ARCHIVO);
        pacientes = new ArrayList<>();
        cargarPacientes();
    }

    private void cargarPacientes() {
        List<String> lineas = gestorArchivos.cargar();
        for (String linea : lineas) {
            String[] datos = linea.split(",");
            if (datos.length == 2) {
                pacientes.add(new Paciente(datos[0], datos[1]));
            }
        }
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        guardarPacientes();
    }

    private void guardarPacientes() {
        if (!pacientes.isEmpty()) {
            gestorArchivos.guardar(pacientes, pacientes.get(0).getEncabezadoCSV());
        }
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }
}
