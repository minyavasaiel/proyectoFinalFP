package com.example.fororol.modelo;

public class Carisma {
    private int idc ;
    private int carisma;
    private int coordinacion;
    private int intimidacion;
    private int oratoria;
    private int seducir;
    private int subterfugio;

    public Carisma() {
    }

    public Carisma(int idc, int carisma, int coordinacion, int intimidacion, int oratoria, int seducir, int subterfugio) {
        this.idc = idc;
        this.carisma = carisma;
        this.coordinacion = coordinacion;
        this.intimidacion = intimidacion;
        this.oratoria = oratoria;
        this.seducir = seducir;
        this.subterfugio = subterfugio;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }

    public int getCoordinacion() {
        return coordinacion;
    }

    public void setCoordinacion(int coordinacion) {
        this.coordinacion = coordinacion;
    }

    public int getIntimidacion() {
        return intimidacion;
    }

    public void setIntimidacion(int intimidacion) {
        this.intimidacion = intimidacion;
    }

    public int getOratoria() {
        return oratoria;
    }

    public void setOratoria(int oratoria) {
        this.oratoria = oratoria;
    }

    public int getSeducir() {
        return seducir;
    }

    public void setSeducir(int seducir) {
        this.seducir = seducir;
    }

    public int getSubterfugio() {
        return subterfugio;
    }

    public void setSubterfugio(int subterfugio) {
        this.subterfugio = subterfugio;
    }

    @Override
    public String toString() {
        return "Carisma{" +
                "idc=" + idc +
                ", carisma=" + carisma +
                ", coordinacion=" + coordinacion +
                ", intimidacion=" + intimidacion +
                ", oratoria=" + oratoria +
                ", seducir=" + seducir +
                ", subterfugio=" + subterfugio +
                '}';
    }
}
