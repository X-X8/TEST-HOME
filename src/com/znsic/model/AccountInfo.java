package com.znsic.model;

import java.util.Date;

import com.znsic.dao.AccountDao;

public class AccountInfo {

	private Integer id;
	private String account;
	private Double amount;
	private Date create_dt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getCreate_date() {
		return create_dt;
	}
	public void setCreate_date(Date create_date) {
		this.create_dt = create_date;
	}
	public static AccountInfo get(int i) {
		// TODO Auto-generated method stub
		return null;
	 
	}}
