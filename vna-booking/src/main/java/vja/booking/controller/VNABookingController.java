package vja.booking.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import vja.booking.entity.Booking;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class VNABookingController {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		// This is useful for debugging
		// When having multiple instance of gallery service running at different ports.
		// We load balance among them, and display which instance received the request.
		return "Hello from Gallery Service running at port: " + env.getProperty("local.server.port");
	}
  
	@RequestMapping("/tickets")
	public Booking Ticket() {
		// create gallery object
		Booking tc = new Booking();
		
		// get list of available images 
		List<Object> ticket = restTemplate.getForObject("http://ticket-vna/tickets/", List.class);
		tc.setTicket(ticket);
	
		return tc;
	}
	@RequestMapping("/{ngaydi}/{ngayve}/{noidi}/{noiden}/{nguoilon}/{treem}/{embe}")
	public Booking getTicket(@PathVariable final String ngaydi, @PathVariable final String ngayve , @PathVariable final String noidi ,@PathVariable final String noiden ,@PathVariable final String nguoilon,
			@PathVariable final String treem, @PathVariable final String embe) {
		// create gallery object
		Booking tc = new Booking();
		JSONObject gioVe = new JSONObject();
		List<Object> vedi = new ArrayList<>();
		List<Object> veve = new ArrayList<>();
		String result = restTemplate.getForObject("http://ticket-vna/tickets/", String.class);
		try {
			Object obj = new JSONParser().parse(result);
			JSONArray ja= (JSONArray) obj;
			for (int i = 0; i < ja.size(); i++) {
				JSONObject tmp = (JSONObject) ja.get(i);
				if (tmp.get("noidi").equals(noidi) && tmp.get("noiden").equals(noiden) && tmp.get("ngaydi").toString().equals(ngaydi)) {
					vedi.add(tmp);
				}
				if (tmp.get("noiden").equals(noiden) && tmp.get("noidi").equals(noidi) && tmp.get("ngayve").toString().equals(ngayve)) {
					veve.add(tmp);
				}
			}
			gioVe.put("Vedi",vedi);
			gioVe.put("Veve",veve);
			JSONArray kk = new JSONArray();
			kk.add(gioVe);
			List<Object> ve = (List<Object>) kk;
			tc.setTicket(ve);			
			return tc;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return tc ; 
	}
	
	// -------- Admin Area --------
	// This method should only be accessed by users with role of 'admin'
	// We'll add the logic of role based auth later
	@RequestMapping("/admin")
	public String homeAdmin() {
		return "This is the admin area of Gallery service running at port: " + env.getProperty("local.server.port");
	}
}