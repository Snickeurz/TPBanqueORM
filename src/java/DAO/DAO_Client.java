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
 * DAO_Client implemente le Design Pattern Singleton
 * @author Nicolas SIBAUD
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
    
    /**
     * Cette méthode appelle la méthode {@link IDAO#remove} pour supprimer le tuple<br>
     * Elle notifie après tous les comptes reliés à ce client que ce client n'existe plus, pour que ces comptes<br>
     * le supprime de leurs cotés. (Design Pattern OBSERVER)
     * @param TupleToBeRemoved L'ibjet Client a supprimer
     * @return true si success, false sinon
     */
    public boolean remove(Client TupleToBeRemoved) {
        if(super.remove(TupleToBeRemoved)){
            TupleToBeRemoved.notifyAccounts();
            return true;
        }
        return false;
    }

}
