/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Organizator;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOPrijavljivanje extends OpstaSO{
    private List<Organizator> orgs;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Organizator)) throw new Exception("Objekat nije instanca klase Organizator!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        orgs=(List<Organizator>)(List<?>)lst;
    }

    public List<Organizator> getOrgs() {
        return orgs;
    }
}
