package com.example.fororol.modelo;

public class Poder {
    private int idp;
    private int poder;
    private int duelo;
    private int pociones;
    private int rituales;

    public Poder() {
    }

    public Poder(int idp, int poder, int duelo, int pociones, int rituales) {
        this.idp = idp;
        this.poder = poder;
        this.duelo = duelo;
        this.pociones = pociones;
        this.rituales = rituales;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getDuelo() {
        return duelo;
    }

    public void setDuelo(int duelo) {
        this.duelo = duelo;
    }

    public int getPociones() {
        return pociones;
    }

    public void setPociones(int pociones) {
        this.pociones = pociones;
    }

    public int getRituales() {
        return rituales;
    }

    public void setRituales(int rituales) {
        this.rituales = rituales;
    }

    @Override
    public String toString() {
        return "Poder{" +
                "idp=" + idp +
                ", poder=" + poder +
                ", duelo=" + duelo +
                ", pociones=" + pociones +
                ", rituales=" + rituales +
                '}';
    }
}
