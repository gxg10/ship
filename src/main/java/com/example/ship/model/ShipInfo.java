package com.example.ship.model;

public class ShipInfo {

    private Long id;
    private String name;
    private double km;

    public ShipInfo() {

    }

    public ShipInfo(Long id, String name, double km) {
        this.id = id;
        this.name = name;
        this.km = km;
    }

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

    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }
}
