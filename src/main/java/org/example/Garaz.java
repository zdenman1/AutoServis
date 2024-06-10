package org.example;

import org.example.car.Car;
import org.example.car.CarRepository;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class Garaz {

	private final CarRepository carRepository;
	private JTable table;

	public Garaz(CarRepository carRepository) {
		this.carRepository = carRepository;
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
		List<Car> auta = carRepository.getAll(); // Use getAll() method to get the list of cars

		// Převedení dat do formátu pro JTable
		Object[][] data = new Object[auta.size()][4];
		for (int i = 0; i < auta.size(); i++) {
			Car car = auta.get(i);
			data[i][0] = car.getVin();
			data[i][1] = car.getBrand();
			data[i][2] = car.getModel();
			data[i][3] = car.getYear();
		}

		// Nastavení nových dat pro JTable
		table.setModel(new DefaultTableModel());
	}
}