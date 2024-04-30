package org.example;

import org.example.auto.Auto;
import org.example.auto.AutoRepository; // Import AutoRepository

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Garaz {

    private final AutoRepository autoRepository;
    private JTable table;

    public Garaz(AutoRepository autoRepository) {
        this.autoRepository = autoRepository;
    }

    JPanel GarauFrame() {
        JPanel garazPanel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Vítejte v systému ", SwingConstants.CENTER);

        // Definice názvů sloupců
        String[] columnNames = {"Název", "Značka", "Model", "Rok"};

        // Vytvoření nového JTable
        table = new JTable(null, columnNames);

        // Přidání JTable do JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);

        // Přidání JScrollPane do garazPanel
        garazPanel.add(scrollPane, BorderLayout.CENTER);

        garazPanel.add(label, BorderLayout.NORTH);

        // Aktualizace dat v tabulce
        updateTable();

        return garazPanel;
    }

    void updateTable() {
        // Získání dat z AutoRepository
        List<Auto> auta = autoRepository.getAll(); // Use getAll() method to get the list of cars

        // Převedení dat do formátu pro JTable
        Object[][] data = new Object[auta.size()][4];
        for (int i = 0; i < auta.size(); i++) {
            Auto auto = auta.get(i);
            data[i][0] = auto.getVin();
            data[i][1] = auto.getZnacka();
            data[i][2] = auto.getModel();
            data[i][3] = auto.getRok();
        }

        // Nastavení nových dat pro JTable
        table.setModel(new DefaultTableModel());
    }
}