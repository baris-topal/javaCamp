package com.project.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="User_Id")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
@EqualsAndHashCode(callSuper=false)
public class Employer extends User {
	
	@Column(name="CompanyName")
	private String companyName;
	
	@Column(name="WebSite")
	private String webSite;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;
	
	@Column(name="SystemVerified")
	private boolean systemVerified;
	
	@Column(name="EmailVerified")
	private boolean emailVerified;
	
	@Column(name="IsRecorded")
	private boolean isRecorded;
	
	@OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
