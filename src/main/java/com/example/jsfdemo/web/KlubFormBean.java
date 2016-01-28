package com.example.jsfdemo.web;

import com.example.jsfdemo.domain.Klub;
import com.example.jsfdemo.service.KlubManager;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.interceptor.Interceptor;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

@Named("klubBean")
@SessionScoped
public class KlubFormBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Klub klub = new Klub();

    private ListDataModel<Klub> klubs = new ListDataModel<Klub>();

    @Inject
    private KlubManager km;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String resetKlub() {
        this.klub = new Klub();
        return null;
    }

    public String loadKlub() {
        for (Klub k : km.getAllKlubs()) {
            if (k.getIdKlub() == getId()) {
                this.klub = k;
                break;
            }
        }
        return null;
    }

    public Klub getKlub() {
        return klub;
    }
    public void setKlub(Klub klub) {
        this.klub = klub;
    }

    public ListDataModel<Klub> getAllKlubs() {
        klubs.setWrappedData(km.getAllKlubs());
        return klubs;
    }

    // Actions
    public String addKlub() {
        km.addKlub(klub);
        return "showKlubs";
    }

    public String deleteKlub() {
        Klub klubToDelete = klubs.getRowData();
        km.deleteKlub(klubToDelete);
        return null;
    }

    public String updateKlub() {
        km.updateKlub(klub);
        return "showKlubs";
    }


    public void correctTelephone(FacesContext context, UIComponent component,
                                 Object value) {

        String telephone = (String)value;

        //Converting to telephone number without "-" sign
        if (telephone.contains("-")) {
            telephone = telephone.replace("-", "");
        }

        if (telephone.length() != 9) {
            FacesMessage message = new FacesMessage();
            message.setDetail("Numer telefonu musi składać się z 9 cyfr");
            message.setSummary("Numer telefonu musi składać się z 9 cyfr");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

        for (int i=0; i < telephone.length(); i++) {
            try {
                int number = Integer.parseInt(Character.toString(telephone.charAt(i)));
            }
            catch (Exception e) {
                FacesMessage message = new FacesMessage();
                message.setDetail("Numer telefonu może składać się jedynie z cyfr i ewentualnie myślników");
                message.setSummary("Numer telefonu może składać się jedynie z cyfr i ewentualnie myślników");
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(message);
            }
        }
    }


}
