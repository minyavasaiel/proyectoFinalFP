package com.example.fororol.modelo;

public class Voluntad {
    private int idvo;
    private int voluntad;
    private int arte;
    private int estilo;
    private int frialdad;

    public Voluntad() {
    }

    public Voluntad(int idvo, int voluntad, int arte, int estilo, int frialdad) {
        this.idvo = idvo;
        this.voluntad = voluntad;
        this.arte = arte;
        this.estilo = estilo;
        this.frialdad = frialdad;
    }

    public int getIdvo() {
        return idvo;
    }

    public void setIdvo(int idvo) {
        this.idvo = idvo;
    }

    public int getVoluntad() {
        return voluntad;
    }

    public void setVoluntad(int voluntad) {
        this.voluntad = voluntad;
    }

    public int getArte() {
        return arte;
    }

    public void setArte(int arte) {
        this.arte = arte;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public int getFrialdad() {
        return frialdad;
    }

    public void setFrialdad(int frialdad) {
        this.frialdad = frialdad;
    }

    @Override
    public String toString() {
        return "Voluntad{" +
                "idvo=" + idvo +
                ", voluntad=" + voluntad +
                ", arte=" + arte +
                ", estilo=" + estilo +
                ", frialdad=" + frialdad +
                '}';
    }
}
