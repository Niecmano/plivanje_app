/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.util.List;
import domen.*;
import java.sql.*;

/**
 *
 * @author Nemanja
 */
public class DBBroker {

    private static Connection conn;
    private static DBBroker dbb;
    public static DBBroker getInstance(){
        if(dbb==null) dbb = new DBBroker();
        return dbb;
    }
    private DBBroker() {
        conn = Konekcija.getInstance().getConn();
    }

    public static Connection getConn() {
        return conn;
    }
    
    public List<OpstiDomenskiObjekat> select(OpstiDomenskiObjekat opstiDO, boolean filter){
        try {
            String upit = "SELECT * FROM " + opstiDO.nazivTabele()+ " " + opstiDO.kraciNazivTabele()
                    + " " + opstiDO.joinDeo()+" "+opstiDO.uslov();
            if(filter==true) upit += opstiDO.filter();
            System.out.println(upit);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(upit);
            return opstiDO.vratiListuObj(rs);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public void update(OpstiDomenskiObjekat opstiDO){
        try {
            String upit = "UPDATE " + opstiDO.nazivTabele()+ " SET " + opstiDO.azuriranje();
            System.out.println(upit);
            Statement st = conn.createStatement();
            st.executeUpdate(upit);
            //int rez se moze izvuci i vratiti odg. boolean vred.
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void delete(OpstiDomenskiObjekat opstiDO){
        try {
            String upit = "DELETE FROM " + opstiDO.nazivTabele()+ " " + opstiDO.brisanje();
            System.out.println(upit);
            Statement st = conn.createStatement();
            st.executeUpdate(upit);
            //int rez se moze izvuci i vratiti odg. boolean vred.
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void insert(OpstiDomenskiObjekat opstiDO){
        try {
            String upit = "INSERT INTO " + opstiDO.nazivTabele()+ " VALUES(" + opstiDO.vrednostiUbacivanje()+")";
            System.out.println(upit);
            Statement st = conn.createStatement();
            st.executeUpdate(upit);
            //int rez se moze izvuci i vratiti odg. boolean vred.
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}


//    public List<PlivackiKlub> vratiKluboveIzBaze() {
//        List<PlivackiKlub> klubovi = new LinkedList<>();
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT pk.*, nazivMesta FROM plivackiklub pk JOIN mesto m ON pk.idMesto = m.idMesto");
//            while (rs.next()) {
//                klubovi.add(new PlivackiKlub(rs.getLong("idPlivackiKlub"), rs.getString("nazivPK"),
//                        rs.getInt("brojPlivaca"), rs.getInt("brojTrenera"), new Mesto(rs.getLong("idMesto"), rs.getString("nazivMesta"))));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return klubovi;
//    }
//
//    public void izbrisiKlubIzBaze(Long id) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM plivackiklub WHERE idPlivackiKlub=?");
//            ps.setLong(1, id);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public List<Mesto> vratiMestaIzBaze() {
//        List<Mesto> mesta = new LinkedList<>();
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM mesto");
//            while (rs.next()) {
//                mesta.add(new Mesto(rs.getLong("idMesto"), rs.getString("nazivMesta")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return mesta;
//    }
//
//    public void dodajPKuBazu(PlivackiKlub pk) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO plivackiklub VALUES(0,?,?,?,?,?)");
//            ps.setString(1, pk.getNazivKluba());
//            ps.setInt(2, pk.getBrojPlivaca());
//            ps.setInt(3, pk.getBrojTrenera());
//            ps.setInt(4, pk.getBrojPlivaca()+pk.getBrojTrenera());
//            ps.setLong(5, pk.getMesto().getIdMesto());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void izmeniKlubUBazi(PlivackiKlub pk) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("UPDATE plivackiklub SET nazivPK=?, "
//                    + "brojPlivaca=?, brojTrenera=?, ukupnoClanova=?, idMesto=? WHERE idPlivackiKlub=?");
//            ps.setString(1, pk.getNazivKluba());
//            ps.setInt(2, pk.getBrojPlivaca());
//            ps.setInt(3, pk.getBrojTrenera());
//            ps.setInt(4, pk.getUkupnoClanova());
//            ps.setLong(5, pk.getMesto().getIdMesto());
//            ps.setLong(6, pk.getIdKluba());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }   

//    public List<Organizator> prijava(Organizator org) {
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM organizator");
//            while(rs.next()){
//                if(rs.getString("username").equals(org.getUsername())
//                        && rs.getString("lozinka").equals(org.getLozinka())){
//                    List<Organizator> orgs = new LinkedList<>();
//                    orgs.add(org);
//                    return orgs;
//                }
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return null;
//    }
    
//    public List<PlivackiKlub> filtriranjeKlubova(String naziv, Mesto mesto) {
//        List<PlivackiKlub> klubovi = new LinkedList<>();
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT pk.*, nazivMesta FROM plivackiklub pk JOIN mesto m "
//                    + "ON pk.idMesto = m.idMesto WHERE LOWER(nazivPK) LIKE '%"+naziv.toLowerCase()+"%' "
//                            + "AND m.idMesto="+mesto.getIdMesto());
//            while (rs.next()) {
//                klubovi.add(new PlivackiKlub(rs.getLong("idPlivackiKlub"), rs.getString("nazivPK"),
//                        rs.getInt("brojPlivaca"), rs.getInt("brojTrenera"), new Mesto(rs.getLong("idMesto"), 
//                                rs.getString("nazivMesta"))));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return klubovi;
//    }

//    public List<Takmicar> vratiTakmPK(PlivackiKlub pk) {
//        List<Takmicar> takms = new LinkedList<>();
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM takmicar WHERE idPK=?");
//            ps.setLong(1, pk.getIdKluba());
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {                
//                takms.add(new Takmicar(rs.getLong("idTakmicar"), rs.getInt("uzrast"),
//                        rs.getString("imePrezime"), Pol.valueOf(rs.getString("pol")), pk));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return takms;
//    }
//
//    public void izbrisiTakmUBazi(Long id) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM takmicar WHERE idTakmicar=?");
//            ps.setLong(1, id);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void dodajTakmicara(Takmicar t) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO takmicar VALUES(0,?,?,?,?)");
//            ps.setInt(1, t.getUzrast());
//            ps.setString(2, t.getImePrezime());
//            ps.setString(3, String.valueOf(t.getPol()));
//            ps.setLong(4, t.getPk().getIdKluba());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void izmeniTakm(Takmicar t) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("UPDATE takmicar SET uzrast=?, "
//                    + "imePrezime=?, idPK=? WHERE idTakmicar=?");
//            ps.setInt(1, t.getUzrast());
//            ps.setString(2, t.getImePrezime());
//            ps.setLong(3, t.getPk().getIdKluba());
//            ps.setLong(4, t.getIdTakmicar());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

//    public boolean prijava(Organizator org) {
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM organizator");
//            while(rs.next()){
//                if(rs.getString("username").equals(org.getUsername())
//                        && rs.getString("lozinka").equals(org.getLozinka())) return true;
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return false;
//    }
    
//    public List<Takmicenje> vratiTakmicenja() {
//        List<Takmicenje> lt = new LinkedList<>();
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM takmicenje");
//            while (rs.next()) {
//                lt.add(new Takmicenje(rs.getLong("id"), rs.getString("naziv")));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return lt;
//    }
//
//    public void brisiTakmicenje(Takmicenje t) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM takmicenje WHERE id=?");
//            ps.setLong(1, t.getIdTakmicenja());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }
//
//    public void dodajTakmicenjeUBazu(Takmicenje t) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO takmicenje VALUES(0,?)");
//            ps.setString(1, t.getNazivTakm());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }   
//
//    public void izmeniTakmicenjeUBazi(Takmicenje t) {
//           try {
//            PreparedStatement ps = conn.prepareStatement("UPDATE takmicenje SET naziv=? WHERE id=?");
//            ps.setString(1, t.getNazivTakm());
//            ps.setLong(2, t.getIdTakmicenja());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

//    public List<EvidencijaPrijave> vratiPrijaveIzBaze() {
//        List<EvidencijaPrijave> ep = new LinkedList<>();
//        try {
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * from evidencijaprijave");
//            while (rs.next()) {
//                ep.add(new EvidencijaPrijave(rs.getLong("idPrijava"), rs.getDate("datumEvid"),
//                        vratiTakmicenjePrijave(rs.getLong("idTakmicenja")), 
//                        vratiKlubPrijave(rs.getLong("idPlivackiKlub"))));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        return ep;
//    }
    
//    public Takmicenje vratiTakmicenjePrijave(Long idTakm){
//        List<Takmicenje> taks = vratiTakmicenja();
//        for (Takmicenje tak : taks) {
//            if(tak.getIdTakmicenja().equals(idTakm)) return tak;
//        }
//        throw new RuntimeException("Ne postoji takmicenje");
//    }
//
//    private PlivackiKlub vratiKlubPrijave(Long id) {
//        List<PlivackiKlub> pks = vratiKluboveIzBaze();
//        for (PlivackiKlub pk : pks) {
//            if(pk.getIdKluba().equals(id)) return pk;
//        }
//        throw new RuntimeException("Ne postoji klub");
//    }

//    public void izbrisiPrijavuIzBaze(Long idprijave) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("DELETE FROM evidencijaprijave WHERE idPrijava=?");
//            ps.setLong(1, idprijave);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

//    public List<EvidencijaPrijave> filtriranjePrijava(PlivackiKlub plivackiKlub, Takmicenje takmicenje) {
//        List<EvidencijaPrijave> prijave = new LinkedList<>();
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM evidencijaprijave WHERE idPlivackiKlub=? AND idTakmicenja=?");
//            ps.setLong(1, plivackiKlub.getIdKluba());
//            ps.setLong(2, takmicenje.getIdTakmicenja());
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                prijave.add(new EvidencijaPrijave(rs.getLong("idPrijava"), rs.getDate("datumEvid"), vratiTakmicenjePrijave(rs.getLong("idTakmicenja")), 
//                        vratiKlubPrijave(rs.getLong("idPlivackiKlub"))));
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return prijave;
//    }

//    public List<StavkaEvidencijePrijave> vratiStavke(EvidencijaPrijave ep) {
//        List<StavkaEvidencijePrijave> stavke = new LinkedList<>();
//        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM stavkaevidencijeprijave WHERE idPrijava=?");
//            ps.setLong(1, ep.getIdPrijave());
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                stavke.add(new StavkaEvidencijePrijave(ep, rs.getLong("rb"),
//                        Disciplina.valueOf(rs.getString("disciplina")), 
//                        vratiTakmicaraStavke(rs.getLong("idTakmicar"),ep.getKlub())));
//            }
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return stavke;
//    }

//    private Takmicar vratiTakmicaraStavke(long idTakm, PlivackiKlub pk) {
//        List<Takmicar> taks = vratiTakmPK(pk);
//        for (Takmicar tak : taks) {
//            if(tak.getIdTakmicar().equals(idTakm)) return tak;
//        }
//        throw new RuntimeException("Ne postoji takmicar");
//    }

//    public void dodajPrijavu(EvidencijaPrijave ep) {
//        try {
//            PreparedStatement ps = conn.prepareStatement("INSERT INTO evidencijaprijave VALUES(0,?,?,?,?)");
//            ps.setInt(1, ep.getBrNastupa());
//            ps.setDate(2, new java.sql.Date(ep.getDatumEvid().getTime()));
//            ps.setLong(3, ep.getKlub().getIdKluba());
//            ps.setLong(4, ep.getTak().getIdTakmicenja());
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//    }

