package com.disoft.ceci.persona.common.resultdata;

public class ResultOperation {
    private Severidad severidad;
    private Integer codigo;
    private String descripcion;

    public ResultOperation() {
    }

    public ResultOperation(String desc) {
        this.descripcion = desc;
    }

    public ResultOperation(String desc, Severidad sev) {
        this.descripcion = desc;
        this.severidad = sev;
    }

    public Severidad getSeveridad() {
        return this.severidad;
    }

    public void setSeveridad(Severidad severidad) {
        this.severidad = severidad;
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setResult(Severidad sev, String desc) {
        this.severidad = sev;
        this.descripcion = desc;
    }

    public void init() {
        this.severidad = null;
        this.codigo = -1;
        this.descripcion = null;
    }

    public String toString() {
        return "ResultadoOperacion { severidad = " + this.severidad + ", descripcion = '" + this.descripcion + "'}";
    }
}
