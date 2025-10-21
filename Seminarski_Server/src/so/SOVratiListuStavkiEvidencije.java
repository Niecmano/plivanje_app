/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import domen.StavkaEvidencijePrijave;
import domen.OpstiDomenskiObjekat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Nemanja
 */
public class SOVratiListuStavkiEvidencije extends OpstaSO{
    private LinkedList<StavkaEvidencijePrijave> stavke;
    
    @Override
    public void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception {
        if(!(odo instanceof StavkaEvidencijePrijave)) throw new Exception("Objekat nije instanca klase StavkaEvidencijePrijave!");
    }

    @Override
    public void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception {
        List<OpstiDomenskiObjekat> lst = DBBroker.getInstance().select(odo,(boolean) o);
        stavke=(LinkedList<StavkaEvidencijePrijave>)(LinkedList<?>)lst;
    }
    
    public LinkedList<StavkaEvidencijePrijave> getStavke(){
        return stavke;
    }
}