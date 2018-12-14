package com.example.ship.repo;

import com.example.ship.entity.Ulei;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UleiDAO extends JpaRepository<Ulei, Long> {

    @Query("select u from Ulei u where u.shipId = :start")
    List<Ulei> sortById(@Param("start") Long id);
}
