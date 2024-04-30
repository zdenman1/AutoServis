package org.example.zakaznik;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.auto.Auto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Zakaznik {
    private String id;
    private String jmeno;
    private String prijmeni;
    private String telefon;
    private String email;
    private List<Auto> auta;

    public Zakaznik(String id, String jmeno, String prijmeni, String telefon, String email) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.email = email;
        this.auta = new ArrayList<>();
    }

    public Zakaznik(String jmeno, String prijmeni, String telefon, String email) {
        this.id = UUID.randomUUID().toString();
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telefon = telefon;
        this.email = email;
        this.auta = new ArrayList<>();
    }

    void addAuto (Auto auto){
        this.auta.add(auto);
    }

}