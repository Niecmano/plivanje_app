/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.EvidencijaPrijave;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuEvidencijaPrijave extends OpstaSO{
    private LinkedList<EvidencijaPrijave> prijave;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof EvidencijaPrijave)) throw new Exception("Objekat nije instanca klase EvidencijaPrijave!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        prijave=(LinkedList<EvidencijaPrijave>)(LinkedList<?>)lst;
    }
    
    public LinkedList<EvidencijaPrijave> getPrijave(){
        return prijave;
    }
}
