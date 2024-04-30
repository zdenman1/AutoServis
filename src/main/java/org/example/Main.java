package org.example;

import org.example.auto.Auto;
import org.example.auto.AutoRepository;
import org.example.auto.MemoryAutoRepository;

public class Main {

    public static void main(String[] args) {



        AutoRepository autoRepository = new MemoryAutoRepository();

        System.out.println(autoRepository.getAll());




        Obraz obraz = new Obraz(autoRepository);
        obraz.createMenuBar();
        obraz.createKancelarFrame();
        obraz.createGarazFrame();



    }
}