/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Nicolas
 */
public abstract class IDAO<T> {

    final EntityManagerFactory emf = Persistence.createEntityManagerFactory("banqueTP_ORMPU");
    final EntityManager em = emf.createEntityManager();
    public boolean insert(T newTuple) {
        em.getTransaction().begin();
        try {
            em.persist(newTuple);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        em.getTransaction().commit();
        return true;

    }

    public abstract List<T> getAll();

    public abstract T getByID(int id);

    public boolean update(T TupleToUpdate) {
        em.getTransaction().begin();
        try {
            em.merge(TupleToUpdate);

        } catch (Exception e) {
            return false;
        }
        em.getTransaction().commit();
        return true;
    }

    public boolean remove(T TupleToBeRemoved) {
        em.getTransaction().begin();
        try {
            em.remove(TupleToBeRemoved);

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        em.getTransaction().commit();
        return true;
    }

}
