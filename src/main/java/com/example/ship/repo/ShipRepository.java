package com.example.ship.repo;

import com.example.ship.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
}
