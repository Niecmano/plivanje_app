/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import domen.LokacijeTakmicenja;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nemanja
 */
public class ModelTabeleLokTakm extends AbstractTableModel {

    private List<LokacijeTakmicenja> locs;
    private String[] kolone = {"takmicenje", "godina", "sportski centar"};

    public ModelTabeleLokTakm(List<LokacijeTakmicenja> locs) {
        this.locs = locs;
    }

    @Override
    public int getRowCount() {
        return locs.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        LokacijeTakmicenja lt = locs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return lt.getT();
            case 1:
                return lt.getGodina();
            case 2:
                return lt.getSc();
            default:
                throw new AssertionError();
        }
    }
}
