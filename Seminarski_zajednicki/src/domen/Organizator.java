/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Nemanja
 */
public class Organizator extends OpstiDomenskiObjekat{
    
    private String username;
    private String lozinka;

    public Organizator(String username, String lozinka) {
        this.username = username;
        this.lozinka = lozinka;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String nazivTabele() {
        return "organizator";
    }

    @Override
    public String kraciNazivTabele() {
        return "";
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
        return "";
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        try {
            while(rs.next()){
                if(rs.getString("username").equals(username)
                        && rs.getString("lozinka").equals(lozinka)){
                    List<OpstiDomenskiObjekat> orgs = new LinkedList<>();
                    orgs.add(new Organizator(username, lozinka));
                    return orgs;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}
