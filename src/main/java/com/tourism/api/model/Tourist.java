package com.tourism.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tourists")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "destination")
    private String destination;

    @Column(name = "visit_date")
    private String visitDate;

    // ---- Default Constructor ----
    public Tourist() {}

    // ---- All-Args Constructor ----
    public Tourist(Long id, String name, String country, String email,
                   String phone, String destination, String visitDate) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.destination = destination;
        this.visitDate = visitDate;
    }

    // ---- Getters ----
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDestination() { return destination; }
    public String getVisitDate() { return visitDate; }

    // ---- Setters ----
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setCountry(String country) { this.country = country; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }
}
