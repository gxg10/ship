package com.example.ship.controller;

import com.example.ship.entity.Ship;
import com.example.ship.entity.Ulei;
import com.example.ship.form.ShipForm;
import com.example.ship.repo.ShipRepository;
import com.example.ship.repo.UleiDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class ShipController {

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private UleiDAO uleiRepo;

    @GetMapping("/ships")
    public List<Ship> getAllShips() {
        return shipRepository.findAll();
    }

    @GetMapping("/ships/{id}")
    public Ship one(@PathVariable Long id) {
        return shipRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    @PostMapping("/ships/oil")
    public ResponseEntity<Void> schimbUlei(@RequestBody ShipForm shipForm) {
        Ship ship = shipRepository.findById(shipForm.getId()).orElseThrow(NullPointerException::new);

        if (ship != null) {
            uleiRepo.save(new Ulei(shipForm.getId(), new Date()));
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/ships/{id}/oil")
    public List<Ulei> getUlei(@PathVariable Long id) {
        List<Ulei> list = uleiRepo.sortById(id);

        return list;
    }




}
