package vja.booking.entity;

import java.util.List;

public class Booking {
    private Integer id;
    private List<Object> ticket;
	public Booking(Integer id, List<Object> ticket) {
		super();
		this.id = id;
		this.ticket = ticket;
	}
	public Booking() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Object> getTicket() {
		return ticket;
	}
	public void setTicket(List<Object> ticket) {
		this.ticket = ticket;
	}

    
}
