package com.hosoomartin.opencafe.controller;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Result<T> {
	private int code = HttpStatus.OK.value();
	private String message = HttpStatus.OK.name();
	private T result;
}
