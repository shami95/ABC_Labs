package com.hms.hospital.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctordb")
public class doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String name;
    @Column(name = "age")
    private String age;
    @Column(name = "degree")
    private String degree;
    @Column(name = "prescription")
    private String prescription;
    @Column(name = "experiance")
    private String experiance;

    public doctor(long id, String name, String age, String degree, String prescription, String experiance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.degree = degree;
        this.prescription = prescription;
        this.experiance = experiance;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDegree() {
        return degree;
    }

    public String getPrescription() {
        return prescription;
    }

    public String getExperiance() {
        return experiance;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public void setExperiance(String experiance) {
        this.experiance = experiance;
    }
}
