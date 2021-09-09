package com.example.esapracticalwork1.ejb;

import com.example.esapracticalwork1.dao.CourseDao;
import com.example.esapracticalwork1.dao.DaoUtil;
import com.example.esapracticalwork1.dao.GroupDao;
import com.example.esapracticalwork1.dao.StudentDao;
import com.example.esapracticalwork1.model.Course;
import com.example.esapracticalwork1.model.Group;
import com.example.esapracticalwork1.model.Student;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class AppBean {

    private final CourseDao courseDao = new CourseDao();
    private final GroupDao groupDao = new GroupDao();
    private final StudentDao studentDao = new StudentDao();

    public void createCourse(Course course, Long groupId) {
        Group group = groupDao.get(groupId);
        if (group == null)
            return;
        course.setGroup(group);
        courseDao.create(course);
    }

    public void createGroup(Group group) {
        groupDao.create(group);
    }

    public void createStudent(Student student, Long groupId) {
        Group group = groupDao.get(groupId);
        if (group == null)
            return;
        student.setGroup(group);
        studentDao.create(student);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAll();
    }

    public Course getCourseById(Long id) {
        return courseDao.get(id);
    }

    public List<Group> getAllGroups() {
        return groupDao.getAll();
    }

    public Group getGroupById(Long id) {
        return groupDao.get(id);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAll();
    }

    public Student getStudentById(Long id) {
        return studentDao.get(id);
    }

    public void updateCourse(Long courseId, Course newCourseData, Long groupId) {
        Group group = groupDao.get(groupId);
        if (group == null)
            return;
        newCourseData.setGroup(group);
        courseDao.update(courseId, newCourseData);
    }

    public void updateGroup(Long groupId, Group newGroupData) {
        groupDao.update(groupId, newGroupData);
    }

    public void updateStudent(Long studentId, Student newStudentData, Long groupId) {
        Group group = groupDao.get(groupId);
        if (group == null)
            return;
        newStudentData.setGroup(group);
        studentDao.update(studentId, newStudentData);
    }

    public void deleteCourse(Long courseId) {
        courseDao.delete(courseId);
    }

    public void deleteGroup(Long groupId) {
        Group group = getGroupById(groupId);
        if (group == null)
            return;
        group.getCourses().forEach(course -> this.deleteCourse(course.getId()));
        group.getStudents().forEach(student -> this.deleteStudent(student.getId()));
        DaoUtil.refresh();
        groupDao.delete(groupId);
    }

    public void deleteStudent(Long studentId) {
        studentDao.delete(studentId);
    }
}
