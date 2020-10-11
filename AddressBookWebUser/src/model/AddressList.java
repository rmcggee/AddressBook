package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "addr_list")
public class AddressList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LIST_ID")
	private int listId;
	
	
	@Column(name = "REVSD_DATE")
	private LocalDate revisedDate;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;

	public AddressList() {
		super();
	}

	
	public AddressList(String fName, String lName) {
		super();
		this.revisedDate = LocalDate.now();
		this.firstName = fName;
		this.lastName = lName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public LocalDate getRevisedDate() {
		return revisedDate;
	}

	public void setRevisedDate(LocalDate revisedDate) {
		this.revisedDate = revisedDate;
	}

	@Override
	public String toString() {
		return "AddressList [listId=" + listId + ", revisedDate=" + revisedDate + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}



}
