package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;


@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    @POST
	@Transactional
	@Path("/submitpayment")
	@Consumes(MediaType.APPLICATION_JSON)
	Response makePayment(Payment payment) {
		Calendar calobj = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		if (df.format(payment.getExpiryDate()).compareTo(df.format(calobj.getTime())) > 0)
			return Response.status(500).entity("Card has expired").build();
		payment.persist();
		return Response.ok(201).entity(payment).build();		
	}
}
