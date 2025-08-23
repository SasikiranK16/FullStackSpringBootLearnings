package com.example.demo.dtos;

import lombok.Data;

@Data
public class AccountDTO {
	private long id;
	private String accountHolderName;
	private double balance;
}
