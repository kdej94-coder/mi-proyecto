package org.imss.modelos;

import org.imss.interfaces.Exportable;
import org.imss.interfaces.Identificable;

public class Cita implements Identificable, Exportable {
    private String id;
    private String fechaHora; // Formato: dd/MM/yyyy HH:mm
    private String motivo;
    private String idDoctor;
    private String idPaciente;

    public Cita(String id, String fechaHora, String motivo, String idDoctor, String idPaciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.idDoctor = idDoctor;
        this.idPaciente = idPaciente;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    @Override
    public String getEncabezadoCSV() {
        return "Id,FechaHora,Motivo,IdDoctor,IdPaciente";
    }

    @Override
    public String toCSV() {
        return id + "," + fechaHora + "," + motivo + "," + idDoctor + "," + idPaciente;
    }
}
