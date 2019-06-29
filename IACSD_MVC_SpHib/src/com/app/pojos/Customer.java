package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="MTab")
public class Customer 
{
	private Integer cid;
	private String name;
	private String city;
	private String email;
	private String password;
	private Date joinDt;
	
		public Customer() {
		super();
	}
	
	public Customer(String name, String city, String email, String password) {
		super();
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", name=" + name + ", city=" + city + ", email=" + email + ", password="
				+ password + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	@Column(length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=20)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Column(length=20,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="Join_Date")
	@Temporal(TemporalType.DATE)
	public Date getJoinDt() {
		return joinDt;
	}

	public void setJoinDt(Date joinDt) {
		this.joinDt = joinDt;
	}

	
}
