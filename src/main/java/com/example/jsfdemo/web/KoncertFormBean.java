package com.example.jsfdemo.web;

import com.example.jsfdemo.domain.Klub;
import com.example.jsfdemo.domain.Koncert;
import com.example.jsfdemo.service.KlubManager;
import com.example.jsfdemo.service.KoncertManager;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("koncertBean")
@SessionScoped
public class KoncertFormBean implements Serializable  {


    private static final long serialVersionUID = 1L;

    private Long id;

    private Koncert koncert = new Koncert();

    private ListDataModel<Koncert> koncerts = new ListDataModel<Koncert>();

    @Inject
    private KoncertManager kom;

    @Inject
    private KlubManager klubm;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String resetKoncert() {
        this.koncert = new Koncert();

        return null;
    }

    public String loadKoncert() {
        for (Koncert k : kom.getAllKoncerts()) {
            if (k.getIdKoncert() == getId()) {
                this.koncert = k;
                break;
            }
        }

        return null;
    }

    public Koncert getKoncert() {
        return koncert;
    }
    public void setKoncert(Koncert koncert) {
        this.koncert = koncert;
    }

    public ListDataModel<Koncert> getAllKoncerts() {
        koncerts.setWrappedData(kom.getAllKoncerts());
        return koncerts;
    }

    // Actions
    public String addKoncert() {
        for (Klub c : klubm.getAllKlubs()) {
            if (c.getIdKlub() == koncert.getIdKlub()) {
                koncert.setKlub(c);
                break;
            }
        }


        kom.addKoncert(koncert);
        return "showKoncerts";
    }

    public String deleteKoncert() {
        Koncert koncertToDelete = koncerts.getRowData();
        kom.deleteKoncert(koncertToDelete);
        return null;
    }

    public String updateKoncert() {
        for (Klub c : klubm.getAllKlubs()) {
            if (c.getIdKlub() == koncert.getIdKlub()) {
                koncert.setKlub(c);
                break;
            }
        }

        kom.updateKoncert(koncert);
        return "showKoncerts";
    }
}
