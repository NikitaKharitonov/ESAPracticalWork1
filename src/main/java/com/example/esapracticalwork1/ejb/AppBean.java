package com.example.esapracticalwork1.ejb;

import com.example.esapracticalwork1.dao.CourseDao;
import com.example.esapracticalwork1.dao.GroupDao;
import com.example.esapracticalwork1.dao.StudentDao;
import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import com.example.esapracticalwork1.model.Student;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateful
public class AppBean {

    private final CourseDao courseDao = new CourseDao();
    private final GroupDao groupDao = new GroupDao();
    private final StudentDao studentDao = new StudentDao();

    public void createCourse(Course course, Long groupId) {
        Group group = groupDao.read(groupId);
        if (group == null)
            return;
        course.setGroup(group);
        courseDao.create(course);
    }

    public void createGroup(Group group) {
        groupDao.create(group);
    }

    public void createStudent(Student student, Long groupId) {
        Group group = groupDao.read(groupId);
        if (group == null)
            return;
        student.setGroup(group);
        studentDao.create(student);
    }

    public List<Course> getAllCourses() {
        return courseDao.readAll();
    }


    public List<Group> getAllGroups() {
        return groupDao.readAll();
    }

    public List<Student> getAllStudents() {
        return studentDao.readAll();
    }

    public void updateCourse(Long id, Course newCourseData) {

    }


}
