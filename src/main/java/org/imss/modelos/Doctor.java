package org.imss.modelos;

public class Doctor extends Persona {
    private String especialidad;

    public Doctor(String id, String nombreCompleto, String especialidad) {
        super(id, nombreCompleto);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String getEncabezadoCSV() {
        return "Id,Nombre,Especialidad";
    }

    @Override
    public String toCSV() {
        return id + "," + nombreCompleto + "," + especialidad;
    }
}
