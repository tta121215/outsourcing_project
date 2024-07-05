package com.tta.t2d3d.dto;

public class NumberRegiterDto {
	private long id;
	private String name;
	private String phone;
	private String session;
	private String date;
	private String number;
	private long amount;
	private String cashtype;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getCashtype() {
		return cashtype;
	}
	public void setCashtype(String cashtype) {
		this.cashtype = cashtype;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public NumberRegiterDto(long id,String name,String phone, String date,String session, String number, long amount,String cashtype) {
		super();
		this.id = id;
		this.date = ddMMyyyFormat(date);
		this.number = number;
		this.amount = amount;
		this.name = name;
		this.phone = phone;
		this.session = session;
		this.cashtype = cashtype;
	}
	
	public String ddMMyyyFormat(String aDate) {
		String l_Date = "";
		if (!aDate.equals("") && aDate != null)
		//	l_Date = aDate.substring(6) + "/" + aDate.substring(4, 6) + "/" + aDate.substring(0, 4);
		l_Date = aDate.substring(0, 4) + "-" + aDate.substring(4, 6) + "-" + aDate.substring(6);

		return l_Date;
	}
	

}
