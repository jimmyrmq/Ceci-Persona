package com.disoft.ceci.persona.common;

public enum Sexo {
    Masculino("M"),
    Femenino("F");

    private String codSexo;

    Sexo(String s) {
        this.codSexo = s;
    }

    public String getCodigo(){
        return codSexo;
    }
}