package com.example.ship.form;

public class ShipForm {

    private Long id;

    private String name;

    public ShipForm() {
    }

    public ShipForm(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
