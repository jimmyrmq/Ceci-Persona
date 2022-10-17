package com.disoft.ceci.persona.v1.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@JsonPropertyOrder({ "id", "idTipoDocumento","numeroDocumento","numeroFiscal", "primerNombre","segundoNombre", "primerApellido","segundoApellido","sexo","fechaNacimiento","direccion1","direccion2","telefono1","telefono2","edoCivil","correo","url","uriFoto" })
public class Persona {
    private Integer ID;
    @ApiModelProperty(notes = "Tipo Documento - 1: RIF 2: Cedula de Identidad", example = "2", required = true)
    private Integer idTipoDocumento;

    @ApiModelProperty(notes = "Numero de Documento", example = "17310860", required = true)
    private Integer numeroDocumento;
    private Integer numeroFiscal;

    @ApiModelProperty(notes = "Primer Nombre de la Persona", example = "Jimmy", required = true)
    private String primerNombre;

    @ApiModelProperty(notes = "Segundo Nombre de la Persona", example = "Jimmy", required = true)
    private String segundoNombre;

    @ApiModelProperty(notes = "Primer Apellido de la Persona", example = "Morales", required = true)
    private String primerApellido;

    @ApiModelProperty(notes = "Segundo Apellido de la Persona", example = "Morales", required = true)
    private String segundoApellido;

    @ApiModelProperty(notes = "Sexo de la Persona", example = "M", required = true)
    private String sexo;
    @ApiModelProperty(notes = "Fecha de nacimineto", example = "1986-07-27", required = true)
    private LocalDate fechaNacimiento;
    private String direccion1;
    private String direccion2;
    private String telefono1;
    private String telefono2;
    private String edoCivil;
    private String correo;
    private String url;
    private String uriFoto;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNumeroFiscal() {
        return numeroFiscal;
    }

    public void setNumeroFiscal(Integer numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getEdoCivil() {
        return edoCivil;
    }

    public void setEdoCivil(String edoCivil) {
        this.edoCivil = edoCivil;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUriFoto() {
        return uriFoto;
    }

    public void setUriFoto(String uriFoto) {
        this.uriFoto = uriFoto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "ID=" + ID +
                ", idTipoDocumento=" + idTipoDocumento +
                ", numeroDocumento=" + numeroDocumento +
                ", numeroFiscal=" + numeroFiscal +
                ", primerNombre='" + primerNombre + '\'' +
                ", segundoNombre='" + segundoNombre + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", sexo='" + sexo + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", direccion1='" + direccion1 + '\'' +
                ", direccion2='" + direccion2 + '\'' +
                ", telefono1='" + telefono1 + '\'' +
                ", telefono2='" + telefono2 + '\'' +
                ", edoCivil='" + edoCivil + '\'' +
                ", correo='" + correo + '\'' +
                ", url='" + url + '\'' +
                ", uriFoto='" + uriFoto + '\'' +
                '}';
    }
}
