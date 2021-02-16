package com.edu.Student.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {
    private static final long serialVersionUID = -2986910067582161676L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID",nullable = false)
    private Department department;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
