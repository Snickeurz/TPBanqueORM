/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.*;

/**
 * Define a Generic DAO contract. 
 * 
 * @author Nicolas SIBAUD
 * @param <T> an Entity
 */
public abstract class IDAO<T> 
{
    // get EntityManager
    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("banqueTP_ORMPU");
    final EntityManager em = emf.createEntityManager();
    
    /**
     * Insert a Generic new tuple into database.
     * 
     * @param newTuple an instance of Entity
     * @return true if persistence is okay, else return false.
     */
    public boolean insert(T newTuple) {
        //Begin transaction
        em.getTransaction().begin();
        try 
        {
            // Perist object
            em.persist(newTuple);
        } catch (Exception e)
        {
            return false;
        }
        // valid transaction
        em.getTransaction().commit();
        return true;
    }

    /**
     * 
     * @return a list of entities 
     */
    public abstract List<T> getAll();

    /**
     * 
     * @param id an identifier
     * @return an Entity
     */
    public abstract T getByID(int id);

    /**
     * Update an Entity.
     * 
     * @param TupleToUpdate the entity to update
     * @return true if update is well executed, else return false
     */
    public boolean update(T TupleToUpdate)
    {
        // Start transaction
        em.getTransaction().begin();
        try
        {
            // merge the entity
            em.merge(TupleToUpdate);
        } catch (Exception e) 
        {
            return false;
        }
        // Valid transaction
        em.getTransaction().commit();
        return true;
    }

    /**
     * Remove an Entity.
     * 
     * @param TupleToBeRemoved a reference to the object to remove
     * @return true if remove is well executed, else return false
     */
    public boolean remove(T TupleToBeRemoved)
    {
        // Start transaction
        em.getTransaction().begin();
        try 
        {
            // Remove the entity from database
            em.remove(TupleToBeRemoved);
        } catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
        // Valid transaction
        em.getTransaction().commit();
        return true;
    }

}
