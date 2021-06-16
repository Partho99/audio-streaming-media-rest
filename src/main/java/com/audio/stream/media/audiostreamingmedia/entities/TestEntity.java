package com.audio.stream.media.audiostreamingmedia.entities;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class TestEntity {

}

/**
@Entity
class Employee {
    @Id
    private int id;
    private String name;
    private long salary;
    @ElementCollection
    @CollectionTable(name="EMP_PHONE")
    @MapKeyColumn(name="PHONE_TYPE")
    @Column(name="PHONE_NUM")
    private Map<String, String> phoneNumbers;
}

@Entity
 class Department {
    @Id private int id;
    private String name;
    @ManyToMany
    @JoinTable(name="DEPT_EMP",
            joinColumns=@JoinColumn(name="DEPT_ID"),
            inverseJoinColumns=@JoinColumn(name="EMP_ID"))
    private Map<String, Employee> employeesByCubicle;
}

@Entity
 class Owner {
    @Id
    private long id;

    @OneToMany(mappedBy="owner")
    @MapKey(name = "vinNo")
    private Map<String, Car> carMap;
}

@Entity
 class Car {
    @Id
    private long id;

    @ManyToOne
    private Owner owner;

    private String vinNo;

}
*/
