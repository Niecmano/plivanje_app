/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.EvidencijaPrijave;

/**
 *
 * @author Nemanja
 */
public class SODodajEvidencijuPrijave extends OpstaSO{

    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof EvidencijaPrijave)) throw new Exception("Objekat nije instanca klase EvidencijaPrijave!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        DBBroker.getInstance().insert(odo);
    }
    
}
