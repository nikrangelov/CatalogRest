package bg.elsys.ip.rest;

public class Car {

	String manufacturer = null;
	String model = null;
	String transmission = null;
	String engine = null;
	int year = 0;
		
	// Second hand car info
	int milleage = 0;
	
	int price = 0;
	
	public Car(){
		
	}
	public Car(String manufacturer, String model, String transmission, String engine, int year, int milleage,
			int price) {
		super();
		this.manufacturer = manufacturer;
		this.model = model;
		this.transmission = transmission;
		this.engine = engine;
		this.year = year;
		this.milleage = milleage;
		this.price = price;
	}
	
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the transmission
	 */
	public String getTransmission() {
		return transmission;
	}

	/**
	 * @param transmission the transmission to set
	 */
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	/**
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the milleage
	 */
	public int getMilleage() {
		return milleage;
	}

	/**
	 * @param milleage the milleage to set
	 */
	public void setMilleage(int milleage) {
		this.milleage = milleage;
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [manufacturer=" + manufacturer + ", model=" + model + ", transmission=" + transmission + ", engine="
				+ engine + ", year=" + year + ", milleage=" + milleage + ", price=" + price + "]";
	}
	
	
	

}
