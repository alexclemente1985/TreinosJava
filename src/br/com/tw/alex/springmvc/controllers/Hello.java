package br.com.tw.alex.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class Hello {
	@RequestMapping("/message")
	public String message() {
		return "hello";
	}
}
