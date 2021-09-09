package com.example.esapracticalwork1.dao;

import com.example.esapracticalwork1.model.Group;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GroupDao {
    public void create(Group group) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(group);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Group get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return group;
    }

    public List<Group> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Group> groups = entityManager.createQuery("select g from Group g", Group.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return groups;
    }

    public void update(Long id, Group newGroupData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, id);
        if (group != null) {
            group.setYear(newGroupData.getYear());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, id);
        if (group != null) {
            entityManager.remove(group);
        }
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
