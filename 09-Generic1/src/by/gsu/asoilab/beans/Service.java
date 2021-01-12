package by.gsu.asoilab.beans;

import by.gsu.asoilab.interfases.Priceable;
import static by.Constants.DELIMITER;

import by.Constants;

public class Service implements Priceable{
	
	private String name;
	private Byn costOfService;
	private int usersNumber;
	
	public Service() {
		this(Constants.EMPTY_STRING, new Byn(), 0);
	}
	
	public Service(String name, Byn costOfService, int usersNumber) {
		this.name = name;
		this.costOfService = costOfService;
		this.usersNumber = usersNumber;
	}
	
	public Service(String name, int costOfService, int usersNumber) {
		this(name, new Byn(costOfService), usersNumber);
	}
	
	public String getName() {
		return name;
	}

	public Byn getCostOfService() {
		return costOfService;
	}

	public int getUsersNumber() {
		return usersNumber;
	}

	@Override
	public Byn getPrice() {
		return costOfService.div(usersNumber);
	}
	
	@Override
	public String toString() {
		return name + DELIMITER + costOfService + DELIMITER + usersNumber + DELIMITER + getPrice();
	}
}
