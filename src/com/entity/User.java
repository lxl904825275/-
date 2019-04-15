package com.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author : liuxulong
 * date : 18:47 2019/4/15
 */
@Entity
@Table(name = "user")
public class User {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    @Id
    @GenericGenerator(name = "_native",strategy = "native")
    @GeneratedValue(generator = "_native")
    @Column(name = "u_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }
}
