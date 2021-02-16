package com.edu.Student.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {
    private static final long serialVersionUID = 2283821365629427570L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME",nullable = false,length = 50)
    private String name;

    @Column(name = "LOCATION", length = 100, nullable = false)
    private String location;

    @OneToMany(mappedBy = "department",orphanRemoval = true)
    private List<Internship> internships = new ArrayList<>();

    @OneToMany(mappedBy = "",orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public List<Internship> getInternships() {
        return internships;
    }

    public void setInternships(List<Internship> internships) {
        this.internships = internships;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
