package org.example.auto;


import java.util.ArrayList;

public interface AutoRepository {

    ArrayList<Auto> getAll();
    void addAuto(Auto auto);

}
