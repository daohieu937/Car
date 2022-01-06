package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.MaxPrice;

public class MaxPriceDao {
	private static final String MaxPrice = "report.txt";
	public void write(List<MaxPrice> maxPriceList) {
		try {
			FileOutputStream fos = new FileOutputStream(new File(MaxPrice));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(maxPriceList);
			fos.close();
			oos.close();
		} 
		catch (Exception e) {
			System.out.println("error");
		}
	}
	
	public List<MaxPrice> read() {
		List<MaxPrice> maxPriceList = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(new File(MaxPrice));
			ObjectInputStream ois = new ObjectInputStream(fis);
			maxPriceList = (List<MaxPrice>) ois.readObject();
			fis.close();
			ois.close();
		} catch (Exception e) {
			System.out.println("error");
		}
		return maxPriceList;
	}
}
