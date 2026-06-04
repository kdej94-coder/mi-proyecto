package org.imss.modelos;

public class Paciente extends Persona {
    public Paciente(String id, String nombreCompleto) {
        super(id, nombreCompleto);
    }

    @Override
    public String getEncabezadoCSV() {
        return "Id,Nombre";
    }

    @Override
    public String toCSV() {
        return id + "," + nombreCompleto;
    }
}
