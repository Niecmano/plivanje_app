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
public class Takmicenje extends OpstiDomenskiObjekat{
    
    private Long idTakmicenja;
    private String nazivTakm;

    public Takmicenje() {
    }

    public Takmicenje(Long idTakmicenja, String nazivTakm) {
        this.idTakmicenja = idTakmicenja;
        this.nazivTakm = nazivTakm;
    }
    
    public Takmicenje(String nazivTakm) {
        this.nazivTakm = nazivTakm;
    }

    public Long getIdTakmicenja() {
        return idTakmicenja;
    }

    public String getNazivTakm() {
        return nazivTakm;
    }

    public void setNazivTakm(String nazivTakm) {
        this.nazivTakm = nazivTakm;
    }

    @Override
    public String toString() {
        return nazivTakm;
    }
    
    @Override   
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Takmicenje)) return false;
        Takmicenje t = (Takmicenje) obj;
        return t.getIdTakmicenja().equals(idTakmicenja);
    }

    @Override
    public String nazivTabele() {
        return "takmicenje";
    }

    @Override
    public String kraciNazivTabele() {
        return "te";
    }

    @Override
    public String joinDeo() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    @Override
    public String vrednostiUbacivanje() {
        return "0,'"+nazivTakm+"'";
    }

    @Override
    public String azuriranje() {
        return "naziv='"+nazivTakm+"' WHERE id="+idTakmicenja;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> lt = new LinkedList<>();
        try {
            while (rs.next()) {
                lt.add(new Takmicenje(rs.getLong("id"), rs.getString("naziv")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return lt;
    }

    @Override
    public String brisanje() {
        return "WHERE id="+idTakmicenja;
    }

    @Override
    public String filter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
