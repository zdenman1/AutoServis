package org.example.auto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.zakaznik.Zakaznik;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Auto {

    private String id;
    private String znacka;
    private String model;
    private int rok;
    private String spz;
    private String vin;
    private String zavada;
    private List<Zakaznik> zakaznici;

    public Auto(String id, String znacka, String model, int rok, String spz, String vin, String zavada) {
        this.id = id;
        this.znacka = znacka;
        this.model = model;
        this.rok = rok;
        this.spz = spz;
        this.vin = vin;
        this.zavada = zavada;
        this.zakaznici = new ArrayList<>(); // Inicializace seznamu zákazníků
    }

    public Auto(String znacka, String model, int rok, String spz, String vin, String zavada) {
        this.id = UUID.randomUUID().toString();
        this.znacka = znacka;
        this.model = model;
        this.rok = rok;
        this.spz = spz;
        this.vin = vin;
        this.zavada = zavada;
        this.zakaznici = new ArrayList<>();
    }

    void addZakaznik (Zakaznik zakaznik){
        this.zakaznici.add(zakaznik);
    }
}
