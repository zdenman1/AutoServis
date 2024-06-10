package org.example;

import org.example.car.Car;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AutoTableModel extends AbstractTableModel {
	private final String[] columnNames = {"Název", "Značka", "Model", "Rok", "Závada", "SPZ"};
	private List<Car> auta;

	public AutoTableModel() {
		this.auta = new ArrayList<>();
	}

	@Override
	public int getRowCount() {
		return auta.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Car car = auta.get(rowIndex);
		switch (columnIndex) {
			case 0:
				return car.getVin();
			case 1:
				return car.getBrand();
			case 2:
				return car.getModel();
			case 3:
				return car.getYear();
			case 4:
				return car.getIssue();
			case 5:
				return car.getRegistrationNumber();


			default:
				return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void addAuto(Car car) {
		auta.add(car);
		fireTableRowsInserted(auta.size() - 1, auta.size() - 1);
	}
}