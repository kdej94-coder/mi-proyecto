package org.imss.modelos;

import org.imss.interfaces.Exportable;
import org.imss.interfaces.Identificable;

public abstract class Persona implements Identificable, Exportable {
    protected String id;
    protected String nombreCompleto;

    public Persona(String id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}
