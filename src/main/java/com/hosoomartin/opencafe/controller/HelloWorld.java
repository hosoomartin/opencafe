package com.hosoomartin.opencafe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping("/")
	String hello() {
		return "Hello, HosooMartin! <br> New Start!!";
	}
}
