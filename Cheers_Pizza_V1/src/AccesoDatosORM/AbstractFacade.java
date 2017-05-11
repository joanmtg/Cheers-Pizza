/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatosORM;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jhonier Andrés
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;
    
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();

    
    public void create(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    public void edit(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }

    public void remove(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    public T find(Object id) {
        T search = getEntityManager().find(entityClass, id);
        return search;
        
    }

    public List<T> findAll() {
        getEntityManager().clear();
        javax.persistence.criteria.CriteriaQuery criteriaQ = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQ.select(criteriaQ.from(entityClass));
        List<T> list = getEntityManager().createQuery(criteriaQ).getResultList();
        return list;
    }

    public List<T> findRange(int[] range) {
        getEntityManager().getTransaction().begin();
        javax.persistence.criteria.CriteriaQuery criteriaQ = getEntityManager().getCriteriaBuilder().createQuery();
        criteriaQ.select(criteriaQ.from(entityClass));
        javax.persistence.Query query = getEntityManager().createQuery(criteriaQ);
        query.setMaxResults(range[1] - range[0]);
        query.setFirstResult(range[0]);
        List<T> list = query.getResultList();
        getEntityManager().getTransaction().commit();
        return list;
    }

    public int count() {
        getEntityManager().getTransaction().begin();
        javax.persistence.criteria.CriteriaQuery criteriaQ = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> root = criteriaQ.from(entityClass);
        criteriaQ.select(getEntityManager().getCriteriaBuilder().count(root));
        javax.persistence.Query query = getEntityManager().createQuery(criteriaQ);
        int count = ((Long) query.getSingleResult()).intValue();
        getEntityManager().getTransaction().commit();
        return count;
    }
    
}
