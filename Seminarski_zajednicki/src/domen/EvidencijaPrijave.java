/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class EvidencijaPrijave extends OpstiDomenskiObjekat{
    
    private Long idPrijave;
    private int brNastupa;
    private Date datumEvid;
    private Takmicenje tak;
    private PlivackiKlub klub;

    public EvidencijaPrijave() {
    }
    
    public EvidencijaPrijave(Long idPrijave){
        this.idPrijave=idPrijave;
    }
    
    public EvidencijaPrijave(PlivackiKlub klub, Takmicenje tak){
        this.klub = klub;
        this.tak = tak;
    }

    public EvidencijaPrijave(Long idPrijave, Date datumEvid, Takmicenje tak, PlivackiKlub klub) {
        this.idPrijave = idPrijave;
        this.datumEvid = datumEvid;
        this.tak = tak;
        this.klub = klub;
    }
    
    public EvidencijaPrijave(Long idPrijave, Date datumEvid, Takmicenje tak, PlivackiKlub klub, int brNastupa) {
        this.idPrijave = idPrijave;
        this.brNastupa = brNastupa;
        this.datumEvid = datumEvid;
        this.tak = tak;
        this.klub = klub;
    }

    public Long getIdPrijave() {
        return idPrijave;
    }

    public void setIdPrijave(Long idPrijave) {
        this.idPrijave = idPrijave;
    }

    public int getBrNastupa() {
        return brNastupa;
    }

    public void setBrNastupa(int brNastupa) {
        this.brNastupa = brNastupa;
    }

    public Date getDatumEvid() {
        return datumEvid;
    }

    public void setDatumEvid(Date datumEvid) {
        this.datumEvid = datumEvid;
    }

    public PlivackiKlub getKlub() {
        return klub;
    }

    public void setKlub(PlivackiKlub klub) {
        this.klub = klub;
    }

    public Takmicenje getTak() {
        return tak;
    }

    public void setTak(Takmicenje tak) {
        this.tak = tak;
    }

    @Override
    public String toString() {
        return klub+" "+tak;
    } 

    @Override
    public String nazivTabele() {
        return "evidencijaprijave";
    }

    @Override
    public String kraciNazivTabele() {
        return "ep";
    }

    @Override
    public String joinDeo() {
        return "JOIN takmicenje te ON(ep.idTakmicenja=te.id) JOIN plivackiklub pk \n" +
"ON(ep.idPlivackiKlub=pk.idPlivackiKlub) JOIN mesto m ON(pk.idMesto=m.idMesto)";
    }

    @Override
    public String uslov() {
        return "";
    }    

    @Override
    public String vrednostiUbacivanje() {
        return getIdPrijave()+","+brNastupa+",'"+new java.sql.Date(datumEvid.getTime())+"',"+klub.getIdKluba()+","+tak.getIdTakmicenja();
    }

    @Override
    public String azuriranje() {
        return "datumEvid='"+new java.sql.Date(datumEvid.getTime())+"',idPlivackiKlub="+klub.getIdKluba()
                +",idTakmicenja="+tak.getIdTakmicenja()+" WHERE idPrijava="+idPrijave;
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
        List<OpstiDomenskiObjekat> ep = new LinkedList<>();
        try {
            while (rs.next()) {
                Takmicenje te = new Takmicenje(rs.getLong("te.id"), rs.getString("te.naziv"));
                Mesto m = new Mesto(rs.getLong("m.idMesto"), rs.getString("m.nazivMesta"));
                PlivackiKlub kl = new PlivackiKlub(rs.getLong("pk.idPlivackiKlub"), 
                        rs.getString("pk.nazivPK"), rs.getInt("pk.brojPlivaca"), rs.getInt("pk.brojTrenera"), m);
                ep.add(new EvidencijaPrijave(rs.getLong("ep.idPrijava"), rs.getDate("ep.datumEvid"),
                        te, kl, rs.getInt("ep.brNastupa")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return ep;
    }

    @Override
    public String brisanje() {
        return "WHERE idPrijava="+idPrijave;
    }

    @Override
    public String filter() {
        return "WHERE ep.idPlivackiKlub="+klub.getIdKluba()+" AND ep.idTakmicenja="+tak.getIdTakmicenja();
    }
}
