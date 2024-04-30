package org.example.auto;

import java.util.ArrayList;

public class MemoryAutoRepository implements AutoRepository {
    private ArrayList<Auto> autos;

    public MemoryAutoRepository() {
        this.autos = new ArrayList<>();
    }

    @Override
    public ArrayList<Auto> getAll() {
        return this.autos;
    }

    @Override
    public void addAuto(Auto auto) {
        this.autos.add(auto);
    }
}
