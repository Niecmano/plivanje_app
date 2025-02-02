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
public class StavkaEvidencijePrijave extends OpstiDomenskiObjekat{
    
    private EvidencijaPrijave evidencija;
    private Long redniBrojStavke;
    private Disciplina disciplina;
    private Takmicar takmicar;

    public StavkaEvidencijePrijave(EvidencijaPrijave ev) {
        evidencija=ev;
    }
    
    public StavkaEvidencijePrijave(EvidencijaPrijave evidencija, Long redniBrojStavke, Disciplina disciplina, Takmicar takmicar) {
        this.evidencija = evidencija;
        this.redniBrojStavke = redniBrojStavke;
        this.disciplina = disciplina;
        this.takmicar = takmicar;
    }

    public EvidencijaPrijave getEvidencija() {
        return evidencija;
    }

    public void setEvidencija(EvidencijaPrijave evidencija) {
        this.evidencija = evidencija;
    }

    public Long getRedniBrojStavke() {
        return redniBrojStavke;
    }

    public void setRedniBrojStavke(Long redniBrojStavke) {
        this.redniBrojStavke = redniBrojStavke;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Takmicar getTakmicar() {
        return takmicar;
    }

    public void setTakmicar(Takmicar takmicar) {
        this.takmicar = takmicar;
    }

    @Override
    public String nazivTabele() {
        return "stavkaevidencijeprijave";
    }

    @Override
    public String kraciNazivTabele() {
        return "se";
    }

    @Override
    public String joinDeo() {
        return "JOIN evidencijaprijave ep ON(se.idPrijava=ep.idPrijava) JOIN takmicenje te ON(ep.idTakmicenja=te.id) \n" +
"JOIN plivackiklub pk ON(pk.idPlivackiKlub=ep.idPlivackiKlub) JOIN takmicar tak ON(se.idTakmicar=tak.idTakmicar)";
    }

    @Override
    public String uslov() {
        return "WHERE ep.idPrijava="+evidencija.getIdPrijave();
    }

    @Override
    public String vrednostiUbacivanje() {
        return evidencija.getIdPrijave()+",0,'"+disciplina+"',"+takmicar.getIdTakmicar();
    }

    @Override
    public String azuriranje() {
        return "disciplina='"+disciplina+"',idTakmicar="+takmicar.getIdTakmicar()+brisanje();
    }

    @Override
    public String brisanje() {
        return " WHERE idPrijava="+evidencija.getIdPrijave()+" AND rb="+redniBrojStavke;
    }

    @Override
    public String filter() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListuObj(ResultSet rs) {
         List<OpstiDomenskiObjekat> stavke = new LinkedList<>();
        try {
            while(rs.next()){
                PlivackiKlub pk = new PlivackiKlub(rs.getLong("idPlivackiKlub"));
                pk.setNazivKluba(rs.getString("idPlivackiKlub"));
                Takmicenje te = new Takmicenje(rs.getLong("te.id"),rs.getString("te.naziv"));
                EvidencijaPrijave ep = new EvidencijaPrijave(rs.getLong("ep.idPrijava"), 
                    rs.getDate("datumEvid"), te, pk);
                Takmicar tak = new Takmicar(rs.getLong("tak.idTakmicar"),rs.getInt("uzrast"),
                    rs.getString("imePrezime"), Pol.valueOf(rs.getString("pol")),pk);
                stavke.add(new StavkaEvidencijePrijave(ep, rs.getLong("rb"),
                        Disciplina.valueOf(rs.getString("disciplina")),tak));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return stavke;
    }
}
