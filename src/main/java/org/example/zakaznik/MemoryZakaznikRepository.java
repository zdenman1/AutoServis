package org.example.zakaznik;

import java.util.ArrayList;

public class MemoryZakaznikRepository implements ZakaznikRepository {
    private ArrayList<Zakaznik> zakaznici;

    public MemoryZakaznikRepository() {
        this.zakaznici = new ArrayList<>();
    }

    @Override
    public ArrayList<Zakaznik> getAll() {
        return this.zakaznici;
    }

    @Override
    public void addZakaznik(Zakaznik zakaznik) {
        this.zakaznici.add(zakaznik);
    }
}