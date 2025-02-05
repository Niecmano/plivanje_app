/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.Takmicenje;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuTakmicenja extends OpstaSO{
    
    private List<Takmicenje> taks;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof Takmicenje)) throw new Exception("Objekat nije instanca klase Takmicenje!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        taks=(List<Takmicenje>)(List<?>)lst;
    }
    
    public List<Takmicenje> getTaks(){
        return taks;
    }
}
