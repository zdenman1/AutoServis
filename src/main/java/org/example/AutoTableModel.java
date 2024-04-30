package org.example;

import org.example.auto.Auto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AutoTableModel extends AbstractTableModel {
    private List<Auto> auta;
    private final String[] columnNames = {"Název", "Značka", "Model", "Rok", "Závada", "SPZ"};

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
        Auto auto = auta.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return auto.getVin();
            case 1:
                return auto.getZnacka();
            case 2:
                return auto.getModel();
            case 3:
                return auto.getRok();
            case 4:
                return auto.getZavada();
            case 5:
                return auto.getSpz();


            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void addAuto(Auto auto) {
        auta.add(auto);
        fireTableRowsInserted(auta.size() - 1, auta.size() - 1);
    }
}