package Day4_Game.Entities;

import java.time.LocalDate;

public class Player {
	
	private int gamerId;
	private String nationalityId;
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	
	public int getId() {
		return gamerId;
	}
	public void setId(int gamerId) {
		this.gamerId = gamerId;
	}
	public String getNationalityId() {
		return nationalityId;
	}
	public void setNationalityId(String nationalityId) {
		this.nationalityId = nationalityId;
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
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
