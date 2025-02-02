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
        dbb = new DBBroker();
        try {
            ServerSocket srvskt = new ServerSocket(4050);
            skt = srvskt.accept();
            Primalac rcv = new Primalac(skt);
            Posiljalac sndr = new Posiljalac(skt);
            while (true) {
                Zahtev req = (Zahtev) rcv.primi();
                Odgovor o;
                switch (req.getOp()) {
                    case PRIJAVA:
                        try {
                            List<Organizator> odg = dbb.prijava((Organizator) req.getArgum());
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case VRATI_TAKMICENJA:
                        try {
//                            List<Takmicenje> odg = dbb.vratiTakmicenja();
                            List<OpstiDomenskiObjekat> odg = dbb.select(new Takmicenje(),false);
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case IZBRISI_TAKMICENJE:
                        try {
//                            dbb.brisiTakmicenje((Takmicenje) req.getArgum());
                            dbb.delete((Takmicenje) req.getArgum());
                            o = new Odgovor(null, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case DODAJ_TAKMICENJE:
                        try {
                            dbb.insert((Takmicenje) req.getArgum());
//                            dbb.dodajTakmicenjeUBazu((Takmicenje) req.getArgum());

                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        o = new Odgovor(null, null);
                        break;
                    case IZMENI_TAKMICENJE:
                        try {
//                            dbb.izmeniTakmicenjeUBazi(t);
                            Takmicenje t = (Takmicenje) req.getArgum();
                            dbb.update(new Takmicenje(t.getIdTakmicenja(),t.getNazivTakm()));
                            o = new Odgovor(null, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case VRATI_MESTA:
                        try {
//                            List<Mesto> odg = dbb.vratiMestaIzBaze();
                            List<OpstiDomenskiObjekat> odg = dbb.select(new Mesto(),false);
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case VRATI_KLUBOVE:
                        try {
//                            List<PlivackiKlub> odg = dbb.vratiKluboveIzBaze();
                            List<OpstiDomenskiObjekat> odg = dbb.select(new PlivackiKlub(),false);
                            o = new Odgovor(odg, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case IZBRISI_KLUBOVE:
                        dbb.delete(new PlivackiKlub((Long) req.getArgum()));
//                        dbb.izbrisiKlubIzBaze((Long) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case DODAJ_KLUBOVE:
                        dbb.insert((PlivackiKlub) req.getArgum());
//                        dbb.dodajPKuBazu((PlivackiKlub) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case IZMENI_KLUBOVE:
                        PlivackiKlub pk = (PlivackiKlub) req.getArgum();
                        dbb.update(pk);
//                        dbb.izmeniKlubUBazi((PlivackiKlub) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case FILTER_KLUBOVE:
                        Object[] filts = (Object[]) req.getArgum();
                        o = new Odgovor(dbb.select(new PlivackiKlub((String)filts[0], (Mesto) filts[1]), true), null);
//                        o = new Odgovor(dbb.filtriranjeKlubova((String)filts[0], (Mesto) filts[1]), null);
                        break;
                    case VRATI_TAKMICARE:
                        try {
                            List<OpstiDomenskiObjekat> taks = dbb.select
                                (new Takmicar((PlivackiKlub) req.getArgum()),false);
//                            List<Takmicar> taks = dbb.vratiTakmPK((PlivackiKlub) req.getArgum());
                            o = new Odgovor(taks, null);
                        } catch (Exception e) {
                            o = new Odgovor(null, e);
                        }
                        break;
                    case DODAJ_TAKMICARA:
                        dbb.insert((Takmicar) req.getArgum());
//                        dbb.dodajTakmicara((Takmicar) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case IZMENI_TAKMICARA:
                        dbb.update((Takmicar) req.getArgum());
//                        dbb.izmeniTakm((Takmicar) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case IZBRISI_TAKMICARA:
                        dbb.delete(new Takmicar((Long) req.getArgum()));
//                        dbb.izbrisiTakmUBazi((Long) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case VRATI_PRIJAVE:
//                        o = new Odgovor(dbb.vratiPrijaveIzBaze(), null);
                        o = new Odgovor(dbb.select(new EvidencijaPrijave(),false), null);
                        break;
                    case IZBRISI_PRIJAVU:
                        dbb.delete(new EvidencijaPrijave((Long)req.getArgum()));
//                        dbb.izbrisiPrijavuIzBaze((Long)req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case IZMENI_PRIJAVU:
                        dbb.update((EvidencijaPrijave) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case FILTER_PRIJAVE:
                        filts = (Object[]) req.getArgum();
                        o = new Odgovor(dbb.select(new EvidencijaPrijave((PlivackiKlub)filts[0], (Takmicenje) filts[1]),true), null);
//                        o = new Odgovor(dbb.filtriranjePrijava((PlivackiKlub)filts[0], (Takmicenje) filts[1]), null);
                        break;
                    case DODAJ_PRIJAVU:
                        dbb.insert((EvidencijaPrijave) req.getArgum());
//                        dbb.dodajPrijavu((EvidencijaPrijave) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case VRATI_STAVKE:
                        StavkaEvidencijePrijave sep = new StavkaEvidencijePrijave((EvidencijaPrijave)req.getArgum());
                        o=new Odgovor(dbb.select(sep,false), null);
//                        o = new Odgovor(dbb.vratiStavke((EvidencijaPrijave)req.getArgum()), null);
                        break;
                    case IZBRISI_STAVKU:
                        dbb.delete((StavkaEvidencijePrijave)req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case DODAJ_STAVKU:
                        dbb.insert((StavkaEvidencijePrijave) req.getArgum());
                        o = new Odgovor(null, null);
                        break;
                    case IZMENI_STAVKU:
                        dbb.update((StavkaEvidencijePrijave) req.getArgum());
                        o = new Odgovor(null, null);
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
