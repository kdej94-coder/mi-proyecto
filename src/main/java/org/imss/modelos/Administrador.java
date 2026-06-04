package org.imss.modelos;

import org.imss.interfaces.Exportable;
import org.imss.interfaces.Identificable;

public class Administrador implements Identificable, Exportable {
    private String id;
    private String password;

    public Administrador(String id, String password) {
        this.id = id;
        this.password = password;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getEncabezadoCSV() {
        return "Id,Password";
    }

    @Override
    public String toCSV() {
        return id + "," + password;
    }
}
