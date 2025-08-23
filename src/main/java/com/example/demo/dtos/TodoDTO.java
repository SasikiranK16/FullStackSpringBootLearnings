package com.example.demo.dtos;

import lombok.Data;

@Data
public class TodoDTO {

	private long id;
	private String title;
	private String description;
	private boolean completed;
}
