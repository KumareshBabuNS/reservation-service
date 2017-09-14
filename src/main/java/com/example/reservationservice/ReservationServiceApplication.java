package com.example.reservationservice;

import com.example.reservationservice.entity.Reservation;
import com.example.reservationservice.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ReservationRepository rr) {
		return args -> {
			Stream.of("Josh", "Heidi", "Cameron", "Saritha",
					"Balaji", "Soumya", "Steve", "Kelsey2")
					.forEach(name -> rr.save(new Reservation(name)));

		};
	}

}
