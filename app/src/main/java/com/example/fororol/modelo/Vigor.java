package com.example.fororol.modelo;

public class Vigor {
    private int idv;
    private int vigor;
    private int atletismo;
    private int pelea;

    public Vigor(){

    }

    public Vigor(int idv, int vigor, int atletismo, int pelea) {
        this.idv = idv;
        this.vigor = vigor;
        this.atletismo = atletismo;
        this.pelea = pelea;
    }

    public int getIdv() {
        return idv;
    }

    public void setIdv(int idv) {
        this.idv = idv;
    }

    public int getVigor() {
        return vigor;
    }

    public void setVigor(int vigor) {
        this.vigor = vigor;
    }

    public int getAtletismo() {
        return atletismo;
    }

    public void setAtletismo(int atletismo) {
        this.atletismo = atletismo;
    }

    public int getPelea() {
        return pelea;
    }

    public void setPelea(int pelea) {
        this.pelea = pelea;
    }

    @Override
    public String toString() {
        return "vigor{" +
                "idv=" + idv +
                ", vigor=" + vigor +
                ", atletismo=" + atletismo +
                ", pelea=" + pelea +
                '}';
    }
}
