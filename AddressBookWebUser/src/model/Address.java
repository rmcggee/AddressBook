package model;


import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADDR_ID")
	private int addressId;
	
	@Column(name = "ADDR_1")
	private String addressLine1;
	
	@Column(name = "ADDR_2")
	private String addressLine2;
	
	@Column(name = "ADDR_3")
	private String addressLine3;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "POSTAL")
	private String postal;
	
	@OneToOne
	@JoinColumn(name = "LIST_ID")

	private AddressList myAddressList;
	
	
	public Address() {
		super();
	}
	
	public Address(String line1, String line2, String line3, String city, String state, String postal, AddressList myAddressList) {
		super();
		this.addressLine1 = line1;
		this.addressLine2 = line2;
		this.addressLine3 = line3;
		this.city = city;
		this.state = state;
		this.postal = postal;
		this.myAddressList = myAddressList;
	}

	public AddressList getMyAddressList() {
		return myAddressList;
	}

	public void setMyAddressList(AddressList myAddressList) {
		this.myAddressList = myAddressList;
	}

	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getAddressLine3() {
		return addressLine3;
	}
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", addressLine3=" + addressLine3 + ", city=" + city + ", state=" + state + ", postal=" + postal
				+ ", myAddressList=" + myAddressList + "]";
	}


	



}
