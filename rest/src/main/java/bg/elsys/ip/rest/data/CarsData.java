package bg.elsys.ip.rest.data;

import java.util.ArrayList;
import java.util.List;

import bg.elsys.ip.rest.types.*;

public final class CarsData {
	
	private static List<Car> cars = new ArrayList<>();
	
	public static void addTestInfo(){
		if(cars.isEmpty() == true){
			Car obj = new Car();
			obj.CarConstructor(Manufacturer.Mercedes, "S Class 65 AMG", Transmission.Automatic, Engine.Disel, 2012, 20000, 165200, "https://upload.wikimedia.org/wikipedia/commons/a/a8/Mercedes_S-Class_V221_65_AMG_facelift_China_2012-06-11.jpg");
			cars.add(obj);
			
			Car obj1 = new Car();
			obj1.CarConstructor(Manufacturer.Mercedes, "E Class 65 AMG", Transmission.Automatic, Engine.Disel, 2012, 20000, 165200, "https://upload.wikimedia.org/wikipedia/commons/a/a8/Mercedes_S-Class_V221_65_AMG_facelift_China_2012-06-11.jpg");
			cars.add(obj1);
		}
	}
	
	public static List<Car> getCars(){
		addTestInfo();
		return cars;
	}
	
	public static void addCar(Car car){
		addTestInfo();
		cars.add(car);
	}

}
