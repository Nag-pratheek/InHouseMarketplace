package com.cg.market.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Empl")

public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	@Column(name="empname")
	private String empName;
	@Column(name="deptname")
	private String deptName;
	@Column(name="location")
	private String location;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", location=" + location
				+ ", user=" + user + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String deptName, String location, User user) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
		this.user = user;
	}
	
	public Employee(String empName, String deptName, String location) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employee(String empName, String deptName, String location, User user) {
		super();
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
		this.user = user;
	}
	
	
}
	
	