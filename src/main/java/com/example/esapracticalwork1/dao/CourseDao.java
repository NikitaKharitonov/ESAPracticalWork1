package com.example.esapracticalwork1.dao;

import com.example.esapracticalwork1.model.Course;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CourseDao {

    public void create(Course course) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(course);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Course get(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();
        return course;
    }

    public List<Course> getAll() {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Course> courses = entityManager.createQuery("select c from Course c", Course.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();
        return courses;
    }

    public void update(Long id, Course newCourseData) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, id);
        course.setName(newCourseData.getName());
        course.setHours(newCourseData.getHours());
        course.setGroup(newCourseData.getGroup());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(Long id) {
        EntityManager entityManager = DaoUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
