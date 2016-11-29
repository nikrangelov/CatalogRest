package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class CarService {
	private static CarService instance;

	public static CarService getInstance() {
		if (instance == null) {
			instance = new CarService();
		}
		return instance;
	}

	private List<Car> carList = new ArrayList<>();

	public CarService() {
			carList.add(new Car("Mercedes", "S Class 65 AMG", "Automatic", "Disel", 2016, 20, 160_000));
			carList.add(new Car("Mercedes", "E Class", "Automatic", "Gasoline", 2014, 21, 30_000));
			carList.add(new Car("Fiat", "Punto", "Manual", "Gasoline", 2015, 10_000, 80_000));
		

	}

	public List<Car> getCars() {
		return Collections.unmodifiableList(carList);
	}

	public void addCar(Car car) {
		carList.add(car);
	}

	/*public PagedResponse getCarsInPagesFiltered(int page, int perPage, String withManufacturer) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream().filter((u) -> u.getManufacturer().equals(withManufacturer) || withManufacturer == null)
				.skip(previousEntries).limit(perPage).collect(Collectors.toList());
		pageOfCars.add(new Car("Mercedes", "S Class 65 AMG", "Automatic", "Disel", 2016, 20, 160_000));
		System.out.println(pageOfCars.toString());

		int totalPages = (int) Math.ceil(((double) carList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);

		return response;
	}*/
	
	public PagedResponse getCarsInPagesFiltered(int page, int perPage, String withManufacturer, String withModel,
			String withTransmission, String withEngine,
			int withMinYear, int withMaxYear,
			int withMinMilleage, int withMaxMilleage,
			int withMinPrice, int withMaxPrice) {
		int previousEntries = page * perPage;
		List<Car> pageOfCars = new ArrayList<Car>();
		List<Car> filteredCars = new ArrayList<Car>();
		for(Car car: carList){
			
			Boolean isManufacturerMatched = false;
			Boolean isModelMatched = false;
			Boolean isTransmissionMatched = false;
			Boolean isEngineMatched = false;
			Boolean isYearMatched = false;
			Boolean isMilleageMatched = false;
			Boolean isPriceMatched = false;
			
			
			// Manufacturer filter
			if(!withManufacturer.isEmpty()){
				if(car.getManufacturer().equals(withManufacturer)){
					isManufacturerMatched = true;
				}
			}else{
				isManufacturerMatched = true;
			}
			
			//Model filter
			if(!withModel.isEmpty()){
				if(car.getModel().equals(withModel)){
					isModelMatched = true;
				}
			}else{
				isModelMatched = true;
			}
			
			//Transmission filter
			if(!withTransmission.isEmpty()){
				if(car.getTransmission().equals(withTransmission)){
					isTransmissionMatched = true;
				}
			}else{
				isTransmissionMatched = true;
			}
			
			//Engine filter
			if(!withEngine.isEmpty()){
				if(car.getEngine().equals(withEngine)){
					isEngineMatched = true;
				}
			}else{
				isEngineMatched = true;
			}
			
			// Year filter
			int year = car.getYear();
			if( (year>=withMinYear) && (year<=withMaxYear)){
				isYearMatched = true;
			}
			
			
			//Milleage filter
			int milleage = car.getMilleage();
			if( (milleage>=withMinMilleage) && (milleage<=withMaxMilleage)){
				isMilleageMatched = true;
			}
			
			
			//Price filter
			int price = car.getPrice();
			if( (price>=withMinPrice) && (milleage<=withMaxPrice)){
				isPriceMatched = true;
			}
			
			if(isManufacturerMatched && isModelMatched && isTransmissionMatched && isEngineMatched && isYearMatched  && isMilleageMatched && isPriceMatched){
				filteredCars.add(car);
			}
		}
		int j = 0;
		for(int i = previousEntries; i < filteredCars.size(); i++){
			if(j < perPage){
				pageOfCars.add(filteredCars.get(i));
				j++;
			}else{
				break;
			}
		}
		int totalPages = (int) Math.ceil(((double) carList.size()) / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);

		return response;
	}
	
	public List<String> getAllDistinctCarManufacturers() {
		return carList.stream()
				.map((u) -> u.getManufacturer())
				.distinct()
				.collect(Collectors.toList());
	}
}
