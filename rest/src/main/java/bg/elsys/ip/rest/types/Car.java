package bg.elsys.ip.rest.types;

public class Car {
	// Basic car Info
	Manufacturer manufacturer = null;
	String model = null;
	Transmission transmission = null;
	Engine engine = null;
	int year = 0;
	
	// Second hand car info
	int milleage = 0;
	
	int price = 0;
	
	//Attributes
	String urlImage = null;
	
	public void CarConstructor(Manufacturer manufacturer, String model, Transmission transmission, Engine engine, int year, int milleage, int price,
			String urlImage) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.transmission = transmission;
		this.engine = engine;
		this.year = year;
		this.milleage = milleage;
		this.price = price;
		this.urlImage = urlImage;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMilleage() {
		return milleage;
	}

	public void setMilleage(int milleage) {
		this.milleage = milleage;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", transmission=" + transmission + ", year="
				+ year + ", milleage=" + milleage + ", price=" + price + ", urlImage=" + urlImage + "]";
	}

	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	
	
	
	

}
