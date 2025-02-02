/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import domen.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nemanja
 */
public class ModelTabeleStavke extends AbstractTableModel{
    private List<StavkaEvidencijePrijave> stavke;
    private String[] kolone = {"takmicar","uzrast","pol","disciplina"};

    public ModelTabeleStavke(List<StavkaEvidencijePrijave> stavke) {
        this.stavke = stavke;
    }

    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaEvidencijePrijave ep = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ep.getTakmicar();
            case 1:
                return ep.getTakmicar().getUzrast();
            case 2:
                return ep.getTakmicar().getPol();
            case 3:
                return String.valueOf(ep.getDisciplina());
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public StavkaEvidencijePrijave get(int index) {
        if(index<0) throw new ArrayIndexOutOfBoundsException();
        return stavke.get(index);
    }
}
