package com.project.hrms.entities.concretes;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_positions")
@AllArgsConstructor
@NoArgsConstructor

public class JobPosition {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
}
