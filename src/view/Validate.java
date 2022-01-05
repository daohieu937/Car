package view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
	public static Scanner scanner = new Scanner(System.in);
	
	public String inputTen() {
		String name;
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		while(true) {
			name = scanner.nextLine();
			if(pattern.matcher(name).find()) {
				break;
			}
			else {
				System.out.println("nhap dung dinh dang:");
			}
		}
		return name;
	}
	
	public String inputHang() {
		String hangXe;
		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
		while(true) {
			hangXe = scanner.nextLine();
			if(pattern.matcher(hangXe).find()) {
				break;
			}
			else {
				System.out.println("nhap dung dinh dang:");
			}
		}
		return hangXe;
	}
	
	public long inputGia() {
		long giaXe;
		while(true) {
			try {
				giaXe = Long.parseLong(scanner.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("nhap dung dinh dang:");
			}
		}
		return giaXe;
	}
}
