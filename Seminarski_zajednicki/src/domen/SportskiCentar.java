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
public class SportskiCentar extends OpstiDomenskiObjekat{
    
    private Long id;
    private String naziv;
    private int kapacitetTribina;

    public SportskiCentar() {
    }
    
    public SportskiCentar(Long id, String naziv, int kapacitetTribina) {
        this.id = id;
        this.naziv = naziv;
        this.kapacitetTribina = kapacitetTribina;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getKapacitetTribina() {
        return kapacitetTribina;
    }

    public void setKapacitetTribina(int kapacitetTribina) {
        this.kapacitetTribina = kapacitetTribina;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    @Override   
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof SportskiCentar)) return false;
        SportskiCentar sc = (SportskiCentar) obj;
        return sc.getId().equals(id);
    }
    
    @Override
    public String nazivTabele() {
        return "sportskicentar";
    }

    @Override
    public String kraciNazivTabele() {
        return "sc";
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
        return id+",'"+naziv+"',"+kapacitetTribina;
    }

    @Override
    public String azuriranje() {
        return "naziv='"+naziv+"',kapacitet="+kapacitetTribina+" WHERE id="+id;
    }

    @Override
    public String brisanje() {
        return "WHERE id="+id;
    }

    @Override
    public String filter() {
        return "";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> cs = new LinkedList<>();
        try {
            while(rs.next()){
                cs.add(new SportskiCentar(rs.getLong("id"),rs.getString("naziv"), rs.getInt("kapacitet")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return cs;
    }
}
