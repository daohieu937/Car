package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MaxPrice implements Serializable{
	private List<Car> carMaxList;
	private Date date;

	public MaxPrice() {

	}

	public MaxPrice(List<Car> carMaxList, Date date) {
		super();
		this.carMaxList = carMaxList;
		this.date = date;
	}

	public List<Car> getCarMaxList() {
		return carMaxList;
	}

	public void setCarList(List<Car> carMaxList) {
		this.carMaxList = carMaxList;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
