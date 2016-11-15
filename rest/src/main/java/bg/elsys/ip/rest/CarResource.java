package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bg.elsys.ip.rest.data.CarsData;
import bg.elsys.ip.rest.types.*;

@Path("/cars")
public class CarResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars() {
		CarsData.addTestInfo();
		List<Car> cars = CarsData.getCars();
		return Response.ok(cars).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCar(Car car) {
		System.out.println(car.toString());
		CarsData.addCar(car);
		if(car.getTransmission() == Transmission.Automatic){
			System.out.println("Trans is Automatic!");
		}
		return "Ok! The post works";
	}
}
