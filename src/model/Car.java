package model;

import java.io.Serializable;

public class Car implements Serializable {
	private int id;
	private String tenXe;
	private String hangXe;
	private long gia;

	public Car() {
		
	}
	
	public Car(int id, String tenXe, String hangXe, long gia) {
		super();
		this.id = id;
		this.tenXe = tenXe;
		this.hangXe = hangXe;
		this.gia = gia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenXe() {
		return tenXe;
	}

	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}

	public String getHangXe() {
		return hangXe;
	}

	public void setHangXe(String hangXe) {
		this.hangXe = hangXe;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

}
