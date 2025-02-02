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
public class Mesto extends OpstiDomenskiObjekat{
    
    private Long idMesto;
    private String nazivMesto;

    public Mesto() {
    }
    
    public Mesto(Long idMesto, String nazivMesto) {
        this.idMesto = idMesto;
        this.nazivMesto = nazivMesto;
    }

    public Long getIdMesto() {
        return idMesto;
    }

    public void setIdMesto(Long idMesto) {
        this.idMesto = idMesto;
    }

    public String getNazivMesto() {
        return nazivMesto;
    }

    public void setNazivMesto(String nazivMesto) {
        this.nazivMesto = nazivMesto;
    }

    @Override
    public String toString() {
        return this.nazivMesto;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Mesto)) return false;
        Mesto m = (Mesto) obj;
        return m.getIdMesto().equals(getIdMesto());
    }

    @Override
    public String nazivTabele() {
        return "mesto";
    }

    @Override
    public String kraciNazivTabele() {
        return "m";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String azuriranje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> mesta = new LinkedList<>();
        try {
            while (rs.next()) {
                mesta.add(new Mesto(rs.getLong("idMesto"), rs.getString("nazivMesta")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return mesta;
    }

    @Override
    public String brisanje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String filter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
