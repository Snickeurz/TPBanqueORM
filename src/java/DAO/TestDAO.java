package DAO;

import Models.BankBranch;
import Models.Client;
import Models.Account;
import java.util.*;
import javax.persistence.*;

/**
 *  
 * @author Nicolas SIBAUD
 */
public class TestDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banqueTP_ORMPU");
    private EntityManager em = emf.createEntityManager();

    public void test() {
        //Instantiation des differents DAO
        DAO_BankBranch dbank = DAO_BankBranch.getInstance();
        DAO_Account daccount = DAO_Account.getInstance();
        DAO_Client dclient = DAO_Client.getInstance();

        System.out.println("Démarrage de la persistance");

        /**
         * *********BankBranches**********
         */
        BankBranch agence1 = new BankBranch();
        agence1.setAdresse("Pantin");
        agence1.setCodeAgence(12345);
        BankBranch agence2 = new BankBranch();
        agence2.setAdresse("Tunis");
        agence2.setCodeAgence(11111);
        
        BankBranch agence3 = new BankBranch();
        agence3.setAdresse("Limay");
        agence3.setCodeAgence(55555);
        
        dbank.insert(agence1);
        dbank.insert(agence2);
        dbank.insert(agence3);

        /**
         * *******************************
         */
        /**
         * *********Clients**********
         */
        Client client1 = new Client();
        client1.setNomClient("LUTUMBA");
        client1.setPrenomClient("Jonathan");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1996);
        cal.set(Calendar.MONTH, Calendar.NOVEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 5);

        client1.setDateNaiss(cal.getTime());

        Client client2 = new Client();
        client2.setNomClient("SIBAUD");
        client2.setPrenomClient("Nicolas");
        cal.set(Calendar.YEAR, 1993);
        cal.set(Calendar.MONTH, Calendar.DECEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 29);
        client2.setDateNaiss(cal.getTime());
        
        Client client3 = new Client();
        client3.setNomClient("BOUKIRAT");
        client3.setPrenomClient("Houssem");
        cal.set(Calendar.YEAR, 1996);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 27);

        client3.setDateNaiss(cal.getTime());

        dclient.insert(client1);
        dclient.insert(client2);
        dclient.insert(client3);


        /**
         * **********Account***************/
         
        Account a1 = new Account();
        a1.setNum_compte("4GJh3F8JUB");
        a1.setClients(client1);
        a1.setClients(client2);
        a1.setAgence(agence1);
        a1.setIBAN("jdwqdisnrabmdzqqtseewfvzuqy");
        a1.setLibelle("Lib1");
        a1.setSolde(7600);

        client1.setAccounts(a1);
        client2.setAccounts(a1);

        daccount.insert(a1);
        
        Account a2 = new Account();
        a2.setNum_compte("5FJh3F8JUC");
        a2.setClients(client3);
        a2.setAgence(agence2);
        a2.setIBAN("jdwqdisnrabmdzqqtsee678zuqy");
        a2.setLibelle("Lib2");
        a2.setSolde(1678);

        client3.setAccounts(a2);

        daccount.insert(a2);
        
        dclient.remove(client3);
        
        /***********************************/


        //dclient.remove(client1);
        //dclient.remove(client2);
        
        //System.out.println(a1.getClients().isEmpty());
        
        //daccount.remove(a1);

        //d.remove(agence1);
        //em.persist(agence1);
        //em.persist(agence2);
        System.out.println("Persistance OK");


    }

}
