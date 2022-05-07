package com.example.fororol.modelo;

public class Inteligencia {
    private int idi;
    private int inteligencia;
    private int adivinacion;
    private int arcanismo;
    private int callejeo;
    private int culturaMagia;
    private int culturaMuggle;
    private int herbologia;
    private int magizoologia;
    private int medicina;
    private int politica;
    private int supervivencia;

    public Inteligencia() {
    }

    public Inteligencia(int idi, int inteligencia, int adivinacion, int arcanismo, int callejeo, int culturaMagia, int culturaMuggle, int herbologia, int magizoologia, int medicina, int politica, int supervivencia) {
        this.idi = idi;
        this.inteligencia = inteligencia;
        this.adivinacion = adivinacion;
        this.arcanismo = arcanismo;
        this.callejeo = callejeo;
        this.culturaMagia = culturaMagia;
        this.culturaMuggle = culturaMuggle;
        this.herbologia = herbologia;
        this.magizoologia = magizoologia;
        this.medicina = medicina;
        this.politica = politica;
        this.supervivencia = supervivencia;
    }

    public int getIdi() {
        return idi;
    }

    public void setIdi(int idi) {
        this.idi = idi;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getAdivinacion() {
        return adivinacion;
    }

    public void setAdivinacion(int adivinacion) {
        this.adivinacion = adivinacion;
    }

    public int getArcanismo() {
        return arcanismo;
    }

    public void setArcanismo(int arcanismo) {
        this.arcanismo = arcanismo;
    }

    public int getCallejeo() {
        return callejeo;
    }

    public void setCallejeo(int callejeo) {
        this.callejeo = callejeo;
    }

    public int getCulturaMagia() {
        return culturaMagia;
    }

    public void setCulturaMagia(int culturaMagia) {
        this.culturaMagia = culturaMagia;
    }

    public int getCulturaMuggle() {
        return culturaMuggle;
    }

    public void setCulturaMuggle(int culturaMuggle) {
        this.culturaMuggle = culturaMuggle;
    }

    public int getHerbologia() {
        return herbologia;
    }

    public void setHerbologia(int herbologia) {
        this.herbologia = herbologia;
    }

    public int getMagizoologia() {
        return magizoologia;
    }

    public void setMagizoologia(int magizoologia) {
        this.magizoologia = magizoologia;
    }

    public int getMedicina() {
        return medicina;
    }

    public void setMedicina(int medicina) {
        this.medicina = medicina;
    }

    public int getPolitica() {
        return politica;
    }

    public void setPolitica(int politica) {
        this.politica = politica;
    }

    public int getSupervivencia() {
        return supervivencia;
    }

    public void setSupervivencia(int supervivencia) {
        this.supervivencia = supervivencia;
    }

    @Override
    public String toString() {
        return "Inteligencia{" +
                "idi=" + idi +
                ", inteligencia=" + inteligencia +
                ", adivinacion=" + adivinacion +
                ", arcanismo=" + arcanismo +
                ", callejeo=" + callejeo +
                ", culturaMagia=" + culturaMagia +
                ", culturaMuggle=" + culturaMuggle +
                ", herbologia=" + herbologia +
                ", magizoologia=" + magizoologia +
                ", medicina=" + medicina +
                ", politica=" + politica +
                ", supervivencia=" + supervivencia +
                '}';
    }
}
