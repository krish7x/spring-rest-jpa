package com.edu.Student.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "INTERNSHIP")
@AllArgsConstructor
@NoArgsConstructor
public class Internship implements Serializable {

    private static final long serialVersionUID = -5458956197358743781L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID", nullable = false)
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
