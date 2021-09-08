package com.example.esapracticalwork1.dao;

import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import com.example.esapracticalwork1.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.Month;

public class DaoUtil {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("postgres-university");

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    static {
        Group group = new Group();
        group.setYear(1);

        Student student = new Student();
        student.setFirstName("Ivan");
        student.setLastName("Ivanov");
        student.setDateOfBirth(LocalDate.of(1999, Month.SEPTEMBER, 15));
        student.setGroup(group);

        Student student1 = new Student();
        student1.setFirstName("Petr");
        student1.setLastName("Petrov");
        student1.setDateOfBirth(LocalDate.of(2000, Month.JANUARY, 23));
        student1.setGroup(group);

        Course course = new Course();
        course.setName("math");
        course.setHours(19);
        course.setGroup(group);

        group.getStudents().add(student);
        group.getStudents().add(student1);
        group.getCourses().add(course);



        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(group);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
