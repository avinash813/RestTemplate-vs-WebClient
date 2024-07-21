package com.sample.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.request.Passenger;
import com.sample.response.Ticket;

@Service
public class BookingTicketServiceImpl implements IBookingTicketService
{

	private static final String BOOK_URL = 
			"http://localhost:8484/TicketBookingApp/api/ticket-booking/getTicketNumber";
	private static final String GET_URL = 
			"http://localhost:8484/TicketBookingApp/api/ticket-booking/getTicket/{ticketNumber}";


	@Override
	public Ticket bookTicket(Passenger passenger) {
		System.out.println(passenger + " in Integration logic method");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Ticket> response=restTemplate.postForEntity(BOOK_URL, passenger, Ticket.class);
		return response.getBody();
		
		//Get the WebClient Object
//				WebClient webClient = WebClient.create();
				
				//Send the request and process the data 
//				Ticket ticket=webClient.post().
//				uri(BOOK_URL).
//				bodyValue(passenger).
//				retrieve().
//				bodyToMono(Ticket.class).
//				block();//synchronous
				return ticket;
		
	}

	@Override
	public Ticket fetchTicketInfo(Integer ticketNumber) {
		RestTemplate restTemplate=new RestTemplate();
		ResponseEntity<Ticket> responseEntity = restTemplate.getForEntity(GET_URL, Ticket.class, ticketNumber);
		Ticket ticket=responseEntity.getBody();
		System.out.println("Ticket object in Consumer service IL "+ ticket);
		
		//Get the WebClient Object
//		WebClient webClient = WebClient.create();
//		
//		Ticket ticket = webClient.get()
//				.uri(GET_URL,ticketNumber).
//				retrieve().
//				bodyToMono(Ticket.class).
//				block();
		
		
		return ticket;
	}

}
