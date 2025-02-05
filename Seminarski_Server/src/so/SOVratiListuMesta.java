/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Mesto;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuMesta extends OpstaSO{
    private LinkedList<Mesto> mesta;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Mesto)) throw new Exception("Objekat nije instanca klase Mesto!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        mesta=(LinkedList<Mesto>)(LinkedList<?>)lst;
    }
    
    public LinkedList<Mesto> getMesta(){
        return mesta;
    }
}
