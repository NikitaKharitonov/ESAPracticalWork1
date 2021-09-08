package com.example.esapracticalwork1.dao;

import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import com.example.esapracticalwork1.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class DaoUtil {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("postgres-university");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    static {
        Group group = new Group(1);
        Group group1 = new Group(2);
        Group group2 = new Group(3);

        List<Student> students = List.of(
                new Student("Ivan", "Ivanov", LocalDate.of(1990, 10, 1), group2),
                new Student("Petr", "Petrov", LocalDate.of(1991, 1, 3), group2),
                new Student("Zakhar", "Zakharov", LocalDate.of(1992, 2, 5), group2),
                new Student("Anna", "Annova", LocalDate.of(1993, 3, 7), group1),
                new Student("Roman", "Romanov", LocalDate.of(1994, 4, 11), group1),
                new Student("Vika", "Vikova", LocalDate.of(1995, 5, 13), group1),
                new Student("Olga", "Olgova", LocalDate.of(1996, 6, 17), group1),
                new Student("Nina", "Ninova", LocalDate.of(1997, 7, 19), group),
                new Student("Ivan", "Petrov", LocalDate.of(1998, 8, 23), group),
                new Student("Petr", "Ivanov", LocalDate.of(1999, 9, 30), group)
        );

        List<Course> courses = List.of(
                new Course("Math", 36, group2),
                new Course("Physics", 36, group2),
                new Course("Chemistry", 36, group1),
                new Course("Geography", 18, group1),
                new Course("Biology", 36, group1),
                new Course("Technology", 36, group1),
                new Course("History", 18, group),
                new Course("Sport", 36, group),
                new Course("Literature", 18, group),
                new Course("English", 18, group)
        );

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(group);
        entityManager.persist(group1);
        entityManager.persist(group2);
        students.forEach(entityManager::persist);
        courses.forEach(entityManager::persist);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
