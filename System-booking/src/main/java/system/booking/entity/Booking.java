package system.booking.entity;

import java.util.List;

public class Booking {
    private List<Object> ticket;

	public Booking(List<Object> ticket) {
		super();
		this.ticket = ticket;
	}

	public Booking() {
		super();
	}
	
	public List<Object> getTicket() {
		return ticket;
	}
	public List<Object> errorTickets() {
		return ticket;
	}
	public void setTicket(List<Object> ticket) {
		this.ticket = ticket;
	}
	


    
}
