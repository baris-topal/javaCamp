package com.project.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_advertisements")
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="Id")
	private int id;
	
	@ManyToOne()
	@JoinColumn(name="User_Id")
	private Employer employer;
	
	@ManyToOne()
    @JoinColumn(name="Job_Positions_Id")
    private JobPosition jobPosition;
	
	@ManyToOne()
    @JoinColumn(name = "City_Id")
    private City city;
	
	@Column(name = "Description")
    private String description;
	
	@Column(name = "Min_Salary")
    private double minSalary;

    @Column(name = "Max_Salary")
    private double maxSalary;
    
    @Column(name = "Quota")
    private int quota;
    
    @Column(name = "Release_Date")
    private Date releaseDate;

    @Column(name = "Deadline")
    private Date Deadline;
    
    @Column(name = "Is_Active")
    private boolean isActive;
    
}
