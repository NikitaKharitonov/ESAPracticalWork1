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

    public Group read(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return group;
    }

    public List<Group> readAll(){
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
//        group.setCourses(newGroupData.getCourses());
//        group.setStudents(newGroupData.getStudents());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Group group = entityManager.find(Group.class, id);
        entityManager.remove(group);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

//    public void addCourse(Long groupId, Long courseId) {
//        EntityManager entityManager = Util.getEntityManagerFactory().createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Group group = entityManager.find(Group.class, groupId);
//        group.getCourses().add(entityManager.find(Course.class, courseId));
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//
//    }
}
