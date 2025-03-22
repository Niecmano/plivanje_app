/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class LokacijeTakmicenja extends OpstiDomenskiObjekat{
    private Takmicenje t;
    private SportskiCentar sc;
    private int godina;

    public LokacijeTakmicenja() {
    }

    public LokacijeTakmicenja(Takmicenje t, SportskiCentar sc, int godina) {
        this.t = t;
        this.sc = sc;
        this.godina = godina;
    }

    public Takmicenje getT() {
        return t;
    }

    public void setT(Takmicenje t) {
        this.t = t;
    }

    public SportskiCentar getSc() {
        return sc;
    }

    public void setSc(SportskiCentar sc) {
        this.sc = sc;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }
    
    @Override
    public String nazivTabele() {
        return "takmsc";
    }

    @Override
    public String kraciNazivTabele() {
        return "ts";
    }

    @Override
    public String joinDeo() {
        return "JOIN takmicenje te ON te.id=ts.idTakm JOIN sportskicentar sc ON sc.id=ts.idSC";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String vrednostiUbacivanje() {
        return t.getIdTakmicenja()+","+sc.getId()+","+godina;
    }

    @Override
    public String azuriranje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String brisanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String filter() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> lts = new LinkedList<>();
        try {
            while(rs.next()){
                Takmicenje t = new Takmicenje(rs.getLong("te.id"), rs.getString("te.naziv"));
                SportskiCentar sc = new SportskiCentar(rs.getLong("sc.id"),rs.getString("sc.naziv"),
                        rs.getInt("sc.kapacitet"));
                lts.add(new LokacijeTakmicenja(t, sc, rs.getInt("ts.godina")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lts;
    }
    
}
