package com.project.hrms.entities.concretes;

import javax.persistence.*;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@PrimaryKeyJoinColumn(name="User_Id")
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="IdentityNumber")
	private String identityNumber;
	
	@Column(name="DateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="MernisVerified")
	private boolean mernisVerified;
	
	@Column(name="EmailVerified")
	private boolean emailVerified;
	
	@Column(name="IsRecorded")
	private boolean isRecorded;
}
