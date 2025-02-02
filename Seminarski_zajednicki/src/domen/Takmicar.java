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
public class Takmicar extends OpstiDomenskiObjekat{
    
    private Long idTakmicar;
    private int uzrast;
    private String imePrezime;
    private Pol pol;
    //promena KM
    private PlivackiKlub pk;

    public Takmicar(PlivackiKlub pk) {
        this.pk=pk;
    }

    public Takmicar(Long idTakm) {
        this.idTakmicar = idTakm;
    }

    public Takmicar(Long idTakmicar, int uzrast, String imePrezime, Pol pol, PlivackiKlub pk) {
        this.idTakmicar = idTakmicar;
        this.uzrast = uzrast;
        this.imePrezime = imePrezime;
        this.pol = pol;
        this.pk = pk;
    }

    public Long getIdTakmicar() {
        return idTakmicar;
    }

    public void setIdTakmicar(Long idTakmicar) {
        this.idTakmicar = idTakmicar;
    }

    public int getUzrast() {
        return uzrast;
    }

    public void setUzrast(int uzrast) {
        this.uzrast = uzrast;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public PlivackiKlub getPk() {
        return pk;
    }

    public void setPk(PlivackiKlub pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return imePrezime;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Takmicar)) return false;
        Takmicar t = (Takmicar) obj;
        return t.getIdTakmicar().equals(idTakmicar);
    }

    @Override
    public String nazivTabele() {
        return "takmicar"; 
    }

    @Override
    public String kraciNazivTabele() {
        return "tak";
    }

    @Override
    public String joinDeo() {
        return "";
    }

    @Override
    public String uslov() {
        return "WHERE idPK="+getPk().getIdKluba();
    }

    @Override
    public String vrednostiUbacivanje() {
        return "0,"+uzrast+",'"+imePrezime+"','"+String.valueOf(pol)+"',"+pk.getIdKluba();
    }

    @Override
    public String azuriranje() {
        return "uzrast="+uzrast+",imePrezime='"+imePrezime+"',idPK="+pk.getIdKluba()+" WHERE idTakmicar="+idTakmicar;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> takms = new LinkedList<>();
        try {
            while (rs.next()) {                
                takms.add(new Takmicar(rs.getLong("idTakmicar"), rs.getInt("uzrast"),
                        rs.getString("imePrezime"), Pol.valueOf(rs.getString("pol")), pk));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return takms;
    }  

    @Override
    public String brisanje() {
        return "WHERE idTakmicar="+idTakmicar;
    }

    @Override
    public String filter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
