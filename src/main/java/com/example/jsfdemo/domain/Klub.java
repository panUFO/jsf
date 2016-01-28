package com.example.jsfdemo.domain;

import javax.validation.constraints.Min;

public class Klub {


    private Long idKlub;
    private String miasto;
    private String nazwa;
    private String NrTelefonu;
    private int ilosc_miejsc;

    public Long getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Long idKlub) {
        this.idKlub = idKlub;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNrTelefonu() {
        return NrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        NrTelefonu = nrTelefonu;
    }

    public int getIlosc_miejsc() {
        return ilosc_miejsc;
    }

    public void setIlosc_miejsc(int ilosc_miejsc) {
        this.ilosc_miejsc = ilosc_miejsc;
    }

    public String getKlubInfo() {
        return getMiasto() + " " + getNazwa();
    }
}
