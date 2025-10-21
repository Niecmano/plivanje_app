/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import domen.*;
import komun.*;

/**
 *
 * @author Nemanja
 */
public class Kontroler {
    
    private static Kontroler kontroler;
    private Socket skt;
    private Primalac rcv;
    private Posiljalac sndr;
    
    private Kontroler(){
        try {
            skt = new Socket("localhost", 4050);
            rcv = new Primalac(skt);
            sndr = new Posiljalac(skt);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    public static Kontroler getInstance(){
        if(kontroler==null) kontroler = new Kontroler();
        return kontroler;
    }

    public List<PlivackiKlub> vratiKlubove() {
        Zahtev req = new Zahtev(Operacija.VRATI_KLUBOVE, null);
        sndr.salji(req);
        Odgovor o = (Odgovor) rcv.primi();
        return (List<PlivackiKlub>) o.getOdg();
    }

    public void izbrisiKlubIzBaze(Long id) {
        Zahtev req = new Zahtev(Operacija.IZBRISI_KLUBOVE, id);
        sndr.salji(req);
        rcv.primi();
    }

    public List<Mesto> vratiMesta() {
        Zahtev req = new Zahtev(Operacija.VRATI_MESTA, null);
        sndr.salji(req);
        Odgovor o = (Odgovor) rcv.primi();
        return (List<Mesto>) o.getOdg();
    }

    public void dodajPK(PlivackiKlub p) {
        Zahtev req = new Zahtev(Operacija.DODAJ_KLUBOVE, p);
        sndr.salji(req);
        rcv.primi();
    }

    public void izmeniKlub(PlivackiKlub p) {
        Zahtev req = new Zahtev(Operacija.IZMENI_KLUBOVE, p);
        sndr.salji(req);
        rcv.primi();
    }

    public List<PlivackiKlub> filtrirajKlubove(String naziv, Mesto mesto) {
        Object[] pom = {naziv,mesto};
        Zahtev req = new Zahtev(Operacija.FILTER_KLUBOVE, pom);
        sndr.salji(req);
        Odgovor odg = (Odgovor) rcv.primi();
        return (List<PlivackiKlub>) odg.getOdg();
    }

    public List<Takmicar> vratiTakmicareKluba(PlivackiKlub pk) {
        Zahtev req = new Zahtev(Operacija.VRATI_TAKMICARE, pk);
        sndr.salji(req);
        Odgovor odg = (Odgovor) rcv.primi();
        return (List<Takmicar>) odg.getOdg();
    }

    public void izbrisiTakmicara(Long id) {
        Zahtev req = new Zahtev(Operacija.IZBRISI_TAKMICARA, id);
        sndr.salji(req);
        rcv.primi();
    }

    public void dodajTakm(Takmicar t) {
        Zahtev req = new Zahtev(Operacija.DODAJ_TAKMICARA, t);
        sndr.salji(req);
        rcv.primi();
    }

    public void izmeniTakm(Takmicar t) {
        Zahtev req = new Zahtev(Operacija.IZMENI_TAKMICARA, t);
        sndr.salji(req);
        rcv.primi();
    }

    public List<Organizator> login(Organizator organizator) {
        Zahtev req = new Zahtev(Operacija.PRIJAVA, organizator);
        sndr.salji(req);
        Odgovor odg = (Odgovor) rcv.primi();
        return (List<Organizator>) odg.getOdg();
    }

    public List<Takmicenje> vratiTakmicenja() {
        Zahtev req = new Zahtev(Operacija.VRATI_TAKMICENJA, null);
        sndr.salji(req);
        Odgovor odg = (Odgovor) rcv.primi();
        return (List<Takmicenje>) odg.getOdg();
    }

    public void izbrisiTakmicenje(Takmicenje t) {
        Zahtev req = new Zahtev(Operacija.IZBRISI_TAKMICENJE, t);
        sndr.salji(req);
        rcv.primi();
    }

    public void dodajTakmicenje(Takmicenje t) {
        Zahtev req = new Zahtev(Operacija.DODAJ_TAKMICENJE, t);
        sndr.salji(req);
        rcv.primi();
    }

    public void izmeniTakmicenje(Takmicenje t) {
        Zahtev req = new Zahtev(Operacija.IZMENI_TAKMICENJE, t);
        sndr.salji(req);
        rcv.primi();
    }

    public List<EvidencijaPrijave> vratiPrijave() {
        Zahtev req = new Zahtev(Operacija.VRATI_PRIJAVE, null);
        sndr.salji(req);
        Odgovor o = (Odgovor) rcv.primi();
        return (List<EvidencijaPrijave>) o.getOdg();
    }

    public void izbrisiPrijavu(Long idPrijave) {
        Zahtev req = new Zahtev(Operacija.IZBRISI_PRIJAVU, idPrijave);
        sndr.salji(req);
        rcv.primi();
    }

    public List<EvidencijaPrijave> filtrirajPrijave(Object klub, Object takm) {
        Object[] pom = {klub,takm};
        Zahtev req = new Zahtev(Operacija.FILTER_PRIJAVE, pom);
        sndr.salji(req);
        Odgovor odg = (Odgovor) rcv.primi();
        return (List<EvidencijaPrijave>) odg.getOdg();
    }

    public void dodajPrijavu(EvidencijaPrijave ep,List<StavkaEvidencijePrijave> sep) {
        Object[] ags = {ep,sep};
        Zahtev req = new Zahtev(Operacija.DODAJ_PRIJAVU, ags);
        sndr.salji(req);
        rcv.primi();
    }

    public void azurirajPrijavu(EvidencijaPrijave ep, List<StavkaEvidencijePrijave> dodate, List<StavkaEvidencijePrijave> obrisane) {
        Object[] ags = {ep,dodate,obrisane};
        Zahtev req = new Zahtev(Operacija.IZMENI_PRIJAVU, ags);
        sndr.salji(req);
        rcv.primi();
    }
    
    public List<StavkaEvidencijePrijave> vratiStavkePrijave(EvidencijaPrijave ep) {
        Zahtev req = new Zahtev(Operacija.VRATI_STAVKE, ep);
        sndr.salji(req);
        Odgovor o = (Odgovor) rcv.primi();
        return (List<StavkaEvidencijePrijave>) o.getOdg();
    }

    public List<SportskiCentar> vratiCentre() {
        Zahtev req = new Zahtev(Operacija.VRATI_CENTRE, null);
        sndr.salji(req);
        Odgovor o = (Odgovor) rcv.primi();
        return (List<SportskiCentar>) o.getOdg();
    }

    public void izbrisiCentar(SportskiCentar sc) {
        Zahtev req = new Zahtev(Operacija.IZBRISI_CENTAR, sc);
        sndr.salji(req);
        rcv.primi();
    }

    public List<LokacijeTakmicenja> vratiLokTakm() {
        Zahtev req = new Zahtev(Operacija.VRATI_LOKTAKM, null);
        sndr.salji(req);
        Odgovor o = (Odgovor) rcv.primi();
        return (List<LokacijeTakmicenja>) o.getOdg();
    }

    public void dodajLokTakm(LokacijeTakmicenja lt) {
        Zahtev req = new Zahtev(Operacija.DODAJ_LOKTAKM, lt);
        sndr.salji(req);
        rcv.primi();
    }

    public void dodajSC(SportskiCentar sc) {
        Zahtev req = new Zahtev(Operacija.DODAJ_SC, sc);
        sndr.salji(req);
        rcv.primi();
    }

    public void izmeniSC(SportskiCentar sc) {
        Zahtev req = new Zahtev(Operacija.IZMENI_SC, sc);
        sndr.salji(req);
        rcv.primi();
    }
}
