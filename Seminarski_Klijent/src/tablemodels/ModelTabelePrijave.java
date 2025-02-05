/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tablemodels;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import domen.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nemanja
 */
public class ModelTabelePrijave extends AbstractTableModel {
    private List<EvidencijaPrijave> prijave;
    private String[] kolone = {"klub","takmicenje","broj nastupa","datum evidencije"};

    public ModelTabelePrijave(List<EvidencijaPrijave> prijave) {
        this.prijave = prijave;
    }

    @Override
    public int getRowCount() {
        return prijave.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EvidencijaPrijave ep = prijave.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return ep.getKlub();
            case 1:
                return ep.getTak();
            case 2:
                return ep.getBrNastupa();
            case 3:
                SimpleDateFormat sablon = new SimpleDateFormat("dd.MM.yyyy");
                return sablon.format(ep.getDatumEvid());
            default:
                return null;
    }
}

    
    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    public EvidencijaPrijave get(int index) {
        if(index<0) throw new ArrayIndexOutOfBoundsException();
        return prijave.get(index);
    }
}
