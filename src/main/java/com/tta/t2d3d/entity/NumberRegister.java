package com.tta.t2d3d.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NL001")
public class NumberRegister {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long syskey;
	private long autokey;
	private String createddate;
	private String modifieddate;
	private int recordstatus;
	private String name;
	private String phone;
	private String date;
	private String session;
	private String number2d3d;
	private long amount;
	private String cashtype;
	
	public NumberRegister() {
		this.syskey=0;
		this.autokey=0;
		this.recordstatus=0;
		this.createddate="";
		this.modifieddate="";
		this.date="";
		this.number2d3d="";
		this.amount=0;
		
	}
	
	public long getSyskey() {
		return syskey;
	}
	public void setSyskey(long syskey) {
		this.syskey = syskey;
	}
	public long getAutokey() {
		return autokey;
	}
	public void setAutokey(long autokey) {
		this.autokey = autokey;
	}
	public int getRecordstatus() {
		return recordstatus;
	}
	public void setRecordstatus(int recordstatus) {
		this.recordstatus = recordstatus;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumber2d3d() {
		return number2d3d;
	}

	public void setNumber2d3d(String number2d3d) {
		this.number2d3d = number2d3d;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	

}
