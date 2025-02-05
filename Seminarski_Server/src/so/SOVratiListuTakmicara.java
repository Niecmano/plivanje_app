/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.Takmicar;
import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuTakmicara extends OpstaSO{
    private LinkedList<Takmicar> taks;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Takmicar)) throw new Exception("Objekat nije instanca klase EvidencijaPrijave!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        taks=(LinkedList<Takmicar>)(LinkedList<?>)lst;
    }
    
    public LinkedList<Takmicar> getTaks(){
        return taks;
    }
}
