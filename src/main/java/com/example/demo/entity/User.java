package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "user")
public class User {

    /*
       AUTO, IDENTITY, SEQUENCE and TABLE
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String last_Name;

    //от страна на user-a гледаме един user -> много адреси
    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Collection<Adress> adress = new ArrayList<Adress>();
}
