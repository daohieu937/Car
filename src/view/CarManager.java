package view;


import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import controller.CarDao;
import model.Car;

public class CarManager {
	public static Scanner scanner = new Scanner(System.in);
	private List<Car> carList;
	private CarDao carDao;
	Validate validate = new Validate();

	public CarManager() {
		carDao = new CarDao();
		carList = carDao.read();
	}

	public void add() {
		int id = (carList.size() > 0) ? (carList.size() + 1) : 1;
		System.out.println("id xe:" + id);
		System.out.println("Nhap ten xe:");
		String tenXe = validate.inputTen();
		System.out.println("Nhap hang xe:");
		String hangXe = validate.inputHang();
		System.out.println("Input gia xe:");
		long giaXe = validate.inputGia();
		Car car = new Car(id, tenXe, hangXe, giaXe);
		carList.add(car);
		carDao.write(carList);
	}

	public void edit(int id) {
		boolean isExisted = false;
		int size = carList.size();
		for (int i = 0; i < size; i++) {
			if (carList.get(i).getId() == id) {
				isExisted = true;
				System.out.println("Nhap lai ten xe:");
				carList.get(i).setTenXe(validate.inputTen());
				System.out.println("Nhap lai hang xe:");
				carList.get(i).setHangXe(validate.inputHang());
				System.out.println("Nhap lai gia xe:");
				carList.get(i).setGia(scanner.nextLong());
				break;
			}
		}
		if (!isExisted) {
			System.out.println("ko ton tai.");
		} else {
			carDao.write(carList);
		}
	}

	public long maxPrice() {
		long maxPrice = carList.get(0).getGia();
		int size = carList.size();
		for (int i = 0; i < size; i++) {
			if (maxPrice < carList.get(i).getGia()) {
				maxPrice = carList.get(i).getGia();
			}
		}
		return maxPrice;
	}

	public void delete(int id) {
		Car car = null;
		int size = carList.size();
		for (int i = 0; i < size; i++) {
			if (carList.get(i).getId() == id) {
				car = carList.get(i);
				break;
			}
		}
		if (car != null) {
			carList.remove(car);
			carDao.write(carList);
		} else {
			System.out.println("khong ton tai.");
		}
	}

	public int inputId() {
		System.out.println("nhap id xe:");
		while (true) {
			try {
				int id = Integer.parseInt((scanner.nextLine()));
				return id;
			} catch (Exception e) {
				System.out.println("nhap dung dinh dang:");
			}
		}
	}

	public void show() {
		for (Car car : carList) {
			System.out.format("||%5d", car.getId());
			System.out.format("%10s", car.getTenXe());
			System.out.format("%10s", car.getHangXe());
			System.out.format("%10d", car.getGia());
		}
	}

	public void showMaxPrice() {
		int size = carList.size();
		for (int i = 0; i < size; i++) {
			if (maxPrice() == carList.get(i).getGia()) {
				System.out.format("%2d", carList.get(i).getId());
				System.out.format("%10s", carList.get(i).getTenXe());
				System.out.format("%10s", carList.get(i).getHangXe());
				System.out.format("%10d", carList.get(i).getGia());
			}
		}
	}
	
	public void showJson() {
		//chuyen collection -> json text
		Gson gson = new Gson();
		String jsonData = gson.toJson(carList);
		System.out.println(jsonData);
		
		//chuyen json text -> collection
		Type objectType = new TypeToken<List<Car>>(){}.getType();
		List<Car> listCar = gson.fromJson(jsonData, objectType);
		for (Car car : listCar) {
			System.out.format("||%5d", car.getId());
			System.out.format("%10s", car.getTenXe());
			System.out.format("%10s", car.getHangXe());
			System.out.format("%10d", car.getGia());
		}
	}
	
}
