package com.project.hrms.entities.concretes;


import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name="job_positions")
public class JobPositions {

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;

	public JobPositions() { }

	public JobPositions(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}	
	
}
