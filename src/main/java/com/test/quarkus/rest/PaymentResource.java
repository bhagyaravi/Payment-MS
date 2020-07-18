package com.test.quarkus.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import com.test.quarkus.model.Payment;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;



@Path("/payment")
public class PaymentResource {
	
	@GET
	@Path("/test")
	public String hello(){
	return "Hello World";
	}

	@POST
	@Path("/makepayment")
	@Transactional
	//@Consumes(MediaType.APPLICATION_JSON)
	Response makePayment() {
		Payment payment = new Payment();
		payment.setAmount(4000);
		payment.setPaymentType("card");
		payment.setCardnumber("1234-1234-1234-1234");
		payment.setExpiryDate(df.parse("11/08/2020"));
		Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		if (df.format(payment.getExpiryDate()).compareTo(df.format(calobj.getTime())) > 0)
			return Response.status(500).entity("Card has expired").build();
		payment.persist();
		return Response.ok(201).entity(payment).build();		
	}
}
