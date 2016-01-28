package com.example.jsfdemo.domain;

import javax.validation.constraints.Min;


public class Koncert {

    private Long idKoncert;
    private String nazwa_koncertu;
    private double ceny_biletow;

    private Klub klub;
    private Long idKlub;




    public Long getIdKoncert() {
        return idKoncert;
    }

    public void setIdKoncert(Long idKoncert) {
        this.idKoncert = idKoncert;
    }

    public String getNazwa_koncertu() {
        return nazwa_koncertu;
    }

    public void setNazwa_koncertu(String nazwa_koncertu) {
        this.nazwa_koncertu = nazwa_koncertu;
    }

    public double getCeny_biletow() {
        return ceny_biletow;
    }

    public void setCeny_biletow(double ceny_biletow) {
        this.ceny_biletow = ceny_biletow;
    }



    public Klub getKlub() {
        return klub;
    }

    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public Long getIdKlub() {
        return idKlub;
    }

    public void setIdKlub(Long idKlub) {
        this.idKlub = idKlub;
    }
}
