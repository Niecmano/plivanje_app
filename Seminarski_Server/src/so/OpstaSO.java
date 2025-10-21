/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import baza.DBBroker;
import java.sql.SQLException;
import domen.OpstiDomenskiObjekat;

/**
 *
 * @author Nemanja
 */
public abstract class OpstaSO {
    public abstract void proveraIspravnosti(OpstiDomenskiObjekat odo) throws Exception;
    public abstract void izvrsavanje(OpstiDomenskiObjekat odo, Object o) throws Exception;
    
    public void sablonIzvrsavanja(OpstiDomenskiObjekat ado, Object o) throws Exception{
        try{
            proveraIspravnosti(ado);
            izvrsavanje(ado, o);
            commit();
        }catch(Exception e){
            System.out.println(e);
            rollback();
            throw e;
        }
    }
    
    public void commit() throws SQLException{
        DBBroker.getConn().commit();
    }
    
    public void rollback() throws SQLException{
        DBBroker.getConn().rollback();
    }
}
