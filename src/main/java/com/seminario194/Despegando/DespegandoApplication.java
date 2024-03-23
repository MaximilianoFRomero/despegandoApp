package com.seminario194.Despegando;

import com.seminario194.Despegando.domain.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
@Slf4j
public class DespegandoApplication implements CommandLineRunner{
	private final HotelRepository hotelRepository;
	private final FlyRepository flyRepository;
	private final CustomerRepository customerRepository;
	private final ReservationRepository reservationRepository;
	private final TicketRepository ticketRepository;


    public DespegandoApplication(
			HotelRepository hotelRepository,
			FlyRepository flyRepository,
			CustomerRepository customerRepository,
			ReservationRepository reservationRepository,
			TicketRepository ticketRepository,
			TourRepository tourRepository) {
        this.hotelRepository = hotelRepository;
        this.flyRepository = flyRepository;
        this.customerRepository = customerRepository;
        this.reservationRepository = reservationRepository;
        this.ticketRepository = ticketRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(DespegandoApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception{

		//Pruebas manuales

		/*var fly = flyRepository.findById(15L).get();
		var hotel = hotelRepository.findById(7L).get();
		var customer = customerRepository.findById("BBMB771012HMCRR022").get();
		var reservation = reservationRepository.findById(UUID.fromString("12345678-1234-5678-1234-567812345678")).get();
		var ticket = ticketRepository.findById(UUID.fromString("12345678-1234-5678-2236-567812345678")).get();


		log.info(String.valueOf(fly));
		log.info(String.valueOf(hotel));
		log.info(String.valueOf(customer));
		log.info(String.valueOf(reservation));
		log.info(String.valueOf(ticket));*/

		/*this.flyRepository.selectLessPrice(BigDecimal.valueOf(20)).forEach(f -> System.out.println(f));
		var fly = flyRepository.findById(1L).get();
		fly.getTickets().forEach(ticket -> System.out.println(ticket));*/

		/*var fly= flyRepository.findByTicketId(UUID.fromString("12345678-1234-5678-2236-567812345678"));*/
		//hotelRepository.findByPriceLessThan(BigDecimal.valueOf(100)).forEach(System.out::println);
		/*System.out.println(hotel);*/

		var customer = customerRepository.findById("GOTW771012HMRGR087").orElseThrow();
		log.info("Client name:" + customer.getFullName());

	}
}

