package com.sample.service;

import com.sample.request.Passenger;
import com.sample.response.Ticket;

public interface IBookingTicketService 
{
	public Ticket bookTicket(Passenger passenger);
	public Ticket fetchTicketInfo(Integer ticketNumber);

}
