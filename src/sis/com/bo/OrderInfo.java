package sis.com.bo;

import java.util.Date;

public class OrderInfo {
	int id ;
	String vechileName;
	String vechileNo;
	float cost;
	String customerName ;
	String customerMob;
	Date bookFrom;
	Date bookTo;
	int orderStatus;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVechileName() {
		return vechileName;
	}
	public void setVechileName(String vechileName) {
		this.vechileName = vechileName;
	}
	public String getVechileNo() {
		return vechileNo;
	}
	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMob() {
		return customerMob;
	}
	public void setCustomerMob(String customerMob) {
		this.customerMob = customerMob;
	}
	public Date getBookFrom() {
		return bookFrom;
	}
	public void setBookFrom(Date bookFrom) {
		this.bookFrom = bookFrom;
	}
	public Date getBookTo() {
		return bookTo;
	}
	public void setBookTo(Date bookTo) {
		this.bookTo = bookTo;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

}
