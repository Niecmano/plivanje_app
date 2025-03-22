/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srv;

import baza.DBBroker;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import komun.*;
import domen.*;
import java.util.List;
import so.*;

/**
 *
 * @author Nemanja
 */
public class Server {

    private static DBBroker dbb;
    private static Socket skt;

    public Server() {

    }

    public static void main(String[] args) {
        dbb = DBBroker.getInstance();
        try {
            ServerSocket srvskt = new ServerSocket(4050);
            skt = srvskt.accept();
            Primalac rcv = new Primalac(skt);
            Posiljalac sndr = new Posiljalac(skt);
            while (true) {
                Zahtev req = (Zahtev) rcv.primi();
                Odgovor o;
                switch (req.getOp()) {
                    case VRATI_TAKMICENJA:
                        try {
                            SOVratiListuTakmicenja so = new SOVratiListuTakmicenja();
                            so.sablonIzvrsavanja(new Takmicenje(),false);
                            List<Takmicenje> odg = so.getTaks();
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case IZBRISI_TAKMICENJE:
                        try {
                            SOIzbrisiTakmicenje so = new SOIzbrisiTakmicenje();
                            so.sablonIzvrsavanja((Takmicenje) req.getArgum(), null);
                            o = new Odgovor(null, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case DODAJ_TAKMICENJE:
                        try {
                            SODodajTakmicenje so = new SODodajTakmicenje();
                            so.sablonIzvrsavanja((Takmicenje) req.getArgum(), null);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        o = new Odgovor(null, null);
                        break;
                    case IZMENI_TAKMICENJE:
                        try {
                            SOPromeniTakmicenje so = new SOPromeniTakmicenje();
                            so.sablonIzvrsavanja((Takmicenje) req.getArgum(), null);
                            o = new Odgovor(null, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case VRATI_MESTA:
                        try {
                            SOVratiListuMesta so = new SOVratiListuMesta();
                            so.sablonIzvrsavanja(new Mesto(),false);
                            List<Mesto> odg = so.getMesta();
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case VRATI_KLUBOVE:
                        try {
                            SOVratiListuPK so = new SOVratiListuPK();
                            so.sablonIzvrsavanja(new PlivackiKlub(),false);
                            List<PlivackiKlub> odg = so.getKlubovi();
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case IZBRISI_KLUBOVE:
                        try {
                            SOIzbrisiPK so = new SOIzbrisiPK();
                            so.sablonIzvrsavanja(new PlivackiKlub((Long) req.getArgum()), null);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        o = new Odgovor(null, null);
                        break;
                    case DODAJ_KLUBOVE:
                        try {
                            SODodajPK so = new SODodajPK();
                            so.sablonIzvrsavanja((PlivackiKlub)req.getArgum(), null);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        o = new Odgovor(null, null);
                        break;

                    case IZMENI_KLUBOVE:
                        try {
                            SOPromeniPK so = new SOPromeniPK();
                            so.sablonIzvrsavanja((PlivackiKlub)req.getArgum(), null);
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                        o = new Odgovor(null, null);
                        break;
                    case FILTER_KLUBOVE:
                        try {
                            Object[] filts = (Object[]) req.getArgum();
                            SOVratiListuPK so = new SOVratiListuPK();
                            so.sablonIzvrsavanja(new PlivackiKlub((String)filts[0], (Mesto) filts[1]), true);
                            o = new Odgovor(so.getKlubovi(), null);
                        } catch (Exception ex) {
                            System.out.println(ex);
                            o = new Odgovor(null, ex);
                        }
                        break;

                    case VRATI_TAKMICARE:
                        try {
                            SOVratiListuTakmicara so = new SOVratiListuTakmicara();
                            so.izvrsavanje(new Takmicar((PlivackiKlub)req.getArgum()), false);
                            o = new Odgovor(so.getTaks(), null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case DODAJ_TAKMICARA:
                        try {
                            SODodajTakmicara so = new SODodajTakmicara();
                            so.sablonIzvrsavanja((Takmicar) req.getArgum(), null);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        o = new Odgovor(null, null);
                        break;  
                    case IZMENI_TAKMICARA:
                        try {
                            SOPromeniTakmicara so = new SOPromeniTakmicara();
                            so.sablonIzvrsavanja((Takmicar) req.getArgum(), null);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        o = new Odgovor(null, null);
                        break;  
                    case IZBRISI_TAKMICARA:
                        try {
                            SOIzbrisiTakmicara so = new SOIzbrisiTakmicara();
                            so.sablonIzvrsavanja(new Takmicar((Long) req.getArgum()), null);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        o = new Odgovor(null, null);
                        break;  
                    case VRATI_PRIJAVE:
                        try {
                            SOVratiListuEvidencijaPrijave so = new SOVratiListuEvidencijaPrijave();
                            so.sablonIzvrsavanja(new EvidencijaPrijave(),false);
                            o = new Odgovor(so.getPrijave(), null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case IZBRISI_PRIJAVU:
                        try {
                            SOIzbrisiEvidencijuPrijave so = new SOIzbrisiEvidencijuPrijave();
                            so.sablonIzvrsavanja(new EvidencijaPrijave((Long)req.getArgum()),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case IZMENI_PRIJAVU:
                        try {
                            SOPromeniEvidencijuPrijave so = new SOPromeniEvidencijuPrijave();
                            so.sablonIzvrsavanja((EvidencijaPrijave)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case FILTER_PRIJAVE:
                        try {
                            Object[] filts = (Object[]) req.getArgum();
                            SOVratiListuEvidencijaPrijave so = new SOVratiListuEvidencijaPrijave();
                            so.sablonIzvrsavanja(new EvidencijaPrijave((PlivackiKlub)filts[0], 
                                (Takmicenje) filts[1]),true);
                            o = new Odgovor(so.getPrijave(), null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case DODAJ_PRIJAVU:
                        try {
                            SODodajEvidencijuPrijave so = new SODodajEvidencijuPrijave();
                            so.sablonIzvrsavanja((EvidencijaPrijave)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case VRATI_STAVKE:
                        try {
                            SOVratiListuStavkuEvidencije so = new SOVratiListuStavkuEvidencije();
                            so.sablonIzvrsavanja(new StavkaEvidencijePrijave((EvidencijaPrijave) 
                                    req.getArgum()),false);
                            o = new Odgovor(so.getStavke(), null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case IZBRISI_STAVKU:
                        try {
                            SOIzbrisiStavkuEvidencije so = new SOIzbrisiStavkuEvidencije();
                            so.sablonIzvrsavanja((StavkaEvidencijePrijave)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case DODAJ_STAVKU:
                        try {
                            SODodajStavkuEvidencije so = new SODodajStavkuEvidencije();
                            so.sablonIzvrsavanja((StavkaEvidencijePrijave)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case IZMENI_STAVKU:
                        try {
                            SOPromeniStavkuEvidencije so = new SOPromeniStavkuEvidencije();
                            so.sablonIzvrsavanja((StavkaEvidencijePrijave)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case PRIJAVA:
                        try {
                            SOPrijavljivanje so = new SOPrijavljivanje();
                            so.sablonIzvrsavanja((Organizator) req.getArgum(),false);
                            o = new Odgovor(so.getOrgs(), null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case VRATI_CENTRE:
                        try {
                            SOVratiListuSC so = new SOVratiListuSC();
                            so.sablonIzvrsavanja(new SportskiCentar(),false);
                            o = new Odgovor(so.getCs(), null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case IZBRISI_CENTAR:
                        try {
                            SOIzbrisiSC so = new SOIzbrisiSC();
                            so.sablonIzvrsavanja((SportskiCentar)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case VRATI_LOKTAKM:
                        try {
                            SOVratiListuLokTakm so = new SOVratiListuLokTakm();
                            so.sablonIzvrsavanja(new LokacijeTakmicenja(),false);
                            o = new Odgovor(so.getLts(), null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case DODAJ_LOKTAKM:
                        try {
                            SODodajLokTakm so = new SODodajLokTakm();
                            so.sablonIzvrsavanja((LokacijeTakmicenja)req.getArgum(),null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e); 
                        }
                        break;
                    case DODAJ_SC:
                        try {
                            SODodajSC so = new SODodajSC();
                            so.sablonIzvrsavanja((SportskiCentar) req.getArgum(), null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case IZMENI_SC:
                        try {
                            SOPromeniSC so = new SOPromeniSC();
                            so.sablonIzvrsavanja((SportskiCentar) req.getArgum(), null);
                            o = new Odgovor(null, null);  
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    default:
                        throw new RuntimeException("Operacija ne postoji");
                }
                sndr.salji(o);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        catch(NullPointerException ex){
            System.out.println("Kraj rada");
        }
    }
}
