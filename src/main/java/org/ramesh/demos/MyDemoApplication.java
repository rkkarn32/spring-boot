package org.ramesh.demos;

import org.java.org.domain.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyDemoApplication {

	@Autowired
	RestTemplateBuilder build;
	
	public static void main(String[] args) {
		SpringApplication.run(MyDemoApplication.class, args);
	}

	@GetMapping("/hello")
	public String getHellow(@RequestParam(required = false, defaultValue = "") String name){
		Quote q= this.build.build().getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return "Hellow There: "+name +", Quote: "+q.toString();
	}
}
