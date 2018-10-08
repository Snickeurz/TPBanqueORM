package tp1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author houssem
 */

import java.util.Date;
import javax.persistence.*;

public class DAO 
{
    //Create new persistence
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banqueTP_ORMPU");
    private EntityManager em = emf.createEntityManager();
    /**
     * Test persistence into DataBase
     */
    public void test()
	{
            em.getTransaction().begin();
            System.out.println("Démarrage de la persistance");
            
            //Given
            //BANK
            BankBranch agence1 = new BankBranch();
            agence1.setAdresse("Montparnasse");
            agence1.setCodeAgence(88888);
            
            BankBranch agence2 = new BankBranch();
            agence2.setAdresse("Creuse");
            agence2.setCodeAgence(99999);
            //CLIENT
            Client client1 = new Client();
            client1.setNumClient(12345678);
            client1.setNomClient("SIBAUD");
            client1.setPrenomClient("Nicolas");
            Date dateBirthDay = new Date(); // Default get system timezone
            client1.setDateNaiss(dateBirthDay);
            //ACCOUNT
            Account account1 = new Account();
            account1.setNum_compte("889988");
            account1.setIBAN("IBAN");
            account1.setLibelle("Nicolas's account");
            account1.setSolde(1230);
            account1.setAgence(agence1);
            
            //client1.setAccounts(account1);
            
            //When            
            em.persist(agence1);
            em.persist(agence2);
            em.persist(client1);
            em.persist(account1);
            em.flush();
            
            System.out.println("Persistance OK");
            
            //Then
            //Valid transaction
             em.getTransaction().commit();            
        }
    
}
