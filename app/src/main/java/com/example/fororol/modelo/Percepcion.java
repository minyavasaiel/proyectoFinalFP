package com.example.fororol.modelo;

public class Percepcion {
    private int idpe;
    private int  percepcion;
    private int alerta;
    private int consciencia;
    private int empatia;
    private int iniciativa;
    private int investigacion;

    public Percepcion() {
    }

    public Percepcion(int idpe, int percepcion, int alerta, int consciencia, int empatia, int iniciativa, int investigacion) {
        this.idpe = idpe;
        this.percepcion = percepcion;
        this.alerta = alerta;
        this.consciencia = consciencia;
        this.empatia = empatia;
        this.iniciativa = iniciativa;
        this.investigacion = investigacion;
    }

    public int getIdpe() {
        return idpe;
    }

    public void setIdpe(int idpe) {
        this.idpe = idpe;
    }

    public int getPercepcion() {
        return percepcion;
    }

    public void setPercepcion(int percepcion) {
        this.percepcion = percepcion;
    }

    public int getAlerta() {
        return alerta;
    }

    public void setAlerta(int alerta) {
        this.alerta = alerta;
    }

    public int getConsciencia() {
        return consciencia;
    }

    public void setConsciencia(int consciencia) {
        this.consciencia = consciencia;
    }

    public int getEmpatia() {
        return empatia;
    }

    public void setEmpatia(int empatia) {
        this.empatia = empatia;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getInvestigacion() {
        return investigacion;
    }

    public void setInvestigacion(int investigacion) {
        this.investigacion = investigacion;
    }

    @Override
    public String toString() {
        return "Percepcion{" +
                "idpe=" + idpe +
                ", percepcion=" + percepcion +
                ", alerta=" + alerta +
                ", consciencia=" + consciencia +
                ", empatia=" + empatia +
                ", iniciativa=" + iniciativa +
                ", investigacion=" + investigacion +
                '}';
    }
}
