package com.example.jsfdemo.service;

import com.example.jsfdemo.domain.Klub;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KlubManager {
    private List<Klub> KlubDB = new ArrayList<Klub>();


    public KlubManager() {

        //Seeding
        Klub newKlub = new Klub();
        newKlub.setIdKlub(1L);
        newKlub.setMiasto("Gdansk");
        newKlub.setNazwa("B90");
        newKlub.setNrTelefonu("721642399");
        newKlub.setIlosc_miejsc(2000);
        KlubDB.add(newKlub);
    }

    public void addKlub(Klub klub) {
        Klub newKlub = new Klub();

        newKlub.setMiasto(klub.getMiasto());
        newKlub.setNazwa(klub.getNazwa());
        newKlub.setNrTelefonu(klub.getNrTelefonu());
        newKlub.setIlosc_miejsc(klub.getIlosc_miejsc());

        if (KlubDB.size() > 0) {
            newKlub.setIdKlub(KlubDB.get(KlubDB.size() - 1).getIdKlub() + 1);
        }
        else {
            newKlub.setIdKlub(1L);
        }

        KlubDB.add(newKlub);
    }


    public void deleteKlub(Klub klub) {
        KlubDB.remove(klub);
    }

    public List<Klub> getAllKlubs() {
        return KlubDB;
    }

    public void updateKlub(Klub klub) {

        for (Klub k : getAllKlubs()) {
            if (k.getIdKlub() == klub.getIdKlub()) {
                k = klub;
                break;
            }
        }
    }


}
