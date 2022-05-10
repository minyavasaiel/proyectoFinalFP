package com.example.fororol.modelo;

public class Pj {
    private int idPj;
    private String nombre;
    private String etapa;

    public Pj() {
    }

    public Pj(int idPj, String nombre, String etapa) {
        this.idPj = idPj;
        this.nombre = nombre;
        this.etapa = etapa;
    }

    public int getIdPj() {
        return idPj;
    }

    public void setIdPj(int idPj) {
        this.idPj = idPj;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    @Override
    public String toString() {
        return "Pj{" +
                "idPj=" + idPj +
                ", nombre='" + nombre + '\'' +
                ", etapa='" + etapa + '\'' +
                '}';
    }
}
