package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.transaction.Transactional;

import com.test.quarkus.model.Payment;

@Path("/payment")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response hello() {
    	Payment payment = new Payment();
		payment.setAmount(4000);
		payment.setPaymentType("card");
		payment.setCardnumber("1234-1234-1234-1234");
		payment.setExpiryDate(new Date("11/08/2020"));
		/*Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		if (df.format(payment.getExpiryDate()).compareTo(df.format(calobj.getTime())) > 0)
			return Response.status(500).entity("Card has expired").build();
		payment.persist();*/
		Jsonb jsonb = JsonbBuilder.create();
		String result = jsonb.toJson(payment);
		return Response.ok(201).entity(result).build();
        //return "hello";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/makepayment")
    @Transactional
    public Response test(Payment payment) {
    	Jsonb jsonb = JsonbBuilder.create();
	    Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String result = jsonb.toJson(payment);
	    if (df.format(payment.getExpiryDate()).compareTo(df.format(calobj.getTime())) > 0)
			return Response.status(500).entity("Card has expired").build();
		payment.persist();
		return Response.ok(201).entity(result).build();
    }
}
