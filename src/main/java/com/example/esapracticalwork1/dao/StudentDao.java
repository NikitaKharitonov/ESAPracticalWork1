package com.example.esapracticalwork1.dao;

import com.example.esapracticalwork1.model.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentDao {

    public void create(Student student) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(student);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Student get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
    }

    public List<Student> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Student> students = entityManager.createQuery("select s from Student s", Student.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return students;
    }

    public void update(Long id, Student newStudentData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);
        student.setFirstName(newStudentData.getFirstName());
        student.setLastName(newStudentData.getLastName());
        student.setDateOfBirth(newStudentData.getDateOfBirth());
        student.setGroup(newStudentData.getGroup());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
