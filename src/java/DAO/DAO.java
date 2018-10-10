package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Nicolas 
 */
import Models.BankBranch;
import Models.Client;
import Models.Account;
import java.util.*;
import javax.persistence.*;

public class DAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banqueTP_ORMPU");
    private EntityManager em = emf.createEntityManager();

    /*
    @PersistenceContext(unitName = "banqueTP_ORMPU")
    private EntityManager em;
     */
    public void test() {
        DAO_BankBranch dbank = DAO_BankBranch.getInstance();
        DAO_Account daccount = DAO_Account.getInstance();
        DAO_Client dclient = DAO_Client.getInstance();

        System.out.println("Démarrage de la persistance");

        /**
         * *********BankBranches**********
         */
        BankBranch agence1 = new BankBranch();
        agence1.setAdresse("Montparnasse");

        BankBranch agence2 = new BankBranch();
        agence2.setAdresse("Tunis Ville");

        dbank.insert(agence1);
        dbank.insert(agence2);

        /**
         * *******************************
         */
        /**
         * *********Clients**********
         */
        Client client1 = new Client();
        client1.setNomClient("Nom1");
        client1.setPrenomClient("Prenom1");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);

        client1.setDateNaiss(cal.getTime());

        Client client2 = new Client();
        client2.setNomClient("Nom2");
        client2.setPrenomClient("Prenom2");
        cal.set(Calendar.YEAR, 2006);
        cal.set(Calendar.MONTH, Calendar.FEBRUARY);
        cal.set(Calendar.DAY_OF_MONTH, 27);

        client2.setDateNaiss(cal.getTime());

        dclient.insert(client1);
        dclient.insert(client2);

        /**
         * *******************************
         */
        Account a1 = new Account();
        a1.setNum_compte("nwghpzawvwe");
        a1.setClients(client1);
        a1.setClients(client2);
        a1.setAgence(agence1);
        a1.setIBAN("jdwqdisnrabmdzqqtseewfvzuqy");
        a1.setLibelle("sdfsdfdsf");
        a1.setSolde(1122);

        client1.setAccounts(a1);
        client2.setAccounts(a1);

        daccount.insert(a1);
        

        //dclient.remove(client1);
        //dclient.remove(client2);
        
        //System.out.println(a1.getClients().isEmpty());
        
        //daccount.remove(a1);
        /**
         * *************Clients***************
         */
        /**
         * ***********************************
         */
        //d.remove(agence1);
        //em.persist(agence1);
        //em.persist(agence2);
        System.out.println("Persistance OK");

        //em.getTransaction().commit();
        //Query q = em.createQuery("select e from BankBranch e");
        //Query q = em.createQuery("from BANKBRANCH e", BankBranch.class);
        /*
            agence1.setAdresse("xoxo");
            d.update(agence1);
            
            for(int i=0; i<d.getAll().size(); i++){
                System.out.println(d.getAll().get(i));
            }  */
    }

}
