/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.Takmicar;

/**
 *
 * @author Nemanja
 */
public class ModelTabeleTakmicari extends AbstractTableModel {
    private List<Takmicar> taks;
    private String[] kolone = {"ime i prezime","uzrast","pol"};

    public ModelTabeleTakmicari(List<Takmicar> taks) {
        this.taks = taks;
    }

    @Override
    public int getRowCount() {
        return taks.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Takmicar tak = taks.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> tak.getImePrezime();
            case 1 -> tak.getUzrast();
            case 2 -> tak.getPol();
            default -> null;
        };
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
}
