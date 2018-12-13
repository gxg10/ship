package com.example.ship;

import com.example.ship.entity.Ship;
import com.example.ship.repo.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShipApplication implements CommandLineRunner {

	@Autowired
    ShipRepository shipRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//        shipRepository.save(new Ship( "Ana", 50));
	}
}

