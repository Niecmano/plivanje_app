/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.OpstiDomenskiObjekat;
import domen.PlivackiKlub;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuPK extends OpstaSO{
    private List<PlivackiKlub> klubovi;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof PlivackiKlub)) throw new Exception("Objekat nije instanca klase PlivackiKlub!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        klubovi=(List<PlivackiKlub>)(List<?>)lst;
    }
    
    public List<PlivackiKlub> getKlubovi(){
        return klubovi;
    }
}
