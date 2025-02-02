package com.codesoom.assignment.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@Where(clause = "deleted = false")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String password;

    private String email;

    private boolean deleted = false;

    @Builder
    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void change(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void change(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public void destory() {
        deleted = true;
    }
}
