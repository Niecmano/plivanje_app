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
public class PlivackiKlub extends OpstiDomenskiObjekat{
    
    private Long idKluba;
    private String nazivKluba;
    private int brojPlivaca;
    private int brojTrenera;
    private int ukupnoClanova;
    private Mesto mesto;

    public PlivackiKlub() {
    }

    public PlivackiKlub(Long idKluba) {
        this.idKluba = idKluba;
    }

    public PlivackiKlub(String nazivKluba, Mesto mesto) {
        this.nazivKluba = nazivKluba;
        this.mesto = mesto;
    }
    
    public PlivackiKlub(Long idKluba, String nazivKluba, int brojPlivaca, int brojTrenera, Mesto mesto) {
        this.idKluba = idKluba;
        this.nazivKluba = nazivKluba;
        this.brojPlivaca = brojPlivaca;
        this.brojTrenera = brojTrenera;
        this.ukupnoClanova = brojPlivaca + brojTrenera;
        this.mesto = mesto;
    }

    public Long getIdKluba() {
        return idKluba;
    }

    public void setIdKluba(Long idKluba) {
        this.idKluba = idKluba;
    }

    public String getNazivKluba() {
        return nazivKluba;
    }

    public void setNazivKluba(String nazivKluba) {
        this.nazivKluba = nazivKluba;
    }

    public int getBrojPlivaca() {
        return brojPlivaca;
    }

    public void setBrojPlivaca(int brojPlivaca) {
        this.brojPlivaca = brojPlivaca;
    }

    public int getBrojTrenera() {
        return brojTrenera;
    }

    public void setBrojTrenera(int brojTrenera) {
        this.brojTrenera = brojTrenera;
    }

    public int getUkupnoClanova() {
        return ukupnoClanova;
    }

    public void setUkupnoClanova(int ukupnoClanova) {
        this.ukupnoClanova = ukupnoClanova;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    @Override
    public String toString() {
        return nazivKluba+" "+mesto;
    }
    
    @Override   
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof PlivackiKlub)) return false;
        PlivackiKlub pk = (PlivackiKlub) obj;
        return pk.getIdKluba().equals(idKluba);
    }

    @Override
    public String nazivTabele() {
        return "plivackiklub";
    }

    @Override
    public String kraciNazivTabele() {
        return "pk";
    }

    @Override
    public String joinDeo() {
        return "JOIN mesto m ON pk.idMesto = m.idMesto";
    }

    @Override
    public String uslov() {
       return "";
    }

    @Override
    public String vrednostiUbacivanje() {
        return "0,'"+nazivKluba+"',"+brojPlivaca+","+brojTrenera+","+(brojPlivaca+brojTrenera)+","+mesto.getIdMesto();
    }

    @Override
    public String azuriranje() {
        return "nazivPK='"+nazivKluba+"',idMesto="+mesto.getIdMesto()+",brojPlivaca="+brojPlivaca
        +",brojTrenera="+brojTrenera+",ukupnoClanova="+(brojPlivaca+brojTrenera)+" WHERE idPlivackiKlub="+idKluba;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> klubovi = new LinkedList<>();
        try {
            while (rs.next()) {
                klubovi.add(new PlivackiKlub(rs.getLong("idPlivackiKlub"), rs.getString("nazivPK"),
                        rs.getInt("brojPlivaca"), rs.getInt("brojTrenera"), new Mesto(rs.getLong("idMesto"), rs.getString("nazivMesta"))));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return klubovi;
    }

    @Override
    public String brisanje() {
        return "WHERE idPlivackiKlub="+idKluba;
    }

    @Override
    public String filter() {
        return "WHERE LOWER(nazivPK) LIKE '%"+nazivKluba.toLowerCase()+"%' AND m.idMesto="+mesto.getIdMesto();
    }
}
