package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Car;

public class CarDao {
	private static final String Car = "car.txt";
	public void write(List<Car> carList) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(Car));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(carList);
			fos.close();
			oos.close();
		} catch (Exception e) {
			System.out.println("Error1");
		}
	}
	
	public List<Car> read(){
		List<Car> carList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(Car));
			ObjectInputStream ois = new ObjectInputStream(fis);
			carList = (List<Car>) ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println("Error2");
		}
		return carList;
	}
}
