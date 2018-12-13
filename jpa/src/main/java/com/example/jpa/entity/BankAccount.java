package com.example.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "full_name", length = 128, nullable = false)
    private String fullName;

    @Column(name = "ballance", nullable = false)
    private double ballance;

    public BankAccount(String fullName, double ballance) {
        this.fullName = fullName;
        this.ballance = ballance;
    }

    public BankAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance) {
        this.ballance = ballance;
    }
}
