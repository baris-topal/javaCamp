package com.project.hrms.entities.concretes;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="system_staff")
@PrimaryKeyJoinColumn(name="UserId", referencedColumnName="Id")
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class SystemStaff  extends User {
	
	@Id
	@GeneratedValue
	@Column(name="UserId")
	private int id;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
}
