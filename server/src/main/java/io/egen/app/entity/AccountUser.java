package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries ({
	@NamedQuery(name = "AccountUser.findAll" , query = "SELECT u from AccountUser u ORDER BY u.email"),
	@NamedQuery(name = "AccountUser.findByEmail" , query = "SELECT u from AccountUser u WHERE u.email=:pEmail ")
})
public class AccountUser {
	
	//details of the user
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String Comment;
	
	@Column(unique = true)
	private String email;
	
	@Column (unique = true)
	private String userName;
	
	public AccountUser() {
		id= UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	@Override
	public String toString() {
		return "AccountUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Comment=" + Comment
				+ ", email=" + email + ", userName=" + userName + "]";
	}

	
	

}
