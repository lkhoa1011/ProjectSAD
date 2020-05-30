package vja.ticket.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vja.ticket.entity.Ticket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class VJATicketController {
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of image service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Image Service running at port: " + env.getProperty("local.server.port");
	}
		
	@RequestMapping("/tickets")
	public  List<Ticket> getTicket() {
		List<Ticket> Ticket = Arrays.asList(
				new Ticket(1, "10042020", "15042020", "HP","DaNang", 1,2,1),
				new Ticket(2, "10042020", "15042020", "HN","HP", 2,2,1),
				new Ticket(3, "10042020", "15042020", "HCM","PhuQuoc", 1,2,1),
				new Ticket(4, "10042020", "15042020", "HCM","NgheAn", 1,2,1),
				new Ticket(5, "10042020", "15042020", "HCM","GiaLai", 2,2,1)	
				);
		return Ticket;
	}
//	@RequestMapping("/ticket/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
//	public List<Ticket> getTicket(@PathVariable String ngaydi,
//			@PathVariable String ngayve , @PathVariable String noidi ,
//			@PathVariable String noiden ,@PathVariable String nguoilon,
//			@PathVariable String treem, @PathVariable String embe) {
//		
//		List<Ticket> ticket = Arrays.asList(
//				new Ticket(1, "10042020", "15042020", "HP","DaNang", 1,2,1),
//				new Ticket(2, "10042020", "15042020", "HN","HP", 2,2,1),
//				new Ticket(3, "10042020", "15042020", "HCM","PhuQuoc", 1,2,1),
//				new Ticket(4, "10042020", "15042020", "HCM","NgheAn", 1,2,1),
//				new Ticket(5, "10042020", "15042020", "HCM","GiaLai", 2,2,1)	
//				);	
//		
//		List<Ticket> tc = new ArrayList<Ticket>();
//		try {
//			for (Ticket ticket2 : ticket) {
//				if (ticket2.getNgaydi().equals(ngaydi) == true &&
//					ticket2.getNgayve().equals(ngayve) == true &&	
//					ticket2.getNoidi().equals(noidi) == true &&
//					ticket2.getNoiden().equals(noiden) == true &&
//					ticket2.getNguoilon() == Integer.parseInt(nguoilon) &&
//				    ticket2.getTreem() == Integer.parseInt(treem)) {
//					
//				}
//			}
//		} catch (Exception e) {
//			tc.add(null);
//		}
//		
//				return ticket;
//		
//	}
}