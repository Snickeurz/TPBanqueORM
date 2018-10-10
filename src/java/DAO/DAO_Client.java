/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Client;
import Models.Account;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;

/**
 *
 * @author Nicolas
 */
public class DAO_Client extends IDAO<Client> {

    
    
    public static final DAO_Client instanceDAO = new DAO_Client();
    
    public static DAO_Client getInstance(){
        return  instanceDAO;
    }
    
    @Override
    public List<Client> getAll() {
        Query q = em.createQuery("select e from Client e");
        return q.getResultList();
    }
    
    @Override
    public Client getByID(int id) {
        Client b =  em.find(Client.class,id); 
        return b;
    }
    
    public boolean remove(Client TupleToBeRemoved) {
        
        if(super.remove(TupleToBeRemoved)){
            TupleToBeRemoved.notifyAccounts();
            return true;
        }
        return false;
        
    }

}
