package com.znsic.model;

import java.util.Date;

public class TransInfo {

	private Integer id;
	private Integer sourAccountId;
	private String sourceAccount;
	private Integer distinationId;
	private String distinationAcceount;
	private Double amount;
	private Date create_dt;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSourAccountId() {
		return sourAccountId;
	}
	public void setSourAccountId(Integer sourAccountId) {
		this.sourAccountId = sourAccountId;
	}
	public String getSourceAccount() {
		return sourceAccount;
	}
	public void setSourceAccount(String sourceAccount) {
		this.sourceAccount = sourceAccount;
	}
	public Integer getDistinationId() {
		return distinationId;
	}
	public void setDistinationId(Integer distinationId) {
		this.distinationId = distinationId;
	}
	public String getDistinationAcceount() {
		return distinationAcceount;
	}
	public void setDistinationAcceount(String distinationAcceount) {
		this.distinationAcceount = distinationAcceount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Date getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(Date create_dt) {
		this.create_dt = create_dt;
	}
}
