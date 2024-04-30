package org.example.zakaznik;

import java.util.ArrayList;

public interface ZakaznikRepository {

    ArrayList<Zakaznik> getAll();

    void addZakaznik(Zakaznik zakaznik);
}