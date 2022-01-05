package view;

import java.util.Scanner;

public class Main {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		String choose = null;
		boolean exit = false;
		CarManager carManager = new CarManager();
		int id;
		showMenu();
		while (true) {
			choose = scanner.nextLine();
			switch (choose) {
			case "1":
				carManager.add();
				break;
			case "2":
				id = carManager.inputId();
				carManager.edit(id);
				break;
			case "3":
				id = carManager.inputId();
				carManager.delete(id);
				break;
			case "4":
				carManager.show();
				break;
			case "5":
				carManager.showMaxPrice();
				break;
			case "6":
				carManager.showJson();;
				break;
			case "0":
				System.out.println("exited!");
				exit = true;
				break;
			default:
				System.out.println("khong ton tai");
				break;
			}
			if (exit) {
				break;
			}
			showMenu();
		}
	}

	public static void showMenu() {
		System.out.println("");
		System.out.println("--menu--");
		System.out.println("1. Add car.");
		System.out.println("2. Edit car id.");
		System.out.println("3. Delete car id.");
		System.out.println("4. Show car.");
		System.out.println("5. Max price.");
		System.out.println("6. Show json");
		System.out.println("0. exit.");
		System.out.println("----");
		System.out.print("Please choose: ");
	}
}
