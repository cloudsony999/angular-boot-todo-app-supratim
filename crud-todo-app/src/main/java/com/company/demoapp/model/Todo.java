package com.company.demoapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "demo_todo")
public class Todo {

	@Id
	@Column(name = "todo_title")
	private String title;

	@Column(name = "todo_desc")
	private String description;

	@Column(name = "todo_status")
	private Boolean active;

}
