package com.example.jsfdemo.service;

import com.example.jsfdemo.domain.Koncert;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class KoncertManager {
    private List<Koncert> KoncertDB = new ArrayList<Koncert>();

    public void addKoncert(Koncert koncert) {
        Koncert newKoncert = new Koncert();

        newKoncert.setNazwa_koncertu(koncert.getNazwa_koncertu());
        newKoncert.setCeny_biletow(koncert.getCeny_biletow());
        newKoncert.setKlub(koncert.getKlub());

        newKoncert.setIdKoncert(koncert.getIdKoncert());


        if (KoncertDB.size() > 0) {
            newKoncert.setIdKoncert(KoncertDB.get(KoncertDB.size() - 1).getIdKoncert() + 1);
        }
        else {
            newKoncert.setIdKoncert(1L);
        }

        KoncertDB.add(newKoncert);
    }

    public void deleteKoncert(Koncert koncert) {
        KoncertDB.remove(koncert);
    }

    public List<Koncert> getAllKoncerts() {
        return KoncertDB;
    }

    public void updateKoncert(Koncert koncert) {

        for (Koncert k : getAllKoncerts()) {
            if (k.getIdKoncert() == koncert.getIdKoncert()) {
                k = koncert;

                break;
            }
        }
    }
}
