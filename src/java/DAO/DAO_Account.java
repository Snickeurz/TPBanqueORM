/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Account;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Nicolas
 */
public class DAO_Account extends IDAO<Account>{

    public static final DAO_Account instanceDAO = new DAO_Account();
    
    public static DAO_Account getInstance(){
        return  instanceDAO;
    }
    
    @Override
    public List<Account> getAll() {
        Query q = em.createQuery("select e from Account e");
        return q.getResultList();
    }

    @Override
    public Account getByID(int id) {
        Account b =  em.find(Account.class,id); 
        return b;
    }
    
    
}
