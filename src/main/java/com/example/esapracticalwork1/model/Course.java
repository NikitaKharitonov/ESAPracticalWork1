package com.example.esapracticalwork1.model;

import jakarta.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer hours;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Course() {
    }

    public Course(String name, Integer hours) {
        this.name = name;
        this.hours = hours;
    }

    public Course(String name, Integer hours, Group group) {
        this.name = name;
        this.hours = hours;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
