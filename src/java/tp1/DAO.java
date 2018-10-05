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

import javax.persistence.*;

public class DAO {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("banqueTP_ORMPU");
    private EntityManager em = emf.createEntityManager();
    /*
    @PersistenceContext(unitName = "TP_BankManagerPU")
    private EntityManager em;
    */
    public void test()
	{
            em.getTransaction().begin();
            System.out.println("Démarrage de la persistance");
            
            BankBranch agence1 = new BankBranch();
            agence1.setAdresse("Montparnasse");
            agence1.setCodeAgence(88888);
            
            BankBranch agence2 = new BankBranch();
            agence2.setAdresse("Tunis Ville");
            agence2.setCodeAgence(99999);
            
            
            
            em.persist(agence1);
            em.persist(agence2);
            em.flush();
            
            System.out.println("Persistance OK");
            
             em.getTransaction().commit();
            
        }
    
}
