/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.SportskiCentar;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuSC extends OpstaSO{
    private List<SportskiCentar> cs;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof SportskiCentar)) throw new Exception("Objekat nije instanca klase SportskiCentar!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        cs=(List<SportskiCentar>)(List<?>)lst;
    }

    public List<SportskiCentar> getCs() {
        return cs;
    }
}
