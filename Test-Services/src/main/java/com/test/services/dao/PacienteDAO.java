package com.test.services.dao;

import com.test.lib.Paciente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class PacienteDAO {

    @PersistenceContext(unitName = "TestPU")
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(Paciente paciente) {
        getEntityManager().persist(getEntityManager().merge(paciente));
    }

    public void update(Paciente paciente) {
        getEntityManager().merge(paciente);
    }

    public void delete(Object id) {
        Paciente entity = getEntityManager().find(Paciente.class, id);
        getEntityManager().remove(entity);
    }

    public Paciente find(Object id) {
        return getEntityManager().find(Paciente.class, id);
    }

    public List<Paciente> loadAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery q = cb.createQuery(Paciente.class);
        Root<Paciente> c = q.from(Paciente.class);
        q.select(c);
        q.orderBy(cb.asc(c.get("id")));
        return getEntityManager().createQuery(q).getResultList();
    }

}
