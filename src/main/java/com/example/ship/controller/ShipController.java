package com.example.ship.controller;

import com.example.ship.entity.Ship;
import com.example.ship.repo.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipController {

    @Autowired
    private ShipRepository shipRepository;

    @GetMapping("/ships")
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    @GetMapping("/ships/{id}")
    public Ship one(@PathVariable Long id) {
        return shipRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    @PutMapping("/ships/{id}")
    public Ship changeName(@RequestBody Ship newShip,
                            @PathVariable("id") Long id ) {
        return shipRepository.findById(id)
                .map(ship -> {
                    ship.setName(newShip.getName());
                    ship.setKm(newShip.getKm());
                    return shipRepository.save(ship);
                })
                .orElseGet(() -> {
                    newShip.setId(id);
                    return shipRepository.save(newShip);
                });
    }

    @GetMapping("/ships/{id}/control")
    public int getKm(@PathVariable("id") Long id) {
        Ship s = shipRepository.findById(id).orElseThrow(NullPointerException::new);

        return s.getKm();
    }

    @GetMapping("/ships/total")
    public int getTotal() {
        int total = 0;
        List<Ship> list = shipRepository.findAll();
        for (Ship s: list) {
            total += s.getKm();
        }

        return total;
    }

}
