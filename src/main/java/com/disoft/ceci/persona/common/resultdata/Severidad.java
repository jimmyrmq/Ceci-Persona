package com.disoft.ceci.persona.common.resultdata;

public enum Severidad {
    NONE("Ninguno"),
    OK("OK"),
    INFO("Informacion"),
    WARNING("Advertencia"),
    ERROR("Error");

    private String descripcion;

    private Severidad(String desc) {
        this.descripcion = desc;
    }

    public String getDescripcion() {
        return this.descripcion;
    }
}
