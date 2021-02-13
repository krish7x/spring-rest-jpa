package com.edu.Student.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SKILL")
public class Skill implements Serializable {
    private static final long serialVersionUID = 6387271984646950349L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "LEVEL", length = 50, nullable = false)
    private String level;

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

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
}
