package bg.elsys.ip.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api(value = "Api for querying cars")
public class CarResource {
	
	@GET
	@Path("/test")
	@ApiOperation(value = "get  all cars")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCars(){
		return "Just a simple test!";
	}

	@GET
	@ApiOperation(value = "get  all cars")
	@Produces(MediaType.APPLICATION_JSON)
	public PagedResponse getCars(
			@DefaultValue("0") @QueryParam("page") int page, 
			@DefaultValue("5") @QueryParam("perPage") int perPage, 
			@DefaultValue("") @QueryParam("maker") String withManufacturer,
			@DefaultValue("") @QueryParam("model") String withModel, 
			@DefaultValue("") @QueryParam("transm") String  withTransmission,
			@DefaultValue("") @QueryParam("engine") String withEngine,
			@DefaultValue("0") @QueryParam("minYear") int withMinYear,
			@DefaultValue("9999") @QueryParam("maxYear") int withMaxYear,
			@DefaultValue("0") @QueryParam("minKm") int withMinMilleage,
			@DefaultValue("1000000000") @QueryParam("maxKm") int withMaxMilleage,
			@DefaultValue("0") @QueryParam("minPrice") int withMinPrice,
			@DefaultValue("1000000000")@QueryParam("maxPrice") int withMaxPrice) {
		
		//withManufacturer = "Mercedes";
		//withModel = "E Class";
		System.out.println(withMaxYear);

		CarService carService = CarService.getInstance();
		PagedResponse carsInPages = carService.getCarsInPagesFiltered(
				page, 
				perPage,
				withManufacturer,
				withModel,
				withTransmission,
				withEngine,
				withMinYear, 
				withMaxYear,
				withMinMilleage,
				withMaxMilleage,
				withMinPrice, 
				withMaxPrice);
		/*
		(
		int page, 
		int perPage, 
		String withManufacturer,
		String withModel,
		String withTransmission, 
		String withEngine,
		int withMinYear,
		int withMaxYear,
		int withMinMilleage, 
		int withMaxMilleage,
		int withMinPrice, 
		int withMaxPrice)
		*/
		
		return carsInPages;
	}
	
	@Path("/manufacturers")
	@GET
	@ApiOperation("get all distinct car manufacturers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllDistinctCarNames(){
		return CarService.getInstance().getAllDistinctCarManufacturers();
	}

	/*@POST
	@ApiOperation(value = "create new car", response = Car.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car) {
		CarService.getInstance().addCar(car);

		return Response.ok(car).status(Status.CREATED).build();
	}*/
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCar(Car car) {
		System.out.println(car.toString());
		CarService.getInstance().addCar(car);
		return "Ok! The post works";
	}
}
