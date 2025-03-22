/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.LokacijeTakmicenja;
import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuLokTakm extends OpstaSO{
    private List<LokacijeTakmicenja> lts;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof LokacijeTakmicenja)) throw new Exception("Objekat nije instanca klase LokacijeTakmicenja!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        lts=(List<LokacijeTakmicenja>)(List<?>)lst;
    }

    public List<LokacijeTakmicenja> getLts() {
        return lts;
    }
}
