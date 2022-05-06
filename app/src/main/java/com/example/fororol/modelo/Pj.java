package com.example.fororol.modelo;

public class Pj {
    private int idPj;
    private String nombre;

    public Pj() {
    }

    public Pj(int idPj, String nombre) {
        this.idPj = idPj;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Pj{" + "idPj=" + idPj + ", nombre=" + nombre + '}';
    }
}
