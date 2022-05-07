package com.example.fororol.modelo;

public class Destreza {
    private int idd;
    private int destreza;
    private int esquivar;
    private int latrocinio;
    private int sigilo;
    private int volar;

    public Destreza() {
    }

    public Destreza(int idd, int destreza, int esquivar, int latrocinio, int sigilo, int volar) {
        this.idd = idd;
        this.destreza = destreza;
        this.esquivar = esquivar;
        this.latrocinio = latrocinio;
        this.sigilo = sigilo;
        this.volar = volar;
    }

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getEsquivar() {
        return esquivar;
    }

    public void setEsquivar(int esquivar) {
        this.esquivar = esquivar;
    }

    public int getLatrocinio() {
        return latrocinio;
    }

    public void setLatrocinio(int latrocinio) {
        this.latrocinio = latrocinio;
    }

    public int getSigilo() {
        return sigilo;
    }

    public void setSigilo(int sigilo) {
        this.sigilo = sigilo;
    }

    public int getVolar() {
        return volar;
    }

    public void setVolar(int volar) {
        this.volar = volar;
    }

    @Override
    public String toString() {
        return "Destreza{" +
                "idd=" + idd +
                ", destreza=" + destreza +
                ", esquivar=" + esquivar +
                ", latrocinio=" + latrocinio +
                ", sigilo=" + sigilo +
                ", volar=" + volar +
                '}';
    }
}
